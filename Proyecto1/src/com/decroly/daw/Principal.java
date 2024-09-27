package com.decroly.daw;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		
//EJERCICIO 1 
		
		  System.out.println("EJERCICIO 1");
		  
		  System.out.println("Buenos Dias");
		  
 //EJERCICIO 2
		  
		  System.out.println("\nEJERCICIO 2");
		  
	//Damos valor a las variables
		  
		  int lado = 5;
		  
	//Calculamos el area
		  
		  System.out.println("Area = 5*5");
		  
		  System.out.println("Area =" + lado * lado);
		  
//Ejercicio 3 
		  
		  System.out.println("\nEJERCICIO 3");
		  
	//Damos valor a las variables
		  
		  System.out.println("¿Cual es el lado del cuadrado?:"); 
		  
		  Double lado3 = entrada.nextDouble();
		  
		  Double area = Math.pow(lado3, 2); 
		  
	//Calculamos el area con los datos recogidos
		  
		  System.out.println("El area del cuadrado es:" + area); 
		  
//Ejercicio 4 
		  
		  System.out.println("\nEJERCICIO 4");
		  
	//Damos valor a las variables
		  
		  System.out.println("Dame un numero:");
		  
		  Double E4num1 = entrada.nextDouble();
		  
		  System.out.println("Dame otro:");
		  
		  Double E4num2 = entrada.nextDouble();
		  
	//Calculamos y mostramos los resultados
		  
		  System.out.println("La suma es:" + (E4num1 + E4num2)); 
		  
		  System.out.println("La resta es:" + (E4num1 - E4num2));
		  
		  System.out.println("El producto es:" + (E4num1 * E4num2)); 
		  
		  System.out.println("La division es:" + (E4num1 / E4num2)); 
		 
		 
	//EJERCICIO 5
		  
		System.out.println("\nEJERCICIO 5");
		
	//Recogemos los datos
		
		System.out.println("Escribe el valor del radio:");
		
		Double radio = entrada.nextDouble();
		
	//Calculamos los valores
		
		Double longitud = 2 * Math.PI * radio;
		
		Double areacirculo = Math.PI * Math.pow(radio, 2);
		
		Double volumen = (4.0/3.0) * Math.PI * Math.pow(radio, 3);
		
	//Calculamos los valores
		
		System.out.println("La longitud del circulo es:" + longitud); 
		
		System.out.println("El area del circulo es:" + areacirculo); 
		
		System.out.println("El volumen del circulo es:" + volumen); 
		
//EJERCICIO 6
		
		System.out.println("\nEJERCICIO 6");
		
	//Preguntamos por el precio de los articulos
		
		System.out.println("¿Cual es el precio del articulo?");
	
		Double precio = entrada.nextDouble();
		
		System.out.println("¿Y cual era su precio original?");
		
		Double precioinicial = entrada.nextDouble();
		
	//Caulculamos el porcentaje
		
		Double porcentaje = precio * 100.0 / precioinicial;
		
		Double descuento = 100.0 - porcentaje;
		
	//Mostramos el resultado
		
		System.out.println("el descuento es de : " + descuento + "%");
		
//EJERCICIO 7
		
		System.out.println("\nEJERCICIO 7");
		
	//Recogemos los datos
		
		System.out.println("Dame la distancia en millas : ");
		
		Double millas = entrada.nextDouble();
		
	//Calculamos y mostramos el resultado
		
		Double metros = millas * 1852;
		
		System.out.println(millas + " millas nauticas son : " + metros + " metros"); 
		
//EJERCICIO 8
		
		System.out.println("\nEJERCICIO 8");
		
	//Pedimos los numeros
		
		System.out.println("Dime un numero :");
		
		Double E8num1 = entrada.nextDouble();
		
		System.out.println("Ahora dame otro numero :");
		
		Double E8num2 =entrada.nextDouble();
		
	//Ordenamos los numeros
		
	    Double NumMax = Math.max (E8num1, E8num2);
	    
	    Double NumMin = Math.min(E8num1,  E8num2);
	    
	    System.out.println(NumMax + " , " + NumMin);
	    
//EJERCICIO 9
	    
		System.out.println("\nEJERCICIO 9");
		
	//Pedimos los numeros
		
		System.out.println("Dime un numero :");
		
		int E9num1 = entrada.nextInt();
		
		System.out.println("Ahora dame otro numero :");
		
		int E9num2 =entrada.nextInt();
		
	//Ordenamos los numeros
		
	    System.out.println("¿Son iguales? " + (E9num1 == E9num2));
	    
	    System.out.println("¿El primer numero es mayor? " + (E9num1 > E9num2));
	  
//EJERCICIO 10
	    System.out.println("\nEJERCICIO10");
	    
	//Pedimos los numeros
	    
        System.out.println("Dime un numero :");
		
		Double E10num1 = entrada.nextDouble();
		
		System.out.println("Ahora dame otro numero :");
		
		Double E10num2 =entrada.nextDouble();
		
		System.out.println("Ahora dame un tercer numero :");
		
		Double E10num3 = entrada.nextDouble(); 
		
	//Ordenamos los numeros
		
		Double mayor1 = Math.max(E10num1, E10num2);
		
	    Double mayor2 = Math.max(mayor1, E10num3);
	    
	    System.out.println("El numero mayor es: " + mayor2);
	    
//EJERCICIO 11
	    System.out.println("\nEJERCICIO 11");
	    
	 //Damos valor a las variables
		  
		  System.out.println("Dame un numero:");
		  
		  Double E11num1 = entrada.nextDouble();
		  
		  System.out.println("Dame otro (¡RECUERDA QUE NO PUEDE SER 0!:");
		  
		  Double E11num2 = entrada.nextDouble();
		  
	//Calculamos y mostramos los resultados
		  
		  System.out.println("La suma es: " + (E11num1 + E11num2)); 
		  
		  System.out.println("La resta es: " + (E11num1 - E11num2));
		  
		  System.out.println("El producto es: " + (E11num1 * E11num2)); 
		  
		  System.out.println("La division es: " + (E11num1 / E11num2)); 
		  
//EJERCICIO 12
		  
		  System.out.println("\nEJERCICIO 12");
		  
	//Pedimos los numeros
			
			System.out.println("Dime un numero :");
			
			Double E12num1 = entrada.nextDouble();
			
			System.out.println("Ahora dame otro numero :");
			
			Double E12num2 =entrada.nextDouble();
			
	//Ordenamos los numeros
			
		    Double NumMax12 = Math.max (E12num1, E12num2);
		    
		    System.out.println(NumMax12);
		    
//EJERCICIO 13
		    System.out.println("\nEJERCICIO 13");
		    
	//Recogemos los datos
		    
		    System.out.println("Dime un numero :");
			
			Double E13num = entrada.nextDouble();
			
	//Mostramos los datos
			
			System.out.println("¿El numero es positivo? " + (E13num >= 0));
			
			System.out.println("¿El numero es negativo? " + (E13num < 0));
	} 
}

