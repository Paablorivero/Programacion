package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);

//EJERCICIO 1

		System.out.println("EJERCICIO 1");

		//Pedimos la cantidad de dinero a dar en billetes

		System.out.println("Introduce una cantidad de dinero");

		int dinero = entrada.nextInt();

		//Comprobamos que la cantidad sea multiplo de 5 y positivo

		if (dinero > 0){
			if (dinero % 5 == 0)
			{
				//Damos un valor a cada billete
				int billete500 = 0;  int billete200 = 0;  int billete100 = 0;

				int billete50 = 0;   int billete20 = 0;   int billete10 = 0;  
				
				int billete5 = 0;   

				//Hacemos un contador para cada billete

				do {
				if (dinero >= 500) {

					billete500++;

					dinero = dinero - 500;
				}

				else if (dinero >= 200) {
					
					billete200++;

					dinero = dinero - 200;
				}

				else if (dinero >= 100) {

					billete100++;

					dinero = dinero - 100;
				}

				else if (dinero >= 50) {
					
					billete50++;

					dinero = dinero - 50;
				}

				else if (dinero >= 20) {
					
					billete20++;

					dinero = dinero - 20;
				}

				else if (dinero >= 10) {

					billete10++;

					dinero = dinero - 10;
				}
			
				else {

					billete5++;

					dinero = dinero - 5;
				}
			} while (dinero > 0);

			//Cuando terminamos el bucle mostamos el resultado

				System.out.println("Billetes 500: " + billete500);

				System.out.println("Billetes 200: " + billete200);

				System.out.println("Billetes 100: " + billete100);

				System.out.println("Billetes 50: " + billete50);

				System.out.println("Billetes 20: " + billete20);

				System.out.println("Billetes 10: " + billete10);

				System.out.println("Billetes 5: " + billete5);
			}
			
			//Enviamos un mensaje si el numero no es multiplo de 5

			else {
				System.out.println("introduce un multiplo de 5");
			}
		}

			//Enviamos un mensaje si el numero es negativo

		else {
			System.out.println("introduce un numero positivo");
		}


//EJERCICIO 2

		System.out.println("\nEJERCICIO 2");

		int opcion;

		do {
            // Marcamos las opciones a elegir

			System.out.println("\nCALCULADORA");
            System.out.println("1. SUMAR");
            System.out.println("2. RESTAR");
            System.out.println("3. MULTIPLICAR");
            System.out.println("4. DIVIDIR");
            System.out.println("5. SALIR");
            System.out.print("Ingrese su opción: ");
            
            opcion = entrada.nextInt();
            
            //Leemos dos numeros y operamos en funcion de la opcion

            if (opcion >= 1) {

                if (opcion == 1) {
					
					System.out.print("Dime el primer numero: ");

                	double num1 = entrada.nextDouble();

                	System.out.print("Dime el segundo : ");

                	double num2 = entrada.nextDouble();

                    System.out.println("Resultado: " + (num1 + num2));
				} 

				else if (opcion == 2) {

					System.out.print("Dime el primer numero: ");

                	double num1 = entrada.nextDouble();

                	System.out.print("Dime el segundo : ");

                	double num2 = entrada.nextDouble();

                    System.out.println("Resultado: " + (num1 - num2));
				} 

				else if (opcion == 3) {

					System.out.print("Dime el primer numero: ");

                	double num1 = entrada.nextDouble();

                	System.out.print("Dime el segundo : ");

                	double num2 = entrada.nextDouble();

                    System.out.println("Resultado: " + (num1 * num2));
				} 

				else if (opcion == 4) {

					System.out.print("Dime el primer numero: ");

                	double num1 = entrada.nextDouble();

                	System.out.print("Dime el segundo : ");

                	double num2 = entrada.nextDouble();

                    if (num2 == 0) {

                        System.out.println("No puedes dividir por 0");
                    } 

					else {

                        System.out.println("Resultado: " + (num1 / num2));
                    }
                }
			}
        } while (opcion != 5);

        System.out.println("Adios");

	}// public static

} //main
