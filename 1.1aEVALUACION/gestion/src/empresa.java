import java.time.LocalDate;

public class empresa {
    
    private String nombreEmpresa;
    private String cif;
    private LocalDate fechaFundacion;
    private int maxTrabajadores;

    private trabajador [] trabajadores;
    private int nTrabajadores;
    

    public empresa(String nombreEmpresa, String cif, LocalDate fechaFundacion, int maxTrabajadores) {
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.fechaFundacion = fechaFundacion;
        this.maxTrabajadores = maxTrabajadores;
        this.nTrabajadores = 0;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public int getMaxTrabajadores() {
        return maxTrabajadores;
    }

    public trabajador[] getTrabajadores() {
        return trabajadores;
    }

    public int getNtrabajadores(){
        return nTrabajadores;
    }

    public boolean valorMaximoTrabajadores(int maxTrabajadores){
        boolean isAdd = false;
        if(maxTrabajadores > 0 ){
        this.trabajadores = new trabajador [maxTrabajadores] ;
        }
        return isAdd;
    }

    public boolean nuevoTrabajador(trabajador nuevo){//CREAR NUEVO CLIENTE
        if (nuevo != null) {
            for (int i = 0; i < nTrabajadores; i++) {
                if (trabajadores[i].getDni().equals(nuevo.getDni())) {
                    return false;
                }
            }
            this.trabajadores[nTrabajadores] = nuevo;
            nTrabajadores++;
            return true;
        }
        return false;
    }

    public trabajador obtenerTrabajadorPorPosicion(int i){//OBTENER CLIENTE
        return this.trabajadores[i];
    }

    public boolean eliminarTrabajador(int t){
        boolean isEliminated = false;
        if(this.trabajadores != null){
            this.trabajadores [t] = null;
            for(int i =  + 1; i < nTrabajadores; i++){
                this.trabajadores [i-1] = this.trabajadores[i];
            }
            this.trabajadores [nTrabajadores-1] = null;
            nTrabajadores--;
            isEliminated = true;
            System.out.println("Trabajador eliminado");
        }
        return isEliminated;
    }

    public String mostrarInfoEmpresa(){
        String infoEmpresa = "";
        infoEmpresa = String.format("\n Informacion de la empresa: \nNombre: %s, cif: %s, F.Fundacion: %s", 
        this.nombreEmpresa, this.cif, this.fechaFundacion);
        return infoEmpresa;
    }

    public String mostrarInfoTrabajadores(){
        String trabajadores = "";
     for(int i = 0; i < nTrabajadores; i++){
        System.out.println(i + "-" + this.trabajadores[i].InfoTrabajador());
        }
    return trabajadores;
    }
}
