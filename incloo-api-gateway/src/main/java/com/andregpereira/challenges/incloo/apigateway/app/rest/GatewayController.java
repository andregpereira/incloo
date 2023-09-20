package com.andregpereira.challenges.incloo.apigateway.app.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/fallback")
public class GatewayController {

    @RequestMapping
    public Mono<ResponseEntity<Object>> fallback() {
        log.error("Erro ao acessar a API");
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
                "URL indisponível no momento. Tente novamente"));
    }

}
