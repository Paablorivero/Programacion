package com.decroly.daw;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DawBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		CuentaBancaria miCuenta;

		//CREAMOS UNA NUEVA CUENTA BANCARIA
		System.out.println("Bienvenido a DawBank" + "\nPara empezar vamos a crear la cuenta");
		System.out.println("Introduce tu nombre completo (Nombre + Apellidos)");
		String nombre = entrada.nextLine();

		//VALIDAREMOS EL IBAN
		System.out.println("Introduce tu IBAN");
		String iban = entrada.nextLine();
		Pattern patiban = Pattern.compile("[A-Z]{2}[0-9]{22}");
		Matcher matiban = patiban.matcher(iban);
		while (!matiban.matches()) {
			System.out.println("El IBAN introducido es incorrecto" + "\nIntroduce un IBAN correcto");
			iban = entrada.nextLine();
			matiban = patiban.matcher(iban);
		}

		miCuenta = new CuentaBancaria(iban, nombre, 0);
		System.out.println("Cuenta creada correctamente");

		//CREAMOS UN MENU PARA LAS DIFERENTES OPCIONES
		
		String opcion;
	do{
		System.out.println("\nBienvenido " + nombre + " ¿Que deseas hacer?");
		System.out.println("1.-Datos de la cuenta");
		System.out.println("2.-IBAN");
		System.out.println("3.-TITULAR");
		System.out.println("4.-SALDO");
		System.out.println("5.-INGRESO");
		System.out.println("6.-RETIRADA");
		System.out.println("7.-MOVIMIENTOS");
		System.out.println("8.-SALIR");
		opcion = entrada.nextLine();

		//PROGRAMAMOS LAS DIFERENTES OPCIONES DEL MENU
		
			switch (opcion) {
				case "1":
					System.out.println(miCuenta.infoCuenta());
					break;

				case "2":
					System.out.println(miCuenta.infoIban());
					break;

				case "3":
					
					break;

				case "4":
					
					break;

				case "5":
					System.out.println("INGRESAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A INGRESAR");
					double cantidad = entrada.nextDouble();

					Movimiento ingreso = new Movimiento("Ingreso",cantidad);
					miCuenta.nuevoIngreso(ingreso);
					break;

				case "6":
					
					break;

				case "7":
					
					break;

				case "8":
					System.out.println("Saliendo de DawBank. ¡Hasta pronto!");
					break;

				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
		}
		while(!opcion.equals("5"));
		entrada.close();
	}//Public static

}//Main
