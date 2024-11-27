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

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
    //Contructores
    public VideoDaw(String cif, String direccion){
        this.cif = cif;
        this.direccion = direccion;
        this.alta = LocalDateTime.now().format(formatter);
        this.npeliculas = 0;
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
    
    public String mostrarInfoVideoDaw(){
        String getInfoVideoDaw = String.format("INFO DEL VIDEOCLUB" +
        "\nCif: %s, Direccion: %s, Fecha de alta: %s, Nº de Peliculas: %s, Nº de clientes %s", 
        this.cif, this.direccion, this.alta, this.npeliculas, this.nclientes);
        return getInfoVideoDaw;
    }
}
