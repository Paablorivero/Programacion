<<<<<<< HEAD
package com.decroly.daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    
    private static int contador = 0;

    //Atributos
    private int cod;
    private String titulo;
    private Generos genero;
    private LocalDateTime registro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    //Constructores
    public Pelicula(String titulo, Generos genero){
        this.cod = this.contador;
        this.contador++;

        this.titulo = titulo;
        this.genero = genero;
        this.registro = LocalDateTime.now();
        this.isAlquilada = false;
        this.fechaAlquiler = fechaAlquiler;
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
    public LocalDateTime getfechaRegistro() {
        return registro;
    }
    public LocalDate getfechaBaja() {
        return fechaBaja;
    }
    public LocalDateTime getfechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    public String InfoPelicula(){
        String getInfoPelicula = String.format("\nCod: Pel-%s, Titulo: %s, Genero: %s, Registro: %s, alquilada: %s",
        this.cod, this.titulo, this.genero, this.registro, this.isAlquilada);
        return getInfoPelicula;
    }
    
    public String CodPelicula(){
        String codigoPelicula = String.format("Numero: %s", this.cod);
        return codigoPelicula;
    }
    
    public boolean Alquiler(){
        this.isAlquilada = true;
        this.fechaAlquiler = LocalDateTime.now();
        return isAlquilada;
    }

    public boolean devolver(){
        this.isAlquilada = false;
        LocalDateTime ahora = LocalDateTime.now();
        Period dias = Period.between(this.fechaAlquiler, ahora);
        return isAlquilada;
    }
=======
package com.decroly.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    
    private static int contador = 0;

    //Atributos
    private int cod;
    private String titulo;
    private Generos genero;
    private LocalDateTime registro;
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
        this.registro = LocalDateTime.now();
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
    public LocalDateTime getfechaRegistro() {
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
    
    public String CodPelicula(){
        String codigoPelicula = String.format("Numero: %s", this.cod);
        return codigoPelicula;
    }
    
    public boolean Alquiler(){
        this.isAlquilada = true;
        return isAlquilada;
    }

    public boolean devolver(){
        this.isAlquilada = false;
        return isAlquilada;
    }
>>>>>>> a13201b534d071c6527cd418418b30c21de4f107
}