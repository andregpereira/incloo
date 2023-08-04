package com.andregpereira.challenges.incloo.inclooapi.infra.dataprovider;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.UsuarioGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Usuario;
import com.andregpereira.challenges.incloo.inclooapi.infra.mapper.UsuarioDataProviderMapper;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor
@Slf4j
@Service
public class UsuarioDataProvider implements UsuarioGateway {

    private final UsuarioRepository repository;
    private final UsuarioDataProviderMapper mapper;

    @Override
    public Usuario save(Usuario usuario) {
        return mapper.toUsuario(repository.save(mapper.toUsuarioEntity(usuario)));
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return Optional.of(repository.findAll(pageable)).filter(not(Page::isEmpty)).map(
                p -> p.map(mapper::toUsuario)).orElseThrow(RuntimeException::new);
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).map(mapper::toUsuario).orElseThrow(RuntimeException::new);
    }

    @Override
    public Usuario findByIdAndAtivoTrue(Long id) {
        return repository.findByIdAndAtivoTrue(id).map(mapper::toUsuario).orElseThrow(RuntimeException::new);
    }

    @Override
    public Usuario findByIdAndAtivoFalse(Long id) {
        return repository.findByIdAndAtivoFalse(id).map(mapper::toUsuario).orElseThrow(RuntimeException::new);
    }

    @Override
    public Usuario findByCpf(String cpf) {
        return repository.findByCpf(cpf).map(mapper::toUsuario).orElseThrow(RuntimeException::new);
    }

    @Override
    public Page<Usuario> findByNome(String nome) {
        return null;
    }

}
