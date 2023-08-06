package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.cross.exception.UsuarioAlreadyExistsException;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class UsuarioUpdateUcImpl implements UsuarioUpdateUc {

    private final UsuarioGateway gateway;

    @Override
    public Usuario update(Long id, Usuario usuarioAtualizado) {
        if (gateway.existsByEmail(usuarioAtualizado.getEmail()))
            throw new UsuarioAlreadyExistsException("e-mail");
        Usuario usuario = gateway.findByIdAndAtivoTrue(id);
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setSobrenome(usuarioAtualizado.getSobrenome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setCelular(usuarioAtualizado.getCelular());
        return gateway.save(usuario);
    }

}
