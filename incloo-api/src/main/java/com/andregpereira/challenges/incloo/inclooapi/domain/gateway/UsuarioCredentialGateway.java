package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.UsuarioCredential;

import java.util.function.UnaryOperator;

public interface UsuarioCredentialGateway {

    UsuarioCredential save(UsuarioCredential t);

    UsuarioCredential findById(Long id);

    UsuarioCredential findByIdAndEnabledTrue(Long id, UnaryOperator<UsuarioCredential> op);

}
