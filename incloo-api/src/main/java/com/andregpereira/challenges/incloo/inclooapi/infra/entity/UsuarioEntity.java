package com.andregpereira.challenges.incloo.inclooapi.infra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_usuarios", uniqueConstraints = {@UniqueConstraint(name = "uk_cpf", columnNames = "cpf"),
        @UniqueConstraint(name = "uk_email", columnNames = "email")})
@SequenceGenerator(name = "usuarios", sequenceName = "sq_usuarios", allocationSize = 1)
public class UsuarioEntity implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private Set<String> vulnerabilidadesSociais;
    private Set<String> deficiencias;

    @Transient
    private int idade;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate dataCriacao;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate dataModificacao;

    @Column(nullable = false)
    private boolean ativo;

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UsuarioEntity usuario))
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
        return new StringJoiner(", ", UsuarioEntity.class.getSimpleName() + "[", "]").add("id=" + id).add(
                "nome='" + nome + "'").add("sobrenome='" + sobrenome + "'").add("cpf='" + cpf + "'").add(
                "email='" + email + "'").add("celular='" + celular + "'").add("dataNascimento=" + dataNascimento).add(
                "vulnerabilidadesSociais=" + vulnerabilidadesSociais).add("deficiencias=" + deficiencias).add(
                "idade=" + idade).add("dataCriacao=" + dataCriacao).add("dataModificacao=" + dataModificacao).add(
                "ativo=" + ativo).toString();
    }

}
