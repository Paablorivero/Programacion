import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        ArrayList<Gato> gatos = new ArrayList<Gato>();
        int contGatos = 0;
        System.out.println("Vamos a guardar 5 gatos");
        do{
            try {
                System.out.println("Dime el nombre (minimo 3 caracteres)");
                String nombre = entrada.nextLine();

                System.out.println("Dime la edad (mayor que 0)");
                int edad = Integer.parseInt(entrada.nextLine()); // Evitamos el problema con nextInt()

                Gato gato = new Gato(nombre, edad);
                // No necesitamos los setters aquí ya que el constructor ya valida y establece los valores
                System.out.println(gato.toString());
                gatos.add(gato);
                contGatos++;
                
            } catch (NumberFormatException e) {
                System.out.println("Error: La edad debe ser un número entero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    } while (contGatos < 5);

    System.out.println("Estos son los gatos que has creado:");
    for (Gato gato : gatos){
        System.out.println(gato.toString());
    }
    }
}
