import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Libro> listaLibros = cargarLibrosDesdeFichero();
        Scanner entrada = new Scanner(System.in);
        String opcion;
        Libro libro = null;

        do {
            // MENU PRINCIPAL
            System.out.println("\nBienvenido a la gestion de tu biblioteca" +
                    "\n1.-Crear Libro y registrarlo en la Biblioteca" + "\n2.-Mostrar Libros existentes" +
                    "\n3.-Eliminar Libro por ISBN" + "\n4.-Guardar Libros en el fichero" +
                    "\n5.-Guardar y Salir\r");
            opcion = entrada.nextLine();

            // OPCIONES DEL MENU POR SELECCION
            switch (opcion) {
                // REGISTRAR NUEVA FRANQUICIA
                case "1":
                    // CREAR LIBRO
                    System.out.println("Vamos a registrar un nuevo libro en tu biblioteca");

                    // PEDIR DATOS DEL LIBRO
                    String isbn = myUtils.leerTextoPantalla("Introduce el ISBN del libro: ");
                    String titulo = myUtils.leerTextoPantalla("Introduce el titulo del libro: ");
                    String autor = myUtils.leerTextoPantalla("Introduce el autor del libro: ");

                    // CREAR LIBRO
                    libro = new Libro(isbn, titulo, autor);
                    System.out.println("Libro creado: " + libro.toString());

                    // AÑADIR LIBRO A LA LISTA
                    listaLibros.add(libro);
                    break;

                // MOSTRAR LIBROS
                case "2":
                    if (listaLibros.isEmpty()) {
                        System.out.println("No hay libros registrados.");
                    } else {
                        System.out.println("Listado de libros:");
                        for (Libro l : listaLibros) {
                            System.out.println(l);
                        }
                    }
                    break;

                // ELIMINAR LIBRO (POR ISBN)
                case "3":
                    String isbnEliminar = myUtils.leerTextoPantalla("Introduce el ISBN del libro que quieres eliminar: ");

                    boolean eliminado = false;
                    for (int i = 0; i < listaLibros.size(); i++) {
                        if (listaLibros.get(i).getIsbn().equals(isbnEliminar)) {
                            listaLibros.remove(i);
                            eliminado = true;
                            break; // Salir del bucle tras eliminar el primer libro encontrado
                        }
                    }

                    if (eliminado) {
                        guardarLibrosEnFichero(listaLibros);
                        System.out.println("Libro eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un libro con ese ISBN.");
                    }
                    break;

                // GUARDAR LIBRO
                case "4":
                    guardarLibrosEnFichero(listaLibros);
                    break;

                // SALIR
                case "5":
                    guardarLibrosEnFichero(listaLibros);
                    System.out.println("Saliendo de tu biblioteca. ¡Hasta pronto!");
                    break;

                // DEFAULT
                default:
                    System.out.println("Seleccione una opcion valida por favor");
                    break;
            }
        } while (!opcion.equals("5"));
        entrada.close();
    }

    private static LinkedList<Libro> cargarLibrosDesdeFichero() {

        LinkedList<Libro> listaLibros = new LinkedList<>();
		
        try (FileInputStream fileIn = new FileInputStream("./resources/biblioteca.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            listaLibros = (LinkedList<Libro>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar el archivo o no existe.");
        }
        return listaLibros;
    }

    private static void guardarLibrosEnFichero(LinkedList<Libro> listaLibros) {
        try (FileOutputStream fileOut = new FileOutputStream("./resources/biblioteca.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(listaLibros);

        } catch (IOException e) {
            System.out.println("Error al guardar los libros en el archivo.");
        }
    }
}



