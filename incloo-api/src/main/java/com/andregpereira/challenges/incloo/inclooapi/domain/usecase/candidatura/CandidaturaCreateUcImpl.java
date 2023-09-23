package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.CandidaturaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CandidaturaCreateUcImpl implements CandidaturaCreateUc {

    private final CandidaturaGateway gateway;

    @Override
    public Candidatura create(Candidatura candidatura) {
        return gateway.save(candidatura);
    }

}
