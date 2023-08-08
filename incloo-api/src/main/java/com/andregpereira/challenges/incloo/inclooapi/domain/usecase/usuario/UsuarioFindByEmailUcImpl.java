package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class UsuarioFindByEmailUcImpl implements UsuarioFindByEmailUc {

    private final UsuarioGateway gateway;

    @Override
    public Usuario findByEmail(String email) {
        return gateway.findByEmail(email);
    }

}
