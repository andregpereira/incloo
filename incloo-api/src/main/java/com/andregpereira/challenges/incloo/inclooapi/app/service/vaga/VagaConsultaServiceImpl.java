package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.VagaServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindAllUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByIdUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByMinorityGroupsUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByTitleUc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaConsultaServiceImpl implements VagaConsultaService {

    private final VagaFindAllUc findAllUc;
    private final VagaFindByIdUc findByIdUc;
    private final VagaFindByTitleUc findByTitleUc;
    private final VagaFindByMinorityGroupsUc findByMinorityGroupsUc;
    private final VagaServiceMapper mapper;

    @Override
    public Page<VagaDto> findAll(Pageable pageable) {
        return findAllUc.findAll(pageable).map(mapper::toVagaDto);
    }

    @Override
    public VagaDetalhesDto findById(Long id) {
        return mapper.toVagaDetalhesDto(findByIdUc.findById(id));
    }

    @Override
    public Page<VagaDto> findByTitle(String title, Pageable pageable) {
        return findByTitleUc.findByTitle(title, pageable).map(mapper::toVagaDto);
    }

    @Override
    public Page<VagaDto> findByMinorityGroups(Set<String> minorityGroups, Pageable pageable) {
        return findByMinorityGroupsUc.findByMinorityGroups(minorityGroups, pageable).map(mapper::toVagaDto);
    }

}
