import java.util.Scanner;

public class App {
    public static void main(String[] args){
        System.out.println("EJERCICIO 4");
            
        Scanner entrada = new Scanner(System.in);
        
            String opcion;
                try {
                    do{
                    System.out.println("1. Probar número positivo");
                    System.out.println("2. Probar número negativo");
                    System.out.println("3. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = entrada.nextLine();
                    
                    
                    
                    switch (opcion) {
                        case "1":
                            System.out.print("Introduzca un número: ");
                            int numero5 = entrada.nextInt();
                            imprimePositivo(numero5);
                            break;
                        case "2":
                            System.out.print("Introduzca un número: ");
                            int numero6 = entrada.nextInt();
                            imprimeNegativo(numero6);
                            break;
                        case "3":
                                System.out.println("¡Hasta luego!");
                                break;
                        default:
                            System.out.println("Opción no válida");
                    }
                }while(!opcion.equals("3"));

                } catch (Exception e) {
                    System.out.println("Se produjo una excepción: " + e.getMessage());
                }
    }

    //CREACION DE EXCEPCIONES
    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("Error: El número " + p + " es negativo. Se requiere un número positivo.");
        }
        System.out.println("Número positivo válido: " + p);
    }
    
    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("Error: El número " + n + " es positivo o cero. Se requiere un número negativo.");
        }
        System.out.println("Número negativo válido: " + n);
    }
}
