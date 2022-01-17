package br.com.walllet.usuario.resources;

import br.com.walllet.usuario.entity.usuario.UsuarioRequest;
import br.com.walllet.usuario.entity.usuario.UsuarioResponse;
import br.com.walllet.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {
    private final UsuarioService service;

    @Override
    public ResponseEntity<UsuarioResponse> criarUsuario(UsuarioRequest usuario) {
        return ResponseEntity.ok(this.service.criarUsuario(usuario));
    }

    @Override
    public ResponseEntity<UsuarioResponse> obterUsuarioPorCof(String cpf) {
        return ResponseEntity.ok(this.service.consultarPorCpf(cpf));
    }
}
