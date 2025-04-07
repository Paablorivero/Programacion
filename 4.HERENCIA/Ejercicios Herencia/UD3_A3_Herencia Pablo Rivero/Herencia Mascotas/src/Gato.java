public class Gato extends Mascotas{

    String Color;
    Boolean peloLargo;

    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String Color, Boolean peloLargo){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.Color = Color;
        this.peloLargo = peloLargo;
    }

    @Override
    public String mostrarInfo(){
        String info;
        info = "Nombre: " + nombre + " Edad: " + edad + " Estado: " + estado + 
        " Fecha de Nacimiento: " + fechaNacimiento + " Color: " + Color + " Pelo Largo: " + peloLargo;
        return info;
    }
}