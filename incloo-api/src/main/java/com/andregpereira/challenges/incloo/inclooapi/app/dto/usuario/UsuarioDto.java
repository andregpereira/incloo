package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.Deficiencia;
import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public record UsuarioDto(Long id,
        String nome,
        String sobrenome,
        String cpf,
        String email,
        String celular,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate dataNascimento,
        int idade,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate dataCriacao,
        @JsonFormat(pattern = "dd/MM/uuuu") LocalDate dataModificacao,
        boolean ativo,
        Set<VulnerabilidadeSocial> vulnerabilidadesSociais,
        Set<Deficiencia> deficiencias) {

}
