package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

public class VagaAlreadyExistsException extends ErrorResponseException {

    private static final HttpStatusCode status = HttpStatus.CONFLICT;

    public VagaAlreadyExistsException() {
        super(status, asProblemDetail("Poxa! Já existe uma vaga com este título cadastrado"), null);
    }

    private static ProblemDetail asProblemDetail(String msg) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, msg);
        pd.setTitle("Vaga existente");
        pd.setType(URI.create("http://incloo.com/errors/conflict"));
        return pd;
    }

}
