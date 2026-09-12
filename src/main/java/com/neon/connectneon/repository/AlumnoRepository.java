package com.neon.connectneon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neon.connectneon.model.Alumno;


public interface AlumnoRepository extends  JpaRepository<Alumno, Long>   {
    
}
