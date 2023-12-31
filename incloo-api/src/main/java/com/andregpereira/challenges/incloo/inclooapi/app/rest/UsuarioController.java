package com.andregpereira.challenges.incloo.inclooapi.app.rest;

import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioCreateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDetalhesDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioDto;
import com.andregpereira.challenges.incloo.inclooapi.app.dto.usuario.UsuarioUpdateDto;
import com.andregpereira.challenges.incloo.inclooapi.app.service.usuario.UsuarioConsultaService;
import com.andregpereira.challenges.incloo.inclooapi.app.service.usuario.UsuarioManutencaoService;
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

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioManutencaoService manutencaoService;
    private final UsuarioConsultaService consultaService;

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody @Valid UsuarioCreateDto dto) {
        log.info("Criando usuário...");
        UsuarioDto usuario = manutencaoService.create(dto);
        log.info("Usuário criado com sucesso");
        URI uri = UriComponentsBuilder.fromPath("/usuarios/{id}").buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDto dto) {
        log.info("Atualizando usuário...");
        UsuarioDto usuario = manutencaoService.update(id, dto);
        log.info("Usuário atualizado com sucesso");
        URI uri = UriComponentsBuilder.fromPath("/usuarios/{id}").buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.ok().location(uri).body(usuario);
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
    public ResponseEntity<Page<UsuarioDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalhesDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @GetMapping("/cpf")
    public ResponseEntity<UsuarioDto> findByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(consultaService.findByCpf(cpf));
    }

    @GetMapping("/nome")
    public ResponseEntity<Page<UsuarioDto>> findByNome(@RequestParam String nome,
            @PageableDefault(sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(consultaService.findByNome(nome, pageable));
    }

}
