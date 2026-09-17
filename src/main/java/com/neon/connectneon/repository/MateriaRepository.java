package com.neon.connectneon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neon.connectneon.model.Materia;

public interface MateriaRepository extends  JpaRepository<Materia, Long>   {
    
    List<Materia> findByNombreContaining(String nombre);
}
