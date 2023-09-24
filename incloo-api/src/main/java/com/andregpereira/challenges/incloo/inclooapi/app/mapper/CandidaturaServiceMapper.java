package com.andregpereira.challenges.incloo.inclooapi.app.mapper;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaDto;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CandidaturaServiceMapper {

    @Mapping(target = "cv", expression = "java(org.hibernate.engine.jdbc.BlobProxy.generateProxy(cv.getBytes()))")
    @Mapping(target = "submittedTechnicalTest",
            expression = "java(org.hibernate.engine.jdbc.BlobProxy.generateProxy(technicalTest.getBytes()))")
    Candidatura toCandidatura(CandidaturaCreateDto dto, MultipartFile cv,
            MultipartFile technicalTest) throws IOException;

    CandidaturaDto toCandidaturaDto(Candidatura v);

}
