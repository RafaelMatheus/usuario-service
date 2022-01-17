package br.com.walllet.usuario.entity.usuario;

import br.com.walllet.usuario.entity.endereco.EnderecoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioResponse {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Set<String> telefones;
    private EnderecoResponse endereco;
}
