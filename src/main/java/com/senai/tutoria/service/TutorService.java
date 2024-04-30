package com.senai.tutoria.service;

import com.senai.tutoria.entity.TutorEntity;

import java.util.List;

public abstract class TutorService {
    public abstract List<TutorEntity> buscarTodos();

    public abstract TutorEntity buscarPorId(Long id);

    public abstract TutorEntity criar(TutorEntity entity);

    public abstract TutorEntity alterar(Long id, TutorEntity entity);

    public abstract void excluir(Long id);
}
