package com.andregpereira.challenges.incloo.inclooapi.cross.security.service;

import com.andregpereira.challenges.incloo.inclooapi.infra.mapper.UsuarioCredentialDataProviderMapper;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.UsuarioCredentialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioCredentialRepository repository;
    private final UsuarioCredentialDataProviderMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username).map(mapper::toUsuarioCredential).orElseThrow(
                () -> new UsernameNotFoundException(MessageFormat.format("Usuário {0} não encontrado", username)));
    }

}
