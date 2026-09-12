package com.neon.connectneon.dto.alumnos;

import lombok.Data;

@Data   
public class AlumnoRequest {
    //id , nombre, apellido, matricula, semestre, telefono, creditos_acumulados

    private String nombre;
    private String apellido;
    private Long matricula;
    private String semestre;
    private String telefono;    
    private int creditos_acumulados;

    public AlumnoRequest(){

    }

  
}
