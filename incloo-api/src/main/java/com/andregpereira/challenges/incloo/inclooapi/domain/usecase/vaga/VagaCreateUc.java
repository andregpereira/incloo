package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;

public sealed interface VagaCreateUc permits VagaCreateUcImpl {

    Vaga create(Vaga vaga);

}
