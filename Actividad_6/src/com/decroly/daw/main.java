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

		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				matriz[i][j] = numero;
				numero++;
				}
			}
			
			for (int i = 0; i < 5; i++){
				for (int j = 0; j < 5; j++){
				System.out.print(matriz[i][j] + "\t");
				}
			}

	}//public static void

}//main
