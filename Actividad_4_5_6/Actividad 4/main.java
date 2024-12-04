package com.decroly.daw;

import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner entrada = new Scanner(System.in);

//ACTIVIDAD 1
	System.out.println("ACTIVIDAD 1");

		int numeros[] = new int[10];

		System.out.println("Dame un numero");

	for (int i = 0; i < numeros.length; i++) {
		numeros[i] = entrada.nextInt();
	}

	System.out.println("los numeros son");

	for (int i = 0; i < numeros.length; i++) {
		System.out.println(numeros[i]);
	}

	
//ACTIVIDAD 2
	System.out.println("\nACTIVIDAD 2");
	
	int suma = 0;
	int numero[] = new int[10];

	System.out.println("Dame un numero");

	for (int i = 0; i < numero.length; i++) {
		numero[i] = entrada.nextInt();
	}

	System.out.println("La suma es");

	for (int i = 0; i < numeros.length; i++){
		suma = suma + numero[i];
	}
	System.out.println(suma);


//ACTIVIDAD 3
	System.out.println("\nACTIVIDAD 3");

	int num[] = new int[10];

	System.out.println("Dame un numero");

	for (int i = 0; i < num.length; i++) {
		num[i] = entrada.nextInt();
	}

	System.out.println("Los mayores y menores son:");

	for (int i = 0; i < num.length; i++) {
		Arrays.sort(num); 
	}

	System.out.println("el menor es: " + num[1]);
	System.out.println("el mayor es: " + num[9]);


//ACTIVIDAD 4
	System.out.println("\nACTIVIDAD 4");

	int sum[] = new int[20];
	int sumanegativos = 0;
	int sumapositivos = 0;
	
	System.out.println("Dame un numero");

	for (int i = 0; i < sum.length; i++) {
		sum[i] = entrada.nextInt();
	}

	for (int nume : sum){
		if(nume < 0){
			sumanegativos = sumanegativos + nume;
		}
		else if(nume > 0){
			sumapositivos = sumapositivos + nume;
		}
	}

	System.out.print("La suma de los numeros positivos es: ");
	System.out.println(sumanegativos);
	System.out.print("La suma de los numeros negativos es: ");
	System.out.println(sumapositivos);

//ACTIVIDAD 5
	System.out.println("\nACTIVIDAD 5");

	double media[] = new double [20];
	double total = 0;
	System.out.println("Dame 20 numeros");

	for (int i = 0; i < media.length; i++) {
		media[i] = entrada.nextInt();
	}

	for(int i = 0; i < media.length; i++){
		total = total + media[i];
	}

	System.out.println("La nota media es de: ");
	System.out.println(total/20);

//ACTIVIDAD 6
	System.out.println("\nACTIVIDAD 6");

	System.out.println("Dame el tamaño del array");
	int N = entrada.nextInt();

	System.out.println("Ahora el numero que quieres que muestre");
	int M = entrada.nextInt();

	int array5[] = new int[N];

	Arrays.fill(array5, M);

	System.out.println("El array es: ");

	for (int i = 0; i < array5.length; i++) {
		System.out.println(array5[i]);
	}

//ACTIVIDAD 7
		System.out.println("\nACTIVIDAD 7");

		System.out.println("Dime un numero");
		int P = entrada.nextInt();

		System.out.println("Dame el numero al que quieres llegar");
		int Q = entrada.nextInt();
		
		int R = Q - P + 1;

		int array6[] = new int[R];

		System.out.println("El array es: ");

		for (int i = 0; i < array6.length; i++) {
			array6[i] = P + i;
		}

		for (int i = 0; i < array6.length; i++) {
				System.out.println(array6[i]);
			}


//ACTIVIDAD 8
		System.out.println("\nACTIVIDAD 8");

		double array7[] = new double[100];

		for (int i = 0; i < array7.length; i++) {
				array7[i] = Math.random();
		}
		
		System.out.println("Introduce un numero entre el 0.0 y el 1.0");
		double n7 = entrada.nextDouble();

		for(int i = 0; i < array7.length; i++){
				if(array7[i] > n7){
					System.out.println(array7[i]);
				}
			}


//ACTIVIDAD 9
		System.out.println("\nACTIVIDAD 9");

		int array8[] = new int[100];

		for (int i = 0; i < array8.length; i++) {
			array8[i] = (int) (1 + Math.random() * 10);
		}
		
		System.out.println("Introduce un numero entre el 1 y el 10");
		int n8 = entrada.nextInt();
		int coincide = 0;

		for (int i = 0; i < array8.length; i++) {
			if(array8[i] == n8){
			coincide = coincide + 1;
			}
		}
		System.out.println(" en el array hay " + coincide + " numeros iguales a " + n8);
			

//ACTIVIDAD 10
		System.out.println("\nACTIVIDAD 10");

		System.out.println("¿Cuantas personas hay?");
		int p = entrada.nextInt();

		double media9 = 0;
		int encimamedia = 0;
		int debajomedia = 0;
		double array9[] = new double[p];

		System.out.println("Dime la altura de las " + p + " personas");

		for(int i = 0; i < array9.length; i++){
			array9[i] = entrada.nextDouble();
		}

		for(int i = 0; i < array9.length; i++){
			Arrays.sort(array9);

			media9 = media9 + array9[i];
		}

		System.out.println("La estatura mas baja es: " + array9[0]);
		System.out.println("La estatura mas alta es: " + array9[p-1]);

		System.out.print("La media de las alturas es: " );
		media9 = media9 / p;
		System.out.println(media9);

		for(int i = 0; i < array9.length; i++){
			if(array9[i] > media9){
				encimamedia = encimamedia + 1;
			}
			if (array9[i] < media9){
				debajomedia = debajomedia + 1;
			}
		}
		System.out.println("Hay " + encimamedia + " numeros por encima de la media");
		System.out.println("Hay " + debajomedia + " numeros por encima de la media");


//ACTIVIDAD 11
		System.out.println("\nACTIVIDAD 11");

		  int[] array1 = new int[100];
		  int[] array2 = new int[100];
  
		  for (int i = 0; i < array1.length; i++) {
			  array1[i] = i + 1; 
		  }
  
		  for (int i = 0; i < array1.length; i++) {
			  array2[i] = array1[array1.length - 1 - i];
		  }

		  System.out.print("Primer array: ");
		  for (int normal : array1){
			  System.out.print(normal + " ");
		  }
  
		  System.out.print("\nSegundo array : ");
		  for (int inverso : array2){
			  System.out.print(inverso + " ");
		  }


//ACTIVIDAD 12
		System.out.println("\nACTIVIDAD 12");

		int[] array = new int[10];
        String opcion;

        do {
            System.out.println("Menú:");
            System.out.println("a. Mostrar valores");
            System.out.println("b. Introducir valor");
            System.out.println("c. Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "a":
                    System.out.print("Valores en el array: ");

                    for (int mostrar : array){
                        System.out.print(mostrar + " ");
                    }

                    System.out.println();
                    break;

                case "b":
                    System.out.print("Introduce un numero: ");
                    int entero = entrada.nextInt();

                    System.out.print("Introduce una posición (0-9): ");
                    int posicion = entrada.nextInt();

                    array[posicion] = entero;

                    System.out.println("Numero " + entero + " añadido en la posición " + posicion);
                    break;

                case "c":
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Introduce una opcion valida");
                    break;
           }
       } while (!opcion.equals("c"));


//ACTIVIDAD 13
	   System.out.println("\nACTIVIDAD 13");


		System.out.print("Introduce el valor inicial: ");
		int v = entrada.nextInt();
		 
		System.out.print("Introduce el incremento: ");
		int in = entrada.nextInt();
		 
		System.out.print("Introduce el número de valores a crear: ");
		int n13 = entrada.nextInt();
 
		int array13[] = new int[n13];
 
		
		for (int i = 0; i < array13.length; i++){
			array13[i] = v + (in * i); 
		}
 
		 // Mostrar la secuencia aritmética
		System.out.print("Secuencia aritmética: ");
		for (int secuencia : array13) {
			System.out.print(secuencia + " ");
		}


//ACTIVIDAD 14
		System.out.println("\nEJERCICIO 14");

		int array14[] = new int[55];
        int n14 = 0;


        for (int i = 1; i <= 10; i++){//i se sumara hasta tener un valor maximo de 10
            for (int j = 0; j < i; j++){//j sumara un valor hasta superar el de i
                array14[n14] = i;
                n14++;
            }
        }

        // Mostrar la secuencia
        System.out.print("Secuencia: ");
        for (int mostrar : array14) {
            System.out.print(mostrar + " ");
        }
	}
}
