
package com.decroly.daw;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    
    private static int contador = 0;

    //ATRIBUTOS
    private int cod;
    private String titulo;
    private Generos genero;
    private LocalDateTime registro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    //CONSTRUCTORES
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

//METODOS PARA MOSTAR INFO
    public String InfoPelicula(){ //MOSTRAMOS LA INFORMACION DE LA PELICULA
        String getInfoPelicula = String.format("\nCod: Pel-%s, Titulo: %s, Genero: %s, Registro: %s, alquilada: %s",
        this.cod, this.titulo, this.genero, this.registro.format(formatter), this.isAlquilada);
        return getInfoPelicula;
    }
    
    public String CodPelicula(){ //MOSTRAMOS UNICAMENTE EL Nº DE CODIGO DE LA PELICULA
        String codigoPelicula = String.format("Numero: %s", this.cod);
        return codigoPelicula;
    }

//METODOS PARA EDITAR ESTADO DE LA PELICULA
    public boolean Alquiler(){ //ALQUILAMOS UNA PELICULA
        this.isAlquilada = true;
        this.fechaAlquiler = LocalDateTime.now();
        return isAlquilada;
    }

    public boolean devolver(){//DEVOLVEMOS UNA PELICULA
        this.isAlquilada = false;
        LocalDateTime ahora = LocalDateTime.now();
        Duration duracion = Duration.between(this.fechaAlquiler, ahora);
        if (duracion.toHours() > 24) {
            System.out.println("Se ha excedido el tiempo de devolucion de 48h");
        }
        return isAlquilada;
    }
}
