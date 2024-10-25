package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

		//VARIABLES
		String menu;//Variable utilizada para las selecciones del menu
		String seleccioncpu[] = {"P" , "L" , "T"};
		int jugadacpu = 0;
		

		//INICIO Y DESCRIPCION DEL JUEGO
		System.out.println("\nBIENVENIDO AL PIEDRA PAPEL TIJERA.");
		System.out.println("Este juego consiste en partidas al mejor de 3 de Piedra Papel Tijera.");
		System.out.println("Se jugara contra la cpu y se podra consultar las partidas ganadas durante el juego.");

		//MENU
		do{
			System.out.println("\n/////////MENU////////");
			System.out.println("Selecciona una opcion");
			System.out.println("a. Jugar partida");
			System.out.println("b. Puntuacion");
			System.out.println("c. Salir");
			System.out.print("¿Que quieres hacer?");
			menu = entrada.nextLine();

			switch (menu) {
				case "a":
					System.out.println("\nBienvenido al juego");
					for(int i = 0; i < seleccioncpu.length; i++)
					seleccioncpu[] = random.nextInt(3);
					jugadacpu = (int) (1 + Math.random() * 3);
						if (jugadacpu == 1) {
							System.out.println("Piedra");
						}
						if (jugadacpu == 2) {
							System.out.println("Papel");
							
						}
						else if(jugadacpu == 3){

						}
					break;
				
				case "b":
					System.out.println("\nPuntuacion");
					break;

				case "c":
					System.out.println("\nEspero que te lo hayas pasado muy bien.");
					System.out.println("¡Adios!");
					break;

				default:
					System.out.println("\nPor favor, introduce una opcion valida");
					break;
			}
		}while(!menu.equals("c"));

	}//public static

}//main
