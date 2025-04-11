package com;

import java.time.Duration;
import java.time.LocalDateTime;


public class Pelicula extends Articulo{

    //ATRIBUTOS
    private Generos genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    //CONSTRUCTORES
    public Pelicula(String titulo, Generos genero){
        super(titulo);
        this.genero = genero;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    //METODOS PARA MOSTAR INFO
    @Override
    public String toString() {
        return "Pelicula [genero=" + genero + ", fechaAlquiler=" + fechaAlquiler + ", isAlquilada=" 
        + isAlquilada + "]";
    }
}