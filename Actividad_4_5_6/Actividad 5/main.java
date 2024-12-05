package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

//EJERCICIO 1
		System.out.println("EJERCICIO 1");

		System.out.println("Escribe un texto");
		String texto = entrada.nextLine();

		String palabras[] = texto.split(" ");

		for(String mostrar : palabras){
			System.out.println(mostrar);
		}


//EJERCICIO 2
		System.out.println("\nEJERCICIO 2");

			System.out.println("Introduce un texto");
			String texto1 = entrada.nextLine();

			System.out.println("Ahora dame otro texto");
			String texto2 = entrada.nextLine();

			if(texto1.equalsIgnoreCase(texto2)){
				System.out.println("Las frases son iguales");
			}
			else{
				System.out.println("Las frases no son iguales");
			}


//EJERCICIO 3
	System.out.println("\nEJERCICIO 3");
	
	System.out.println("Introduce tu nombre");
	String nom = entrada.nextLine().toUpperCase();

	System.out.println("Introduce tu primer apellido");
	String apellido1 = entrada.nextLine().toUpperCase();

	System.out.println("Introduce tu segundo apellido");
	String apellido2 = entrada.nextLine().toUpperCase();

	   
	String codigoUsuario =	nom.substring(0, 3) + 
							apellido1.substring(0, 3)+
							apellido2.substring(0, 3);

	System.out.println("El código de usuario es: " + codigoUsuario);


//EJERCICIO 4
	System.out.println("\nEJERCICIO 4");

	System.out.print("Introduce una frase: ");
	String frase = entrada.nextLine().toLowerCase();

	int contadorA = 0;
	int contadorE = 0; 
	int contadorI = 0; 
	int contadorO = 0; 
	int contadorU = 0;

	for (int i = 0; i < frase.length(); i++) {
		char c = frase.charAt(i);

		switch (c) {
			case 'a': contadorA++; 
			break;

			case 'e': contadorE++; 
			break;

			case 'i': contadorI++; 
			break;

			case 'o': contadorO++;
			break;

			case 'u': contadorU++; 
			break;

			default: break;
		}
	}

	System.out.println("Nº de A: " + contadorA);
	System.out.println("Nº de E: " + contadorE);
	System.out.println("Nº de I: " + contadorI);
	System.out.println("Nº de O: " + contadorO);
	System.out.println("Nº de U: " + contadorU);


//EJERCICIO 5
		System.out.println("\nEJERCICIO 5");

        System.out.println("Introduce una frase:");
        String frase5 = entrada.nextLine();
        
        String fraseLimpia = frase5.replaceAll(" ", "").toLowerCase();
        
        boolean esPalindromo = true;
        int longitud = fraseLimpia.length();
        
        for (int i = 0; i < longitud; i++) {
            if (fraseLimpia.charAt(i) != fraseLimpia.charAt(longitud - 1 - i)) {
                esPalindromo = false;
            }
        }
        
        if (esPalindromo){
            System.out.println("La frase es un palíndromo.");
        } else{
            System.out.println("La frase no es un palíndromo.");
        }
	}

}
