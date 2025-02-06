public class Satelite extends Astro{

    private int distPlaneta;
    private int orbPlaneta;
    private String planeta;

    public Satelite(int radio, int rotacion, int masa, int temperatura, int gravedad, int distPlaneta, int orbPlaneta,
            String planeta) {
        super(radio, rotacion, masa, temperatura, gravedad);
        this.distPlaneta = distPlaneta;
        this.orbPlaneta = orbPlaneta;
        this.planeta = planeta;
    }

    public int getDistPlaneta() {
        return distPlaneta;
    }

    public int getOrbPlaneta() {
        return orbPlaneta;
    }

    public String getPlaneta() {
        return planeta;
    }
    
    @Override
    public String mostrarInfo(){
        String info = super.mostrarInfo();
        info += "Distancia al Planeta: " + this.distPlaneta + " Orbita: " + this.orbPlaneta + 
        " Planeta al que pertenece: " + this.planeta;
        return info;
    }
}
