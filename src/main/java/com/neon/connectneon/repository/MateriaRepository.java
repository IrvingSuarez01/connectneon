package com.neon.connectneon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neon.connectneon.model.Materia;

public interface MateriaRepository extends  JpaRepository<Materia, Long>   {
    
}
