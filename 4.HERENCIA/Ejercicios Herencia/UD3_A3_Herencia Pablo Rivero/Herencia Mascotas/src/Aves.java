public abstract class Aves extends Mascotas {

    protected String pico;
    protected Boolean vuela;

    public String mostrarInfo() {
        return "Nombre: " + nombre + " Edad: " + edad + " Estado: " + estado + " Fecha de Nacimiento: "
                + fechaNacimiento + " Pico: " + pico + " Vuela: " + vuela;
    }

    public boolean volar() {
        return false;
    }
}