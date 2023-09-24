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
        return gateway.findByIdAndAtivoTrue(id, u -> {
            if (gateway.existsByEmail(usuarioAtualizado.getEmail()))
                throw new UsuarioAlreadyExistsException("e-mail");
            u.setName(usuarioAtualizado.getName());
            u.setEmail(usuarioAtualizado.getEmail());
            u.setMobileNumber(usuarioAtualizado.getMobileNumber());
            return gateway.save(u);
        });
    }

}
