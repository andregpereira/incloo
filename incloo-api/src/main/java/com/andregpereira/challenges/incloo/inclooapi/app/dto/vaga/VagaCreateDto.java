package com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record VagaCreateDto(@NotBlank(message = "O título é obrigatório") String title,
        @NotBlank(message = "A descrição é obrigatória") String description,
        @NotEmpty(message = "O público-alvo é obrigatório") Set<String> minorityGroups) {

}
