import java.time.LocalDate;

public class Cliente extends Persona{
    private static int contador = 0;

    //ATRIBUTOS
    private int cod;
    private LocalDate fechaBaja;
    private int nalquiladas;
    private int nArticulos;
    private Articulo [] articulosCliente;

    //CONSTRUCTOR
    
    public Cliente(String dni, String nombre, String direccion, LocalDate nacimiento) {
        super(dni, nombre, direccion, nacimiento);
        this.cod = contador;
        contador++;
        
        this.fechaBaja = fechaBaja;
        this.nalquiladas = nalquiladas;
        this.nArticulos = nArticulos;
    }
    
    public static int getContador() {
        return contador;
    }
    public static void setContador(int contador) {
        Cliente.contador = contador;
    }

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getNalquiladas() {
        return nalquiladas;
    }
    public void setNalquiladas(int nalquiladas) {
        this.nalquiladas = nalquiladas;
    }

    public int getnArticulos() {
        return nArticulos;
    }
    public void setnArticulos(int nPelicula) {
        this.nArticulos = nPelicula;
    }

    //MOSTRAMOS DATOS
    
    @Override
    public String toString() {
        return "Cliente [cod=" + cod + ", fechaBaja=" + fechaBaja + ", nalquiladas=" + nalquiladas + ", nArticulos="
                + nArticulos + "]";
    }

    public String mostrarPeliculas(){ //MOSTRAMOS PELICULAS CLIENTE
        String peliculasAlquiladas = "";
        for(int i = 0; i < nArticulos; i++){
           peliculasAlquiladas += articulosCliente[i].toString();
           }
       return peliculasAlquiladas;
    }

    //MODIFICAMOS DATOS
    public boolean addArticulo(Articulo p){//AÑADIMOS UNA PELICULA
        boolean isAdd = false;
        if (p != null){
            this.articulosCliente[nArticulos] = p;
            nalquiladas++;
            nArticulos++;
        }
        return isAdd;
    }

    public boolean elimArticulo(Articulo p){//ELIMINAMOS UNA PELICULA
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



