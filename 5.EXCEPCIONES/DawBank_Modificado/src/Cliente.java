import java.time.LocalDate;

public class Cliente extends Persona {
    
    private int telefono;
    private String email;
    private String direccion;
    
    public Cliente(String nombre, String dni, LocalDate fechaNacimiento, int telefono, String email, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente [telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + "]";
    }
}
