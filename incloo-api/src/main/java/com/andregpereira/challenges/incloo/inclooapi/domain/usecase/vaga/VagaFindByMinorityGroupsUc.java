package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public sealed interface VagaFindByMinorityGroupsUc permits VagaFindByMinorityGroupsUcImpl {

    Page<Vaga> findByMinorityGroups(Set<String> minorityGroups, Pageable pageable);

}
