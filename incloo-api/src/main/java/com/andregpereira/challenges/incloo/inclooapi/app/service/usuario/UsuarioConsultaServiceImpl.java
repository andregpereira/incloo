package com.andregpereira.challenges.incloo.inclooapi.app.service.usuario;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.UsuarioServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.*;
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
    private final UsuarioFindByNomeUc findByNomeUc;
    private final UsuarioFindByIdUc findByIdUc;
    private final UsuarioFindByCpfUc findByCpfUc;
    private final UsuarioFindByEmailUc findByEmailUc;
    private final UsuarioServiceMapper mapper;

    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {
        return findAllUc.findAll(pageable).map(mapper::toUsuarioDto);
    }

    @Override
    public Page<UsuarioDto> findByNome(String nome, Pageable pageable) {
        return findByNomeUc.findByNome(nome, pageable).map(mapper::toUsuarioDto);
    }

    @Override
    public UsuarioDto findById(Long id) {
        return mapper.toUsuarioDto(findByIdUc.findById(id));
    }

    @Override
    public UsuarioDto findByCpf(String cpf) {
        return mapper.toUsuarioDto(findByCpfUc.findByCpf(cpf));
    }

    @Override
    public UsuarioDto findByEmail(String email) {
        return mapper.toUsuarioDto(findByEmailUc.findByEmail(email));
    }

}
