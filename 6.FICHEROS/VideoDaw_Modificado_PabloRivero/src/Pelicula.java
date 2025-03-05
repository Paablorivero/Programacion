import java.time.Duration;
import java.time.LocalDateTime;


public class Pelicula extends Articulo{

    //ATRIBUTOS
    private Generos genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    //CONSTRUCTORES
    public Pelicula(String titulo, Generos genero){
        super(titulo);
        this.genero = genero;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    //METODOS PARA MOSTAR INFO
    @Override
    public String toString() {
        return "Pelicula [genero=" + genero + ", fechaAlquiler=" + fechaAlquiler + ", isAlquilada=" 
        + isAlquilada + "]";
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
