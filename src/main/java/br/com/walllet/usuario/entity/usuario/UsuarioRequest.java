package br.com.walllet.usuario.entity.usuario;

import br.com.walllet.usuario.constraint.Cpf;
import br.com.walllet.usuario.entity.endereco.EnderecoRequest;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioRequest {
    @NotEmpty
    private String nome;
    @Cpf
    private String cpf;
    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataNascimento;
    @NotNull
    private Set<String> telefones;
    @NotNull
    @Valid
    private EnderecoRequest endereco;
}
