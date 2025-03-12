import java.time.LocalDate;

public class Director extends Persona{
    
    private int numeroTelefono;
    private boolean reunido;
    private boolean fueraOficina;

    

    public Director(String nombre, LocalDate nacimiento, String dni, String direccion, int numeroTelefono) {
        super(nombre, nacimiento, dni, direccion);
        this.numeroTelefono = numeroTelefono;
        this.reunido = false;
        this.fueraOficina = false;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isReunido() {
        return reunido;
    }

    public void setReunido(boolean reunido) {
        this.reunido = reunido;
    }

    public boolean isFueraOficina() {
        return fueraOficina;
    }

    public void setFueraOficina(boolean fueraOficina) {
        this.fueraOficina = fueraOficina;
    }

    @Override
    public String toString() {
        return "Director [numeroTelefono=" + numeroTelefono + ", reunido=" + reunido + ", fueraOficina=" + fueraOficina
                + "]";
    }

    
}
