package com.neon.connectneon.dto.materias;

public class MateriaRequest {
    //id , nombre, creditos_necesarios
    //Nombre que recibimos

    private String nombre;
    private int creditos_necesarios;

    public MateriaRequest(){

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
