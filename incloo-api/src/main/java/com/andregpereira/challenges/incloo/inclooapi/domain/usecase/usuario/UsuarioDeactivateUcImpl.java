package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class UsuarioDeactivateUcImpl implements UsuarioDeactivateUc {

    private final UsuarioGateway gateway;

    @Override
    public void deactivate(Long id) {
        gateway.findByIdAndAtivoTrue(id, u -> {
            u.setAtivo(false);
            gateway.save(u);
        });
    }

}
