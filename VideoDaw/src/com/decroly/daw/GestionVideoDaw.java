package com.decroly.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GestionVideoDaw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

		String opcion; //Creamos un String opcion para la seleccion del menu
	do{
		entrada = new Scanner(System.in);
		System.out.println("\nBienvenido a VideoDaw, ¿Que deseas hacer?");
		System.out.println("1.-Crear y Registrar Videoclub");
		System.out.println("2.-Registrar pelicula en videoclub");
		System.out.println("3.-Crear y registrar cliente en videoclub");
		System.out.println("4.-Alquilar pelicula");
		System.out.println("5.-Registrar pelicula");
		System.out.println("6.-Dar de baja cliente");
		System.out.println("7.-Dar de baja pelicula");
		System.out.println("8.-SALIR");
		opcion = entrada.nextLine();

		//PROGRAMAMOS LAS DIFERENTES OPCIONES DEL MENU
		
			switch (opcion) {
				case "1":
				VideoDaw miFranquicia;
				System.out.println("\nCREAR NUEVA FRANQUICIA");

				//COMPROBAMOS EL CIF
				final String patronCif = "[A-Z]{1}[0-9]{8}";
				String cif = myUtils.comprobarPatronRepetidamente(patronCif, "\nPara empezar escribe el cif de la empresa");
					
				//RECOGEMOS LA DIRECCION
				String direccion = myUtils.leerTextoPantalla("\nAhora añade la direccion");
				miFranquicia = new VideoDaw(cif, direccion);
				System.out.println("\nFRANQUICIA REGISTRADA, ¡FELICIDADES!");
				System.out.println(miFranquicia.InfoVideoDaw());
					break;

				case "2":
				Pelicula nuevaPelicula;
				System.out.println("\nREGISTRAR NUEVA PELICULA");	
				String titulo = myUtils.leerTextoPantalla("\nEscribe el titulo de la pelicula");
				for(int i = 0; i < 2; i++){
					String genero = myUtils.leerTextoPantalla("\nEscribe el genero de la pelicula:" + 
					"\n1.-ACCION" + "\n2.-COMEDIA" + "\n3.-DRAMA" + "\n4.-FANTASIA" + "\n5.-TERROR " + "\n6.-DOCUMENTALES");
				
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
						System.out.println("Pelicula registrada correctamente");
						System.out.println(nuevaPelicula.InfoPelicula());
					}
					else{
						System.out.println("ERROR. El dato introducido es invalido");
					}
				}
				System.out.println("Pelicula registrada correctamente");
				System.out.println(nuevaPelicula.InfoPelicula());					
					break;

				case "3":
				Cliente nuevoCliente;
				System.out.println("\nREGISTRAR NUEVO CLIENTE");

				//CREAMOS PATRONES DE DATOS
				final String patronDNI = "[1-9]{8}[A-Z]{1}";

				//RECOGEMOS DATOS Y REGISTRAMOS CLIENTE
				String dni = myUtils.comprobarPatronRepetidamente(patronDNI, "\nDime tu DNI");
				String nombre = myUtils.leerTextoPantalla("\nEscribe un nombre");
				String direccionCliente = myUtils.leerTextoPantalla("\nEscribe tu direccion");
				String fechaCliente = myUtils.leerTextoPantalla("\nDime la fecha de nacimiento dd/MM/yyyy");
				//Falta fecha nacimiento
					break;

				case "4":
				
					break;

				case "5":
					
					break;

				case "6":
				
					break;

				case "7":
				
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
