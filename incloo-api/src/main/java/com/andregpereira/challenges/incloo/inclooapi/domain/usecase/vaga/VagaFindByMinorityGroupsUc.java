package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public sealed interface VagaFindByPublicoAlvoUc permits VagaFindByPublicoAlvoUcImpl {

    Page<Vaga> findByPublicosAlvos(Set<String> publicosAlvos, Pageable pageable);

}
