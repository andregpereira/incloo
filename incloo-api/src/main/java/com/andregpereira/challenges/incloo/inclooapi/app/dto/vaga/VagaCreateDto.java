package com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record VagaCreateDto(@NotBlank(message = "O título é obrigatório") String titulo,
        @NotBlank(message = "A descrição é obrigatória") String descricao,
        @NotEmpty(message = "O público-alvo é obrigatório") Set<VulnerabilidadeSocial> publicosAlvos) {

}
