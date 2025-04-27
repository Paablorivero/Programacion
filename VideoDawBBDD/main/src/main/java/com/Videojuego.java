package com;

import java.sql.Date;

public class Videojuego extends Articulo{

    private int cod;
    private GenerosVideojuego genero;
    
    public Videojuego(int codigo, String titulo, String descripcion, Date fechaRegistro, String tipo, boolean isAlquilada,
    int cod, GenerosVideojuego genero) {
        super(codigo, titulo, descripcion, fechaRegistro, tipo, isAlquilada);
        this.cod = cod;
        this.genero = genero;
    }

    public GenerosVideojuego getGenero() {
        return genero;
    }

    public void setGenero(GenerosVideojuego genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Videojuego [cod=" + cod + ", genero=" + genero + "]";
    }
}
