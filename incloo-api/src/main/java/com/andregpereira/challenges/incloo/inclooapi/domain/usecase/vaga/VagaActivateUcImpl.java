package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaActivateUcImpl implements VagaActivateUc {

    private final VagaGateway gateway;

    @Override
    public void activate(Long id) {
        gateway.findByIdAndAtivoFalse(id, v -> {
            v.setActive(true);
            gateway.save(v);
        });
    }

}
