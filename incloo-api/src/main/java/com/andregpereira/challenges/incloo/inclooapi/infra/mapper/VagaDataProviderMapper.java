package com.andregpereira.challenges.incloo.inclooapi.infra.mapper;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import com.andregpereira.challenges.incloo.inclooapi.infra.entity.VagaEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = CandidaturaDataProviderMapper.class)
public interface VagaDataProviderMapper {

    @Mapping(target = "jobApplications", qualifiedByName = "toCandidaturaWithoutJobs")
    Vaga toVaga(VagaEntity e);

    VagaEntity toVagaEntity(Vaga v);

}
