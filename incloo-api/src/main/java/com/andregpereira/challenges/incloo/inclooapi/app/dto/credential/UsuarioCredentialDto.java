package com.andregpereira.challenges.incloo.inclooapi.app.dto.credential;

import com.andregpereira.challenges.incloo.inclooapi.cross.security.Role;

public record UsuarioCredentialDto(Long id,
        String username,
        String password,
        Role role,
        boolean active) {

}
