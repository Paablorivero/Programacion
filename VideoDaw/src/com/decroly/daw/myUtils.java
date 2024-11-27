package com.decroly.daw;

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
}
