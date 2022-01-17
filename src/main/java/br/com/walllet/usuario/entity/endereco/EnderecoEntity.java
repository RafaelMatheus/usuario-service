package br.com.walllet.usuario.entity.endereco;

import br.com.walllet.usuario.entity.usuario.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "endereco")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String estado;
    private String cep;
    private String cidade;
    @OneToOne(mappedBy = "endereco")
    private UsuarioEntity usuario;
}
