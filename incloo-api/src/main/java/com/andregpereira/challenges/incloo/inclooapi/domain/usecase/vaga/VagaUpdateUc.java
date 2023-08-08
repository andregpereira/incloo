package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;

public sealed interface VagaUpdateUc permits VagaUpdateUcImpl {

    Vaga update(Long id, Vaga vaga);

}
