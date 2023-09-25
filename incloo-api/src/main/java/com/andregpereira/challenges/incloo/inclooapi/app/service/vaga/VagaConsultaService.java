package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ConsultaService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public sealed interface VagaConsultaService extends ConsultaService<VagaDto> permits VagaConsultaServiceImpl {

    ByteArrayResource downloadTechnicalTest(Long id);

    VagaDetalhesDto findById(Long id);

    Page<VagaDto> findByTitle(String title, Pageable pageable);

    Page<VagaDto> findByMinorityGroups(Set<String> minorityGroups, Pageable pageable);

}
