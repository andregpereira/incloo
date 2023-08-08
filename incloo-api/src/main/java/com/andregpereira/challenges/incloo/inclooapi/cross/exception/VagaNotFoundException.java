package com.andregpereira.challenges.incloo.inclooapi.cross.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.text.MessageFormat;

public class VagaNotFoundException extends ErrorResponseException {

    private static final HttpStatusCode status = HttpStatus.NOT_FOUND;

    public VagaNotFoundException(Long id) {
        super(status, asProblemDetail(MessageFormat.format("Ops! Nenhuma vaga com id {0} foi encontrada", id)), null);
    }

    public VagaNotFoundException(Long id, boolean ativo) {
        super(status, asProblemDetail(MessageFormat.format("Ops! Nenhuma vaga {1} com id {0} foi encontrada", id,
                ativo ? "ativa" : "inativa")), null);
    }

    public VagaNotFoundException(String titulo) {
        super(status,
                asProblemDetail(MessageFormat.format("Ops! Nenhuma vaga ativa com título {0} foi encontrada", titulo)),
                null);
    }

    private static ProblemDetail asProblemDetail(String msg) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, msg);
        pd.setTitle("Vaga não encontrada");
        pd.setType(URI.create("http://incloo.com/errors/not-found"));
        return pd;
    }

}
