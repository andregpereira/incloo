package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface VagaGateway extends BaseGateway<Vaga> {

    boolean existsByTitulo(String titulo);

    Page<Vaga> findAll(Pageable pageable);

    Page<Vaga> findByTitulo(String titulo, Pageable pageable);

    Page<Vaga> findByPublicosAlvos(Set<String> publicosAlvos, Pageable pageable);

}
