import java.time.LocalDateTime;

public class Videojuego extends Articulo{
    private GenerosVideojuego genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilado;
    
    public Videojuego(String titulo, GenerosVideojuego genero) {
        super(titulo);
        this.genero = genero;
        this.fechaAlquiler = null;
        this.isAlquilado = false;
    }

    public GenerosVideojuego getGenero() {
        return genero;
    }

    public void setGenero(GenerosVideojuego genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isAlquilado() {
        return isAlquilado;
    }

    public void setAlquilado(boolean isAlquilado) {
        this.isAlquilado = isAlquilado;
    }

    @Override
    public String toString() {
        return "Videojuego [genero=" + this.genero + ", fechaAlquiler=" + this.fechaAlquiler + ", isAlquilado=" 
        + this.isAlquilado + "]";
    }
}
