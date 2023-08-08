package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;

public sealed interface UsuarioFindByCpfUc permits UsuarioFindByCpfUcImpl {

    Usuario findByCpf(String cpf);

}
