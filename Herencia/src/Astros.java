public abstract class Astros {

    protected double radio;
    protected int rotacion;
    protected double masa;
    protected double temperatura;
    protected double gravedad;


    public double getRadio() {
        return radio;
    }
    public int getRotacion() {
        return rotacion;
    }
    public double getMasa() {
        return masa;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public double getGravedad() {
        return gravedad;
    }

    @Override
    public String toString() {
        return "Vehiculo [radio=" + radio + ", rotacion=" + 
        rotacion + ", + masa=" + masa + " , temperatura=" + temperatura + " , gravedad=" + gravedad + "]";
    }

}
