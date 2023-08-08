package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;

public sealed interface VagaFindByIdUc permits VagaFindByIdUcImpl {

    Vaga findById(Long id);

}
