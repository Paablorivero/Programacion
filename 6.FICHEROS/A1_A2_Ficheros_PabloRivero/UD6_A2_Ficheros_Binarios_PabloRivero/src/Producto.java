public class Producto {
    
    private int codigo;
    private String nombre;
    private int cantidad; 
    private Double precio;
    private static int contador = 0;
    
    public Producto(String nombre, int cantidad, Double precio){
        this.codigo = this.contador;
        this.contador++;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Producto [codigo= " + codigo + ", nombre= " + nombre + ", cantidad= " + cantidad + ", precio= " + precio + " ]";
    }
}
