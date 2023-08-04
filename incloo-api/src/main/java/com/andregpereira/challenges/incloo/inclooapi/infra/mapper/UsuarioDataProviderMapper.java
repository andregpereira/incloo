package com.andregpereira.challenges.incloo.inclooapi.infra.mapper;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioDataProviderMapper {

    Usuario toUsuario(UsuarioEntity e);

    UsuarioEntity toUsuarioEntity(Usuario u);

}
