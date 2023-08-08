package com.andregpereira.challenges.incloo.inclooapi.domain.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vaga implements Serializable {

    private String titulo;
    private String descricao;
    private Set<String> publicosAlvos;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vaga vaga))
            return false;
        return ativo == vaga.ativo && Objects.equals(titulo, vaga.titulo) && Objects.equals(descricao,
                vaga.descricao) && Objects.equals(publicosAlvos, vaga.publicosAlvos) && Objects.equals(dataCriacao,
                vaga.dataCriacao) && Objects.equals(dataModificacao, vaga.dataModificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, publicosAlvos, dataCriacao, dataModificacao, ativo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vaga.class.getSimpleName() + "[", "]").add("titulo='" + titulo + "'").add(
                "descricao='" + descricao + "'").add("publicosAlvos=" + publicosAlvos).add(
                "dataCriacao=" + dataCriacao).add("dataModificacao=" + dataModificacao).add(
                "ativo=" + ativo).toString();
    }

}
