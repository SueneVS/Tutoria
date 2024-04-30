package com.senai.tutoria.service.impl;

import com.senai.tutoria.entity.AlunoEntity;
import com.senai.tutoria.exception.dto.NotFoundException;
import com.senai.tutoria.repository.AlunoRepository;
import com.senai.tutoria.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl extends AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlunoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AlunoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Aluno não encontrado com id: " + id
                ));
    }

    @Override
    public AlunoEntity criar(AlunoEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public AlunoEntity alterar(Long id, AlunoEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AlunoEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}