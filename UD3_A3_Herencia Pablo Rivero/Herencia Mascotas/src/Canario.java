public class Canario extends Aves {
    
    String color;
    Boolean canta;

    public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, Boolean vuela, String color, Boolean canta){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.pico = pico;
        this.vuela = vuela;
        this.color = color;
        this.canta = canta;
    }

    @Override
    public String mostrarInfo(){
        String info;
        info = "Nombre: " + nombre + " Edad: " + edad + " Estado: " + estado + 
        " Fecha de Nacimiento: " + fechaNacimiento + " Pico: " + pico + " Vuela: " + vuela + " Color: " + color + " Canta: " + canta;
        return info;
    }

    public boolean hablar(){
        return true;
    }

    public boolean volar(){
        return true;
    }
}