package com.senai.tutoria.service;

import com.senai.tutoria.entity.AgendaEntity;

import java.util.List;

public abstract class AgendaService {

    public abstract List<AgendaEntity> buscarTodos();

    public abstract AgendaEntity buscarPorId(Long id);

    public abstract AgendaEntity criar(AgendaEntity entity);

    public abstract AgendaEntity alterar(Long id, AgendaEntity entity);

    public abstract void excluir(Long id);

    public abstract List<AgendaEntity> buscarAlunoId(Long alunoId);

    public abstract List<AgendaEntity> buscarProximosAlunoId(Long alunoId);

    public abstract List<AgendaEntity> buscarTutorId(Long tutorId);

    public abstract List<AgendaEntity> buscarProximosTutorId(Long tutorId);
}
