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
@Entity(name = "usuario_credential")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_usuarios_credentials")
@SequenceGenerator(name = "usuarios_credentials", sequenceName = "sq_usuarios_credentials", allocationSize = 1)
public class UsuarioCredentialEntity {

    @Id
    @Column(name = "id_usuarios_credentials")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_credentials")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate lastModifiedDate;

    @Column(nullable = false)
    private boolean enabled;

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UsuarioCredentialEntity credential))
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        return getId() != null && Objects.equals(getId(), credential.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
