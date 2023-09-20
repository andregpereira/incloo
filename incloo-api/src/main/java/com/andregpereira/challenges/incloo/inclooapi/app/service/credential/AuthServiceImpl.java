package com.andregpereira.challenges.incloo.inclooapi.app.service.credential;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.credential.LoginDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.UsuarioCredentialServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.credential.LoginUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.credential.ValidateTokenUc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final ValidateTokenUc validateTokenUc;
    private final LoginUc loginUc;
    private final UsuarioCredentialServiceMapper mapper;

    @Override
    public String login(LoginDto dto) {
        return loginUc.login(mapper.toLogin(dto));
    }

    @Override
    public void validarToken(String token) {
        validateTokenUc.validate(token);
    }

}
