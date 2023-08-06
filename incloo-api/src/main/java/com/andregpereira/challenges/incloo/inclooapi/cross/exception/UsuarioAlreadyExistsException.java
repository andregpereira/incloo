package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.text.MessageFormat;

public class UsuarioAlreadyExistsException extends ErrorResponseException {

    private static final HttpStatusCode status = HttpStatus.CONFLICT;

    public UsuarioAlreadyExistsException(String atributoUnico) {
        super(status, asProblemDetail(
                MessageFormat.format("Poxa! Já existe um usuário com este {0} cadastrado", atributoUnico)), null);
    }

    private static ProblemDetail asProblemDetail(String msg) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, msg);
        pd.setTitle("Usuário existente");
        pd.setType(URI.create("http://incloo.com/errors/conflict"));
        return pd;
    }

}
