package com.andregpereira.challenges.incloo.inclooapi.infra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Entity(name = "vaga")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_vagas")
@SequenceGenerator(name = "vagas", sequenceName = "sq_vagas", allocationSize = 1)
public class VagaEntity implements Serializable {

    @Id
    @Column(name = "id_vaga")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vagas")
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Set<String> publicosAlvos;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate dataCriacao;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate dataModificacao;

    @Column(nullable = false)
    private boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VagaEntity vaga))
            return false;
        return ativo == vaga.ativo && Objects.equals(id, vaga.id) && Objects.equals(titulo,
                vaga.titulo) && Objects.equals(descricao, vaga.descricao) && Objects.equals(publicosAlvos,
                vaga.publicosAlvos) && Objects.equals(dataCriacao, vaga.dataCriacao) && Objects.equals(dataModificacao,
                vaga.dataModificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, publicosAlvos, dataCriacao, dataModificacao, ativo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VagaEntity.class.getSimpleName() + "[", "]").add("id=" + id).add(
                "titulo='" + titulo + "'").add("descricao='" + descricao + "'").add(
                "publicosAlvos=" + publicosAlvos).add("dataCriacao=" + dataCriacao).add(
                "dataModificacao=" + dataModificacao).add("ativo=" + ativo).toString();
    }

}
