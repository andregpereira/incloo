package com.andregpereira.challenges.incloo.inclooapi.infra.dataprovider;

import com.andregpereira.challenges.incloo.inclooapi.cross.exception.CandidaturaNotFoundException;
import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.CandidaturaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import com.andregpereira.challenges.incloo.inclooapi.infra.mapper.CandidaturaDataProviderMapper;
import com.andregpereira.challenges.incloo.inclooapi.infra.repository.CandidaturaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CandidaturaDataProvider implements CandidaturaGateway {

    private final CandidaturaRepository repository;
    private final CandidaturaDataProviderMapper mapper;

    @Override
    public Candidatura save(Candidatura candidatura) {
        return mapper.toCandidatura(repository.save(mapper.toCandidaturaEntity(candidatura)));
    }

    @Override
    public Candidatura findById(Long id) {
        return repository.findById(id).map(mapper::toCandidatura).orElseThrow(
                () -> new CandidaturaNotFoundException(id));
    }

    @Override
    public Page<Candidatura> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toCandidatura);
    }

}
