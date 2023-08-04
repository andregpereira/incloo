package com.andregpereira.challenges.incloo.inclooapi.app.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum Deficiencia {
    VISUAL,
    AUDITIVA,
    MOTORA,
    INTELECTUAL;

    @JsonCreator
    public static Deficiencia findByNome(String nome) {
        return Stream.of(values()).filter(d -> d.name().equals(nome)).findFirst().orElseThrow(RuntimeException::new);
    }
}
