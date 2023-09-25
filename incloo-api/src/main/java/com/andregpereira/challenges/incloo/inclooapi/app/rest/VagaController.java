package com.andregpereira.challenges.incloo.inclooapi.app.rest;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.vaga.VagaConsultaService;
import com.andregpereira.challenges.incloo.inclooapi.app.service.vaga.VagaManutencaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaManutencaoService manutencaoService;
    private final VagaConsultaService consultaService;

    @PostMapping
    public ResponseEntity<VagaDto> create(@RequestPart @Valid VagaCreateDto dto,
            @RequestPart(required = false) MultipartFile technicalTest) {
        log.info("Criando vaga...");
        VagaDto vaga = manutencaoService.create(dto, technicalTest);
        log.info("Vaga criada com sucesso");
        URI uri = UriComponentsBuilder.fromPath("/vagas/{id}").buildAndExpand(vaga.id()).toUri();
        return ResponseEntity.created(uri).body(vaga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDto> update(@PathVariable Long id, @RequestBody @Valid VagaCreateDto dto) {
        log.info("Atualizando vaga...");
        VagaDto vaga = manutencaoService.update(id, dto);
        log.info("Vaga atualizada com sucesso");
        URI uri = UriComponentsBuilder.fromPath("/vagas/{id}").buildAndExpand(vaga.id()).toUri();
        return ResponseEntity.ok().location(uri).body(vaga);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> activate(@PathVariable Long id) {
        manutencaoService.activate(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        manutencaoService.deactivate(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("baixar-teste/{id}")
    public ResponseEntity<ByteArrayResource> downloadTechnicalTest(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.downloadTechnicalTest(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDetalhesDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VagaDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findAll(pageable).stream().toList());
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<VagaDto>> findByTitle(@RequestParam String title,
            @PageableDefault(sort = "title") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findByTitle(title, pageable).stream().toList());
    }

    @GetMapping("/publicos-alvos")
    public ResponseEntity<List<VagaDto>> findByMinorityGroups(@RequestParam("publicos") Set<String> minorityGroups,
            @PageableDefault(sort = "id_vaga") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findByMinorityGroups(minorityGroups, pageable).stream().toList());
    }

}
