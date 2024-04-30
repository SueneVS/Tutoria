package com.senai.tutoria.controller;

import com.senai.tutoria.entity.AgendaEntity;
import com.senai.tutoria.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {
    private final AgendaService service;

    public AgendamentoController(AgendaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("aluno-id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> getAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarAlunoId(alunoId));
    }

    @GetMapping("aluno-id/{alunoId}/vigentes")
    public ResponseEntity<List<AgendaEntity>> getProximosPorAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarProximosAlunoId(alunoId));
    }

    @GetMapping("tutor-id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> getTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(service.buscarTutorId(tutorId));
    }

    @GetMapping("tutor-id/{tutorId}/vigentes")
    public ResponseEntity<List<AgendaEntity>> getProximosPorTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(service.buscarProximosTutorId(tutorId));
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaEntity request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> update(
            @PathVariable Long id, @RequestBody AgendaEntity request
    ) {
        return ResponseEntity.ok(service.alterar(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
