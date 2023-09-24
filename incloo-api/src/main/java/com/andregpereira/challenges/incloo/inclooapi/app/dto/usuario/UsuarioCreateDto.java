package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuarioCreateDto(@NotBlank(message = "O nome é obrigatório") String name,
        @NotBlank(message = "O CPF é obrigatório") @CPF(
                message = "Insira um CPF válido. Formatos aceitos: xxx.xxx.xxx-xx, xxxxxxxxx-xx e xxxxxxxxxxx") String cpf,
        @NotBlank(message = "O e-mail é obrigatório") @Email(message = "Insira um e-mail válido") String email,
        @NotBlank(message = "A senha é obrigatória") String password,
        @NotBlank(message = "O celular é obrigatório") @Pattern(
                message = "Formato do celular inválido. Por favor, informe um celular no seguinte formato (xx) xxxxx-xxxx",
                regexp = "^[(]\\d{2}[)] \\d{4,5}-\\d{4}$") String mobileNumber,
        @Past(message = "Insira uma data de nascimento válida") LocalDate birthDate,
        String ethnicity,
        Boolean lgbtqia,
        String disability) {

}
