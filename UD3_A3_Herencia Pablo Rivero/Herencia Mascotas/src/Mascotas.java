
public abstract class Mascotas{

protected String nombre;
protected int edad;
protected String estado;
protected String fechaNacimiento;


public String mostrarInfo(){
    return "Nombre: " + nombre + " Edad: " + edad + " Estado: " + estado + 
    " Fecha de Nacimiento: " + fechaNacimiento;
}

public String cumpleaños(){
    return fechaNacimiento;
}

public boolean morir(){
    return false;
}
public boolean hablar(){
    return false;
}

}