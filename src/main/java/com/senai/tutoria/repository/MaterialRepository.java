package com.senai.tutoria.repository;

import com.senai.tutoria.entity.AgendaEntity;
import com.senai.tutoria.entity.MaterialEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    List<MaterialEntity> findByAgenda(AgendaEntity agenda);

}