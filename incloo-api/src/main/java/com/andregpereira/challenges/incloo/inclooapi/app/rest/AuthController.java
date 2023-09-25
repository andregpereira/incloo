package com.andregpereira.challenges.incloo.inclooapi.app.rest;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.credential.LoginDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.credential.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {
        log.info("Fazendo login...");
        return ResponseEntity.ok(service.login(dto));
    }

    @GetMapping("/validar")
    public String validarToken(@RequestParam String token) {
        service.validarToken(token);
        return "Token inválido";
    }

}
