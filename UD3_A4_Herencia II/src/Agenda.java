public class Agenda {

    private Contacto[] contactos = new Contacto[100];
    private int numContactos;


    public boolean addContacto (Contacto c){
        boolean isAdd = false;
        if (numContactos < contactos.length){
            for (int i = 0; i < numContactos; i++){
                if (contactos[i].getNombre().equalsIgnoreCase(c.getNombre())){   
                    return false; 
                }              
            }
        contactos[numContactos] = c;
        numContactos++;
        isAdd = true;
        }
        return isAdd;
    }

    public boolean elimContacto (String nombre){

    if (this.contactos != null){
        for (int i = 0; i < numContactos; i++){
          if (contactos[i].getNombre().equalsIgnoreCase(nombre)){
                contactos[i] = null;
                numContactos--;
                if (i > 0){
                    contactos[i - 1] = contactos[i];
                }
                return true;
            }
        }
    }
    return false;
    }

    public boolean existContacto (String nombre){
      boolean isExist = false;
      if (this.contactos != null){
        for (int i = 0; i < numContactos; i++){
          if (contactos[i].getNombre().equalsIgnoreCase(nombre)){
            isExist = true;
          }
        }
      }
      return isExist;
    }

    public void listaContactos(){
        
      if (this.contactos != null){
        for (int i = 0; i < numContactos; i++){
            System.out.println((i+1) + ".- " +  contactos[i].infoContacto());
        }
      }
    }

    public int buscarContacto (String nombre){
      int pos = -1;
      if (this.contactos != null){
        for (int i = 0; i < numContactos; i++){
          if (contactos[i].getNombre().equalsIgnoreCase(nombre)){
            pos = i + 1;
          }
        }
      }
      return pos;
    }   
}