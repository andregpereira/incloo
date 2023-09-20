package com.andregpereira.challenges.incloo.inclooapi.cross.security.jwt;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface JwtProvider {

    String gerarToken(String email, List<? extends GrantedAuthority> roles);

    void validarToken(String token);

}
