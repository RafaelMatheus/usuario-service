package br.com.walllet.usuario.entity.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
    private String logradouro;
    private String numero;
    private String complemento;
    private String estado;
    private String cep;
    private String cidade;
}
