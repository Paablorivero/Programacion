package com.decroly.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    
    private static int contador = 0;

    //Atributos
    private int cod;
    private String titulo;
    private String genero;
    private String registro;
    private String baja;
    private String alquiler;
    private boolean isAlquilada;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    //Constructores
    public Pelicula(String titulo, String genero){
        this.cod = this.contador;
        this.contador++;

        this.titulo = titulo;
        this.genero = genero;
        this.registro = LocalDateTime.now().format(formatter);
        this.isAlquilada = false;
    }


    public static int getContador() {
        return contador;
    }
    public int getcodPelicula() {
        return cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getGenero() {
        return genero;
    }
    public String getfechaRegistro() {
        return registro;
    }
    public String getfechaBaja() {
        return baja;
    }
    public String getfechaAlquiler() {
        return alquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    public String mostrarCodigoPelicula(){
        String codigoPelicula = "Pel-0" + contador;
        return codigoPelicula;
    }
    public String mostrarInfoPelicula(){
        String getInfoPelicula = String.format("INFO DE LA PELICULA" + "\nCod: Pel-0%s, Titulo: %s, Genero: %s, Registro: %s", 
        this.cod, this.titulo, this.genero, this.registro);
        return getInfoPelicula;
    }
}
