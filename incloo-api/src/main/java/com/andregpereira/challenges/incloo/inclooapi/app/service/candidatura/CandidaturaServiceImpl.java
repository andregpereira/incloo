package com.andregpereira.challenges.incloo.inclooapi.app.service.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.mapper.CandidaturaServiceMapper;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Candidatura;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura.CandidaturaCreateUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura.CandidaturaFindAllUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.candidatura.CandidaturaFindByIdUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.usuario.UsuarioFindByIdUc;
import com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga.VagaFindByIdUc;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Slf4j
@Service
public class CandidaturaServiceImpl implements CandidaturaService {

    private final CandidaturaCreateUc createUc;
    private final CandidaturaFindByIdUc candidaturaFindByIdUc;
    private final CandidaturaFindAllUc findAllUc;
    private final UsuarioFindByIdUc usuarioFindByIdUc;
    private final VagaFindByIdUc vagaFindByIdUc;
    private final CandidaturaServiceMapper mapper;

    @Override
    @SneakyThrows
    public CandidaturaDto create(CandidaturaCreateDto dto, MultipartFile cv, MultipartFile technicalTest) {
        Candidatura candidatura = mapper.toCandidatura(dto, cv, technicalTest);
        candidatura.setUser(usuarioFindByIdUc.findById(dto.userId()));
        candidatura.setJob(vagaFindByIdUc.findById(dto.jobId()));
        return mapper.toCandidaturaDto(createUc.create(candidatura));
    }

    @Override
    public CandidaturaDto findById(Long id) {
        return mapper.toCandidaturaDto(candidaturaFindByIdUc.findById(id));
    }

    @Override
    public ByteArrayResource downloadCv(Long id) {
        return new ByteArrayResource(candidaturaFindByIdUc.findById(id).getCv());
    }

    @Override
    public ByteArrayResource downloadSubmittedTechnicalTest(Long id) {
        return new ByteArrayResource(candidaturaFindByIdUc.findById(id).getSubmittedTechnicalTest());
    }

    @Override
    public Page<CandidaturaDto> findAll(Pageable pageable) {
        return findAllUc.findAll(pageable).map(mapper::toCandidaturaDto);
    }

}
