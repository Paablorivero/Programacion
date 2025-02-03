import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Taller taller = new Taller();


        String opcion;
        do{
            Scanner entrada = new Scanner(System.in);
            System.out.println("\n¿Que deseas hacer?");
            System.out.println("1.-Añadir coche al taller");
            System.out.println("2.-Eliminar coche del taller");
            System.out.println("3.-SALIR");
            opcion = entrada.nextLine();

            switch (opcion) {
    
                case "1":
                    System.out.println("Añadir coche al taller");
                    System.out.println("Introduce la marca del coche");
                    String marca = entrada.nextLine();

                    System.out.println("Introduce el color del coche");
                    String color = entrada.nextLine();

                    Coche coche = new Coche(color, marca);

                    System.out.println("Introduce la matricula del coche");
                    String matricula = entrada.nextLine();

                    if(taller.addElemento(taller, matricula, coche)==true){
                        System.out.println("Coche añadido correctamente");
                       System.out.println(taller.mostrarCoches()); 
                        System.out.println(taller.mostrarMatricula());
                        System.out.println(taller.listaTaller());
                    }else{
                        System.out.println("No se ha podido añadir el coche");
                    }
                    break;

                case "2":
                    System.out.println("Eliminar coche del taller");
                    System.out.println("Introduce la matricula del coche");
                    matricula = entrada.nextLine();

                    if(taller.deleteElemento(taller, matricula)==true){
                        System.out.println("Coche eliminado correctamente");
                    }else{
                        System.out.println("No se ha podido eliminar el coche");
                    }   
                    break;

                case "3":
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Seleccione una opcion valida por favor");
                    break;
            }//cierre SWITCH
        }while(!opcion.equals("8"));//Cierre DO-WHILE
    }//cierre MAIN
}//cierre CLASE
