package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class UsuarioActivateUcImpl implements UsuarioActivateUc {

    private final UsuarioGateway gateway;

    @Override
    public void activate(Long id) {
        gateway.findByIdAndAtivoFalse(id, u -> {
            u.setAtivo(true);
            gateway.save(u);
        });
    }

}
