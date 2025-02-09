import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Vamos a crear un gato");

        System.out.println("Dime el nombre (minimo 3 caracteres)");
        String nombre = entrada.nextLine();

        System.out.println("Dime la edad (mayor que 0)");
        int edad = entrada.nextInt();

        try {
            Gato gato = new Gato(nombre, edad);
            gato.setNombre(nombre);
            gato.setEdad(edad);
            System.out.println(gato.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
