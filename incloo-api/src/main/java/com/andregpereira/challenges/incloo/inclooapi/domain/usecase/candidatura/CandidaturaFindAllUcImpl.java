package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.CandidaturaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CandidaturaFindAllUcImpl implements CandidaturaFindAllUc {

    private final CandidaturaGateway gateway;

    @Override
    public Page<Candidatura> findAll(Pageable pageable) {
        return gateway.findAll(pageable);
    }

}
