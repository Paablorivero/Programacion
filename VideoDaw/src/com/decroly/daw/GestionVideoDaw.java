package com.decroly.daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class GestionVideoDaw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		String opcion; //Creamos un String opcion para la seleccion del menu
		
		VideoDaw miFranquicia = null; //Variable para el videoclub
		Pelicula nuevaPelicula = null; //Variable para las peliculas
		Cliente nuevoCliente = null; //Variable para los clientes

	//PATRONES DE DATOS
		final String patronCif = "[A-Z]{1}[0-9]{8}";
		final String patronDNI = "[0-9]{8}[A-Z]{1}";
//INICIAMOS EL MENU 
	do{
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

		//PROGRAMAMOS LAS DIFERENTES OPCIONES DEL MENU
		
			switch (opcion) {
				case "1": //REGISTRAR NUEVA FRANQUICIA
				entrada = new Scanner(System.in);
				System.out.println("\nCREAR NUEVA FRANQUICIA");

			//COMPROBAMOS EL CIF
				String cif = myUtils.comprobarPatronRepetidamente(patronCif, "\nPara empezar escribe el cif de la empresa");
					
			//RECOGEMOS LA DIRECCION
				String direccion = myUtils.leerTextoPantalla("\nAhora añade la direccion");
				miFranquicia = new VideoDaw(cif, direccion);
				System.out.println("\nFRANQUICIA REGISTRADA, ¡FELICIDADES!");
				System.out.println(miFranquicia.InfoVideoDaw());
					break;

				case "2": //REGISTRAR NUEVA PELICULA
				if(miFranquicia != null){
					entrada = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVA PELICULA");	

				//LEEMOS EL TITULO
					String titulo = myUtils.leerTextoPantalla("\nEscribe el titulo de la pelicula");

				//LEEMOS GENERO Y REGISTRAMOS PELICULA
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
						else if(nGenero > 6 || nGenero < 1){
							System.out.println("ERROR. El dato introducido es invalido");
							i -= 1;
						}
					}
					if (nuevaPelicula != null){
						System.out.println("Pelicula registrada correctamente");
						System.out.println(nuevaPelicula.InfoPelicula());
						miFranquicia.nuevaPelicula(nuevaPelicula);
					}
				}else{
					System.out.println("Antes de añadir una pelicula, registre una franquicia por favor.");
				}				
					break;

				case "3"://REGISTRAR CLIENTE
				if (miFranquicia != null){
					entrada = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVO CLIENTE");	

				//RECOGEMOS DATOS Y REGISTRAMOS CLIENTE
					String dni = myUtils.comprobarPatronRepetidamente(patronDNI, "\nIntroduce el DNI");

					String nombre = myUtils.leerTextoPantalla("\nEscribe el nombre");

					String direccionCliente = myUtils.leerTextoPantalla("\nEscribe una direccion");

					LocalDate fechaNacimiento = myUtils.leerFecha();

					LocalDate hoy = LocalDate.now();
					Period Años = Period.between(fechaNacimiento, hoy);

					if (Años.getYears() > 18){
						nuevoCliente = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
						miFranquicia.nuevoCliente(nuevoCliente);

						System.out.println("Cliente registrado con exito");
						System.out.println(nuevoCliente.InfoCliente());
					} else {
						System.out.println("La edad minima son 18 años, cliente no registrado");
					}
				} else {
					System.out.println("Antes de añadir un cliente, registre una franquicia por favor.");
				}
					break;

				case "4": //ALQUILAR PELICULA
				entrada = new Scanner(System.in);

				if(miFranquicia != null && nuevaPelicula != null && nuevoCliente != null){
				//SELECCIONAR CLIENTE
					System.out.println("Quien va a alquilar la pelicula");
					System.out.println(miFranquicia.mostrarClientes());	 
					int cliente = entrada.nextInt();
				
				//SELECCIONAR PELICULA
					System.out.println("¿Que pelicula quieres alquilar?");
					System.out.println(miFranquicia.mostrarPeliculasNoAlquiladas());
					int pelicula = entrada.nextInt();

					if(miFranquicia.obtenerPeliculaPorPosicion(pelicula).isAlquilada() == false)
					{
					miFranquicia.alquilarPelicula(cliente, pelicula);

					miFranquicia.obtenerClientePorPosicion(cliente).addPelicula
					(miFranquicia.obtenerPeliculaPorPosicion(pelicula));

					System.out.println(miFranquicia.obtenerClientePorPosicion(cliente).mostrarPeliculas());	
					} else {
						System.out.println("La pelicula seleccionada ya esta alquilada");
					}
				}else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas en el videoclub.");
				}
					break;

				case "5": //DEVOLVER PELICULA
				if(miFranquicia != null && nuevaPelicula != null && nuevoCliente != null){
					System.out.println("Quien va a devolver la pelicula");
					System.out.println(miFranquicia.mostrarClientes());	 
					int bajacliente = entrada.nextInt();

					if(miFranquicia.obtenerClientePorPosicion(bajacliente).getNalquiladas() > 0){
						System.out.println("Selecciona pelicula a devolver");
						System.out.println(miFranquicia.obtenerClientePorPosicion(bajacliente).mostrarPeliculas());
						int bajapelicula = entrada.nextInt();

						miFranquicia.devolverPelicula(bajacliente, bajapelicula);
						miFranquicia.obtenerClientePorPosicion(bajacliente).elimPelicula
						(miFranquicia.obtenerPeliculaPorPosicion(bajapelicula));
						
						miFranquicia.obtenerClientePorPosicion(bajacliente).mostrarPeliculas();
					}
					else{
						System.out.println("No hay peliculas alquiladas, alquila alguna pelicula.");
					}
				} else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas o Cientes en el videoclub.");
				}
				break;

				case "6": //DAR DE BAJA CLIENTE
				entrada = new Scanner(System.in);
				System.out.println(miFranquicia.mostrarClientes());

				System.out.println("Introduce la posicion del cliente a dar de baja");
		    	int numSocio = entrada.nextInt();
					 	 
				miFranquicia.darBajaCliente(nuevoCliente, numSocio);
					break;

				case "7": //DAR DE BAJA PELICULA
				entrada = new Scanner(System.in);
				System.out.println("Introduce la posicion de la pelicula a dar de baja");
				System.out.println(miFranquicia.mostrarPeliculas());
				int cod = entrada.nextInt();

				miFranquicia.darBajaPelicula(nuevaPelicula, cod);
					break;

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