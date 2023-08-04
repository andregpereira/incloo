package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;

public sealed interface UsuarioCreateUc permits UsuarioCreateUcImpl {

    Usuario create(Usuario usuario);

}
