package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.CandidaturaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CandidaturaFindByIdUcImpl implements CandidaturaFindByIdUc {

    private final CandidaturaGateway gateway;

    @Override
    public Candidatura findById(Long id) {
        return gateway.findById(id);
    }

}
