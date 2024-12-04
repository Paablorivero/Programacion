<<<<<<< HEAD
package com.decroly.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myUtils {

    Scanner reader = new Scanner(System.in);

    public static void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public static String leerTextoPantalla(String mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = reader.nextLine();
        return valor;
    }

    public static boolean comprobarPatron(String patron, String texto)
    {
        boolean isOk = false;
        Pattern pat = Pattern.compile(patron); //"[0-9]{7,8}[A-Za-z]"
        Matcher mat = pat.matcher(texto);
        isOk = mat.matches();
        return isOk;
    }

    public static String comprobarPatronRepetidamente(String patron, String mensaje){
        boolean isOk = false;
        String texto;
        do { 
            texto = myUtils.leerTextoPantalla(mensaje);
            isOk = myUtils.comprobarPatron(patron, texto);
            if(!isOk){
                myUtils.imprimir("El formato es incorrecto");
            }
        } while (!isOk);
        return texto;
    }

    public static LocalDate leerFecha(){
        Scanner entrada = new Scanner(System.in);

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        myUtils.imprimir("\nEscribe la fecha de nacimiento en formato DD/MM/AAAA");
        String dateString = entrada.nextLine();

        //convert String to LocalDate
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        return fechaLocalDate;
    }
    
    public static int leerNumeroPantalla(int mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        int valor = reader.nextInt();
        return valor;
    }

}
=======
package com.decroly.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myUtils {

    Scanner reader = new Scanner(System.in);

    public static void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public static String leerTextoPantalla(String mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = reader.nextLine();
        return valor;
    }

    public static boolean comprobarPatron(String patron, String texto)
    {
        boolean isOk = false;
        Pattern pat = Pattern.compile(patron); //"[0-9]{7,8}[A-Za-z]"
        Matcher mat = pat.matcher(texto);
        isOk = mat.matches();
        return isOk;
    }

    public static String comprobarPatronRepetidamente(String patron, String mensaje){
        boolean isOk = false;
        String texto;
        do { 
            texto = myUtils.leerTextoPantalla(mensaje);
            isOk = myUtils.comprobarPatron(patron, texto);
            if(!isOk){
                myUtils.imprimir("El formato es incorrecto");
            }
        } while (!isOk);
        return texto;
    }

    public static LocalDate leerFecha(){
        Scanner entrada = new Scanner(System.in);

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        myUtils.imprimir("\nEscribe la fecha de nacimiento en formato DD/MM/AAAA");
        String dateString = entrada.nextLine();

        //convert String to LocalDate
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        return fechaLocalDate;
    }
    
    public static int leerNumeroPantalla(int mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        int valor = reader.nextInt();
        return valor;
    }

}
>>>>>>> a13201b534d071c6527cd418418b30c21de4f107
