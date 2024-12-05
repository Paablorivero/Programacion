package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

//EJERCICIO 1
		System.out.println("EJERCICIO 1");

		int[][] matriz = new int[5][5];
		int numero = 1;

		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				matriz[i][j] = numero;
				numero++;
				}
			}
			
		for(int i = 0; i < 5; i++){
			System.out.println(" ");
			for (int j = 0; j < 5; j++){
			
			System.out.print(matriz[i][j] + "\t");
			}
		}


//EJERCICIO 2
		System.out.println("\nEjercicio 2");

		int[][] matriz2 = new int [10][10];

		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz2[i][j] = (i + 1) * (j + 1);
            }
        }

        
        for (int i = 0; i < 10; i++){
		System.out.println(" ");
            for (int j = 0; j < 10; j++){
                System.out.print(matriz2[i][j] + "\t"); 
			}
			System.out.println("Tabla del " + (i + 1));
        }

	
//EJERCICIO 3
		System.out.println("\nEJERCICIO 3");

		System.out.println("Introduce el numero de filas");
		int N = entrada.nextInt();

		System.out.println("Introduce el numero de columnas");
		int M = entrada.nextInt();

		int[][] matriz3 = new int [N][M];

		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
				System.out.println("Introduce el valor de la posicion (" + i + "," + j + ")");
				int valor = entrada.nextInt();
                matriz3[i][j] = valor;
            }
        }

		for (int i = 0; i < N; i++){
			System.out.println(" ");
				for (int j = 0; j < M; j++){
					System.out.print(matriz3[i][j] + "\t"); 
				}
			}

		int menor0 = 0;
		int igual0 = 0;
		int mayor0 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matriz3[i][j] < 0){
					menor0++;
				}

				if(matriz3[i][j] > 0){
					mayor0++;
				}

				else if(matriz3[i][j] == 0){
					igual0++;
				}
			}
		}
	
		System.out.println("\nLos menores que 0 son: " + menor0);
		System.out.println("Los iguales a 0 son: " + igual0);
		System.out.println("Los mayores que 0 son: " + mayor0);


//EJERCICIO 4
		System.out.println("\nEJERCICIO 4");

        double[][] notas = new double[4][5];

        for (int i = 0; i < 4; i++) {
            System.out.println("Introduce las notas para el Alumno " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.print("Asignatura " + (j + 1) + ": ");
                notas[i][j] = entrada.nextDouble();
            }
        }

        for (int i = 0; i < 4; i++) {
            double min = notas[i][0];

            double max = notas[i][0];

            double suma = 0;

            for (int j = 0; j < 5; j++) {

                if (notas[i][j] < min) {
                    min = notas[i][j];
                }
                if (notas[i][j] > max) {
                    max = notas[i][j];
                }
                suma = suma + notas[i][j];
            }

            double media = suma / 5;
            System.out.println("\nResultados para el Alumno " + (i + 1) + ":");
            System.out.println("Nota mínima: " + min);
            System.out.println("Nota máxima: " + max);
            System.out.println("Nota media: " + media);
        }


//EJERCICIO 5
		System.out.println("\nEJERCICIO 5");

		System.out.print("Ingrese el número de personas: ");
        int num = entrada.nextInt();
        
        int[][] personas = new int[num][2];
        
        for (int i = 0; i < num; i++){
            System.out.print("\nIngrese el género (0 para hombre, 1 para mujer) de la persona " + (i + 1) + ": ");
            personas[i][0] = entrada.nextInt();
            System.out.print("Ingrese el sueldo de la persona " + (i + 1) + ": ");
            personas[i][1] = entrada.nextInt();
        }

        double sumaHombres = 0;
        double sumaMujeres = 0;
        int contadorHombres = 0;
        int contadorMujeres = 0;
        
        for (int i = 0; i < num; i++){
            if (personas[i][0] == 0){ 
                sumaHombres = sumaHombres + personas[i][1];
                contadorHombres++;
            } 
			else{ 
                sumaMujeres = sumaMujeres + personas[i][1];
                contadorMujeres++;
            }
        }
        
        double sueldoMedioHombres = (sumaHombres / contadorHombres);
        double sueldoMedioMujeres = (sumaMujeres / contadorMujeres);
        
        System.out.println("\nSueldo medio de hombres: " + sueldoMedioHombres);
        System.out.println("Sueldo medio de mujeres: " + sueldoMedioMujeres);
        
        if (sueldoMedioHombres > sueldoMedioMujeres){
            System.out.println("Existe una brecha salarial a favor de los hombres.");
        } 
		else if (sueldoMedioHombres < sueldoMedioMujeres){
            System.out.println("Existe una brecha salarial a favor de las mujeres.");
        } 
		else{
            System.out.println("No existe brecha salarial.");
        }

	}

}
