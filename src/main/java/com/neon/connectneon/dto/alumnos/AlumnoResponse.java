package com.neon.connectneon.dto.alumnos;

import lombok.Data;

@Data 
public class AlumnoResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Long matricula;
    private String semestre;
    private String telefono;    
    private int creditos_acumulados;

    public AlumnoResponse(Long id, String nombre, String apellido, Long matricula, String semestre, String telefono, int creditos_acumulados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.semestre = semestre;
        this.telefono = telefono;
        this.creditos_acumulados = creditos_acumulados;
    }
}
