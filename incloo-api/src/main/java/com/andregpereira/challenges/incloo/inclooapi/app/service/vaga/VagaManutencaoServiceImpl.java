package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.VagaServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaActivateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaCreateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaDeactivateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaUpdateUc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public non-sealed class VagaManutencaoServiceImpl implements VagaManutencaoService {

    private final VagaCreateUc createUc;
    private final VagaUpdateUc updateUc;
    private final VagaActivateUc activateUc;
    private final VagaDeactivateUc deactivateUc;
    private final VagaServiceMapper mapper;

    @Override
    public VagaDto create(VagaCreateDto dto) {
        return mapper.toVagaDto(createUc.create(mapper.toVaga(dto)));
    }

    @Override
    public VagaDto update(Long id, VagaCreateDto dto) {
        return mapper.toVagaDto(updateUc.update(id, mapper.toVaga(dto)));
    }

    @Override
    public void activate(Long id) {
        activateUc.activate(id);
    }

    @Override
    public void deactivate(Long id) {
        deactivateUc.deactivate(id);
    }

}
