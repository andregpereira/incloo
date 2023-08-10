package com.andregpereira.challenges.incloo.inclooapi.app.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum VulnerabilidadeSocial {
    INDIGENA,
    LGBTQIA,
    NEGRO,
    BAIXA_RENDA,
    PCD,
    QUARENTA_ANOS_MAIS;

    @JsonCreator
    public static VulnerabilidadeSocial findByNome(String nome) {
        return Stream.of(values()).filter(vs -> vs.name().equals(nome)).findFirst().orElseThrow(RuntimeException::new);
    }
}
