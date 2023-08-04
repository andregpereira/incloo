package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.UsuarioServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioFindAllUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioFindByIdUc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public non-sealed class UsuarioConsultaServiceImpl implements UsuarioConsultaService {

    private final UsuarioFindAllUc findAllUc;
    private final UsuarioFindByIdUc findByIdUc;
    private final UsuarioServiceMapper mapper;

    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {
        return findAllUc.findAll(pageable).map(mapper::toUsuarioDto);
    }

    @Override
    public UsuarioDto findById(Long id) {
        return mapper.toUsuarioDto(findByIdUc.findById(id));
    }

    @Override
    public UsuarioDto findByCpf(String cpf) {
        // TODO
        return null;
    }

    @Override
    public UsuarioDto findByNome(String nome) {
        // TODO
        return null;
    }

}
