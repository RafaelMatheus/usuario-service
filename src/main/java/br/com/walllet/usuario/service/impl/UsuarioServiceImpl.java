package br.com.walllet.usuario.service.impl;

import br.com.walllet.usuario.entity.usuario.UsuarioEntity;
import br.com.walllet.usuario.entity.usuario.UsuarioRequest;
import br.com.walllet.usuario.entity.usuario.UsuarioResponse;
import br.com.walllet.usuario.exception.ObjetoConsultaNotFoundException;
import br.com.walllet.usuario.mapper.UsuarioMapper;
import br.com.walllet.usuario.repository.UsuarioRepository;
import br.com.walllet.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity entity = this.mapper.paraUsuarioEntity(usuarioRequest);

        entity.setDataHoraCadastro(LocalDateTime.now());

        return this.mapper.paraUsuarioResponse(this.repository.save(entity));
    }

    @Override
    public UsuarioResponse consultarPorCpf(String cpf) {
        return this.mapper.paraUsuarioResponse(this.repository.findByCpf(cpf)
                .orElseThrow(() -> new ObjetoConsultaNotFoundException("Objeto não encontrado")));
    }
}
