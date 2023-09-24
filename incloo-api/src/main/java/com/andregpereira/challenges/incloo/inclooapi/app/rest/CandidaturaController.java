package com.andregpereira.challenges.incloo.inclooapi.app.rest;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.candidatura.CandidaturaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.candidatura.CandidaturaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    private final CandidaturaService service;

    @PostMapping
    public ResponseEntity<CandidaturaDto> create(@RequestPart CandidaturaCreateDto dto, @RequestPart MultipartFile cv,
            @RequestPart MultipartFile technicalTest) {
        log.info("Criando candidatura...");
        CandidaturaDto candidatura = service.create(dto, cv, technicalTest);
        log.info("Candidatura criada com sucesso");
        URI uri = UriComponentsBuilder.fromPath("/candidaturas/{id}").buildAndExpand(candidatura.id()).toUri();
        return ResponseEntity.created(uri).body(candidatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidaturaDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/baixar-cv/{id}")
    public ResponseEntity<ByteArrayResource> downloadCv(@PathVariable Long id) {
        return ResponseEntity.ok().headers(h -> h.setContentDisposition(ContentDisposition.attachment().filename(
                String.format("Candidatura_%1s-CV.pdf", id)).build())).contentType(MediaType.APPLICATION_PDF).body(
                service.downloadCv(id));
    }

    @GetMapping("/baixar-teste-tecnico/{id}")
    public ResponseEntity<ByteArrayResource> downloadSubmittedTechnicalTest(@PathVariable Long id) {
        return ResponseEntity.ok().headers(h -> h.setContentDisposition(ContentDisposition.attachment().filename(
                String.format("Candidatura_%1s-Teste_Tecnico.pdf", id)).build())).contentType(
                MediaType.APPLICATION_PDF).body(service.downloadSubmittedTechnicalTest(id));
    }

    @GetMapping
    public ResponseEntity<Page<CandidaturaDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

}
