package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface VagaFindByTituloUc permits VagaFindByTituloUcImpl {

    Page<Vaga> findByTitulo(String titulo, Pageable pageable);

}
