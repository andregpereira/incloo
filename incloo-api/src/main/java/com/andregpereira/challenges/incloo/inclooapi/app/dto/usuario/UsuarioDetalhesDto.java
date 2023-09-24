package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record UsuarioDetalhesDto(Long id,
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
        boolean active,
        List<CandidaturaDto> jobApplications) {

}
