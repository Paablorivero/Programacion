import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        String opcion;
        Mascotas[] mascotas = new Mascotas[100];
        int contadorMascotas = 0;
        Boolean pulgas = null;
        Boolean pelo = null;
        Boolean habla = null;
        Boolean canta = null;

        do{
            System.out.println("Seleccione una opción:");
            System.out.println("1.-Mostrar tipos de animales");
            System.out.println("2.-Mostrar todos los datos de un animal");
            System.out.println("3.-Añadir animales en el inventario");
            System.out.println("4.-Eliminar animal del inventario");
            System.out.println("5.-Vaciado de inventario");
            System.out.println("6.-Salir");

            opcion = entrada.nextLine();

            switch(opcion){
                case "1":
                System.out.println("Tipos de Mascotas:");
                System.out.println("1.-Perro" + "\n" + "2.-Gato" + "\n" + "3.-(AVE)Loro" + "\n" + "4.-(AVE)Canario");
                    break;
                case "2":
                    System.out.println("Mostrar todos los datos de un animal");
                    System.out.println("Seleccione el tipo de animal:");
                    System.out.println("1.-Perro" + "\n" + "2.-Gato" + "\n" + "3.-(AVE)Loro" + "\n" + "4.-(AVE)Canario");
                    String tipo = entrada.nextLine();
                    switch (tipo){ 
                    
                        case "1":
                        System.out.println("1.-Nombre" + "\n2.-Edad " + "\n3.-Estado " + "\n4.-Fecha de Nacimiento " + 
                        "\n5.-Raza " + "\n6.-Pulgas ");
                        break;

                        case "2":
                        System.out.println("1.-Nombre" + "\n2.-Edad " + "\n3.-Estado " + "\n4.-Fecha de Nacimiento " +
                        "\n5.-Color " + "\n6.-Pelo Largo ");
                        break;

                        case "3":
                        System.out.println("1.-Nombre" + "\n2.-Edad " + "\n3.-Estado " + "\n4.-Fecha de Nacimiento " +
                        "\n5.-Pico " + "\n6.-Vuela ");
                        break;

                        case "4":
                        System.out.println("1.-Nombre" + "\n2.-Edad " + "\n3.-Estado " + "\n4.-Fecha de Nacimiento " +
                        "\n5.-Color " + "\n6.-Canta ");
                        break;
                    }
                    break;

                case "3":
                    entrada = new Scanner(System.in);
                    System.out.println("Añadir animales en el inventario");

                    System.out.println("Introduce el nombre:");
                    String nombre = entrada.nextLine();

                    System.out.println("Introduce la edad:");
                    int edad = entrada.nextInt();

                    System.out.println("Introduce el estado:");
                    String estado = entrada.nextLine();

                    System.out.println("Introduce la fecha de nacimiento:");
                    String fechaNacimiento = entrada.nextLine();

                    System.out.println("Seleccione el tipo de animal:");
                    System.out.println("1.-Perro" + "\n" + "2.-Gato" + "\n" + "3.-(AVE)Loro" + "\n" + "4.-(AVE)Canario");
                    String tipoAdd = entrada.nextLine();

                    switch (tipoAdd) 
                    {
                        case "1":
                        System.out.println("Introduce la raza:");
                        String raza = entrada.nextLine();
                        System.out.println("Introduce si tiene pulgas (si o no):");
                        String pulgasString = entrada.nextLine();
                        if (pulgasString.equalsIgnoreCase("si")) {
                             pulgas = true;
                        } else {
                             pulgas = false;
                        }
                        if (pulgas != null)
                        mascotas[contadorMascotas] = new Perro(nombre, edad, estado, fechaNacimiento, raza, pulgas);
                        System.out.println("Perro añadido correctamente");
                        contadorMascotas++;
                        break;

                        case "2":
                        System.out.println("Introduce el color:");
                        String color = entrada.nextLine();
                        System.out.println("Introduce si tiene el pelo largo (si o no):");
                        String peloLargo = entrada.nextLine();
                        if (peloLargo.equalsIgnoreCase("si")) {
                             pelo = true;
                        } else {
                            pelo = false;
                        }
                        mascotas[contadorMascotas] = new Gato(nombre, edad, estado, fechaNacimiento, color, pelo);
                        System.out.println("Gato añadido correctamente");
                        contadorMascotas++;
                        break;

                        case "3":
                        System.out.println("Introduce el pico:");
                        String pico = entrada.nextLine();
                        System.out.println("Introduce si vuela:");
                        Boolean vuela = entrada.nextBoolean();
                        System.out.println("Introduce el origen:");
                        String origen = entrada.nextLine();
                        System.out.println("Introduce si habla (si o no):");
                        String hablaString = entrada.nextLine();
                        if (hablaString.equalsIgnoreCase("si")) {
                            habla = true;
                        } else {
                            habla = false;
                        }
                        mascotas[contadorMascotas] = new Loro(nombre, edad, estado, fechaNacimiento, pico, vuela, origen, habla);
                        System.out.println("Loro añadido correctamente");
                        contadorMascotas++;
                        break;

                        case "4":
                        System.out.println("Introduce el pico:");
                        String picoCanario = entrada.nextLine();
                        System.out.println("Introduce si vuela:");
                        Boolean vuelaCanario = entrada.nextBoolean();
                        System.out.println("Introduce el color:");
                        String colorCanario = entrada.nextLine();
                        System.out.println("Introduce si canta (si o no):");
                        String cantaString = entrada.nextLine();
                        if (cantaString.equalsIgnoreCase("si")) {
                             canta = true;
                        } else {
                            canta = false;
                        }
                        mascotas[contadorMascotas] = new Canario(nombre, edad, estado, fechaNacimiento, picoCanario, vuelaCanario, colorCanario, canta);
                        System.out.println("Canario añadido correctamente");
                        contadorMascotas++;
                        break;
                    }
                    break;
                case "4":
                    System.out.println("Eliminar animal del inventario");
                    for (int i = 0; i < contadorMascotas; i++) {
                        System.out.println(i + ".-" + mascotas[i].mostrarInfo());
                    }
                    System.out.println("Seleccione el animal a eliminar:");
                    int eliminar = entrada.nextInt();
                    mascotas[eliminar] = null;
                    for (int i = eliminar; i < contadorMascotas; i++) {
                        mascotas[i-1] = mascotas[i];
                    }
                    break;
                case "5":
                    System.out.println("Vaciado de inventario");
                    for (int i = 0; i < contadorMascotas; i++) {
                        mascotas[i] = null;
                    }
                    break;
                case "6":
                    System.out.println("Salir");
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(!opcion.equals("6"));
    }
}
