package com.decroly.daw;

public class Cliente {
    private static int contador = 0;

    //Atributos
    private String dni;
    private String nombre;
    private int cod;
    private String direccion;
    private String nacimiento;
    private String baja;
    private int nalquiladas;

    public Cliente(String dni, String nombre, String direccion, String nacimiento){
        this.cod = this.contador;
        this.contador++;

        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nacimiento = "";
        this.nalquiladas = 0;
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
    public String getNacimiento() {
        return nacimiento;
    }
    public String getBaja() {
        return baja;
    }
    public int getNalquiladas() {
        return nalquiladas;
    }

     public String mostrarCodigoSocio(){
        String codigoSocio = "Soc-0" + contador;
        return codigoSocio;
     }
    
     public String mostrarInfoCliente(){
        String getInfoCliente = String.format("INFO DEL CLIENTE" +
        "\nDNI: %s, Nombre: %s, Codigo: Soc-0%s, Direccion: %s, F.Nacimiento %s, Nº Alquiladas %s",  
        this.dni, this.nombre, this.cod, this.direccion, this.nacimiento, this.nalquiladas);
        return getInfoCliente;
     }
}
