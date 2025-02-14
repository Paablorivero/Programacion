import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class DawBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		CuentaBancaria miCuenta;

		//PATTERNS
		final String patiban = "[A-Z]{2}[0-9]{22}";
		final String patDNI = "[0-9]{8}[A-Z]{1}";

		//CREAMOS UNA PERSONA
		System.out.println("Introduzca el nombre");
		String nombre = entrada.nextLine();

		System.out.println("Ahora dime tu DNI");
		String dni = myUtils.comprobarPatronRepetidamente(patDNI, "Intruduce el DNI");

		System.out.println("Introduzca la fecha de nacimiento");
		LocalDate nacimiento = myUtils.leerFecha();

		Persona persona = new Persona(nombre, dni, nacimiento);

		
		

		//VALIDAREMOS EL IBAN
		String iban = myUtils.comprobarPatronRepetidamente(patiban, "Introduce tu IBAN");
		miCuenta = new CuentaBancaria(iban, nombre, 0);
		System.out.println("Cuenta creada correctamente");

		//CREAMOS UN MENU PARA LAS DIFERENTES OPCIONES
		
		String opcion;
	do{
		entrada = new Scanner(System.in);
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
					System.out.println(miCuenta.toString());
					break;

				case "2":
					System.out.println(miCuenta.infoIban());
					break;

				case "3":
				System.out.println(miCuenta.infoTitular());
					break;

				case "4":
				System.out.println(miCuenta.infoSaldo());
					break;

				case "5":
					entrada = new Scanner(System.in);
					System.out.println("INGRESAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A INGRESAR");
					double cantidadingreso = entrada.nextDouble();

					if(cantidadingreso > 0){
						if (cantidadingreso > 3000) {
							System.out.println("VA A REALIZAR UNA OPERACION DE MAS DE 3000 EUROS." 
							+ "\nNOTIFIQUE A HACIENDA POR FAVOR");
						}
						Movimiento ingreso = new Movimiento("Ingreso",cantidadingreso);
						miCuenta.nuevoIngreso(ingreso);
						System.out.println("INGRESO REALIZADO CON EXITO" + "\n" + miCuenta.infoSaldo());
					}

					else {
						System.out.println("POR FAVOR, INTRODUCE UNA CANTIDAD VALIDA");
					}
					break;

				case "6":
					entrada = new Scanner(System.in);
					System.out.println("RETIRAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A RETIRAR");
					double cantidadretirada = entrada.nextDouble();

					if (cantidadretirada > 0) {
						if (cantidadretirada > 3000) {
							System.out.println("VA A REALIZAR UNA OPERACION DE MAS DE 3000 EUROS." 
							+ "\nNOTIFIQUE A HACIENDA POR FAVOR");
						}
						Movimiento retirada = new Movimiento("Retirada",cantidadretirada);
						miCuenta.nuevoRetirada(retirada);
						System.out.println("RETIRADA REALIZADA CON EXITO" + "\n" + miCuenta.infoSaldo());
					}
					else{
						System.out.println("POR FAVOR, INTRODUCE UNA CANTIDAD VALIDA");
					}
					break;

				case "7":
					System.out.println(miCuenta.infoMovimiento());
					break;

				case "8":
					System.out.println("Saliendo de DawBank. ¡Hasta pronto!");
					break;

				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
		}
		while(!opcion.equals("8"));
		entrada.close();
	}//Public static

}//Main