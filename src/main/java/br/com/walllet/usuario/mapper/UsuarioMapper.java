package br.com.walllet.usuario.mapper;

import br.com.walllet.usuario.entity.usuario.UsuarioEntity;
import br.com.walllet.usuario.entity.usuario.UsuarioRequest;
import br.com.walllet.usuario.entity.usuario.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    UsuarioEntity paraUsuarioEntity(UsuarioRequest usuarioRequest);

    UsuarioResponse paraUsuarioResponse(UsuarioEntity entity);
}
