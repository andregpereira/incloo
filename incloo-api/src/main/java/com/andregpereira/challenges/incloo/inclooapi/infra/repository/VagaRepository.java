package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.VagaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VagaRepository extends BaseRepository<VagaEntity> {

    boolean existsByTitle(String title);

    @Query(value = """
            SELECT * FROM tb_vagas v
            WHERE v.title ILIKE %:title%
            """, nativeQuery = true)
    Page<VagaEntity> findByTitle(@Param("title") String title, Pageable pageable);

    @Query(value = """
            SELECT * FROM tb_vagas v WHERE v.id_vaga IN
            (SELECT va.id_vaga FROM tb_vagas va
            JOIN vaga_minority_groups vmg ON va.id_vaga = vmg.vaga_id_vaga WHERE vmg.minority_groups IN
            (:minorityGroups) GROUP BY va.id_vaga
            HAVING COUNT(va.id_vaga) = :countMinorityGroups)
            """, nativeQuery = true)
    Page<VagaEntity> findByMinorityGroupsIn(@Param("minorityGroups") Collection<String> minorityGroups,
            @Param("countMinorityGroups") long countMinorityGroups, Pageable pageable);

}
