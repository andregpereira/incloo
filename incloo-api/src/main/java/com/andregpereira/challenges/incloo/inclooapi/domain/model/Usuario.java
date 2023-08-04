package com.andregpereira.challenges.incloo.inclooapi.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String celular;
    private LocalDate dataNascimento;
    private Set<String> vulnerabilidadesSociais;
    private Set<String> deficiencias;
    private int idade;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Usuario usuario))
            return false;
        return idade == usuario.idade && ativo == usuario.ativo && Objects.equals(id, usuario.id) && Objects.equals(
                nome, usuario.nome) && Objects.equals(sobrenome, usuario.sobrenome) && Objects.equals(cpf,
                usuario.cpf) && Objects.equals(email, usuario.email) && Objects.equals(celular,
                usuario.celular) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(
                vulnerabilidadesSociais, usuario.vulnerabilidadesSociais) && Objects.equals(deficiencias,
                usuario.deficiencias) && Objects.equals(dataCriacao, usuario.dataCriacao) && Objects.equals(
                dataModificacao, usuario.dataModificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, cpf, email, celular, dataNascimento, vulnerabilidadesSociais,
                deficiencias, idade, dataCriacao, dataModificacao, ativo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]").add("id=" + id).add(
                "nome='" + nome + "'").add("sobrenome='" + sobrenome + "'").add("cpf='" + cpf + "'").add(
                "email='" + email + "'").add("celular='" + celular + "'").add("dataNascimento=" + dataNascimento).add(
                "vulnerabilidadesSociais=" + vulnerabilidadesSociais).add("deficiencias=" + deficiencias).add(
                "idade=" + idade).add("dataCriacao=" + dataCriacao).add("dataModificacao=" + dataModificacao).add(
                "ativo=" + ativo).toString();
    }

}
