package br.com.walllet.usuario.service;

import br.com.walllet.usuario.entity.usuario.UsuarioRequest;
import br.com.walllet.usuario.entity.usuario.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest);
    UsuarioResponse consultarPorCpf(String cpf);
}
