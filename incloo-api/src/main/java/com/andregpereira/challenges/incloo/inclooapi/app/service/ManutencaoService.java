package com.andregpereira.challenges.incloo.inclooapi.app.service;

public interface ManutencaoService<T, U, R> {

    R create(T dto);

    R update(Long id, U dto);

    void activate(Long id);

    void deactivate(Long id);

}
