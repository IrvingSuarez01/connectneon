package com.neon.connectneon.dto;

public class UsuarioRequest {
    
    //Nombre que recibimos
    private String nombre;

    private String email;

    public UsuarioRequest(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
