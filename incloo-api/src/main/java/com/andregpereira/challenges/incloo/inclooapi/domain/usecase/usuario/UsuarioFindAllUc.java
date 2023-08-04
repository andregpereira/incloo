package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface UsuarioFindAllUc permits UsuarioFindAllUcImpl {

    Page<Usuario> findAll(Pageable pageable);

}
