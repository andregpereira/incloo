package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioUpdateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.ManutencaoService;

public sealed interface UsuarioManutencaoService extends ManutencaoService<UsuarioCreateDto, UsuarioUpdateDto, UsuarioDto> permits UsuarioManutencaoServiceImpl {

    UsuarioDto create(UsuarioCreateDto dto);

}
