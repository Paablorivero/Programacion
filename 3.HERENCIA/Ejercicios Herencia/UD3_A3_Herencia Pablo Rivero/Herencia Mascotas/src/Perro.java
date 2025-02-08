public class Perro extends Mascotas{

    String Raza;
    Boolean pulgas;
    
    public Perro(String nombre, int edad, String estado, String fechaNacimiento, String Raza, Boolean pulgas){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.Raza = Raza;
        this.pulgas = pulgas;
    }

    @Override
    public String mostrarInfo(){
        String info;
        info = "Nombre: " + nombre + " Edad: " + edad + " Estado: " + estado + 
        " Fecha de Nacimiento: " + fechaNacimiento + " Raza: " + Raza + " Pulgas: " + pulgas;
        return info;
    }

    public boolean hablar(){
        return false;
    }
}
