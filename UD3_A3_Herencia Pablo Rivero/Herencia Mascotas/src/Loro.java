public class Loro extends Aves {
    
    String origen;
    Boolean habla;

    public Loro(String nombre, int edad, String estado, String fechaNacimiento, String pico, Boolean vuela, String origen, Boolean habla){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.pico = pico;
        this.vuela = vuela;
        this.origen = origen;
        this.habla = habla;
    }

    @Override
    public String mostrarInfo(){
        String info;
        info = "Nombre: " + nombre + " Edad: " + edad + " Estado: " + estado + 
        " Fecha de Nacimiento: " + fechaNacimiento + " Pico: " + pico + " Vuela: " + vuela + " Origen: " + origen + " Habla: " + habla;
        return info;
    }

    public boolean hablar(){
        return true;
    }

    public boolean saludar(){
        return true;
    }

    public boolean volar(){
        return true;
    }
}