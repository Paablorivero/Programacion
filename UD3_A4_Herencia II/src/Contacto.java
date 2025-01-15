public class Contacto {
    
    String nombre;
    int telefono;

    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String infoContacto(){
        String infoContacto = String.format("Nombre: %s, Telefono: %d", nombre, telefono);
        return infoContacto;
    }
}
