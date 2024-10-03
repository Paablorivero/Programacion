package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

       Scanner entrada = new Scanner (System.in);
       
//EJERCICIO 1
       
       System.out.println("EJERCICIO 1");
       
       //Pedimos y registramos la edad
       
       System.out.println("¿Cual es tu edad?");
       
       int edad = entrada.nextInt();
       
       //Damos una respuesta en funcion de la edad marcada
       
       if (edad > 18)
       {
    	  System.out.println("Eres mayor de edad");
       }
       
//EJERCICIO 2
       
       System.out.println("\nEJERCICIO 2");
       
       //Pedimos y registramos la edad
       
       System.out.println("¿Cual es tu edad?");
       
       int edad2 = entrada.nextInt();
       
       //Damos una respuesta en funcion de la edad marcada
       
       if (edad2 > 18)
       {
    	  System.out.println("Eres mayor de edad");
       }
       
       else
       {
    	   System.out.println("Eres menor de edad");
       }
       
//EJERCICIO 3
       
       System.out.println("\nEJERCICIO 3");
       
       //Damos el valor 1 a una variable y sumamos 1 hasta llegar a 20
       
       for (int i = 1; i <=20; i++)
       { 
    	   System.out.print(" " + i);
       }
//EJERCICIO 4
       
       System.out.println("\nEJERCICIO 4");
       
       //Damos valor 2 a la variable y sumamos 2 hasta 200
       
      for (int i = 2; i <= 200; i = i + 2)
      {
    	  System.out.print(" " + i);
      }
       
//EJERCICIO 5
      
      System.out.println("\nEJERCICIO 5");
      
      //Damos valor 1 a la variable y sumamos 1 hasta 200
      
      for (int i = 1; i <=200; i++)
      {
    	  if ( i % 2 == 0)
    	  {
    		  System.out.print(" " + i);
    	  }
      }
      
//EJERCICIO 6
      
      System.out.println("\nEJERCICIO 6");
      
      // Pedimos la variable N de los numeros que queremos obtener
      
      System.out.println("¿Hasta que numero quieres llegar?");
      
      int N6 = entrada.nextInt();
      
      // Sumamos 1 a la variable i hasta llegar al numero escrito antes
      for (int i = 1; i <= N6; i++)
      {
    	  System.out.print(" " + i);
      }
      
//EJERCICIO 7
      
      System.out.println("\nEJERCICIO 7");
      
      // Pedimos un numero para clasificarlo
      
      System.out.println("¿Que nota has sacado?");
      
      Double nota7 = entrada.nextDouble();
      
      //Clasificamos las notas
      
      if (nota7 < 3)
      {
    	  System.out.println("Tu nota ha sido muy deficiente :( ");
      }
      else if (nota7 < 5)
    	  
      {
    	  System.out.println("Tu nota ha sido insuficiente");
      } 
      
      else if (nota7 < 6)
      {
    	  System.out.println("Tu nota ha sido bien");
      }
    	
      else if (nota7 < 9)
      {
    	  System.out.println("Tu nota ha sido notable");
      }
      
      else if (nota7 < 10)
      {
    	  System.out.println("Tu nota ha sido sobresaliente :)");
      }
      
//EJERCICIO 8
      
      System.out.println("\nEJERCICIO 8");
      
      //Recogemos el valor 
      
      System.out.println("Dime un numero");
      
      int N8 = entrada.nextInt();
      
      int facto = 1;
      
      //Hacemos el factorial
      
      if (N8 < 0)
      {
    	  System.out.println("No se puede");
      }
      else
      {
    	  for (int i = 1; i <= N8; i++)
    	  {
    		  facto = facto * i ;
    	  	  
    	  }
    	  System.out.println("El factorial de " + N8 + " = " + facto);
      }
      
//EJERCICIO 9
      
      System.out.println("\nEJERCICIO 9");
      
      //Pedimos la hora
      
      System.out.println("¿Que hora es?");
      
      int hora = entrada.nextInt();
      
      System.out.println("¿Que minuto es?");
      
      int minu = entrada.nextInt();
      
      System.out.println("¿Que segundos son?");
      
      int seg = entrada.nextInt();
      
      //Sumamos un segundo a la hora dandole condiciones
        
      if (seg < 59)
      {
    	 seg = seg + 1;
    	
    	 System.out.println("La hora en un seg es: " + hora + ":" + minu + ":" + seg);
      }
      
      else
      {
    	  seg = 00;
    	  
    	  minu = minu + 1;
    	  
    	  if (minu < 59)
    	  {    		  
    		  System.out.println("La hora en un seg es: " + hora + ":" + minu + ":" + seg);
    	  }
    	  
    	  else
    	  {
    		  minu = 00;
    		  
    		  hora = hora + 1;
    		  
    		  if (hora < 24)
    		  {
    			  
    			  System.out.println("La hora en un seg es: " + hora + ":" + minu + ":" + seg);
    		  }
    		  
    		  else
    		  {
    			  hora = 00;
    			  
    			  System.out.println("La hora en un seg es: " + hora + ":" + minu + ":" + seg);
    		  }
    	  }
      }
      
//EJERCICIO 10
      
     System.out.println("\nEJERCICIO 10");
     
     //Leemos los  numeros
     
     int Num;
     
     int Negativos;
     
     int cont;
     
     while (cont <= 10)
     {
     if (Num = 0)
     {
    	 System.out.println("Introduce un numero que no sea 0");
     }
     else 
     {
    	 cont = cont +1;
    	 if (Num < 0)
    	 {
    		 
    	 }
     }
     }   
     //Comprobamos si alguno es negativo
     
     
     
      }// public static void  
}//main