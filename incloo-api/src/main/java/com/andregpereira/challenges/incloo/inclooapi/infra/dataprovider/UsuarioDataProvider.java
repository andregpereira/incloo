package com.andregpereira.challenges.incloo.inclooapi.infra.dataprovider;

import com.andregpereira.challenges.incloo.inclooapi.cross.exception.UsuarioNotFoundException;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import com.andregpereira.challenges.incloo.inclooapi.infra.mapper.UsuarioDataProviderMapper;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UsuarioDataProvider implements UsuarioGateway {

    private final UsuarioRepository repository;
    private final UsuarioDataProviderMapper mapper;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return mapper.toUsuario(repository.save(mapper.toUsuarioEntity(usuario)));
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toUsuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).map(mapper::toUsuario).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @Override
    public Usuario findByIdAndAtivoTrue(Long id) {
        return repository.findByIdAndAtivoTrue(id).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(id, true));
    }

    @Override
    public Usuario findByIdAndAtivoFalse(Long id) {
        return repository.findByIdAndAtivoFalse(id).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(id, false));
    }

    @Override
    public Usuario findByCpf(String cpf) {
        return repository.findByCpf(cpf).map(mapper::toUsuario).orElseThrow(() -> new UsuarioNotFoundException(cpf));
    }

    @Override
    public Page<Usuario> findByNome(String nome) {
        // TODO
        return null;
    }

}
