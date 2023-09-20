package com.andregpereira.challenges.incloo.inclooapi.infra.mapper;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.UsuarioCredential;
import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioCredentialEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioCredentialDataProviderMapper {

    @Mapping(target = "authorities",
            expression = "java(java.util.Set.of(com.andregpereira.challenges.incloo.inclooapi.cross.security.Role.valueOf(e.getRole())))")
    UsuarioCredential toUsuarioCredential(UsuarioCredentialEntity e);

    @Mapping(target = "role", expression = "java(u.getAuthorities().stream().findFirst().get().toString())")
    UsuarioCredentialEntity toUsuarioCredentialEntity(UsuarioCredential u);

}
