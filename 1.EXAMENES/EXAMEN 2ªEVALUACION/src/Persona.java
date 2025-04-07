import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona extends Exception{
    
    private String nombre;
    private LocalDate nacimiento;
    private String dni;
    private String direccion;
    
    public Persona(String nombre, LocalDate nacimiento, String dni, String direccion) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", nacimiento=" + nacimiento + ", dni=" + dni + ", direccion=" + direccion
                + "]";
    }

    public boolean comprobarDni(String dni) throws ExcepcionesEmpresa{
        boolean isOk;
        Pattern pat = Pattern.compile("[0-9]{8}[A-Z]{1}");
        Matcher mat = pat.matcher(dni);
        isOk = mat.matches();

        if(isOk == false){
            throw new ExcepcionesEmpresa("El DNI introducido no es correcto.");
        }

        return isOk;
    }
}
