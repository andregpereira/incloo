package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.credential;

import com.andregpereira.challenges.incloo.inclooapi.cross.security.Role;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioCredentialGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.UsuarioCredential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class UserCreateUcImpl implements UserCreateUc {

    private final UsuarioCredentialGateway gateway;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(UsuarioCredential usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.getAuthorities().add(Role.USER);
        gateway.save(usuario);
    }

}
