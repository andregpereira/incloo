package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

public sealed interface UsuarioActivateUc permits UsuarioActivateUcImpl {

    void activate(Long id);

}
