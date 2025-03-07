import java.time.LocalDate;
import java.util.Scanner;

 /**
  * @author daw1
  * @version JavaSE-21
  * @throws CuentaExcepcion
  * @since 1.0
  * 
  */

public class DawBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		CuentaBancaria miCuenta;

		//PATTERNS
		final String patiban = "[A-Z]{2}[0-9]{22}";
		final String patDNI = "[0-9]{8}[A-Z]{1}";

	try{
		//CREAMOS UN CLIENTE
		String nombre = myUtils.leerTextoPantalla("Introduce tu nombre:");
		String dni = myUtils.comprobarPatronRepetidamente(patDNI, "Introduce tu DNI:");
		int telefono = myUtils.leerNumeroPantalla("Introduce tu telefono:");
		String email = myUtils.leerTextoPantalla("Introduce tu email:");
		String direccion = myUtils.leerTextoPantalla("Introduce tu direccion:");

		System.out.print("Introduzca la fecha de nacimiento");
		LocalDate nacimiento = myUtils.leerFecha();

		Cliente cliente = new Cliente(nombre, dni, nacimiento, telefono, email, direccion);
		System.out.println("Cliente creado correctamente");
		
		//Creamos una cuenta bancaria
		String iban = myUtils.comprobarPatronRepetidamente(patiban, "Introduce tu IBAN");
		miCuenta = new CuentaBancaria(cliente, iban, 0);
		System.out.println("Cuenta creada correctamente");
	

		//CREAMOS UN MENU PARA LAS DIFERENTES OPCIONES
		String opcion;
	do{
		entrada = new Scanner(System.in);
		System.out.println("\nBienvenido, ¿Que deseas hacer?");
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
				System.out.println(miCuenta.infoCliente());
					break;

				case "4":
				System.out.println(miCuenta.infoSaldo());
					break;

				case "5":
					try{
					System.out.println("INGRESAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A INGRESAR");
					double cantidadingreso = entrada.nextDouble();

					Movimiento ingreso = new Movimiento("Ingreso",cantidadingreso);
					miCuenta.nuevoIngreso(ingreso);
					System.out.println("INGRESO REALIZADO CON EXITO" + "\n" + miCuenta.infoSaldo());
					}
					catch (CuentaExcepcion e){
						System.out.println(e.getMessage());
					}
					catch (AvisarHaciendaExcepcion e){
						System.out.println(e.getMessage());
						System.out.println("INGRESO REALIZADO CON EXITO" + "\n" + miCuenta.infoSaldo());
					}
					break;

				case "6":
					try{
					System.out.println("RETIRAR SALDO" + "\nINTRODUCE LA CANTIDAD QUE VAS A RETIRAR");
					double cantidadretirada = entrada.nextDouble();

					Movimiento retirada = new Movimiento("Retirada",cantidadretirada);
					miCuenta.nuevoRetirada(retirada);
					System.out.println("RETIRADA REALIZADA CON EXITO" + "\n" + miCuenta.infoSaldo());
					}
					catch (CuentaExcepcion e){
						System.out.println(e.getMessage());
					}
					catch (AvisarHaciendaExcepcion e){
						System.out.println(e.getMessage());
						System.out.println("RETIRADA REALIZADO CON EXITO" + "\n" + miCuenta.infoSaldo());
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
	}catch (Exception e){
		System.out.println("Error inesperado. Saliendo de DawBank");
	}finally{
		entrada.close();
	}
	}//Public static

}//Main