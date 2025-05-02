package com;

import java.util.Date;

public class Cliente{
    private static int contador = 0;

    //ATRIBUTOS
    private int cod;
    private String dni;
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;
    private Date fechaBaja;
    private int nalquiladas;
    private int nArticulos;

    public Cliente(String dni, String nombre, String direccion, Date fechaNacimiento) {
        this.cod = contador; 
        contador++; 
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(int cod, String dni, String nombre){
        this.cod = cod;
        this.dni = dni;
        this.nombre = nombre;

    }

    public int getCod() {
        return cod;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getNalquiladas() {
        return nalquiladas;
    }

    public void setNalquiladas(int nalquiladas) {
        this.nalquiladas = nalquiladas;
    }

    public int getnArticulos() {
        return nArticulos;
    }

    public void setnArticulos(int nArticulos) {
        this.nArticulos = nArticulos;
    }

    @Override
    public String toString() {
        return "Cliente [cod=" + cod + ", dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion
                + ", fechaNacimiento=" + fechaNacimiento + ", fechaBaja=" + fechaBaja + ", nalquiladas=" + nalquiladas
                + ", nArticulos=" + nArticulos + "]";
    }

    

   
}