import java.time.LocalDate;

public class trabajador {
    
    private String nombre;
    private LocalDate nacimiento;
    private String dni;
    private String direccion;
    private int numeross;

    private int nPersonas = 0;

    public trabajador (String nombre, LocalDate nacimiento, String dni, String direccion){
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.direccion = direccion;
    }
    
    public trabajador(String nombre, LocalDate nacimiento, String dni, String direccion, int numeross) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.direccion = direccion;
        this.numeross = numeross;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumeross() {
        return numeross;
    }

    public String InfoTrabajador(){//MOSTRAMOS LA INFO DEL TRABAJADOR
        String getInfoTrabajador = String.format( 
        "\nNombre: %s, F.Nacimiento: %s, DNI: %s, Direccion: %s, Numero Seguridad Social: %s",  
        this.nombre, this.nacimiento, this.dni, this.direccion, this.numeross);
        return getInfoTrabajador;
    }
}

