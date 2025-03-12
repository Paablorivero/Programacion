import java.time.LocalDate;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empresa extends Exception{
    
    private String nombreEmpresa;
    private String cif;
    private LocalDate fundacion;
    private LinkedList<Persona> PersonasEmpresa;


    public Empresa(String nombreEmpresa, String cif, LocalDate fundacion) {
        nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.fundacion = fundacion;
        this.PersonasEmpresa = new LinkedList<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        nombreEmpresa = nombreEmpresa;
    }
    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public LocalDate getFundacion() {
        return fundacion;
    }
    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public LinkedList<Persona> getPersonasEmpresa() {
        return PersonasEmpresa;
    }

    public void setPersonasEmpresa(LinkedList<Persona> personasEmpresa) {
        PersonasEmpresa = personasEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa [nombreEmpresa=" + nombreEmpresa + ", cif=" + cif + ", fundacion=" + fundacion + "]";
    }

    public boolean registrarTrabajador(Persona persona) throws ExcepcionesEmpresa {
        if (persona instanceof Trabajador) {
            for (Persona p : PersonasEmpresa) {
                if (p.getDni().equals(persona.getDni())) {
                throw new ExcepcionesEmpresa("El cliente con DNI " + persona.getDni() + " ya está registrado.");
                }
            }
            PersonasEmpresa.add(persona);
        }
        return true;
    }

    public boolean registrarGerente(Persona persona) throws ExcepcionesEmpresa {
        if (persona instanceof GerenteDep) {
            for (Persona p : PersonasEmpresa) {
                if (p.getDni().equals(persona.getDni())) {
                throw new ExcepcionesEmpresa("El cliente con DNI " + persona.getDni() + " ya está registrado.");
                }
            }
            PersonasEmpresa.add(persona);
        }
        return true;
    }

    public boolean registrarDirector(Persona persona) throws ExcepcionesEmpresa {
        if (persona instanceof Director) {
            for (Persona p : PersonasEmpresa) {
                if (p.getDni().equals(persona.getDni())) {
                throw new ExcepcionesEmpresa("El cliente con DNI " + persona.getDni() + " ya está registrado.");
                }
            }
            PersonasEmpresa.add(persona);
        }
        return true;
    }

    public boolean eliminarTrabajador(String dni) throws ExcepcionesEmpresa {
        Persona persona = null;

        for (int i = 0; i < PersonasEmpresa.size(); i++) {
            persona = PersonasEmpresa.get(i);
            if (persona.getDni().equals(dni)){
            PersonasEmpresa.remove(persona);
            return true;
            }
        }
        return false;
    }

    public String infoTrabajadores() throws ExcepcionesEmpresa {
        String infoTrabajadores = "";
        Persona persona;
        if (PersonasEmpresa.isEmpty()) {
            throw new ExcepcionesEmpresa( "No hay Trabajadores en la empresa");
        }

        for (int i = 0 ; i < PersonasEmpresa.size(); i++) {
            persona = PersonasEmpresa.get(i);
            if (persona instanceof Trabajador) {
                infoTrabajadores += i + ". " + persona.toString();
                Trabajador trabajador = (Trabajador) persona;
                infoTrabajadores +="numeroSS=" + trabajador.getNumeroSS() + ", email=" + trabajador.getEmail() + ", Salario=" + trabajador.getSalario() + ", departamento="
                + trabajador.getDepartamento() + ", Trabajando=" + (trabajador.isTrabajando() ? "Sí" : "No");
            }
        } 
        return infoTrabajadores;
    }

    public String infoGerente() throws ExcepcionesEmpresa {
        String infoTrabajadores = "";
        Persona persona;
        if (PersonasEmpresa.isEmpty()) {
            throw new ExcepcionesEmpresa( "No hay Trabajadores en la empresa");
        }

        for (int i = 0 ; i < PersonasEmpresa.size(); i++) {
            persona = PersonasEmpresa.get(i);
            if (persona instanceof GerenteDep) {
                infoTrabajadores += i + ". " + persona.toString();
                GerenteDep trabajador = (GerenteDep) persona;
                infoTrabajadores += trabajador.toString();
            }
        } 
        return infoTrabajadores;
    }

    public String infoDirector() throws ExcepcionesEmpresa {
        String infoTrabajadores = "";
        Persona persona;
        if (PersonasEmpresa.isEmpty()) {
            throw new ExcepcionesEmpresa( "No hay Trabajadores en la empresa");
        }

        for (int i = 0 ; i < PersonasEmpresa.size(); i++) {
            persona = PersonasEmpresa.get(i);
            if (persona instanceof Director) {
                infoTrabajadores += i + ". " + persona.toString();
                Director trabajador = (Director) persona;
                infoTrabajadores += trabajador.toString();
            }
        } 
        return infoTrabajadores;
    }

    public String reunirEmpresa () throws ExcepcionesEmpresa {
        String reunirEmpresa = "";
        Persona persona ;
        boolean directorPresente = false;

        if (PersonasEmpresa.isEmpty()) {
            throw new ExcepcionesEmpresa( "No hay Trabajadores en la empresa");
        }

        for (int i = 0 ; i < PersonasEmpresa.size(); i++) {
        persona = PersonasEmpresa.get(i);
            if(persona instanceof Director){
                Director director = (Director) persona;
                directorPresente = director.isFueraOficina();
                reunirEmpresa += director.toString();
            }
        }

        if(directorPresente){
        for (int i = 0 ; i < PersonasEmpresa.size(); i++) {
            persona = PersonasEmpresa.get(i);
            if (persona instanceof Trabajador) {
                Trabajador trabajador = (Trabajador) persona;
                if(trabajador.isTrabajando()){
                reunirEmpresa += i + ". " + persona.toString();
                reunirEmpresa +="numeroSS=" + trabajador.getNumeroSS() + ", email=" + trabajador.getEmail() + ", Salario=" + trabajador.getSalario() + ", departamento="
                + trabajador.getDepartamento() + ", Trabajando=" + (trabajador.isTrabajando() ? "Sí" : "No");
                }
            }
        } 
    }else if(directorPresente == false){
        throw new ExcepcionesEmpresa("El director no esta disponible");
    }
        return reunirEmpresa;
    }

    public boolean comprobarcif(String cif) throws ExcepcionesEmpresa{
        boolean isOk;
        Pattern pat = Pattern.compile("[A-Z]{1}[0-9]{10}");
        Matcher mat = pat.matcher(cif);
        isOk = mat.matches();

        if(isOk == false){
            throw new ExcepcionesEmpresa("El cif introducido no es correcto.");
        }

        return isOk;
    }

    public String infoDepartamento(Departamento dpt) throws ExcepcionesEmpresa{

        String infoTrabajadores = "";
        Persona persona;
        if (PersonasEmpresa.isEmpty()) {
            throw new ExcepcionesEmpresa( "No hay Trabajadores en la empresa");
        }

        for (int i = 0 ; i < PersonasEmpresa.size(); i++) {
            persona = PersonasEmpresa.get(i);
            if (persona instanceof GerenteDep) {
                GerenteDep trabajador = (GerenteDep) persona;
                if(trabajador.getDepartamento().equals(dpt)){ 
                infoTrabajadores += i + ". " + persona.toString();
                infoTrabajadores +="numeroSS=" + trabajador.getNumeroSS() + ", email=" + trabajador.getEmail() + ", Salario=" + trabajador.getSalario() + ", departamento="
                + trabajador.getDepartamento() + ", Trabajando=" + (trabajador.isTrabajando() ? "Sí" : "No");
                }
                
            }

            if (persona instanceof Trabajador) {
                Trabajador trabajador = (Trabajador) persona;
                if(trabajador.getDepartamento().equals(dpt)){ 
                infoTrabajadores += i + ". " + persona.toString();
                infoTrabajadores +="numeroSS=" + trabajador.getNumeroSS() + ", email=" + trabajador.getEmail() + ", Salario=" + trabajador.getSalario() + ", departamento="
                + trabajador.getDepartamento() + ", Trabajando=" + (trabajador.isTrabajando() ? "Sí" : "No");
                }
            }
        } 
        return infoTrabajadores;
    }

    public int nTrabajadores(){
        int nTrabajadores = PersonasEmpresa.size();
        return nTrabajadores;
    }
}
