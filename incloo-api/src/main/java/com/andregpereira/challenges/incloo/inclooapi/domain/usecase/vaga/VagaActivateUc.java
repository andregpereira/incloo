package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

public sealed interface VagaActivateUc permits VagaActivateUcImpl {

    void activate(Long id);

}
