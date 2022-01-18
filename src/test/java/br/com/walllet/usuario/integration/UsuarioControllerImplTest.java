package br.com.walllet.usuario.integration;

import br.com.walllet.usuario.UsuarioApplication;
import br.com.walllet.usuario.configuration.ObjectMapperConfiguration;
import br.com.walllet.usuario.entity.endereco.EnderecoRequest;
import br.com.walllet.usuario.entity.usuario.UsuarioRequest;
import br.com.walllet.usuario.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static utils.TestUtils.toJson;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = UsuarioApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Import({ObjectMapperConfiguration.class})
public class UsuarioControllerImplTest {
    private static final String ENDPOINT = "/usuarios";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UsuarioService service;

    @Test
    @DisplayName("Deve retornar status HTTP 400 quando enviar uma requisição POST com erro no BODY")
    void deveRetornar400BodyIncorreto() throws Exception {
        this.mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(UsuarioRequest.builder().build()))).andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Erro de validação"))
                .andExpect(jsonPath("$.path").value("/usuarios"))
                .andExpect(jsonPath("$.fieldMessages").isArray());
    }

    @Test
    @DisplayName("Deve retornar status HTTP 200 quando enviar uma requisição POST correta")
    void deveRetornar200BodyCorreto() throws Exception {

        this.mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(obterUsuarioRequest())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf").exists())
                .andExpect(jsonPath("$.dataNascimento").exists())
                .andExpect(jsonPath("$.nome").exists())
                .andExpect(jsonPath("$.telefones").isArray())
                .andExpect(jsonPath("$.endereco").exists());

    }

    private UsuarioRequest obterUsuarioRequest() {
        EnderecoRequest enderecoRequest = EnderecoRequest.builder()
                .cep("55920000")
                .cidade("Itambé")
                .estado("PE")
                .complemento("APTO 02")
                .numero("180")
                .logradouro("Av teste")
                .build();

        return UsuarioRequest.builder()
                .cpf("01234567890")
                .dataNascimento(LocalDate.of(1998, 8, 13))
                .endereco(enderecoRequest)
                .nome("Teste")
                .telefones(Set.of("81999999999"))
                .build();
    }
}
