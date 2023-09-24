package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UsuarioDto(Long id,
        String name,
        String cpf,
        String email,
        String mobileNumber,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate birthDate,
        Integer age,
        String ethnicity,
        Boolean lgbtqia,
        String disability,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate createdDate,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate lastModifiedDate,
        boolean active) {

}
