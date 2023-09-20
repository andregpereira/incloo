package com.andregpereira.challenges.incloo.inclooapi.app.mapper;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioUpdateDto;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UsuarioServiceMapper {

    Usuario toUsuario(UsuarioCreateDto dto);

    Usuario toUsuario(UsuarioUpdateDto dto);

    UsuarioDto toUsuarioDto(Usuario u);

}
