package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidaturaGateway {

    Candidatura save(Candidatura candidatura);

    Candidatura findById(Long id);

    Page<Candidatura> findAll(Pageable pageable);

}
