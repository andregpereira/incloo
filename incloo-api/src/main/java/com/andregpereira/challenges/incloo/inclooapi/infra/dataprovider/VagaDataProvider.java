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
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

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
    public boolean existsByTitle(String title) {
        return repository.existsByTitle(title);
    }

    @Override
    public Page<Vaga> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toVaga);
    }

    @Override
    public Page<Vaga> findByTitle(String title, Pageable pageable) {
        return repository.findByTitle(title, pageable).map(mapper::toVaga);
    }

    @Override
    public Page<Vaga> findByMinorityGroups(Set<String> minorityGroups, Pageable pageable) {
        return repository.findByMinorityGroupsIn(minorityGroups, pageable).map(mapper::toVaga);
    }

    @Override
    public Vaga findById(Long id) {
        return repository.findById(id).map(mapper::toVaga).orElseThrow(() -> new VagaNotFoundException(id));
    }

    @Override
    public Vaga findByIdAndAtivoTrue(Long id, UnaryOperator<Vaga> op) {
        return op.apply(repository.findByIdAndActiveTrue(id).map(mapper::toVaga).orElseThrow(
                () -> new VagaNotFoundException(id, true)));
    }

    @Override
    public void findByIdAndAtivoTrue(Long id, Consumer<Vaga> op) {
        op.accept(repository.findByIdAndActiveTrue(id).map(mapper::toVaga).orElseThrow(
                () -> new VagaNotFoundException(id, true)));
    }

    @Override
    public void findByIdAndAtivoFalse(Long id, Consumer<Vaga> op) {
        op.accept(repository.findByIdAndActiveFalse(id).map(mapper::toVaga).orElseThrow(
                () -> new VagaNotFoundException(id, false)));
    }

}
