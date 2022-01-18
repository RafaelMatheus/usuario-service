package br.com.walllet.usuario.resources;

import br.com.walllet.usuario.constraint.Cpf;
import br.com.walllet.usuario.entity.usuario.UsuarioRequest;
import br.com.walllet.usuario.entity.usuario.UsuarioResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Usuario API")
public interface UsuarioController {
    @ApiOperation(value = "Criação de um novo usuário")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody @Valid final UsuarioRequest usuario);

    @ApiOperation(value = "Obter usuario por cpf.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{cpf}")
    ResponseEntity<UsuarioResponse> obterUsuarioPorCof(@PathVariable @Valid @Cpf String cpf);
}
