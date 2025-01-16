public class ContactoEmpresa extends Contacto{

    String web;

    public ContactoEmpresa(String nombre, int telefono, String web) {
        super(nombre, telefono);
        this.web = web;
    }

    public String getWeb() {
        return web;
    }

    @Override
    public String infoContacto(){
        String infoContacto = String.format("Nombre: %s, Telefono: %d, Web: %s", nombre, telefono, web);
        return infoContacto;
    }

    
    
}
