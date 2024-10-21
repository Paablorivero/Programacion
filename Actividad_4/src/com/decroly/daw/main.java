package com.decroly.daw;

import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner entrada = new Scanner(System.in);

//ACTIVIDAD 1
//	System.out.println("ACTIVIDAD 1");

//		int numeros[] = new int[10];

//		System.out.println("Dame un numero");

//	for (int i = 0; i < numeros.length; i++) {
//		numeros[i] = entrada.nextInt();
//	}

//	System.out.println("los numeros son");

//	for (int i = 0; i < numeros.length; i++) {
//		System.out.println(numeros[i]);
//	}

	
//ACTIVIDAD 2
//	System.out.println("\nACTIVIDAD 2");
	
//	int suma = 0;
//	int numero[] = new int[10];

//	System.out.println("Dame un numero");

//	for (int i = 0; i < numero.length; i++) {
//		numero[i] = entrada.nextInt();
//	}

//	System.out.println("La suma es");

//	for (int i = 0; i < numeros.length; i++){
//		suma = suma + numero[i];
//	}
//	System.out.println(suma);


//ACTIVIDAD 3
//	System.out.println("\nACTIVIDAD 3");

//	int num[] = new int[10];

//	System.out.println("Dame un numero");

//	for (int i = 0; i < num.length; i++) {
//		num[i] = entrada.nextInt();
//	}

//	System.out.println("Los mayores y menores son:");

//	for (int i = 0; i < num.length; i++) {
//		Arrays.sort(num); 
//	}

//	System.out.println("el menor es: " + num[1]);
//	System.out.println("el mayor es: " + num[9]);


//ACTIVIDAD 4
//	System.out.println("\nACTIVIDAD 4");

//	int sum[] = new int[20];
//	int sumanegativos = 0;
//	int sumapositivos = 0;
	
//	System.out.println("Dame un numero");

//	for (int i = 0; i < sum.length; i++) {
//		sum[i] = entrada.nextInt();
//	}

//	for (int nume : sum){
//		if(nume < 0){
//			sumanegativos = sumanegativos + nume;
//		}
//		else if(nume > 0){
//			sumapositivos = sumapositivos + nume;
//		}
//	}

//	System.out.print("La suma de los numeros positivos es: ");
//	System.out.println(sumanegativos);
//	System.out.print("La suma de los numeros negativos es: ");
//	System.out.println(sumapositivos);

//ACTIVIDAD 5
//	System.out.println("\nACTIVIDAD 5");

//	double media[] = new double [20];
//	double total = 0;
//	System.out.println("Dame 20 numeros");

//	for (int i = 0; i < media.length; i++) {
//		media[i] = entrada.nextInt();
//	}

//	for(int i = 0; i < media.length; i++){
//		total = total + media[i];
//	}

//	System.out.println("La nota media es de: ");
//	System.out.println(total/20);

//ACTIVIDAD 6
//	System.out.println("\nACTIVIDAD 6");

//	System.out.println("Dame el tamaño del array");
//	int N = entrada.nextInt();

//	System.out.println("Ahora el numero que quieres que muestre");
//	int M = entrada.nextInt();

//	int array5[] = new int[N];

//	Arrays.fill(array5, M);

//	System.out.println("El array es: ");

//	for (int i = 0; i < array5.length; i++) {
//		System.out.println(array5[i]);
//	}

//ACTIVIDAD 7
//		System.out.println("\nACTIVIDAD 7");

//		System.out.println("Dime un numero");
//		int P = entrada.nextInt();

//		System.out.println("Dame el numero al que quieres llegar");
//		int Q = entrada.nextInt();
		
//		int R = Q - P + 1;

//		int array6[] = new int[R];

//		System.out.println("El array es: ");

//		for (int i = 0; i < array6.length; i++) {
//			array6[i] = P + i;
//		}

//		for (int i = 0; i < array6.length; i++) {
//				System.out.println(array6[i]);
//			}


//ACTIVIDAD 8
//		System.out.println("\nACTIVIDAD 8");

//		double array7[] = new double[100];

//		for (int i = 0; i < array7.length; i++) {
//				array7[i] = Math.random();
//		}
		
//		System.out.println("Introduce un numero entre el 0.0 y el 1.0");
//		double n7 = entrada.nextDouble();

//		for(int i = 0; i < array7.length; i++){
//				if(array7[i] > n7){
//					System.out.println(array7[i]);
//				}
//			}


//ACTIVIDAD 9
		System.out.println("\nACTIVIDAD 9");

		double array8[] = new double[100];

		for (int i = 0; i < array8.length; i++) {
			array8 [i] =  1 + Math.random() * 10;
		}
		
		System.out.println("Introduce un numero entre el 1 y el 10");
		double n8 = entrada.nextDouble();

		for(int i = 0; i < array8.length; i++){
			if(array8[i] == n8){
			System.out.println(array8[i]);
			}
		}
			


	}//Public Static Void
}//Main
