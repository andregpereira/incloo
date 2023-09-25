package com.andregpereira.challenges.incloo.inclooapi.app.service;

public interface ManutencaoService<C, U, R> {

    R update(Long id, U dto);

    void activate(Long id);

    void deactivate(Long id);

}
