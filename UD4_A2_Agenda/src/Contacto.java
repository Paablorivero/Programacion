import java.util.regex.Pattern;

public class Contacto {
    
    private String nombre;
    private String telefono;
    private String correo;

    Pattern nombPattern = Pattern.compile("[A-Z] {1} [a-z] ");
    Pattern telPattern = Pattern.compile("[6,7,9] {1} + [0-9] {8}");
    
}
