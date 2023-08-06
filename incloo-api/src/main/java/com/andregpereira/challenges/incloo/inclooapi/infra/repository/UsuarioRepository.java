package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(value = """
            SELECT COUNT(cpf) > 0 FROM tb_usuarios u
            WHERE u.cpf LIKE REPLACE(REPLACE(:cpf, '.', ''), '-', '')
            """, nativeQuery = true)
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Optional<UsuarioEntity> findByCpf(String cpf);

    Optional<UsuarioEntity> findByIdAndAtivoTrue(Long id);

    Optional<UsuarioEntity> findByIdAndAtivoFalse(Long id);

    @Query(value = """
            SELECT * FROM tb_usuarios u
            WHERE u.cpf LIKE REPLACE(REPLACE(:cpf, '.', ''), '-', '')
            """, nativeQuery = true)
    Optional<UsuarioEntity> findByCpfAndAtivoTrue(String cpf);

}
