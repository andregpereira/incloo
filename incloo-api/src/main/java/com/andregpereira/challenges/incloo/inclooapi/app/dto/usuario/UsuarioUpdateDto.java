package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.Deficiencia;
import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record UsuarioUpdateDto(@NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O sobrenome é obrigatório") String sobrenome,
        @NotBlank(message = "O e-mail é obrigatório") String email,
        @NotBlank(message = "O celular é obrigatório") String celular,
        Set<VulnerabilidadeSocial> vulnerabilidadesSociais,
        Set<Deficiencia> deficiencias) {
}
