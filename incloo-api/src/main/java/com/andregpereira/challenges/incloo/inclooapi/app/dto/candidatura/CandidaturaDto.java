package com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;

public record CandidaturaDto(Long id,
        String linkedin,
        String salaryExpectation,
        UsuarioDto user,
        VagaDto job) {

}
