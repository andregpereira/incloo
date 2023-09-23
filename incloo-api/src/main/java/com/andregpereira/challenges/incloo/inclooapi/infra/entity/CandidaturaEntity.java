package com.andregpereira.challenges.incloo.inclooapi.infra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "candidatura")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_candidaturas")
@SequenceGenerator(name = "candidaturas", sequenceName = "sq_candidaturas", allocationSize = 1)
public class CandidaturaEntity {

    @Id
    @Column(name = "id_candidatura")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidaturas")
    private Long id;

    private String linkedin;
    private String salaryExpectation;
    private String status;

    @Lob
    private byte[] cv;

    @Lob
    private byte[] submittedTechnicalTest;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity user;

    @ManyToOne
    @JoinColumn(name = "id_vaga")
    private VagaEntity job;

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CandidaturaEntity candidatura))
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        return getId() != null && Objects.equals(getId(), candidatura.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
