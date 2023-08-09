package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ConsultaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public sealed interface UsuarioConsultaService extends ConsultaService<UsuarioDto> permits UsuarioConsultaServiceImpl {

    Page<UsuarioDto> findByNome(String nome, Pageable pageable);

    UsuarioDto findByCpf(String cpf);

    UsuarioDto findByEmail(String email);

}
