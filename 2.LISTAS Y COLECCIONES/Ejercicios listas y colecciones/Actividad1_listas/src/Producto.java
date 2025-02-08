public class Producto{

    String nombre;
    int cantidad;   

    public Producto(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantidad(){
        return cantidad;
    }

    public String mostrarInfo(){
        String info;        
        info = String.format("Nombre: %s - Cantidad %s euros", nombre, cantidad);
        return info;
    }


}