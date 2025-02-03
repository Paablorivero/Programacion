import java.util.HashMap;
import java.util.Map;

public class Taller {
    
    private Map<String, Coche> coches = new HashMap<String, Coche>();


    public boolean addElemento(Taller t, String matricula, Coche coche){
        if(!t.coches.containsKey(matricula)){
            coches.put(matricula, coche);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteElemento(Taller t, String matricula){
        if(t.coches.containsKey(matricula)){
            coches.remove(matricula);
            return true;
        }else{
            return false;
        }
    }

    public String mostrarCoches(){
        String listaCoches = "";
        for (Coche coche : coches.values()) {
            listaCoches += "Marca: " + coche.getMarca() + " Color: " + coche.getColor() + "\n";
        }
        return listaCoches;
    }

    public String mostrarMatricula(){
        String listaMatriculas = "";
        for (Map.Entry<String, Coche> entry : coches.entrySet()) {
            listaMatriculas += "Matricula: " + entry.getKey() + "\n";
        }
        return listaMatriculas;
    }

    public Map<String, Coche> listaTaller(){
        return coches;
    }
}//Cierre CLASE
