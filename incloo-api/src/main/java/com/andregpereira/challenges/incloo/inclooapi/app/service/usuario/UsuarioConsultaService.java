package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface UsuarioConsultaService permits UsuarioConsultaServiceImpl {

    Page<UsuarioDto> findAll(Pageable pageable);

    Page<UsuarioDto> findByNome(String nome, Pageable pageable);

    UsuarioDto findById(Long id);

    UsuarioDto findByCpf(String cpf);

    UsuarioDto findByEmail(String email);

}
