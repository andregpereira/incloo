package com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public record VagaDto(Long id,
        String title,
        String description,
        Set<String> publicosAlvos,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate createdDate,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate lastModifiedDate,
        boolean active,
        Set<UsuarioDto> users) {

}
