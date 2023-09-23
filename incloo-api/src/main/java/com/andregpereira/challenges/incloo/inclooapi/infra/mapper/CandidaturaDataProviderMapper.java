package com.andregpereira.challenges.incloo.inclooapi.infra.mapper;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import com.andregpereira.challenges.incloo.inclooapi.infra.entity.CandidaturaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidaturaDataProviderMapper {

    Candidatura toCandidatura(CandidaturaEntity e);

    CandidaturaEntity toCandidaturaEntity(Candidatura v);

}
