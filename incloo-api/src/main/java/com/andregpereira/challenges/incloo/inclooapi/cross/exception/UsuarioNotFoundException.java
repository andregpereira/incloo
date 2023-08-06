package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.text.MessageFormat;

public class UsuarioNotFoundException extends ErrorResponseException {

    private static final HttpStatusCode status = HttpStatus.NOT_FOUND;

    public UsuarioNotFoundException(Long id) {
        super(status, asProblemDetail(MessageFormat.format("Ops! Nenhum usuário com id {0} foi encontrado", id)), null);
    }

    private static ProblemDetail asProblemDetail(String msg) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, msg);
        pd.setTitle("Usuário não encontrado");
        return pd;
    }

}
