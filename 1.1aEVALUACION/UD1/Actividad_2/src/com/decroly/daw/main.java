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
       
       System.out.println("\n" + "\nEJERCICIO 4");
       
       //Damos valor 2 a la variable y sumamos 2 hasta 200
       
      for (int i = 2; i <= 200; i = i + 2)
      {
    	  System.out.print(" " + i);
      }
       
//EJERCICIO 5
      
      System.out.println("\n" + "\nEJERCICIO 5");
      
      //Damos valor 1 a la variable y sumamos 1 hasta 200
      
      for (int i = 1; i <=200; i++)
      {
    	  if ( i % 2 == 0)
    	  {
    		  System.out.print(" " + i);
    	  }
      }
      
//EJERCICIO 6
      
      System.out.println("\n" + "\nEJERCICIO 6");
      
      // Pedimos la variable N de los numeros que queremos obtener
      
      System.out.println("¿Hasta que numero quieres llegar?");
      
      int N6 = entrada.nextInt();
      
      // Sumamos 1 a la variable i hasta llegar al numero escrito antes
      for (int i = 1; i <= N6; i++)
      {
    	  System.out.print(" " + i);
      }
      
//EJERCICIO 7
      
      System.out.println("\n" + "\nEJERCICIO 7");
      
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
     
     //Damos valor a las variables
     
     int Negativos = 0;
     
     int cont;
     
     //Aplicamos una condicion para que haga un contador de 10 numeros y cuente tambien los negativos

     for (cont = 0; cont < 10; cont++)
     {
      System.out.println("Dame un numero");

      int Num = entrada.nextInt();

     if (Num == 0)
       {
            cont = cont - 1;

    	      System.out.println("Introduce un numero que no sea 0");
       }

    	 if (Num < 0)
    	 {
    		 Negativos = Negativos + 1;
    	 }
     }
       
     //Cuando el contador llegue a 10 mostramos el resultado

     if (cont == 10) 
     {
      System.out.println("En los 10 numeros habia " + Negativos + " numeros negativos");
     }
     
//EJERCICIO 11
      
     System.out.println("\nEJERCICIO 11");
     
     //Damos valor a las variables
     
     int negativos = 0;

     int Positivos = 0;
     
     int cont2;
     
     //Aplicamos una condicion para que haga un contador de 10 numeros y cuente tambien los negativos y positivos

     for (cont2 = 0; cont2 < 10; cont2++)
     {
      System.out.println("Dame un numero");

      int Num2 = entrada.nextInt();

         if (Num2 == 0){
        	 
            cont2 = cont2 - 1;

    	    System.out.println("Introduce un numero que no sea 0");
         }           

    	 if (Num2 < 0){
    		 
    		 negativos = negativos + 1;
    	 }

    	 else{
        	 
            Positivos = Positivos + 1;
         }
     }
       
     //Cuando el contador llegue a 10 mostramos el resultado
     
     if (cont2 == 10) 
     {
      System.out.println("En los 10 numeros habia " + negativos + " numeros negativos y " + Positivos + " numeros positivos");
     }
     
//EJERCICIO 12
      
      System.out.println("\nEJERCICIO 12");
     
      //Damos valor a las variables

      int negativos3 = 0;

      int positivos3 = 0;

      int cont3 = 1;

      //Hacemos un contador de numeros positivos y negativos

      while (cont3 >= 1)
      {
      System.out.println("Dame un numero");

      int Num3 = entrada.nextInt();

            if (Num3 < 0)
            {
                  negativos3 = negativos3 + 1;
            }

            if (Num3 > 0)
            {
                  positivos3 = positivos3 + 1;
            }

            if (Num3 == 0)
            {
                  cont3 = cont3 - cont3;
            }
      }
  
      //Mostramos el resultado en funcion de los negativos

      if (cont3 == 0) 

            if (negativos3 > 0) 
            {
                  System.out.println("En los numeros habia " + negativos3 + " numeros negativos y " + positivos3 + " numeros positivos");
            }

            if (negativos3 == 0)
            {
                  System.out.println("No habia ningun numero negativo");
            }

//EJERCICIO 13
            System.out.println("\nEJERCICIO13");

            int suma = 1;

            int multi = 1;
            for (int i = 2; i <= 10; i++)
            {
                  suma = suma + i;

                  multi = multi * i;
            }

            System.out.println("La suma de los 10 primeros numeros naturales es: " + suma);

            System.out.println("El producto de los 10 primeros numeros naturales es: " + multi);

//EJERCICIO 14
            System.out.println("\nEJERCICIO 14");

            //Vemos cuantas horas y cual es la tarifa de Juan

            System.out.println("¿Cuantas horas trabaja Juan?");

            Double horas = entrada.nextDouble();
            
            System.out.println("¿Cuanto cobra Juan la hora?");

            Double tarifa = entrada.nextDouble();
            
            Double sueldobruto = 0.0;
            
            //Calculamos los sueldos brutos

            if (horas <=35)
            {
            sueldobruto = horas * tarifa;
            }

            if (horas > 35)
            {
            Double tarifaextra = tarifa * 1.5;

            Double horasExtra = horas - 35;

            Double tarifatotal = 35 * tarifa;

            Double tarifatotalextra = horasExtra * tarifaextra;

            sueldobruto = tarifatotal + tarifatotalextra;
            }
            
          //Con el sueldo bruto sacamos el sueldo neto 
            
            if (sueldobruto <= 500)
            {
            	System.out.println("El sueldo de Juan sera de: " + sueldobruto);
            			
            }
            
            if (sueldobruto <= 900)
            {
            	Double resta1 = sueldobruto - 500;
            	
            	Double imp = resta1 * 0.25;
            	
            	Double sueldoneto = sueldobruto - imp;
            	
            	System.out.println("El sueldo de Juan sera de: " + sueldoneto);
            }
            
            if (sueldobruto > 900)
            {
            	Double resta2 = sueldobruto - 900;
            	
            	Double imp = 400 * 0.25;
            	
            	Double imp1 = resta2 * 0.45;
            	
            	Double sueldoneto = sueldobruto - imp - imp1;
            	
            	System.out.println("El sueldo de Juan sera de: " + sueldoneto);
            }                                 
      }
}