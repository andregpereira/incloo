package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.credential;

import com.andregpereira.challenges.incloo.inclooapi.cross.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ValidateTokenUcImpl implements ValidateTokenUc {

    private final JwtProvider jwtProvider;

    @Override
    public void validate(String token) {
        jwtProvider.validarToken(token);
    }

}
