import java.time.LocalDateTime;

public class Movimiento {
    //Atributos
    private int id;
    private LocalDateTime fecha;
    private String tipo;
    private double cantidad;

    //Constructores
    public Movimiento(String tipo, double cantidad){

        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public int getId(){
        return this.id;
    }

    public String getTipo(){
        return this.tipo;
    }
    
    public double getCantidad(){
        return this.cantidad;
    }

    @Override
    public String toString() {
        return "Movimiento [id=" + id + ", fecha=" + fecha + ", tipo=" + tipo + ", cantidad=" + cantidad + "]";
    }
}

