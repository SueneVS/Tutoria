package com.senai.tutoria.repository;

import com.senai.tutoria.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}