package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.credential;

import com.andregpereira.challenges.incloo.inclooapi.cross.security.jwt.JwtProvider;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Login;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class LoginUcImpl implements LoginUc {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public String login(Login login) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        if (authenticate.isAuthenticated())
            try {
                return jwtProvider.gerarToken(authenticate.getName(),
                        (List<? extends GrantedAuthority>) authenticate.getAuthorities());
            } catch (JwtException e) {
                log.info(e.getMessage());
                return null;
            }
        else
            throw new RuntimeException("Erro ao gerar token");
    }

}
