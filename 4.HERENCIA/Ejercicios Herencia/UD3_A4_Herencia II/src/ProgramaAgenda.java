import java.util.Scanner;

public class ProgramaAgenda {
    public static void main(String[] args) throws Exception {
      
        //ATRIBUTOS Y VARIABLES
        Scanner entrada = new Scanner(System.in);
        String opcion = "";

        Agenda agenda = new Agenda();
    do {
        entrada = new Scanner(System.in);
        System.out.println("Agenda de contactos (Escribe el número de la opción que deseas)");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Comprobar si existe el contacto");
        System.out.println("4. Mostrar lista de contactos");
        System.out.println("5. Buscar la posicion de un contacto");
        System.out.println("6. Salir");
        opcion = entrada.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("Introduce el tipode contacto (1. Persona, 2. Empresa)");
                String tipoContacto = entrada.nextLine();

                switch (tipoContacto) {
                    case "1":
                    System.out.println("Introduce el nombre del contacto");
                    String nombre = entrada.nextLine();

                    System.out.println("Introduce el telefono del contacto");
                    int telefono = entrada.nextInt();

                    System.out.println("Introduce la fecha de cumpleaños del contacto");
                    String cumple = entrada.nextLine();

                    ContactoPersona contactoPersona = new ContactoPersona(nombre, telefono, cumple);

                    if (agenda.addPersona(contactoPersona) == true){
                        System.out.println("Contacto añadido correctamente");
                    } else {
                        System.out.println("No se ha podido añadir el contacto, comprueba si existe");
                    }
                        break;

                    case "2":
                    System.out.println("Introduce el nombre de la empresa");
                    String nombreEmpresa = entrada.nextLine();

                    System.out.println("Introduce el telefono de la empresa");
                    int telefonoEmpresa = entrada.nextInt();

                    System.out.println("Introduce la web de la empresa");
                    String webEmpresa = entrada.nextLine();

                    ContactoEmpresa contactoEmpresa = new ContactoEmpresa(nombreEmpresa, telefonoEmpresa, webEmpresa);

                    if (agenda.addEmpresa(contactoEmpresa) == true){
                        System.out.println("Contacto añadido correctamente");
                    } else {
                        System.out.println("No se ha podido añadir el contacto, comprueba si existe");
                    }
                        break;
                        
                    default:
                        System.out.println("Opción no válida, seleccione otra opcion por favor");
                        break;
                }
                break;

            case "2":
                System.out.println("Introduce el nombre del contacto que deseas eliminar");
                String nombreEliminar = entrada.nextLine();

                if (agenda.elimContacto(nombreEliminar) == true){
                    System.out.println("Contacto eliminado correctamente");
                } else if(agenda.elimContacto(nombreEliminar) == false){
                    System.out.println("No se ha podido eliminar el contacto, comprueba si existe");
                }
                break;

            case "3":
                System.out.println("Introduce el nombre del contacto a comprobar");
                String nombreComprobar = entrada.nextLine();

                if (agenda.existContacto(nombreComprobar) == true){
                    System.out.println("El contacto existe");
                } else {
                    System.out.println("El contacto no existe");
                }
                break;

            case "4":
                System.out.println("Lista de contactos");
                agenda.listaContactos();

                break;

            case "5":
                System.out.println("Introduce el nombre del contacto a buscar");
                String nombreBuscar = entrada.nextLine();

                if (agenda.buscarContacto(nombreBuscar) != -1){
                    System.out.println("El contacto se encuentra en la posición " + agenda.buscarContacto(nombreBuscar));
                } else {
                    System.out.println("El contacto no existe");
                }
                break;

            case "6":
                System.out.println("Hasta luego");
                break;
        
            default:
                System.out.println("Opción no válida, seleccione otra opcion por favor");
                break;
            }
        } while (!opcion.equals("6"));
    }
}



