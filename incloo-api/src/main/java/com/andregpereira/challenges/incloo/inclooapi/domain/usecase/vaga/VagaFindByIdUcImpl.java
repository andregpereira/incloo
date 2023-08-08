package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaFindByIdUcImpl implements VagaFindByIdUc {

    private final VagaGateway gateway;

    @Override
    public Vaga findById(Long id) {
        return gateway.findById(id);
    }

}
