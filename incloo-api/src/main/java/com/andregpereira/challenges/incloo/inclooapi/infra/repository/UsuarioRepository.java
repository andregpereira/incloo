package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByCpf(String cpf);

    Optional<UsuarioEntity> findByCpf(String cpf);

    Optional<UsuarioEntity> findByIdAndAtivoTrue(Long id);

    Optional<UsuarioEntity> findByIdAndAtivoFalse(Long id);

}
