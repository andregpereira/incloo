package com.andregpereira.challenges.incloo.inclooapi.infra.mapper;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import com.andregpereira.challenges.incloo.inclooapi.infra.entity.CandidaturaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidaturaDataProviderMapper {

    @Mapping(target = "user.jobApplications", ignore = true)
    @Mapping(target = "job.jobApplications", ignore = true)
    Candidatura toCandidatura(CandidaturaEntity e);

    @Named("toCandidaturaWithoutUsers")
    @Mapping(target = "user.jobApplications", ignore = true)
    Candidatura toCandidaturaWithoutUsers(CandidaturaEntity e);

    @Named("toCandidaturaWithoutJobs")
    @Mapping(target = "job.jobApplications", ignore = true)
    Candidatura toCandidaturaWithoutJobs(CandidaturaEntity e);

    CandidaturaEntity toCandidaturaEntity(Candidatura v);

}
