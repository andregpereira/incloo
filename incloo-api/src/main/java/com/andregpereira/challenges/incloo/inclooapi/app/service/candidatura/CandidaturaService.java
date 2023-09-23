package com.andregpereira.challenges.incloo.inclooapi.app.service.candidatura;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface CandidaturaService {

    CandidaturaDto create(CandidaturaCreateDto dto, MultipartFile cv, MultipartFile technicalTest);

    CandidaturaDto findById(Long id);

    ByteArrayResource downloadCv(Long id);

    ByteArrayResource downloadSubmittedTechnicalTest(Long id);

    Page<CandidaturaDto> findAll(Pageable pageable);

}
