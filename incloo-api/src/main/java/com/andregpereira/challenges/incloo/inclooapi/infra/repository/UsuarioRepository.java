package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<UsuarioEntity> {

    @Query(value = """
            SELECT COUNT(cpf) > 0 FROM tb_usuarios u
            WHERE u.cpf LIKE REPLACE(REPLACE(:cpf, '.', ''), '-', '')
            """, nativeQuery = true)
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    @Query(value = """
            SELECT * FROM tb_usuarios u
            WHERE u.cpf LIKE REPLACE(REPLACE(:cpf, '.', ''), '-', '') AND u.ativo = true
            """, nativeQuery = true)
    Optional<UsuarioEntity> findByCpf(String cpf);

    Optional<UsuarioEntity> findByEmailAndActiveTrue(String email);

    @Query(value = """
            SELECT * FROM tb_usuarios u
            WHERE u.nome ILIKE %:nome% AND u.ativo=true
            """, nativeQuery = true)
    Page<UsuarioEntity> findByName(@Param("nome") String nome, Pageable pageable);

}
