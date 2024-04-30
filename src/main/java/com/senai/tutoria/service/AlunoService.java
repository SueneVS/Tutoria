package com.senai.tutoria.service;

import com.senai.tutoria.entity.AlunoEntity;

import java.util.List;

public abstract class AlunoService {
    public abstract List<AlunoEntity> buscarTodos();

    public abstract AlunoEntity buscarPorId(Long id);

    public abstract AlunoEntity criar(AlunoEntity entity);

    public abstract AlunoEntity alterar(Long id, AlunoEntity entity);

    public abstract void excluir(Long id);
}
