import java.time.LocalDate;

public class Articulo{

    private int codigo;
    private String titulo;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;

    private static int contador = 0;

    public Articulo(String titulo){
        this.codigo = this.contador;
        this.contador++;
        this.titulo = titulo;
        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public String toString() {
        return "Articulo [codigo=" + codigo + ", titulo=" + titulo + ", fechaRegistro=" + 
        fechaRegistro + ", fechaBaja=" + fechaBaja + "]";
    }
}