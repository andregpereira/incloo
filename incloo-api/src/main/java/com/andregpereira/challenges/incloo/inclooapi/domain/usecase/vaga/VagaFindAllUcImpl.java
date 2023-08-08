package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaFindAllUcImpl implements VagaFindAllUc {

    private final VagaGateway gateway;

    @Override
    public Page<Vaga> findAll(Pageable pageable) {
        return gateway.findAll(pageable);
    }

}
