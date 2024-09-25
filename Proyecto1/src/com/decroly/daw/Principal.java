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
		  
		  System.out.print("Area =");
		  
		  System.out.println(lado * lado);
		  
//Ejercicio 3 
		  
		  System.out.println("/nEJERCICIO 3");
		  
		  //Damos valor a las variables
		  
		  Double lado3; 
		  
		  System.out.println("¿Cual es el lado del cuadrado?:"); 
		  
		  lado3 = entrada.nextDouble();
		  
		  Double area = Math.pow(lado3, 2); 
		  
		  //Calculamos el area con los datos recogidos
		  
		  System.out.print("El area del cuadrado es:" + area); 
		  
//Ejercicio 4 
		  
		  System.out.println("/nEJERCICIO 4");
		  
		  //Damos valor a las variables
		  
		  Double E4num1;
		  
		  Double E4num2; 
		  
		  System.out.println("Dame un numero:");
		  
		  E4num1 = entrada.nextDouble();
		  
		  System.out.println("Dame otro:");
		  
		  E4num2 = entrada.nextDouble();
		  
		  
		  //Calculamos las operaciones
		  
		  Double suma = E4num1 + E4num2;

		  Double resta = E4num1 - E4num2;
		  
		  Double producto = E4num1 * E4num2;
		  
		  Double division = E4num1 / E4num2;
		  
		  //Mostramos los resultados
		  
		  System.out.println("La suma es:" + suma); 
		  
		  System.out.println("La resta es:" + resta);
		  
		  System.out.println("El producto es:" + producto ); 
		  
		  System.out.println("La division es:" + division); 
		 
		 
	//EJERCICIO 5
		  
		System.out.println("/nEJERCICIO 5");
		
		//Recogemos los datos
		
		Double radio;
		
		System.out.println("Escribe el valor del radio:");
		
		radio = entrada.nextDouble();
		
		//Calculamos los valores
		
		Double longitud = 2 * Math.PI * radio;
		
		Double areacirculo = Math.PI * Math.pow(radio, 2);
		
		Double volumen = (4.0/3.0) * Math.PI * Math.pow(radio, 3);
		
		//Calculamos los valores
		
		System.out.print("La longitud del circulo es:" + longitud); 
		
		System.out.print("El area del circulo es:" + areacirculo); 
		
		System.out.print("El volumen del circulo es:" + volumen); 
		
//EJERCICIO 6
		
		System.out.println("/nEJERCICIO 6");
		
		//Preguntamos por el precio de los articulos

		Double precio;
		
		Double precioinicial;
		
		System.out.println("¿Cual es el precio del articulo?");
	
		precio = entrada.nextDouble();
		
		System.out.println("¿Y cual era su precio original?");
		
		precioinicial = entrada.nextDouble();
		
		//Caulculamos el porcentaje
		
		Double porcentaje = precio * 100.0 / precioinicial;
		
		Double descuento = 100.0 - porcentaje;
		
		//Mostramos el resultado
		
		System.out.print("el descuento es de : " + descuento + "%");
		
//EJERCICIO 7
		
		System.out.println("/nEJERCICIO 7");
		
		//Recogemos los datos
		
		Double millas;
		
		System.out.println("Dame la distancia en millas : ");
		
		millas = entrada.nextDouble();
		
		//Calculamos y mostramos el resultado
		
		Double metros = millas * 1852;
		
		System.out.print(millas + " millas nauticas son : " + metros + " metros"); 
		
//EJERCICIO 8
		
		System.out.println("/nEJERCICIO 8");
		
		//Pedimos los numeros
		
		Double E8num1;
		
		Double E8num2;
		
		System.out.println("Dime un numero :");
		
		E8num1 = entrada.nextDouble();
		
		System.out.println("Ahora dame otro numero :");
		
		E8num2 =entrada.nextDouble();
		
		//Ordenamos los numeros
		
		if (E8num1 > E8num2)
		{
			System.out.println( E8num1 + " es mayor que " + E8num2);
		}
		else 
		{
			System.out.println( E8num2 + " es mayor que " + E8num1);
		}
		
//EJERCICIO 9
		System.out.println("/nEJERCICIO 9");
		
	} 

}

