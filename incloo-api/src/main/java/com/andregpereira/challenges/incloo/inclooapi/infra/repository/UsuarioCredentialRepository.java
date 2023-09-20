package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioCredentialRepository extends JpaRepository<UsuarioCredentialEntity, Long> {

    boolean existsByRole(String role);

    Optional<UsuarioCredentialEntity> findByUsername(String email);

}
