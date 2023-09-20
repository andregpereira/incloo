package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface VagaGateway extends BaseGateway<Vaga> {

    boolean existsByTitle(String title);

    Page<Vaga> findAll(Pageable pageable);

    Page<Vaga> findByTitle(String title, Pageable pageable);

    Page<Vaga> findByMinorityGroups(Set<String> minorityGroups, Pageable pageable);

}
