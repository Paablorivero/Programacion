import java.util.HashMap;
import java.util.Map;

public class Agenda {
    Map<String, Contacto> contactos = new HashMap<>();

    public int addContacto(String nombre, String telefono, String correo){
       Contacto contacto = new Contacto (nombre, telefono, correo);
       if(!contacto.validaciones(1, nombre)){
        return 1;
       }

       if(!contacto.validaciones(2, telefono)){
        return 2;
       }

       if(!contacto.validaciones(3, correo)){
        return 2;
       }

       for (Contacto c : contactos.values()){
        if (c.getNombre().equals(nombre)){
            return 4;
        }
       }
       contactos.put(nombre, contacto);
       return 0;
    }

    public String buscarContacto(String nombre){
        String buscar = "";
        for(Contacto c : contactos.values()){
            if(contactos.containsKey(nombre)){
                return "Nombre: " + nombre + "Telefono: " + c.getTelefono() + "Correo: " + c.getCorreo();
            } else {
                return "No existe el contacto";
            }
        }
        return buscar;
    }
       
    public String eliminaContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            return contactos.remove(nombre).toString();
        } else {
            return "No existe el contacto";
        }
    }

    public String visualizaAgenda(){
        String agenda = "";
        for (Map.Entry<String, Contacto> entry : contactos.entrySet()) {
            agenda += entry.getValue().toString();
        }
        return agenda;
    }
    
}
