import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
		
		LinkedList <Libro> listaLibros = new LinkedList<Libro>();
        Scanner entrada = new Scanner(System.in);
        String opcion;
		Libro libro = null;

		//Variables para lectura y escritura de ficheros
		FileInputStream MostrarFile;
		ObjectInputStream MostrarBuffer;

		FileOutputStream file;
 		ObjectOutputStream buffer;

        do{
	//MENU PRINCIPAL
		entrada = new Scanner(System.in);
		System.out.println("\nBienvenido a la gestion de tu biblioteca" +
		"\n1.-Crear Libro y registrarlo en la Biblioteca" + "\n2.-Mostrar Libros existentes" +
		"\n3.-Eliminar Libro por ISBN" + "\n4.-Guardar Libros en el fichero" +
		"\n5.-Guardar y Salir\r" );
		opcion = entrada.nextLine();

		//OPCIONES DEL MENU POR SELECCION
			switch (opcion) {
			//REGISTRAR NUEVA FRANQUICIA
				case "1": 
				//CREAR LIBRO
					System.out.println("Vamos a registrar un nuevo libro en tu biblioteca");

					//PEDIR DATOS DEL LIBRO
					String isbn = myUtils.leerTextoPantalla("Introduce el ISBN del libro: ");
					String titulo = myUtils.leerTextoPantalla("Introduce el titulo del libro: ");
					String autor = myUtils.leerTextoPantalla("Introduce el autor del libro: ");

					//CREAR LIBRO
					libro = new Libro(isbn, titulo, autor);
					System.out.println("Libro creado: " + libro.toString());

					//AÑADIR LIBRO A LA LISTA
					listaLibros.add(libro);
					break;

			//MOSTRAR LIBROS
				case "2": 
				
					System.out.println("Mostrando los libros existentes en tu biblioteca");
					for (Libro libro2 : listaLibros) {
						System.out.println(libro2.toString());
					}

					//MOSTRAR LIBROS
					// Abrir fichero para lectura
 					try {
					entrada = new Scanner(System.in);
 					MostrarFile = new FileInputStream("./resources/biblioteca.dat");
 					MostrarBuffer = new ObjectInputStream(MostrarFile);

					 ArrayList<Libro> librosLeidos = new ArrayList<>();
 					} catch (IOException e) {
 					System.out.println("No se ha podido abrir el fichero");
 					System.out.println(e.getMessage());
 					return;
 					}

					// Lee el objeto guardado 
					try {
						for(Libro leerLibro : listaLibros){
							leerLibro = (Libro) MostrarBuffer.readObject();
							System.out.println("ISBN: " + leerLibro.getIsbn());
							System.out.println("Titulo: " + leerLibro.getTitulo());
							System.out.println("Autor: " + leerLibro.getAutor());
						}
					} catch (IOException e) {
						System.out.println("Error al leer del fichero");
						System.out.println(e.getMessage());
					} 
 					// Cerrar el fichero
 					try {
 					MostrarBuffer.close();
 					MostrarFile.close();
 					} catch (IOException e) {
 					System.out.println("Error al cerrar el fichero");
 					System.out.println(e.getMessage());
 					} 
					break;
				
			//ELIMINAR PELICULA(POR ISBN)
				case "3":
					//PEDIMOS EL ISBN DEL LIBRO QUE QUEREMOS ELIMINAR
					String isbnEliminar = myUtils.leerTextoPantalla("Introduce el ISBN del libro que quieres eliminar: ");

					//RECORREMOS LA LISTA Y ELIMINAMOS CUANDO COINCIDA EL ISBN
					for (int i = 0; i < listaLibros.size(); i++) {
						if(listaLibros.get(i).getIsbn().equals(isbnEliminar)){
							listaLibros.remove(i);
							System.out.println("Libro eliminado");
						}
					}
					break;

			//GUARDAR PELICULA
				case "4": 
				// Abrir fichero para escritura
 				try {
 				file = new FileOutputStream("./resources/biblioteca.dat");
 				buffer = new ObjectOutputStream(file);
 				} catch (IOException e) {
 				System.out.println("No se ha podido abrir el fichero");
 				System.out.println(e.getMessage());
 				return;
 				}

				// Guarda objeto en el fichero alumno.dat
 				try {
				buffer.writeObject(libro);
				System.out.println("El objeto se ha grabado con éxito");
				} catch (IOException e) {
				System.out.println("Error al escribir en el fichero");
				System.out.println(e.getMessage());
				}
   
				// Cerrar el fichero
				try {
				buffer.close();
				file.close();
				} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				System.out.println(e.getMessage());
				} 
					break;

			//SALIR
				case "5":
					System.out.println("Saliendo de tu biblioteca. ¡Hasta pronto!");
					break;
			
			//DEFAULT
				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
		}
		while(!opcion.equals("5"));
		entrada.close();
	}
 }

