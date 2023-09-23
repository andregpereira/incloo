package com.andregpereira.challenges.incloo.inclooapi.app.mapper;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface VagaServiceMapper {

    Vaga toVaga(VagaCreateDto dto);

    VagaDto toVagaDto(Vaga v);

    VagaDetalhesDto toVagaDetalhesDto(Vaga v);

}
