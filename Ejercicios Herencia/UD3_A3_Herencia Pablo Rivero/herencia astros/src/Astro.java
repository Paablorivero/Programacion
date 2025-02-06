public class Astro{

    private int radio;
    private int rotacion;
    private int masa;
    private int temperatura;
    private int gravedad;
    
    public Astro(int radio, int rotacion, int masa, int temperatura, int gravedad) {
        this.radio = radio;
        this.rotacion = rotacion;
        this.masa = masa;
        this.temperatura = temperatura;
        this.gravedad = gravedad;
    }

    public int getRadio() {
        return radio;
    }

    public int getRotacion() {
        return rotacion;
    }

    public int getMasa() {
        return masa;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getGravedad() {
        return gravedad;
    }

    public String mostrarInfo(){
        String info;
        info = "Radio: " + this.radio+ " Rotacion: " + this.rotacion + " Masa: "+ this.masa + 
        " Temperatura: " + this.temperatura + " Gravedad: " + this.gravedad;
        return info;
    }
   

    
}