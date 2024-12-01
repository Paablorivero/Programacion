package com.decroly.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pelicula {
    
    private static int contador = 0;

    //Atributos
    private int cod;
    private String titulo;
    private Generos genero;
    private String registro;
    private String fechaBaja;
    private String fechaAlquiler;
    private boolean isAlquilada;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    //Constructores
    public Pelicula(String titulo, Generos genero){
        this.cod = this.contador;
        this.contador++;

        this.titulo = titulo;
        this.genero = genero;
        this.registro = LocalDateTime.now().format(formatter);
        this.isAlquilada = false;
    }

    public int getcodPelicula() {
        return cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public Generos getGenero() {
        return genero;
    }
    public String getfechaRegistro() {
        return registro;
    }
    public String getfechaBaja() {
        return fechaBaja;
    }
    public String getfechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    public String InfoPelicula(){
        String getInfoPelicula = String.format("\nCod: Pel-%s, Titulo: %s, Genero: %s, Registro: %s", 
        this.cod, this.titulo, this.genero, this.registro);
        return getInfoPelicula;
    }

    public boolean Alquiler(){
        isAlquilada = true;
        this.fechaAlquiler = LocalDateTime.now().format(formatter);
        return isAlquilada;
    }
}

