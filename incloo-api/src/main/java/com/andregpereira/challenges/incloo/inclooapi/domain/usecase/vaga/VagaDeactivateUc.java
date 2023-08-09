package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

public sealed interface VagaDeactivateUc permits VagaDeactivateUcImpl {

    void deactivate(Long id);

}
