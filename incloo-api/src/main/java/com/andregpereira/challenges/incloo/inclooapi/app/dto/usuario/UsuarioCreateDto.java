package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.Deficiencia;
import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Set;

public record UsuarioCreateDto(@NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O sobrenome é obrigatório") String sobrenome,
        @NotBlank(message = "O CPF é obrigatório") @CPF() String cpf,
        @NotBlank(message = "O e-mail é obrigatório") String email,
        @NotBlank(message = "O celular é obrigatório") String celular,
        @NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento,
        Set<VulnerabilidadeSocial> vulnerabilidadesSociais,
        Set<Deficiencia> deficiencias) {

}
