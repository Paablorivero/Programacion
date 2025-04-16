package com;

import java.util.Date;


public class Pelicula extends Articulo{

    //ATRIBUTOS
    private String genero;
    private Date fechaAlquiler;
    private boolean isAlquilada;

    //CONSTRUCTORES

    public Pelicula(int cod, String titulo, String descripcion, Date fechaRegistro, String genero, boolean alquilada) {
        super(cod, titulo, descripcion, fechaRegistro);
        this.genero = genero;
        this.isAlquilada = alquilada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    @Override
    public String toString() {
        return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", fechaRegistro=" + fechaRegistro +
        ", genero=" + genero + ", isAlquilada=" + isAlquilada + "]";
    }


    
}