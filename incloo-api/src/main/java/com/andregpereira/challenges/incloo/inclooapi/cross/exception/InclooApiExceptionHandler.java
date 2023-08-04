package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class InclooApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String LOG_TRATANDO_EXCECAO = "Tratando exceção {}";

    @Override
    protected ResponseEntity<Object> handleErrorResponseException(ErrorResponseException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        log.warn(LOG_TRATANDO_EXCECAO, ex.toString());
        return super.handleErrorResponseException(ex, headers, status, request);
    }

}
