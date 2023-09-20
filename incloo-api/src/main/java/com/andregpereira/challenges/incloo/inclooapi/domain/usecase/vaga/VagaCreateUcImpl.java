package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.cross.exception.VagaAlreadyExistsException;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaCreateUcImpl implements VagaCreateUc {

    private final VagaGateway gateway;

    @Override
    public Vaga create(Vaga vaga) {
        if (gateway.existsByTitle(vaga.getTitle()))
            throw new VagaAlreadyExistsException();
        return gateway.save(vaga);
    }

}
