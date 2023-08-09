package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioUpdateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.UsuarioServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioActivateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioCreateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioDeactivateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioUpdateUc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public non-sealed class UsuarioManutencaoServiceImpl implements UsuarioManutencaoService {

    private final UsuarioCreateUc createUc;
    private final UsuarioUpdateUc updateUc;
    private final UsuarioActivateUc activateUc;
    private final UsuarioDeactivateUc deactivateUc;
    private final UsuarioServiceMapper mapper;

    @Override
    public UsuarioDto create(UsuarioCreateDto dto) {
        return mapper.toUsuarioDto(createUc.create(mapper.toUsuario(dto)));
    }

    @Override
    public UsuarioDto update(Long id, UsuarioUpdateDto dto) {
        return mapper.toUsuarioDto(updateUc.update(id, mapper.toUsuario(dto)));
    }

    @Override
    public void activate(Long id) {
        activateUc.activate(id);
    }

    @Override
    public void deactivate(Long id) {
        deactivateUc.deactivate(id);
    }

}
