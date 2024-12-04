<<<<<<< HEAD
package com.decroly.daw;

import java.time.LocalDate;

public class Cliente {
    private static int contador = 0;

    //Atributos
    private String dni;
    private String nombre;
    private int cod;
    private String direccion;
    private LocalDate nacimiento;
    private LocalDate fechaBaja;
    private int nalquiladas;

    private int nPelicula;
    private Pelicula [] peliculasCliente;

    public Cliente(String dni, String nombre, String direccion, LocalDate nacimiento){
        this.cod = this.contador;
        this.contador++;

        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.nalquiladas = 0;
        this.peliculasCliente = new Pelicula[100];
        this.nPelicula = 0;
        this.fechaBaja = fechaBaja;
    }
    
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCod() {
        return cod;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public LocalDate getBaja() {
        return fechaBaja;
    }
    public int getNalquiladas() {
        return nalquiladas;
    }

    public int getNpeliculas(){
        return nPelicula;
    }
    
    public String InfoCliente(){
        String getInfoCliente = String.format( 
        "\nDNI: %s, Nombre: %s, Codigo: Soc-%s, Direccion: %s, F.Nacimiento %s, Nº Alquiladas %s",  
        this.dni, this.nombre, this.cod, this.direccion, this.nacimiento, this.nalquiladas );
        return getInfoCliente;
    }

    public boolean addPelicula(Pelicula p){
        boolean isAdd = false;
        if (p != null){
            this.peliculasCliente[nPelicula] = p;
            nalquiladas++;
            nPelicula++;
        }
        return isAdd;
    }

    public boolean elimPelicula(Pelicula p){
        boolean isEliminated = false;
        if (p != null){
            nalquiladas--;
        }
        return isEliminated;
    }

    public String mostrarPeliculas(){
        String peliculasAlquiladas = "";
        for(int i = 0; i < nPelicula; i++){
           peliculasAlquiladas += peliculasCliente[i].InfoPelicula();
           }
       return peliculasAlquiladas;
       }

    public LocalDate baja(){
        LocalDate fechaBaja = LocalDate.now();
        return fechaBaja;
    }
}

=======
package com.decroly.daw;

import java.time.LocalDate;

public class Cliente {
    private static int contador = 0;

    //Atributos
    private String dni;
    private String nombre;
    private int cod;
    private String direccion;
    private LocalDate nacimiento;
    private String baja;
    private int nalquiladas;

    private Pelicula [] peliculasCliente;

    public Cliente(String dni, String nombre, String direccion, LocalDate nacimiento){
        this.cod = this.contador;
        this.contador++;

        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.nalquiladas = 0;
        this.peliculasCliente = new Pelicula[100];
    }
    
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCod() {
        return cod;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public String getBaja() {
        return baja;
    }
    public int getNalquiladas() {
        return nalquiladas;
    }
    
    public String InfoCliente(){
        String getInfoCliente = String.format( 
        "\nDNI: %s, Nombre: %s, Codigo: Soc-%s, Direccion: %s, F.Nacimiento %s, Nº Alquiladas %s",  
        this.dni, this.nombre, this.cod, this.direccion, this.nacimiento, this.nalquiladas );
        return getInfoCliente;
    }

    public boolean addPelicula(Pelicula p){
        boolean isAdd = false;
        if (p != null){
            this.peliculasCliente[nalquiladas] = p;
            nalquiladas++;
        }
        return isAdd;
    }

    public boolean elimPelicula(Pelicula p){
        boolean isEliminated = false;
        if (p != null){
            this.peliculasCliente[nalquiladas] = null;
            nalquiladas--;
        }
        return isEliminated;
    }

    public String mostrarPeliculas(){
        String peliculasAlquiladas = "";
        System.out.println("Peliculas alquiladas: ");
        for(int i = 0; i < nalquiladas; i++){
           System.out.println(peliculasCliente[i].InfoPelicula());
           }
       return peliculasAlquiladas;
       }
        
    
}

>>>>>>> a13201b534d071c6527cd418418b30c21de4f107
