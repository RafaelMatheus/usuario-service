package br.com.walllet.usuario.entity.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
    @NotEmpty
    private String logradouro;
    @NotEmpty
    private String numero;
    private String complemento;
    @NotEmpty
    private String estado;
    @Pattern(regexp = "\\d+")
    private String cep;
    @NotEmpty
    private String cidade;
}
