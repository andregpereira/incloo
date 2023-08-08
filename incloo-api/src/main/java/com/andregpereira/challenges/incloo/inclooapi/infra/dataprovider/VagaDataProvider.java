package com.andregpereira.challenges.incloo.inclooapi.infra.dataprovider;

import com.andregpereira.challenges.incloo.inclooapi.cross.exception.VagaNotFoundException;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import com.andregpereira.challenges.incloo.inclooapi.infra.mapper.VagaDataProviderMapper;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Service
public class VagaDataProvider implements VagaGateway {

    private final VagaRepository repository;
    private final VagaDataProviderMapper mapper;

    @Override
    @Transactional
    public Vaga save(Vaga vaga) {
        return mapper.toVaga(repository.save(mapper.toVagaEntity(vaga)));
    }

    @Override
    public boolean existsByTitulo(String titulo) {
        return repository.existsByTitulo(titulo);
    }

    @Override
    public Page<Vaga> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toVaga);
    }

    @Override
    public Page<Vaga> findByTitulo(String titulo, Pageable pageable) {
        return repository.findByTitulo(titulo, pageable).map(mapper::toVaga);
    }

    @Override
    public Page<Vaga> findByPublicosAlvos(Set<String> publicosAlvos, Pageable pageable) {
        return repository.findByPublicosAlvosIn(publicosAlvos, pageable).map(mapper::toVaga);
    }

    @Override
    public Vaga findById(Long id) {
        return repository.findById(id).map(mapper::toVaga).orElseThrow(() -> new VagaNotFoundException(id));
    }

    @Override
    public Vaga findByIdAndAtivoTrue(Long id) {
        return repository.findByIdAndAtivoTrue(id).map(mapper::toVaga).orElseThrow(
                () -> new VagaNotFoundException(id, true));
    }

    @Override
    public Vaga findByIdAndAtivoFalse(Long id) {
        return repository.findByIdAndAtivoFalse(id).map(mapper::toVaga).orElseThrow(
                () -> new VagaNotFoundException(id, false));
    }

}
