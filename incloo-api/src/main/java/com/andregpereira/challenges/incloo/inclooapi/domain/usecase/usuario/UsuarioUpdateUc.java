package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;

public sealed interface UsuarioUpdateUc permits UsuarioUpdateUcImpl {

    Usuario update(Long id, Usuario usuarioAtualizado);

}
