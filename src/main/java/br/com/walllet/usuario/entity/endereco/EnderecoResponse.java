package br.com.walllet.usuario.entity.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {
    private String logradouro;
    private String numero;
    private String complemento;
    private String estado;
    private String cep;
    private String cidade;
}
