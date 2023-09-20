package com.andregpereira.challenges.incloo.inclooapi.infra.dataprovider;

import com.andregpereira.challenges.incloo.inclooapi.cross.exception.UsuarioNotFoundException;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioCredentialGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.UsuarioCredential;
import com.andregpereira.challenges.incloo.inclooapi.infra.mapper.UsuarioCredentialDataProviderMapper;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.UsuarioCredentialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.UnaryOperator;

@RequiredArgsConstructor
@Slf4j
@Component
public class UsuarioCredentialDataProvider implements UsuarioCredentialGateway {

    private final UsuarioCredentialRepository repository;
    private final UsuarioCredentialDataProviderMapper mapper;

    @Override
    @Transactional
    public UsuarioCredential save(UsuarioCredential usuarioCredential) {
        return mapper.toUsuarioCredential(repository.save(mapper.toUsuarioCredentialEntity(usuarioCredential)));
    }

    @Override
    public UsuarioCredential findById(Long id) {
        return repository.findById(id).map(mapper::toUsuarioCredential).orElseThrow(
                () -> new UsuarioNotFoundException(id));
    }

    @Override
    public UsuarioCredential findByIdAndEnabledTrue(Long id, UnaryOperator<UsuarioCredential> op) {
        return op.apply(repository.findById(id).map(mapper::toUsuarioCredential).orElseThrow(
                () -> new UsuarioNotFoundException(id)));
    }

}
