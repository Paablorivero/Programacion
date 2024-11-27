package com.decroly.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VideoDaw {
    
    //Atributos
    private String cif;
    private String direccion;
    private String alta;
    private int npeliculas;
    private int nclientes;
    
    private Cliente [] clientes;
    private Pelicula [] peliculas;

    private boolean esCreada = false;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    //Contructores
    public VideoDaw(String cif, String direccion){
        this.cif = cif;
        this.direccion = direccion;
        this.alta = LocalDateTime.now().format(formatter);
        this.peliculas = new Pelicula[100];
        this.npeliculas = 0;
        this.clientes = new Cliente[100];
        this.nclientes = 0;
    }

    public String getCif() {
        return cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getAlta() {
        return alta;
    }
    public int getNpeliculas() {
        return npeliculas;
    }
    public int getNclientes() {
        return nclientes;
    }
    
    public String InfoVideoDaw(){
        String getInfoVideoDaw = String.format("INFO DEL VIDEOCLUB" +
        "\nCif: %s, Direccion: %s, Fecha de alta: %s, Nº de Peliculas: %s, Nº de clientes %s", 
        this.cif, this.direccion, this.alta, this.npeliculas, this.nclientes);
        return getInfoVideoDaw;
    }

    public String mostrarPeliculas(){
     String peliculasDisponibles = "";
     for(int i = 0; i < npeliculas; i++){
        peliculasDisponibles  = peliculasDisponibles + peliculas [i].InfoPelicula();
        }
    return peliculasDisponibles;
    }

    //public boolean nuevoAlquiler(Pelicula alq){
      //boolean isAdd = false;
        //if(alq != null){
          //  this.peliculas [npeliculas] = alq;
            //this.npeliculas++;
        //}
    //}
}
