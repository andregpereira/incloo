package com.andregpereira.challenges.incloo.inclooapi.app.mapper;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.credential.LoginDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.credential.UsuarioCredentialCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Login;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.UsuarioCredential;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UsuarioCredentialServiceMapper {

    UsuarioCredential toUsuarioCredential(UsuarioCredentialCreateDto dto);

    @Mapping(target = "username", source = "email")
    UsuarioCredential toUsuarioCredential(UsuarioCreateDto dto);

    Login toLogin(LoginDto dto);

}
