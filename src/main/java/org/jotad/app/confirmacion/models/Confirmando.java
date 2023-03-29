package org.jotad.app.confirmacion.models;

import java.time.LocalDate;

public class Confirmando {
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Boolean estado;
    private Sacramento sacramento;

    public Confirmando() {
    }

    public Confirmando(Integer id, String nombre, String telefono, String direccion, LocalDate fechaNacimiento, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Sacramento getSacramento() {
        return sacramento;
    }

    public void setSacramento(Sacramento sacramento) {
        this.sacramento = sacramento;
    }
}
