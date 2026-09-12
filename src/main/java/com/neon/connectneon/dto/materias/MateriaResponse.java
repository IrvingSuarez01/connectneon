package com.neon.connectneon.dto.materias;

public class MateriaResponse {
    private Long id;
    private String nombre;
    private int creditos_necesarios;

 

    public MateriaResponse(Long id, String nombre, int creditos_necesarios) {
        this.id = id;   
        this.nombre=nombre;
        this.creditos_necesarios = creditos_necesarios;
    }

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditosNecesarios() {
        return creditos_necesarios;
    }

    public void setCreditosNecesarios(int creditos_necesarios) {
        this.creditos_necesarios = creditos_necesarios;
    }
}
