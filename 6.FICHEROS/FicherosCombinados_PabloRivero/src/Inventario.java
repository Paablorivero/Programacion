import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Inventario {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        File file = new File("./resources/productos.csv");
        

        do{
            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir (inventario.dat).");
            System.out.println("4. Registrar producto en el Inventario");
            System.out.println("Introduce una opción: ");
            opcion = sc.nextLine();
            
            switch(opcion){
                case "1":
                    System.out.println("Mostrar Productos en el Inventario.");
                    //Mostramos el arccivo productos.csv
                    try{
                    fichero = new FileInputStream("almacen.dat");
                    lector = new DataInputStream (fichero);
                    } catch (IOException e) {
                    System.out.println("Ha ocurrido un error al abrir el archivo");
                    System.out.println(e.getMessage());
                    return; 
                    }
                    break;
                case "2":
                    System.out.println("Eliminar Producto por referencia.");
                    break;
                case "3":
                    System.out.println("Guardar y Salir");
                    break;
                case "4":
                    System.out.println("Opcion en desarrollo");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(!opcion.equals("3"));
        sc.close();
    }
}
