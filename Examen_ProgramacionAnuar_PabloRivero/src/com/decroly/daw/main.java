package com.decroly.daw;

import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

		String menu; //añadimos una variable para la seleccion del menu
		//creamos el array
		System.out.println("¿Cuantos numeros quieres almacenar?");
		int t = entrada.nextInt(); //La t sera el tamaño del array
		int array[] = new int [t];

	if(t > 0){
		do{
			//Reiniciamos scanner y creamos un menu
		entrada = new Scanner(System.in);
		System.out.println("\nELIGE LA OPCION QUE QUIERAS UTILIZAR");
		System.out.println("a. Modificar coleccion");
		System.out.println("b. Estadisticas de la coleccion");
		System.out.println("c. Ampliar el valor de la coleccion");
		System.out.println("d. Salir");
		menu = entrada.nextLine();

			//Hacemos un swich para las diferentes opciones del menu
		switch (menu) {
			case "a":
				//Creamos un submenu
			System.out.println("\n¿Que quieres hacer?");
			System.out.println("1. insertar numero");
			System.out.println("2. Borrar numero de una posicion especifica");
			System.out.println("3. Modificar numero de una posicion especifica");
			String menu1 = entrada.nextLine();

			switch (menu1) {
					//Añadimos valores
				case "1":
					System.out.println("El array tiene " + t + " numeros");
					System.out.println("¿Que posicion quieres añadir?");
                    int posicion = entrada.nextInt();

					System.out.print("Introduce un numero: ");
                    int entero = entrada.nextInt();

                    array[posicion - 1] = entero;

                    System.out.println("Numero " + entero + " añadido en la posición " + posicion);
					break;

					//Eliminamos posicion
				case "2":
					System.out.println("El array tiene " + t + "numeros");
					System.out.println("¿Que posicion quieres eliminar?");
					posicion = entrada.nextInt();

					array[posicion - 1] = 0;

					System.out.println("Numero de la posicion " + posicion + " eliminado");
					break;

				case "3":
					//Modificar numero
					System.out.println("El array tiene " + t + " numeros");
					System.out.println("¿Que posicion quieres modificar?");
					posicion = entrada.nextInt();

					System.out.println("El numero de esa posicion es " + array[posicion] + "\n¿Cual quieres añadir?");
					entero = entrada.nextInt();

					array[posicion - 1] = entero;

					System.out.println("Numero " + entero + " añadido en la posición " + posicion);
					break;
			}
				break;
			
				case "b":
					//creamos un submenu
				System.out.println("\n¿Que quieres hacer?");
				System.out.println("1. Media de valores no nulos");
				System.out.println("2. Suma de todos los valores");
				System.out.println("3. Max de la coleccion");
				System.out.println("4. Min de la coleccion");
				String menu2 = entrada.nextLine();

				switch (menu2) {
						//hacemos la media
					case "1":
					double media = 0;
					int nulo = 0;
					for(int i = 0; i < array.length; i++){
						media = media + array[i];
						if(array[i] == 0 ){
							nulo = nulo + 1;
						}
						
					}
						System.out.print("La media es: " );
						media = media / (t - nulo);
						System.out.println(media);
					
					break;

						//Sumamos los valores
					case "2":
					int suma = 0;
					System.out.println("La suma es");

					for (int i = 0; i < array.length; i++){
					suma = suma + array[i];
					}
					System.out.println(suma);
					break;

						//Mostramos el max
					case "3":
					for (int i = 0; i < array.length; i++) {
						Arrays.sort(array); 
						}
	
						System.out.println("El numero max de la coleccion es: " + array[t-1]);
					break;

						//Mostramos el min
					case "4":
					for (int i = 0; i < array.length; i++) {
						Arrays.sort(array); 
						}
	
						System.out.println("El numero min de la coleccion es " + array[1]);
					break;
				}
				break;

					//Ampliamos el tamaño del array
				case "c":
				System.out.println("¿A cuantos numeros lo quieres ampliar?");
				int amp = entrada.nextInt();
				t = amp;
				break;

					//Salir del programa
				case "d":
				System.out.println("\nEspero que te lo hayas pasado muy bien.");
				System.out.println("¡Adios!");
				break;

				default:
					System.out.println("\nPor favor, introduce una opcion valida");
					break;
			}
		
		}while(!menu.equals("d"));
	}else{
		System.out.println("introduce un valor valido para el tamaño del array");
	}
	entrada.close();


	}//public static

}//main
