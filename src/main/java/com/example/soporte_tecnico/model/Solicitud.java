//Marco suarez

package com.example.soporte_tecnico.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Solicitud {
    private Long id; 
    
    @NotBlank(message = "El título del problema es obligatorio")
    @Size(min = 5, max = 150, message = "El título debe tener entre 5 y 150 caracteres")
    private String titulo;
    
    @NotBlank(message = "La descripción del problema es obligatoria")
    private String descripcion;
    
    @NotNull(message = "Los datos del cliente son obligatorios")
    @Valid
    private Cliente cliente; 

    private String estado; 
    
    @Min(value = 1, message = "La prioridad debe ser al menos 1")
    @NotNull(message = "La prioridad es obligatoria")
    private Integer prioridad;

    public Solicitud() {
        this.estado = "Pendiente"; 
    }

    public Solicitud(Long id, String titulo, String descripcion, Cliente cliente, Integer prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.prioridad = prioridad;
        this.estado = "Pendiente";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Integer getPrioridad() { return prioridad; }
    public void setPrioridad(Integer prioridad) { this.prioridad = prioridad; }
}
