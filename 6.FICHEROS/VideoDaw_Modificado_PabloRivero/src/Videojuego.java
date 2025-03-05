import java.time.LocalDateTime;

public class Videojuego {
    private GenerosVideojuego genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilado;
    
    public Videojuego(GenerosVideojuego genero, LocalDateTime fechaAlquiler, boolean isAlquilado) {
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilado = isAlquilado;
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
        return "Videojuego [genero=" + genero + ", fechaAlquiler=" + fechaAlquiler + ", isAlquilado=" 
        + isAlquilado + "]";
    }
}
