package br.com.walllet.usuario.entity.usuario;

import br.com.walllet.usuario.constraint.Cpf;
import br.com.walllet.usuario.entity.endereco.EnderecoRequest;
import lombok.AllArgsConstructor;
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
public class UsuarioRequest {
    @NotEmpty
    private String nome;
    @Cpf
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private Set<String> telefones;
    @NotNull
    @Valid
    private EnderecoRequest endereco;
}
