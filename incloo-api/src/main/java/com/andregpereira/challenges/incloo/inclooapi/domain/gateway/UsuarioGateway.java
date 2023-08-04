package com.andregpereira.challenges.incloo.inclooapi.domain.gateway;

import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioGateway {

    Usuario save(Usuario usuario);

    boolean existsByCpf(String cpf);

    Page<Usuario> findAll(Pageable pageable);

    Usuario findById(Long id);

    Usuario findByIdAndAtivoTrue(Long id);

    Usuario findByIdAndAtivoFalse(Long id);

    Usuario findByCpf(String cpf);

    Page<Usuario> findByNome(String nome);

}
