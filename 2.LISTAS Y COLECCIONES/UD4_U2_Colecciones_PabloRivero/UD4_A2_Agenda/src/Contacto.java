import java.util.regex.Pattern;

public class Contacto {
    
    private String nombre;
    private String telefono;
    private String correo;

    Pattern nombPattern = Pattern.compile("^[A-Z][a-zA-Z]+([\\\\s][A-Z][a-zA-Z]+)*$");
    Pattern telPattern = Pattern.compile("^[679]\\d{8}$");
    Pattern correoPattern = Pattern.compile("[a-zA-Z0-9_.-]+@[a-z]+\\.[a-z]{2,4}");

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean validaciones (int opcion, String texto){
        switch(opcion){
            case 1:
                return nombPattern.matcher(nombre).matches();
            case 2:
                return telPattern.matcher(telefono).matches();
            case 3:
                return correoPattern.matcher(correo).matches();
            }
            return false;
        }
        
    public void setNombre(String nombre){
        if (validaciones(1, nombre)){
            this.nombre = nombre;
        }
    }
    
    public void setTelefono(String telefono){
        if (validaciones(2, telefono)){
            this.telefono = telefono;
        }
    }
    
    public void setCorreo(String correo){
        if (validaciones(3, correo)){
            this.correo = correo;
        }
    }

    @Override
    public String toString(){
        return "Contacto (Nombre: " + nombre + " Telefono: " + telefono + " Correo: " + correo + ")\n";
    }
    
}
