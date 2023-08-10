package com.andregpereira.challenges.incloo.inclooapi.app.rest;

import com.andregpereira.challenges.incloo.inclooapi.app.constant.VulnerabilidadeSocial;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.vaga.VagaDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.vaga.VagaConsultaService;
import com.andregpereira.challenges.incloo.inclooapi.app.service.vaga.VagaManutencaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<VagaDto> create(@RequestBody @Valid VagaCreateDto dto) {
        log.info("Criando vaga...");
        VagaDto vaga = manutencaoService.create(dto);
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

    @GetMapping
    public ResponseEntity<Page<VagaDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @GetMapping("/titulo")
    public ResponseEntity<Page<VagaDto>> findByTitulo(@RequestParam String titulo,
            @PageableDefault(sort = "titulo") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findByTitulo(titulo, pageable));
    }

    @GetMapping("/publicos-alvos")
    public ResponseEntity<Page<VagaDto>> findByPublicosAlvos(
            @RequestParam("publicos") Set<VulnerabilidadeSocial> publicosAlvos,
            @PageableDefault(sort = "publicosAlvos") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findByPublicosAlvos(publicosAlvos, pageable));
    }

}
