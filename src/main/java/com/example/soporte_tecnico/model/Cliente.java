package com.example.soporte_tecnico.model;


import jakarta.validation.constraints.NotBlank;

public class Cliente {
    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El email del cliente es obligatorio")
    private String email;

    public Cliente() {}
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}