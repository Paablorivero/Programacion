public class Planeta extends Astro {
    
    private int distSol;
    private int orbita;
    private boolean satelites;


    public Planeta(int radio, int rotacion, int masa, int temperatura, int gravedad, int distSol, int orbita, boolean satelites) {
        super(radio, rotacion, masa, temperatura, gravedad);
        this.distSol = distSol;
        this.orbita = orbita;
        this.satelites = satelites;
    }

    public int getDistSol() {
        return distSol;
    }

    public int getOrbita() {
        return orbita;
    }

    public boolean isSatelites() {
        return satelites;
    }

    public String mostrarInfoPlaneta(){
        String info = super.mostrarInfo();
        info += "Distancia al sol: " + this.distSol + " Orbita: " + this.orbita + 
        " Satelites: " + this.satelites;
        return info;
    }

    @Override
    public String mostrarInfo(){
        String info = super.mostrarInfo();
        info += "Distancia al sol: " + this.distSol + " Orbita: " + this.orbita + 
        " Satelites: " + this.satelites;
        return info;
    }

}
