package com.neon.connectneon.dto.materias;

public class MateriaRequest {
    //id , nombre, creditos_necesarios
    //Nombre que recibimos

    private String nombre;
    private String creditos_necesarios;

    public MateriaRequest(){

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
