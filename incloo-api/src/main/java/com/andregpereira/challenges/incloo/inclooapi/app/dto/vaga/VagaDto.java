package com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public record VagaDto(Long id,
        String titulo,
        String descricao,
        Set<VulnerabilidadeSocial> publicosAlvos,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate dataCriacao,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate dataModificacao,
        boolean ativo) {

}
