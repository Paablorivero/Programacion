import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);//Creamos el scanner

        //Creamos un ArrayList para guardar los productos y un iterator para mostrarlos
        LinkedList<Producto> listaProductos = new LinkedList<Producto>();
        File file = new File("./resources/Almacen.dat");
        Producto producto = null;
        System.out.println("Bienvenido al programa de gestion de productos");

        String opcion;
	do{
		entrada = new Scanner(System.in);
		System.out.println("\nBienvenido, ¿Que deseas hacer?");
		System.out.println("1.-CREAR PRODUCTO");
		System.out.println("2.-MOSTRAR PRODUCTOS EXISTENTES");
		System.out.println("3.-ELIMINAR PRODUCTO POR CODIGO");
		System.out.println("4.-GUARDAR PRODUCTO EN EL FICHERO");
		System.out.println("5.-SALIR");

		opcion = entrada.nextLine();

		//PROGRAMAMOS LAS DIFERENTES OPCIONES DEL MENU
		
			switch (opcion) {
				case "1":
                    System.out.println("Vamos a crear un producto");

                    String nombre = myUtils.leerTextoPantalla("Escribe el nombre del producto");
                    int cantidad = myUtils.leerNumeroPantalla("Introduce la cantidad del producto");
                    Double precio = myUtils.leerDoublePantalla("Introduce el precio del producto");

                    producto = new Producto(nombre, cantidad, precio);
                    listaProductos.add(producto);

                    System.out.println("Producto añadido correctamente" + producto.toString());
					break;

				case "2":
					System.out.println("LISTA DE PRODUCTOS: \n");
        			for (Producto p : listaProductos) {
            			System.out.println(p.toString());
        			}
					break;

				case "3":
                    System.out.println("Introduce el codigo del producto a eliminar");
                    int codigo = entrada.nextInt();

					Producto productoElim = null;

					for (Producto ll : listaProductos) {
						if (ll.getCodigo() == codigo) {
							productoElim = ll;
						}
					}
					listaProductos.remove(productoElim);
					System.out.println("Producto eliminado de la lista");
					break;

				case "4":
					try (FileWriter fw = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fw)) {
                 
                	for (Producto p : listaProductos) {
                    	String linea = p.getNombre() + "," + p.getCantidad() + "," + p.getPrecio();
                    	writer.write(linea);
                    	writer.newLine();
                	}
                
                	System.out.println("Productos guardados correctamente en " + file.getPath());
            
        			} catch (IOException e) {
            			System.out.println("Error al guardar los productos: " + e.getMessage());
        			}
					break;

				case "5":
					System.out.println("Saliendo del programa, hasta pronto");
					break;

				default:
					System.out.println("Seleccione una opcion valida por favor");
					break;
			}
        }while(!opcion.equals("5"));

        entrada.close();
    }
}

