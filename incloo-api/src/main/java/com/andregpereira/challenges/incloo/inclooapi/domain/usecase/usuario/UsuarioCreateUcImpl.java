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
public non-sealed class UsuarioCreateUcImpl implements UsuarioCreateUc {

    private final UsuarioGateway gateway;

    @Override
    public Usuario create(Usuario usuario) {
        if (gateway.existsByCpf(usuario.getCpf()))
            throw new UsuarioAlreadyExistsException("CPF");
        else if (gateway.existsByEmail(usuario.getEmail()))
            throw new UsuarioAlreadyExistsException("e-mail");
        usuario.setCpf(usuario.getCpf().replaceAll("[.-]", ""));
        usuario.setActive(true);
        return gateway.save(usuario);
    }

}
