package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

public sealed interface UsuarioDeactivateUc permits UsuarioDeactivateUcImpl {

    void deactivate(Long id);

}
