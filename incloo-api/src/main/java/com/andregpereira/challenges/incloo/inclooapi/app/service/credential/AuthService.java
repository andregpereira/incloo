package com.andregpereira.challenges.incloo.inclooapi.app.service.credential;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.credential.LoginDto;

public interface AuthService {

    String login(LoginDto dto);

    void validarToken(String token);

}
