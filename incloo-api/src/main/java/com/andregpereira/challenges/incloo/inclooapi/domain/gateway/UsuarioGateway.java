package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioGateway extends BaseGateway<Usuario> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Page<Usuario> findAll(Pageable pageable);

    Page<Usuario> findByNome(String nome, Pageable pageable);

    Usuario findByCpf(String cpf);

    Usuario findByEmail(String email);

}
