package com.andregpereira.challenges.incloo.inclooapi.cross.security.config;

import com.andregpereira.challenges.incloo.inclooapi.cross.security.Role;
import com.andregpereira.challenges.incloo.inclooapi.infra.entity.UsuarioCredentialEntity;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.UsuarioCredentialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class AdminConfig {

    private final UsuarioCredentialRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initSuperAdmin() {
        return args -> {
            log.info("Criando Admin...");
            if (!repository.existsByRole(Role.ADMIN.toString())) {
                repository.save(
                        new UsuarioCredentialEntity(null, "admin@incloo.com", passwordEncoder.encode("Admin123"),
                                Role.ADMIN.toString(), null, null, true));
                log.info("Admin criado");
                return;
            }
            log.info("Admin já existe");
        };
    }

}
