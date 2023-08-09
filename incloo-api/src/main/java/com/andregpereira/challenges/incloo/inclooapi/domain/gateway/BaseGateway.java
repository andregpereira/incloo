package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public interface BaseGateway<T> {

    T save(T t);

    T findById(Long id);

    T findByIdAndAtivoTrue(Long id, UnaryOperator<T> op);

    void findByIdAndAtivoTrue(Long id, Consumer<T> op);

    void findByIdAndAtivoFalse(Long id, Consumer<T> op);

}
