package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class InclooApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String LOG_TRATANDO_EXCECAO = "Tratando exceção [{}]";

    @Override
    protected ResponseEntity<Object> handleErrorResponseException(ErrorResponseException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        log.warn(LOG_TRATANDO_EXCECAO, ex.toString());
        return super.handleExceptionInternal(ex, null, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.warn(LOG_TRATANDO_EXCECAO, ex.toString());
        ProblemDetail body = ex.getBody();
        body.setTitle("Campos inválidos");
        body.setProperty("errors", ex.getFieldErrors().stream().map(DadoInvalido::new));
        return super.handleExceptionInternal(ex, null, headers, status, request);
    }

    private record DadoInvalido(String campo,
            String mensagem) {

        public DadoInvalido(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }

    }

}
