package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ManutencaoService;
import org.springframework.web.multipart.MultipartFile;

public sealed interface VagaManutencaoService extends ManutencaoService<VagaCreateDto, VagaCreateDto, VagaDto> permits VagaManutencaoServiceImpl {
    VagaDto create(VagaCreateDto dto, MultipartFile technicalTest);

}
