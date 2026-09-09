package com.neon.connectneon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neon.connectneon.model.Usuario;

public interface UsuarioRepository extends  JpaRepository<Usuario, Long>   {
    
}
