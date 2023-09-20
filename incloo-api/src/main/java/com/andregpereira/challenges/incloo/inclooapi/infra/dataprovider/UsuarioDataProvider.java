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

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

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
    public Page<Usuario> findByNome(String nome, Pageable pageable) {
        return repository.findByName(nome, pageable).map(mapper::toUsuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).map(mapper::toUsuario).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @Override
    public Usuario findByIdAndAtivoTrue(Long id, UnaryOperator<Usuario> op) {
        return op.apply(repository.findByIdAndActiveTrue(id).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(id, true)));
    }

    @Override
    public void findByIdAndAtivoTrue(Long id, Consumer<Usuario> op) {
        op.accept(repository.findByIdAndActiveTrue(id).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(id, true)));
    }

    @Override
    public void findByIdAndAtivoFalse(Long id, Consumer<Usuario> op) {
        op.accept(repository.findByIdAndActiveFalse(id).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(id, false)));
    }

    @Override
    public Usuario findByCpf(String cpf) {
        return repository.findByCpf(cpf).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException("CPF", cpf));
    }

    @Override
    public Usuario findByEmail(String email) {
        return repository.findByEmailAndActiveTrue(email).map(mapper::toUsuario).orElseThrow(
                () -> new UsuarioNotFoundException("e-mail", email));
    }

}
