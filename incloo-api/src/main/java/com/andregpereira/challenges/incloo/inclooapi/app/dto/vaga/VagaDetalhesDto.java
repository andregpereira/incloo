package com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record VagaDetalhesDto(Long id,
        String title,
        String description,
        Set<String> minorityGroups,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate createdDate,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate lastModifiedDate,
        boolean active,
        List<CandidaturaDto> jobApplications) {

}
