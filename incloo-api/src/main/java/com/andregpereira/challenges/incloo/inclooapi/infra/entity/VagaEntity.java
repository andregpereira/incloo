package com.andregpereira.challenges.incloo.inclooapi.infra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vaga")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_vagas")
@SequenceGenerator(name = "vagas", sequenceName = "sq_vagas", allocationSize = 1)
public class VagaEntity {

    @Id
    @Column(name = "id_vaga")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vagas")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 3000)
    private String description;

    @ElementCollection
    @Column(nullable = false)
    private Set<String> minorityGroups = new LinkedHashSet<>();

    @Lob
    private byte[] technicalTest;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate lastModifiedDate;

    @Column(nullable = false)
    private boolean active;

    @ToString.Exclude
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<CandidaturaEntity> jobApplications = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VagaEntity vaga))
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        return getId() != null && Objects.equals(getId(), vaga.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
