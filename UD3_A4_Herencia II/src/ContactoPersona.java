public class ContactoPersona extends Contacto {
    
    String cumple;

    public ContactoPersona(String nombre, int telefono, String cumple) {
        super(nombre, telefono);
        this.cumple = cumple;
    }

    public String getCumple() {
        return cumple;
    }

    @Override
    public String infoContacto(){
        String infoContacto = String.format("Nombre: %s, Telefono: %d, Cumpleaños: %s", nombre, telefono, cumple);
        return infoContacto;
    }
    
    

    
   
    

}
