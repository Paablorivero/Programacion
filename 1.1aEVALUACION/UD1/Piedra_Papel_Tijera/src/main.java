package com.decroly.daw;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CREAMOS UN SCANNER PARA LA LECTURA DE DATOS Y RANDOM PARA LA JUAGADA ALEATORIA
		Scanner entrada = new Scanner(System.in);
		Random seleccion = new Random();

		//VARIABLES
		String menu;//Variable utilizada para las selecciones del menu

		String opcionescpu[] = {"P" , "L" , "T"};//array para la eleccion de jugada de la cpu

		int ganadausuario = 0;//contador de victorias del usuario
		int ganadacpu = 0;//contador de victorias de la cpu
		int juegosusuario = 0;//Contador de partidas ganadas del usuario 
		int juegoscpu = 0;//Contador de partidas ganadas de la cpu

		//INICIO Y DESCRIPCION DEL JUEGO
		System.out.println("\nBIENVENIDO AL PIEDRA PAPEL TIJERA.");
		System.out.println("Este juego consiste en partidas de 3 en Piedra Papel Tijera.");
		System.out.println("Se jugara contra la cpu y se podra consultar las partidas ganadas durante el juego.");

		//MENU
		do{
			System.out.println("\n/////////INICIO////////");
			System.out.println("Selecciona una opcion");
			System.out.println("a. Jugar partida");
			System.out.println("b. Puntuacion");
			System.out.println("c. Salir");
			System.out.print("¿Que quieres hacer?");
			menu = entrada.nextLine();

			//Reseteamos el contador de victorias durante el juego
			ganadausuario = 0;
			ganadacpu = 0;

			switch (menu) {
				case "a":
					for(int i = 0; i < 3; i++){

					//CABECERA DE CADA JUGADA Y ELECCION DE JUGADOR Y CPU
						System.out.println("\n//////JUEGO " + (i+1)  + "//////");
						System.out.println("Escribe la jugada que quieres hacer");
						System.out.println("P para piedra" + "\nL para papel" + "\nT para tijera");
						System.out.print("¿Que eliges?: ");
						String seljugador = entrada.nextLine();

						String jugadacpu = opcionescpu[seleccion.nextInt(opcionescpu.length)];

					//MOSTRAMOS LAS ELECCIONES

						System.out.println("\nTU ELECCION: " + seljugador);
						System.out.println("ELECCION CPU: " + jugadacpu);
					
							//PARTIDAS EMPATADAS
							if(seljugador.equalsIgnoreCase(jugadacpu) ){
								System.out.println("=====EMPATE=====");
							}

							//PARTIDAS GANADAS POR EL USUARIO 
							if (seljugador.equalsIgnoreCase("P") && jugadacpu.equalsIgnoreCase("T") ||
								seljugador.equalsIgnoreCase("L") && jugadacpu.equalsIgnoreCase("P") ||
								seljugador.equalsIgnoreCase("T") && jugadacpu.equalsIgnoreCase("L")){

									System.out.println("+++++GANASTE+++++");
									ganadausuario++;
							}

							//PARTIDAS GANADAS POR LA CPU
							else if (jugadacpu.equalsIgnoreCase("P") && seljugador.equalsIgnoreCase("T") ||
								 	jugadacpu.equalsIgnoreCase("L") && seljugador.equalsIgnoreCase("P") ||
								 	jugadacpu.equalsIgnoreCase("T") && seljugador.equalsIgnoreCase("L")) {
							
										System.out.println("-----PERDISTE-----");
										ganadacpu++;
							}
					
							//MOSTRAMOS EL MARCADOR DE LA PARTIDA
							System.out.println("////MARCADOR////");
							System.out.println("JUGADOR: " + ganadausuario);
							System.out.println("CPU: " + ganadacpu);
						
					}

					//SE SUMA UN JUEGO POR PARTIDA GANADA
					if(ganadausuario < ganadacpu){
						juegoscpu++;
					}

					else if(ganadausuario > ganadacpu){
						juegosusuario++;
					}
					break;
				
				case "b":
					System.out.println("\nPuntuacion:");
					System.out.println("Partidas ganadas por el usuario: " + juegosusuario);
					System.out.println("Partidas ganadas por la cpu: " + juegoscpu);
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

		entrada.close();
	}

}