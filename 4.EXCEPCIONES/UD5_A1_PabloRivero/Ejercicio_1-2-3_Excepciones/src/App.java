import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int numero1 = 0;

        //EJERCICIO 1
        System.out.println("Ejercicio 1");

        System.out.println("Dime un numero entero");
        try{
            numero1 = entrada.nextInt();
            System.out.println("Valor introducio = " +  numero1);
        }
        catch (InputMismatchException e){
            System.out.println("Dato invalido");
        }

        //EJERCICIO 2
        int numero2 = 0;
        int numero3 = 0;
        int resultado1 = 0;
        System.out.println("Ejercicio 2");
        try{
        System.out.println("Vamos a dividir dos numeros");

        System.out.println("Dime el primer numero");
        numero2 = entrada.nextInt();

        System.out.println("Dime el segundo numero");
        numero3 = entrada.nextInt();

        resultado1 = numero2/numero3;
        System.out.println("El resultado es: " + resultado1);
        }catch(InputMismatchException e){
            System.out.println("Dato invalido");
        }catch(ArithmeticException e){
            System.out.println("No se ha podido realizar la division");
        }

        //EJERCICIO 3
        
        System.out.println("EJERCICIO 3");

        Double numeros [] = new Double[5];
        int pos = 0;

        do{
            try{
                System.out.println("Se van a pedir 5 numeros para guardar");
                System.out.println("Introduce un numero en formato 0,0");
                numeros[pos] = entrada.nextDouble();  
                pos++;

            }catch(NumberFormatException e){
                System.out.println("Dato invalido. Intentalo de nuevo");
                numeros[pos] = null;
                pos--;
            }catch (InputMismatchException e) {
                System.out.println("Dato erreoneo. Intentalo de nuevo");
                numeros[pos] = null;
                pos--;
            }
            
        }while (pos < 5);         
        

        if(numeros[4] != null){
            System.out.println("\nValores introducidos en el vector:");
            for (int i = 0; i < numeros.length; i++){
                System.out.println("Numero " + i + ": " + numeros[i]);
            }
        }       
    }  
}
