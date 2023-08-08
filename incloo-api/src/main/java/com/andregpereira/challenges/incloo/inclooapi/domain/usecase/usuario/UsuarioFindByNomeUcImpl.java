package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class UsuarioFindByNomeUcImpl implements UsuarioFindByNomeUc {

    private final UsuarioGateway gateway;

    @Override
    public Page<Usuario> findByNome(String nome, Pageable pageable) {
        return gateway.findByNome(nome, pageable);
    }

}
