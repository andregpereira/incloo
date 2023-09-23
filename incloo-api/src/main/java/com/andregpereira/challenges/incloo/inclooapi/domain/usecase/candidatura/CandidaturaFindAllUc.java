package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidaturaFindAllUc {

    Page<Candidatura> findAll(Pageable pageable);

}
