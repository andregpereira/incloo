package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioUpdateDto;

public sealed interface UsuarioManutencaoService permits UsuarioManutencaoServiceImpl {

    UsuarioDto create(UsuarioCreateDto dto);

    UsuarioDto update(Long id, UsuarioUpdateDto dto);

    void activate(Long id);

    void deactivate(Long id);

}
