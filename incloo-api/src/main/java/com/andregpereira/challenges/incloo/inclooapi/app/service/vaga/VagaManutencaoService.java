package com.andregpereira.challenges.incloo.inclooapi.app.service.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ManutencaoService;

public sealed interface VagaManutencaoService extends ManutencaoService<VagaCreateDto, VagaCreateDto, VagaDto> permits VagaManutencaoServiceImpl {

}
