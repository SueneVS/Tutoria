package com.senai.tutoria.service.impl;

import com.senai.tutoria.entity.AgendaEntity;
import com.senai.tutoria.entity.AlunoEntity;
import com.senai.tutoria.entity.TutorEntity;
import com.senai.tutoria.exception.dto.NotFoundException;
import com.senai.tutoria.repository.AgendaRepository;
import com.senai.tutoria.service.AgendaService;
import com.senai.tutoria.service.AlunoService;
import com.senai.tutoria.service.TutorService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class AgendaServiceImpl extends AgendaService {
    private final AlunoService alunoService;
    private final TutorService tutorService;
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AlunoService alunoService, TutorService tutorService, AgendaRepository repository) {
        this.alunoService = alunoService;
        this.tutorService = tutorService;
        this.agendaRepository = repository;
    }

    @Override
    public List<AgendaEntity> buscarTodos() {
        return agendaRepository.findAll();
    }

    @Override
    public AgendaEntity buscarPorId(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Agenda não encontrada com id: " + id
                ));
    }

    @Override
    public AgendaEntity criar(AgendaEntity entity) {
        entity.setId(null);

        AlunoEntity aluno = alunoService.buscarPorId(entity.getAluno().getId());
        entity.setAluno(aluno);

        TutorEntity tutor = tutorService.buscarPorId(entity.getTutor().getId());
        entity.setTutor(tutor);

        return agendaRepository.save(entity);
    }

    @Override
    public AgendaEntity alterar(Long id, AgendaEntity entity) {
        buscarPorId(id);
        entity.setId(id);

        AlunoEntity aluno = alunoService.buscarPorId(entity.getAluno().getId());
        entity.setAluno(aluno);

        TutorEntity tutor = tutorService.buscarPorId(entity.getTutor().getId());
        entity.setTutor(tutor);

        return agendaRepository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AgendaEntity entity = buscarPorId(id);
        agendaRepository.delete(entity);
    }

    @Override
    public List<AgendaEntity> buscarAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return agendaRepository.findByAlunoIdOrderByData(alunoId);
    }

    @Override
    public List<AgendaEntity> buscarProximosAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return agendaRepository.findByAlunoIdAndDataGreaterThanOrderByData(alunoId, LocalDateTime.now());
    }

    @Override
    public List<AgendaEntity> buscarTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return AgendaRepository.findByTutorIdOrderByData(tutorId);
    }

    @Override
    public List<AgendaEntity> buscarProximosTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return agendaRepository.findByTutorIdAndDataGreaterThanOrderByData(tutorId, LocalDateTime.now());
    }
}
