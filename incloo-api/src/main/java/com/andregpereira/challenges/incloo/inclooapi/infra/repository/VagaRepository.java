package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.VagaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VagaRepository extends BaseRepository<VagaEntity> {

    boolean existsByTitulo(String titulo);

    @Query(value = """
            SELECT * FROM tb_vagas v
            WHERE v.titulo ILIKE %:titulo%
            """, nativeQuery = true)
    Page<VagaEntity> findByTitulo(@Param("titulo") String titulo, Pageable pageable);

    Page<VagaEntity> findByPublicosAlvosIn(Set<String> publicosAlvos, Pageable pageable);

}
