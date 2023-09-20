package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ConsultaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public sealed interface VagaConsultaService extends ConsultaService<VagaDto> permits VagaConsultaServiceImpl {

    Page<VagaDto> findByTitle(String title, Pageable pageable);

    Page<VagaDto> findByMinorityGroups(Set<String> minorityGroups, Pageable pageable);

}
