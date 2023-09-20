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

    boolean existsByTitle(String titulo);

    @Query(value = """
            SELECT * FROM tb_vagas v
            WHERE v.title ILIKE %:title%
            """, nativeQuery = true)
    Page<VagaEntity> findByTitle(@Param("title") String title, Pageable pageable);

    Page<VagaEntity> findByMinorityGroupsIn(Set<String> minorityGroups, Pageable pageable);

}
