package com.decroly.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VideoDaw {
    
    //Atributos
    private String cif;
    private String direccion;
    private String alta;
    private int npeliculas;
    private int nclientes;
    
    private Cliente [] clientes;
    private Pelicula [] peliculas;

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
    
    public boolean nuevoCliente(Cliente nuevo){
        boolean isAdd = false;
        if (nuevo != null){
            this.clientes [nclientes] = nuevo;
            nclientes++;
        }
        return isAdd;
    }

    public boolean nuevaPelicula(Pelicula nueva){
        boolean isAdd = false;
        if (nueva != null){
            this.peliculas [npeliculas] = nueva;
            npeliculas++;
        }
        return isAdd;
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
        System.out.println(i + "." + peliculas[i].InfoPelicula());
        }
    return peliculasDisponibles;
    }

    public String mostrarClientes(){
        String mostrarClientes = "";
        if(clientes != null){   
        for(int i = 0; i < nclientes; i++){
            System.out.println(i + "." + clientes[i].InfoCliente());
            }
        }
        return mostrarClientes;
    }

    public boolean alquilarPelicula(Pelicula p , Cliente c){
        boolean isAdd = false;
        if (p.isAlquilada() == false){
            p.Alquiler();

        }
        else{
            System.out.println("La pelicula seleccionada esta alquilada, por favor seleccione otra");
        }
        return isAdd;
    } 

    public boolean darBajaCliente(Cliente c){
        boolean isEliminated = false;
        Scanner entrada = new Scanner(System.in);
        if(this.clientes != null){
		    System.out.println("Introduce la posicion del cliente a dar de baja");
		    int numSocio = entrada.nextInt();

            this.clientes [numSocio] = null;
            
            for(int i = numSocio + 1; i < nclientes; i++){
                this.clientes [i-1] = this.clientes[i];
            }
            this.clientes [nclientes-1] = null;
            nclientes--;
            isEliminated = true;
            System.out.println("Cliente eliminado");
        }
        
    return isEliminated;
    }

    public boolean darBajaPelicula(Pelicula p){
        boolean isEliminated = false;
        Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce la posicion de la pelicula a dar de baja");
		int cod = entrada.nextInt();
        if (cod >= 0 && cod < npeliculas) {
            this.peliculas [cod] = null;
            
            for(int i = cod + 1; i < npeliculas; i++){
                this.peliculas [i-1] = this.peliculas[i];
            }
            this.peliculas [npeliculas-1] = null;
            npeliculas--;
            isEliminated = true;
            System.out.println("Pelicula eliminada");
        }
    return isEliminated;
    }
}
