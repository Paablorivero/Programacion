import java.util.HashMap;
import java.util.Map;

public class Taller {
    
    private HashMap<String, Coche> coches = new HashMap<String, Coche>();

    public boolean addElemento(Taller t, String matricula, String marca, String color){
        if(!t.coches.containsKey(matricula)){
            coches.put(matricula, new Coche(color, marca));
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
        for (String matricula : coches.keySet()) {
            listaMatriculas += matricula + ",";
        }
        return listaMatriculas;
    }


    public String visualizarTaller(){
        String listaTaller = "";
        for(Map.Entry<String, Coche> entry : coches.entrySet()){
            listaTaller += "Matricula: " + entry.getKey() + " " + entry.getValue() + "\n";
        }
        return listaTaller;
    }
}//Cierre CLASE
