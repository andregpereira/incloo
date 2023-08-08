package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;

public sealed interface UsuarioFindByEmailUc permits UsuarioFindByEmailUcImpl {

    Usuario findByEmail(String email);

}
