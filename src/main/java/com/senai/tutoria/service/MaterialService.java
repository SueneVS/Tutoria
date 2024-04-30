package com.senai.tutoria.service;

import com.senai.tutoria.entity.MaterialEntity;

import java.util.List;

public abstract class MaterialService {
    public abstract List<MaterialEntity> buscarTodos();

    public abstract MaterialEntity buscarPorId(Long id);

    public abstract List<MaterialEntity> buscarPorAgenda(Long agendaId);

    public abstract MaterialEntity criar(MaterialEntity entity);

    public abstract MaterialEntity alterar(Long id, MaterialEntity entity);

    public abstract void excluir(Long id);
}
