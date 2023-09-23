package com.andregpereira.challenges.incloo.inclooapi.infra.repository;

import com.andregpereira.challenges.incloo.inclooapi.infra.entity.CandidaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidaturaRepository extends JpaRepository<CandidaturaEntity, Long> {

}
