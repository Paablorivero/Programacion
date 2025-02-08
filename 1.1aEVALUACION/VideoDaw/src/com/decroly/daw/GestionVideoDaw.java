package com.decroly.daw;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class GestionVideoDaw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//VARIABLES
		Scanner entrada = new Scanner(System.in);
		String opcion; //Creamos un String opcion para la seleccion del menu
		
		VideoDaw miFranquicia = null; //Variable para el videoclub
		Pelicula nuevaPelicula = null; //Variable para las peliculas
		Cliente nuevoCliente = null; //Variable para los clientes

	//PATRONES DE DATOS
		final String patronCif = "[A-Z]{1}[0-9]{8}"; //Patron para el CIF
		final String patronDNI = "[0-9]{8}[A-Z]{1}"; //Patron para el DNI

//PROGRAMA GESTION VIDEODAW
	do{
	//MENU PRINCIPAL
		entrada = new Scanner(System.in);
		System.out.println("\nBienvenido a VideoDaw, ¿Que deseas hacer?");
		System.out.println("1.-Crear y Registrar Videoclub");
		System.out.println("2.-Registrar pelicula en videoclub");
		System.out.println("3.-Crear y registrar cliente en videoclub");
		System.out.println("4.-Alquilar pelicula");
		System.out.println("5.-Devolver pelicula");
		System.out.println("6.-Dar de baja cliente");
		System.out.println("7.-Dar de baja pelicula");
		System.out.println("8.-SALIR");
		opcion = entrada.nextLine();

		//OPCIONES DEL MENU POR SELECCION
			switch (opcion) {

			//REGISTRAR NUEVA FRANQUICIA
				case "1": 
				entrada = new Scanner(System.in);
				System.out.println("\nCREAR NUEVA FRANQUICIA");

				//Recogemos datos
				String cif = myUtils.comprobarPatronRepetidamente(patronCif, "\nPara empezar escribe el cif de la empresa");
				String direccion = myUtils.leerTextoPantalla("\nAhora añade la direccion");

				//Creamos la franquicia
				miFranquicia = new VideoDaw(cif, direccion);
				System.out.println("\nFRANQUICIA REGISTRADA, ¡FELICIDADES!");
				System.out.println(miFranquicia.InfoVideoDaw());
					break;

			//REGISTRAR NUEVA PELICULA
				case "2": 
				if(miFranquicia != null){
					entrada = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVA PELICULA");	

					//Leemos datos
					String titulo = myUtils.leerTextoPantalla("\nEscribe el titulo de la pelicula");

					//Leemos el genero y creamos la pelicula
					for(int i = 0; i < 1; i++){
						System.out.println("\n¿Cual es el genero de la pelicula? " + "\n1.-ACCION" + 
						"\n2.-COMEDIA" + "\n3.-DRAMA" + "\n4.-FANTASIA" + "\n5.-TERROR " + "\n6.-DOCUMENTALES");
						entrada = new Scanner(System.in);
						int nGenero = entrada.nextInt();

						if (nGenero == 1){
							nuevaPelicula = new Pelicula(titulo, Generos.ACCION);	
						}
						if (nGenero == 2){
							nuevaPelicula = new Pelicula(titulo, Generos.COMEDIA);
						}
						if (nGenero == 3){
							nuevaPelicula = new Pelicula(titulo, Generos.DRAMA);
						}
						if (nGenero == 4){
							nuevaPelicula = new Pelicula(titulo, Generos.FANTASIA);
						}
						if (nGenero == 5){
							nuevaPelicula = new Pelicula(titulo, Generos.TERROR);
						}
						if (nGenero == 6){
							nuevaPelicula = new Pelicula(titulo, Generos.DOCUMENTALES);
						}

						//evitamos seleccionar un numero equivocado
						else if(nGenero > 6 || nGenero < 1){
							System.out.println("ERROR. El dato introducido es invalido");
							i -= 1;
						}
					}

					//Comprobamos que se haya registrado y mostramos pelicula
					if (nuevaPelicula != null){
						System.out.println("Pelicula registrada correctamente");
						System.out.println(nuevaPelicula.InfoPelicula());
						miFranquicia.nuevaPelicula(nuevaPelicula);
					}
				}
				else{
					System.out.println("Antes de añadir una pelicula, registre una franquicia por favor.");
				}				
					break;

			//REGISTRAR CLIENTE
				case "3":
				if (miFranquicia != null){
					entrada = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVO CLIENTE");	

					//Leemos los datos
					String dni = myUtils.comprobarPatronRepetidamente(patronDNI, "\nIntroduce el DNI");
					String nombre = myUtils.leerTextoPantalla("\nEscribe el nombre");
					String direccionCliente = myUtils.leerTextoPantalla("\nEscribe una direccion");
					LocalDate fechaNacimiento = myUtils.leerFecha();

					//Comrpobamos que sea mayor de 18 años
					LocalDate hoy = LocalDate.now();
					Period Años = Period.between(fechaNacimiento, hoy);
					if (Años.getYears() > 18){

						//Registramos el cliente
						nuevoCliente = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);

						//Comprobamos que el dni no coincide
						if (miFranquicia.nuevoCliente(nuevoCliente) == true){
							//Mostramos el cliente
							System.out.println("Cliente registrado con exito");
							System.out.println(nuevoCliente.InfoCliente());
						}
						else{
							System.out.println("cliente ya registrado");
						}
					}
					else{
						System.out.println("El cliente debe ser mayor de edad");
					}
				}
				else {
					System.out.println("Antes de añadir un cliente, registre una franquicia por favor.");
				}
					break;

			//ALQUILAR PELICULA
				case "4": 
				entrada = new Scanner(System.in);

				//Comprobamos que se haya una franquicia con clientes y peliculas
				if(miFranquicia != null && miFranquicia.getNpeliculas() > 0 &&
				 nuevaPelicula != null && nuevoCliente != null){

					//Seleccionamos un cliente
					System.out.println("Quien va a alquilar la pelicula");
					System.out.println(miFranquicia.mostrarClientes());	 
					int cliente = entrada.nextInt();
				
					//Seleccionamos una pelicula
					System.out.println("¿Que pelicula quieres alquilar?");
					System.out.println(miFranquicia.mostrarPeliculasNoAlquiladas());
					int pelicula = entrada.nextInt();

					//Comprobamos que no esta alquilada
					if(miFranquicia.obtenerPeliculaPorPosicion(pelicula).isAlquilada() == false){

						//alquilamos la pelicula
						miFranquicia.alquilarPelicula(cliente, pelicula);
						miFranquicia.obtenerClientePorPosicion(cliente).addPelicula
						(miFranquicia.obtenerPeliculaPorPosicion(pelicula));

						//Mostramos las peliculas del cliente
						System.out.println(miFranquicia.obtenerClientePorPosicion(cliente).mostrarPeliculas());	
					} else {
						System.out.println("La pelicula seleccionada ya esta alquilada");
					}
				}else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas en el videoclub.");
					}
					break;

			//DEVOLVER PELICULA
				case "5": 

				//Comprobamos que haya registrada una franquicia con clientes y peliculas
				if( miFranquicia != null && miFranquicia.getNclientes() > 0 && 
				nuevaPelicula != null && nuevoCliente != null){

					//Seleccionamos cliente
					System.out.println("Quien va a devolver la pelicula");
					System.out.println(miFranquicia.mostrarClientes());	 
					int bajacliente = entrada.nextInt();

					//Comprobamos que tenga peliculas alquiladas
					if(miFranquicia.obtenerClientePorPosicion(bajacliente).getNalquiladas() > 0){

						//Seleccionamos la pelicula
						System.out.println("Selecciona pelicula a devolver");
						System.out.println(miFranquicia.obtenerClientePorPosicion(bajacliente).mostrarPeliculas());
						int bajapelicula = entrada.nextInt();

						//Devolvemos la pelicula
						miFranquicia.devolverPelicula(bajacliente, bajapelicula);
						miFranquicia.obtenerClientePorPosicion(bajacliente).elimPelicula
						(miFranquicia.obtenerPeliculaPorPosicion(bajapelicula));

						//Mostramos el registro de peliculas del cliente
						System.out.println("Registro movimientos: ");
						miFranquicia.obtenerClientePorPosicion(bajacliente).mostrarPeliculas();
					} else{
						System.out.println("No hay peliculas alquiladas, alquila alguna pelicula.");
						}	
				} else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas en el videoclub.");
					}
				break;

			//DAR DE BAJA CLIENTE
				case "6": 
				entrada = new Scanner(System.in);

				//Comprobamos que haya franquicia y clientes registrados
				if(miFranquicia != null && miFranquicia.getNclientes() > 0){

				//Seleccionamos cliente a dar de baja
				System.out.println(miFranquicia.mostrarClientes());
				System.out.println("Introduce la posicion del cliente a dar de baja");
		    	int numSocio = entrada.nextInt();

				//Damos de baja al cliente seleccionado
				miFranquicia.darBajaCliente(nuevoCliente, numSocio);
				} else{
					System.out.println("No hay clientes registrados");
				}
					break;

			//DAR DE BAJA PELICULA
				case "7": 
				entrada = new Scanner(System.in);

				//Comprobamos que haya franquicuia y peliculas registradas
				if(miFranquicia != null && miFranquicia.getNpeliculas() > 0){

				//Seleccionamos pelicula a dar de baja
				System.out.println("Introduce la posicion de la pelicula a dar de baja");
				System.out.println(miFranquicia.mostrarPeliculas());
				int cod = entrada.nextInt();
				
				//Damos de baja la pelicula
				miFranquicia.darBajaPelicula(nuevaPelicula, cod);
				} else {
					System.out.println("No hay peliculas registradas");
				}
					break;

			//SALIR
				case "8":
					System.out.println("Saliendo de VideoDaw. ¡Hasta pronto!");
					break;
			
				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
		}
		while(!opcion.equals("8"));
		entrada.close();
	}

}