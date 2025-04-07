import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        Agenda agenda = new Agenda();

        String opcion;

        do{
            System.out.println("Menu agenda:");
            System.out.println("1.Añadir contacto");
            System.out.println("2.Buscar contacto");
            System.out.println("3.Eliminar contacto");
            System.out.println("4.Visualizar agenda");
            System.out.println("5.Número de contactos de mi agenda");
            System.out.println("6.Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextLine();
            
            switch (opcion) {
                case "1":
                    System.out.println("Introduzca el nombre del contacto: ");
                    String nombre = entrada.next();

                    System.out.println("Introduzca el teléfono del contacto: ");
                    String telefono = entrada.next();

                    System.out.println("Introduzca el correo del contacto: ");
                    String correo = entrada.next();

                    int error = agenda.addContacto(nombre, telefono, correo);
                    switch (error) {
                        case 0:
                            System.out.println("Contacto añadido correctamente.");
                            break;

                        case 1:
                            System.out.println("Nombre inválido. Debe comenzar con mayúscula y contener solo letras.");
                            break;

                        case 2:
                            System.out.println("Teléfono inválido. Debe comenzar por 6, 7 u 8 y tener 9 dígitos.");
                            break;

                        case 3:
                            System.out.println("Correo inválido. Debe tener un formato válido.");
                            break;

                        case 4:
                            System.out.println("El contacto ya existe.");
                            break;
                    }
                    break;

                case "2":
                    System.out.println("Introduzca el nombre del contacto que se va a buscar: ");
                    nombre = entrada.next();

                    System.out.println(agenda.buscarContacto(nombre));
                    break;

                case "3":
                    System.out.println("Introduzca el nombre del contacto que se va a eliminar: ");
                    nombre = entrada.next();

                    System.out.println(agenda.eliminaContacto(nombre));
                    break;

                case "4":
                    System.out.println(agenda.visualizaAgenda());
                    break;

                case "5":
                    System.out.println("Contactos en la agenda: " + agenda.contactos.size());
                    break;

                case "6":
                    System.out.println("Saliendo de la app");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }while (!opcion.equals("6"));
    }
}
