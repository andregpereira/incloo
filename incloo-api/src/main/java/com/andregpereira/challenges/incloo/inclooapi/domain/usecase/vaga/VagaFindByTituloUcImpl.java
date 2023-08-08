package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaFindByTituloUcImpl implements VagaFindByTituloUc {

    private final VagaGateway gateway;

    @Override
    public Page<Vaga> findByTitulo(Vaga vaga, Pageable pageable) {
        return gateway.findByTitulo(vaga.getTitulo(), pageable);
    }

}
