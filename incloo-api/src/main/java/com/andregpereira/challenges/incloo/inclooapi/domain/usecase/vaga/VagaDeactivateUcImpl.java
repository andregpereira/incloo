package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaDeactivateUcImpl implements VagaDeactivateUc {

    private final VagaGateway gateway;

    @Override
    public void deactivate(Long id) {
        gateway.findByIdAndAtivoTrue(id, v -> {
            v.setAtivo(false);
            gateway.save(v);
        });
    }

}
