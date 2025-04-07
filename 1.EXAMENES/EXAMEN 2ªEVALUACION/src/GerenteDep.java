
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class GerenteDep extends Trabajador{
    
    private int nTrabajadores;
    private int nTelefono;
    private LinkedList<Trabajador> listaTrabajadores;

    public GerenteDep(String nombre, LocalDate nacimiento, String dni, String direccion, String numeroSS, String email,
            int salario, Departamento departamento, int nTelefono) {
        super(nombre, nacimiento, dni, direccion, numeroSS, email, salario, departamento);
        this.nTrabajadores = nTrabajadores;
        this.nTelefono = nTelefono;
        this.listaTrabajadores = listaTrabajadores;
    }

    public int getnTrabajadores() {
        return nTrabajadores;
    }

    public void setnTrabajadores(int nTrabajadores) {
        this.nTrabajadores = nTrabajadores;
    }

    public int getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(int nTelefono) {
        this.nTelefono = nTelefono;
    }

    public LinkedList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(LinkedList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    @Override
    public String toString() {
        return "GerenteDep [nTrabajadores=" + nTrabajadores + ", nTelefono=" + nTelefono + ", listaTrabajadores="
                + listaTrabajadores + "]";
    }

    public String reunionDept (Departamento dept) throws ExcepcionesEmpresa {
        String reunionDept = "";
        String fecha = "Reunion convocada :" + LocalDateTime.now().toString();
        Trabajador trabajador;

        if (listaTrabajadores.isEmpty()) {
            throw new ExcepcionesEmpresa( "No hay Trabajadores en la empresa");
        }

        for (int i = 0 ; i < listaTrabajadores.size(); i++) {
            trabajador = listaTrabajadores.get(i);
            if (trabajador.getDepartamento() == dept) {
                reunionDept += i + ". " + trabajador.toString();
            }
        } 
        return fecha + reunionDept;
    }

    public boolean addTrabajador(Trabajador t){
        listaTrabajadores.add(t);
        return true;
    }
}
    

