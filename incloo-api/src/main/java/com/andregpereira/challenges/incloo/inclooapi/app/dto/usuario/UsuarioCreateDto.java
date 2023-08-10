package com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.Deficiencia;
import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Set;

public record UsuarioCreateDto(@NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O sobrenome é obrigatório") String sobrenome,
        @NotBlank(message = "O CPF é obrigatório") @CPF(
                message = "Insira um CPF válido. Formatos aceitos: xxx.xxx.xxx-xx, xxxxxxxxx-xx e xxxxxxxxxxx") String cpf,
        @NotBlank(message = "O e-mail é obrigatório") @Email(message = "Insira um e-mail válido") String email,
        @NotBlank(message = "O celular é obrigatório")@Pattern(
                message = "Formato do celular inválido. Por favor, informe um celular no seguinte formato (xx) xxxxx-xxxx",
                regexp = "^[(]\\d{2}[)] \\d{4,5}-\\d{4}$") String celular,
        @NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento,
        Set<VulnerabilidadeSocial> vulnerabilidadesSociais,
        Set<Deficiencia> deficiencias) {

}
