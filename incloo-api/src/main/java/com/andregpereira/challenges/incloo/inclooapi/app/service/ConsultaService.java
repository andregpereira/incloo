package com.andregpereira.challenges.incloo.inclooapi.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsultaService<R> {

    Page<R> findAll(Pageable pageable);

    R findById(Long id);

}
