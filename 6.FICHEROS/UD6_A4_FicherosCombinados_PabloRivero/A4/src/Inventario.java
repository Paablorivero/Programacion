import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario{
    public static void main(String[] args) throws Exception {
        
        LinkedList<Producto> listaProductos = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String opcion;
        boolean salir = false;
        
        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Mostrar Productos en el Inventario");
            System.out.println("2. Eliminar Producto por referencia");
            System.out.println("3. Guardar y Salir ");
            System.out.println("4. Registrar producto en el Inventario");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextLine();
                
            switch (opcion) {

                //Mostrar Productos en el Inventario
                case "1":

                    //Leer productos del fichero CSV
                    try (FileReader file = new FileReader("A4\\Recursos\\productos.csv");
                    BufferedReader buffer = new BufferedReader(file)) {

                    String linea = buffer.readLine();
                    while (linea != null) {
                        String[] elementos = linea.split("/"); 

                        Producto p = new Producto(elementos[0], elementos[1], elementos[2]);
                        listaProductos.add(p);
                        linea = buffer.readLine();
                    }
                    System.out.println(listaProductos);

                    } catch (IOException e) {
                        System.out.println("Error al leer el fichero");
                        System.out.println(e.getMessage());
                    } 

                    //Leer productos del fichero almacen.dat
                    try (FileInputStream file = new FileInputStream("A4\\Recursos\\almacen.dat");
                    DataInputStream buffer = new DataInputStream(file)){ 
                        LinkedList<Producto> producto = new LinkedList<>();
                        boolean eof = false;

                        while (!eof) {
                        int i = 0;

                        try {
                            while (true) {
                            String referencia = buffer.readUTF();
                            String descripcion = buffer.readUTF();
                            String tipo = buffer.readUTF();
                            int cantidad = buffer.readInt();
                            double precio = buffer.readDouble();
                            int descuento = buffer.readInt();
                            int IVA = buffer.readInt();
                            boolean aplicarDto = buffer.readBoolean();

                            Producto p = new Producto(referencia, descripcion, tipo, cantidad, precio, descuento, IVA, aplicarDto);
                            producto.add(p);

                            producto
                            
                            i++;
                                }

                            } catch (EOFException e) {
                                eof = true;
                            }
                        }
                    }catch (IOException e) {
                        System.out.println("Ha ocurrido un error al abrir el fichero: ");
                        System.out.println(e.getMessage());
                        return;
                        }
                    break;

                    //Eliminar Producto por referencia
                    case "2":
                        System.out.print("Ingrese la referencia del producto a eliminar: ");
                        String referencia = sc.nextLine();
                        
                        boolean encontrado = false;
                        Producto productoAEliminar = null;
                        
                        for (Producto p : listaProductos) {
                            if (p.getReferencia().equals(referencia)) {
                                encontrado = true;
                                productoAEliminar = p;
                                break;
                            }
                        }
                        
                        if (encontrado) {
                            listaProductos.remove(productoAEliminar);
                            System.out.println("Producto eliminado correctamente.");
                        }
                        break;

                    //Guardar y Salir
                    case "3":
                        try {
                            FileOutputStream fichero = new FileOutputStream("./src/Recursos/" + "inventario.dat");
                            DataOutputStream escritor = new DataOutputStream(fichero);
                            
                            System.out.println("Guardando " + listaProductos.size() + " productos...");
                            
                            for (Producto p : listaProductos) {
                                escritor.writeUTF(p.getReferencia());
                                escritor.writeUTF(p.getDescripcion());
                                escritor.writeUTF(p.getTipo());
                                escritor.writeInt(p.getCantidad());
                                escritor.writeDouble(p.getPrecio());
                                escritor.writeInt(p.getDescuento());
                                escritor.writeInt(p.getIVA());
                                escritor.writeBoolean(p.isAplicarDto());
                            }
                            
                            escritor.close();
                            fichero.close();
                            
                            System.out.println("Datos guardados correctamente en " + "inventario.dat");
                            System.out.println("Programa finalizado.");
                            
                        } catch (IOException e) {
                            System.out.println("Error al guardar los datos: ");
                        } catch (Exception e) {
                            System.out.println("Error inesperado al guardar los datos: ");
                            e.printStackTrace();
                        }
                        salir = true;
                        break;

                    //Registrar producto en el Inventario
                    case "4":
                    sc = new Scanner(System.in);
                    try {
                        System.out.println("\n=== REGISTRO DE NUEVO PRODUCTO ===");
                        
                        String referenciaP = myUtils.leerTextoPantalla("Introduce la referencia");
                        
                        // Comprobar si la referencia ya existe
                        for (Producto p : listaProductos) {
                            if (p.getReferencia().equals(referenciaP)) {
                                
                            }
                        }

                        String descripcion = myUtils.leerTextoPantalla("Introduce la descripcion");
                        String tipo = myUtils.leerTextoPantalla("Introduce el tipo");
                        int cantidad = myUtils.leerNumeroPantalla("Introduce la cantidad");
                        double precio = myUtils.leerNumeroDecimalPantalla("Introduce el precio");
                        int descuento = myUtils.leerNumeroPantalla("Introduce el descuento");
                        int iva = myUtils.leerNumeroPantalla("Introduce el iva");
                        
                        System.out.print("¿Hay que aplicar descuento? (true/false): ");
                        boolean aplicarDto = Boolean.parseBoolean(sc.nextLine());
                        
                        Producto nuevoProducto = new Producto(referenciaP, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                        listaProductos.add(nuevoProducto);
                        
                        System.out.println("Producto registrado correctamente.");
                        break;
                        
                    }catch (Exception e) {
                        System.out.println("Error al registrar el producto: ");
                    }
                    break;

                    //Opcion por defecto
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
                        break;

                }

            
        }while(!opcion.equals("3"));
        
        sc.close();
    }
}