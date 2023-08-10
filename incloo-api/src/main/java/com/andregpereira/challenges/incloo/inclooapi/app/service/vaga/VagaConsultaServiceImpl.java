package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.VagaServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindAllUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByIdUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByPublicoAlvoUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByTituloUc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaConsultaServiceImpl implements VagaConsultaService {

    private final VagaFindAllUc findAllUc;
    private final VagaFindByIdUc findByIdUc;
    private final VagaFindByTituloUc findByTituloUc;
    private final VagaFindByPublicoAlvoUc findByPublicoAlvoUc;
    private final VagaServiceMapper mapper;

    @Override
    public Page<VagaDto> findAll(Pageable pageable) {
        return findAllUc.findAll(pageable).map(mapper::toVagaDto);
    }

    @Override
    public VagaDto findById(Long id) {
        return mapper.toVagaDto(findByIdUc.findById(id));
    }

    @Override
    public Page<VagaDto> findByTitulo(String titulo, Pageable pageable) {
        return findByTituloUc.findByTitulo(titulo, pageable).map(mapper::toVagaDto);
    }

    @Override
    public Page<VagaDto> findByPublicosAlvos(Set<VulnerabilidadeSocial> publicosAlvos, Pageable pageable) {
        return findByPublicoAlvoUc.findByPublicosAlvos(
                publicosAlvos.stream().map(Enum::toString).collect(Collectors.toSet()), pageable).map(
                mapper::toVagaDto);
    }

}
