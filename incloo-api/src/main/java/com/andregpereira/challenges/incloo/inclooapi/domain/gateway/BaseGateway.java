package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

public interface BaseGateway<T> {

    T save(T t);

    T findById(Long id);

    T findByIdAndAtivoTrue(Long id);

    T findByIdAndAtivoFalse(Long id);

}
