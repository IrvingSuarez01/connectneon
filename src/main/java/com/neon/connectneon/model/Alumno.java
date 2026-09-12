package com.neon.connectneon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity 
@Table (name="alumno")
@Data  
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Long matricula;
    private String semestre;
    private String telefono;    
    private int creditos_acumulados;

}
//id, nombre, apellido, matricula, semestre, telefono, creditos_acumulados