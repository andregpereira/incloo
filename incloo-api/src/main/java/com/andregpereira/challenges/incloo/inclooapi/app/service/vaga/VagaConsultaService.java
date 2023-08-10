package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ConsultaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public sealed interface VagaConsultaService extends ConsultaService<VagaDto> permits VagaConsultaServiceImpl {

    Page<VagaDto> findByTitulo(String titulo, Pageable pageable);

    Page<VagaDto> findByPublicosAlvos(Set<VulnerabilidadeSocial> publicosAlvos, Pageable pageable);

}
