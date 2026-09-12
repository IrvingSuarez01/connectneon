package com.neon.connectneon.dto.materias;

public class MateriaResponse {
    private Long id;
    private String nombre;
    private String creditos_necesarios;

 

    public MateriaResponse(Long id, String nombre, String creditos_necesarios) {
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

    public String getCreditosNecesarios() {
        return creditos_necesarios;
    }

    public void setCreditosNecesarios(String creditos_necesarios) {
        this.creditos_necesarios = creditos_necesarios;
    }
}
