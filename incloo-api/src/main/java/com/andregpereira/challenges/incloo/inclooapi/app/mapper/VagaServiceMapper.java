package com.andregpereira.challenges.incloo.inclooapi.app.mapper;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface VagaServiceMapper {

    Vaga toVaga(VagaCreateDto dto);

    @Mapping(target = "technicalTest",
            expression = "java(org.hibernate.engine.jdbc.BlobProxy.generateProxy(technicalTest.getBytes()))")
    Vaga toVaga(VagaCreateDto dto, MultipartFile technicalTest) throws IOException;

    VagaDto toVagaDto(Vaga v);

    VagaDetalhesDto toVagaDetalhesDto(Vaga v);

}
