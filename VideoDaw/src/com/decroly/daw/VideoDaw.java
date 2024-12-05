package com.decroly.daw;
import java.time.LocalDate;

public class VideoDaw { 
    //Atributos
    private String cif;
    private String direccion;
    private LocalDate alta;
    private int npeliculas;
    private int nclientes;
    
    private Cliente [] clientes;
    private Pelicula [] peliculas;

    //Contructores
    public VideoDaw(String cif, String direccion){
        this.cif = cif;
        this.direccion = direccion;
        this.alta = LocalDate.now();
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
    public LocalDate getAlta() {
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

    public String mostrarPeliculasNoAlquiladas(){
        String peliculasNoAlquiladas = "";
        if(npeliculas > 0){
        for(int i = 0; i < npeliculas; i++){
            if (peliculas[i].isAlquilada() == false){
                peliculasNoAlquiladas += (peliculas[i].InfoPelicula());
            }
        }
        }else{
            peliculasNoAlquiladas = "No hay peliculas en el videoclub";
        }
    return peliculasNoAlquiladas;
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

    public Pelicula obtenerPeliculaPorPosicion(int i){
        return this.peliculas[i];
    } 

    public Cliente obtenerClientePorPosicion(int i){
        return this.clientes[i];
    }

    public boolean alquilarPelicula(int c, int p){
        this.obtenerClientePorPosicion(c);
        this.obtenerPeliculaPorPosicion(p).Alquiler();
        boolean isAdd = false;
        return isAdd;
    }

    public boolean devolverPelicula(int c, int p){
        this.obtenerClientePorPosicion(c);
        this.obtenerPeliculaPorPosicion(p).devolver();
        boolean isEliminated = false;
        return isEliminated;
    }

    public boolean darBajaCliente(Cliente c, int numSocio){
        boolean isEliminated = false;
        if(this.clientes != null){
            this.clientes [numSocio] = null;
            LocalDate fechaBajaCliente = obtenerClientePorPosicion(numSocio).baja();
            for(int i = numSocio + 1; i < nclientes; i++){
                this.clientes [i-1] = this.clientes[i];
            }
            this.clientes [nclientes-1] = null;
            nclientes--;
            isEliminated = true;
            System.out.println("Cliente eliminado");
            obtenerClientePorPosicion(numSocio).InfoCliente();
            System.out.println("Fecha de baja: " + fechaBajaCliente);
        }
        
    return isEliminated;
    }

    public boolean darBajaPelicula(Pelicula p, int cod){
        boolean isEliminated = false;
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
