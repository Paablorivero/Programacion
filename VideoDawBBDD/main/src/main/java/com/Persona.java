package com;

import java.time.LocalDate;

public class Persona{

    private String dni; 
    private String nombre;
    private String direccion;
    private LocalDate nacimiento;

    
    public Persona(String dni, String nombre, String direccion, LocalDate nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", nacimiento=" + nacimiento
                + "]";
    }
}
