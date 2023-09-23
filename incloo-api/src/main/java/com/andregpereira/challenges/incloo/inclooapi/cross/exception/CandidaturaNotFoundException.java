package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.text.MessageFormat;

public class CandidaturaNotFoundException extends ErrorResponseException {

    private static final HttpStatusCode status = HttpStatus.NOT_FOUND;

    public CandidaturaNotFoundException(Long id) {
        super(status, asProblemDetail(MessageFormat.format("Ops! Nenhuma candidatura com id {0} foi encontrada", id)),
                null);
    }

    private static ProblemDetail asProblemDetail(String msg) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, msg);
        pd.setTitle("Candidatura não encontrada");
        pd.setType(URI.create("http://incloo.com/errors/not-found"));
        return pd;
    }

}
