package com;

import java.util.Date;


public class Pelicula extends Articulo{

    //ATRIBUTOS
    private int cod;
    private String genero;

    //CONSTRUCTORES

    public Pelicula(int codigo, String titulo, String descripcion, Date fechaRegistro, String tipo, boolean isAlquilada, 
    int cod, String genero) {
        super(codigo, titulo, descripcion, fechaRegistro, tipo, isAlquilada);
        this.cod = cod;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula [cod=" + cod + ", genero=" + genero  + "]";
    }
}