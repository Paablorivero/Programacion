import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trabajador extends Persona{
    
    private String numeroSS;
    private String email;
    private int Salario;
    private Departamento departamento;
    private boolean isTrabajando;

    

    public Trabajador(String nombre, LocalDate nacimiento, String dni, String direccion, String numeroSS, String email,
            int salario, Departamento departamento) {
        super(nombre, nacimiento, dni, direccion);
        this.numeroSS = numeroSS;
        this.email = email;
        Salario = salario;
        this.departamento = departamento;
        this.isTrabajando = false;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public boolean isTrabajando() {
        return isTrabajando;
    }

    public void setTrabajando(boolean isTrabajando) {
        this.isTrabajando = isTrabajando;
    }

    @Override
    public String toString() {
        return "Trabajador [numeroSS=" + numeroSS + ", email=" + email + ", Salario=" + Salario + ", departamento="
                + departamento + ", isTrabajando=" + isTrabajando + "]";
    }

    public boolean comprobarSS(String numeroSS) throws ExcepcionesEmpresa{
        boolean isOk;
        Pattern pat = Pattern.compile("[0-9]{10}");
        Matcher mat = pat.matcher(numeroSS);
        isOk = mat.matches();

        if(isOk == false){
            throw new ExcepcionesEmpresa("El numero de la seguridad social introducido no es correcto.");
        }

        return isOk;
    }
    
}
