import java.time.LocalDate;

public class Cliente {
    private static int contador = 0;

    //ATRIBUTOS
    private String dni;
    private String nombre;
    private int cod;
    private String direccion;
    private LocalDate nacimiento;
    private LocalDate fechaBaja;
    private int nalquiladas;

    private int nPelicula;
    private Pelicula [] peliculasCliente;

    //CONSTRUCTOR
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
    
//MOSTRAMOS DATOS
    public String InfoCliente(){//MOSTRAMOS LA INFO DEL CLIENTE
        String getInfoCliente = String.format( 
        "\nDNI: %s, Nombre: %s, Codigo: Soc-%s, Direccion: %s, F.Nacimiento %s, Nº Alquiladas %s",  
        this.dni, this.nombre, this.cod, this.direccion, this.nacimiento, this.nalquiladas );
        return getInfoCliente;
    }

    public String mostrarPeliculas(){ //MOSTRAMOS PELICULAS CLIENTE
        String peliculasAlquiladas = "";
        for(int i = 0; i < nPelicula; i++){
           peliculasAlquiladas += peliculasCliente[i].InfoPelicula();
           }
       return peliculasAlquiladas;
    }

//MODIFICAMOS DATOS
    public boolean addPelicula(Pelicula p){//AÑADIMOS UNA PELICULA
        boolean isAdd = false;
        if (p != null){
            this.peliculasCliente[nPelicula] = p;
            nalquiladas++;
            nPelicula++;
        }
        return isAdd;
    }

    public boolean elimPelicula(Pelicula p){//ELIMINAMOS UNA PELICULA
        boolean isEliminated = false;
        if (p != null){
            nalquiladas--;
        }
        return isEliminated;
    }

    public LocalDate baja(){ //AÑADIMOS FECHA DE BAJA
        LocalDate fechaBaja = LocalDate.now();
        return fechaBaja;
    }
}



