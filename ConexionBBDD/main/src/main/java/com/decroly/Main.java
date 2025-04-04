package com.decroly;

import java.util.LinkedList;
import java.util.List;

import com.producto;
import com.tipo;

public class Main {
    public static void main(String[] args) {

        SQLAcessProducto ProductoData = new SQLAcessProducto();
        producto miProducto;
        tipo TipoProducto;
        List<String> referencias = ProductoData.getReferencias();

        List<String> opciones1 = new LinkedList<>();
        opciones1.add("A - Mostrar todos los Productos en el Inventario.");
        opciones1.add("B - Buscar producto por referencia.");
        opciones1.add("C - Buscar productos por tipo.");
        opciones1.add("D - Buscar producto por cantidad.");
        opciones1.add("E - Insertar un nuevo producto");
        opciones1.add("F - Eliminar Producto por referencia.");
        opciones1.add("G - Actualizar producto");
        opciones1.add("H - Insertar un nuevo tipo de producto.");
        opciones1.add("S - SALIR");
        String opcion = "";

        do {
            opcion = myUtils.generarMenu(opciones1);
            System.out.println("Opcion escogida: "+opcion);

            switch (opcion) {
                //MOSTRAMOS INFORMACION DE PRODUCTOS POR ELEMENTOS
                case "A"://Mostrar todos los productos
                    System.out.println("\n" + "Productos en el inventario: ");
                    List<producto> names = ProductoData.getProductos();

                    for(producto nm : names){
                        System.out.println(nm);
                    }
                    break;

                case "B"://Buscar producto por referencia
                    System.out.println("Buscar producto por referencia");
                    String selReferencia = myUtils.leerTextoPantalla("Introduce la referencia del producto:");

                    List<producto> namesReferencia = ProductoData.getProductosPorReferencia(selReferencia);

                    for(producto nr : namesReferencia){
                        System.out.println(nr);
                    }
                    break;

                case "C"://Buscar productos por tipo
                    System.out.println("Buscar productos por tipo");
                    String selTipo = myUtils.leerTextoPantalla("Introduce el tipo del producto:");

                    List<producto> namesTipo = ProductoData.getProductosPorTipo(selTipo);

                    for(producto nt : namesTipo){
                        System.out.println(nt);
                    }
                    break;

                case "D"://Buscar producto por cantidad
                    System.out.println("Buscar producto por cantidad");
                    int selCantidad = myUtils.leerNumeroPantalla("Introduce la cantidad del producto:");

                    List<producto> namesCantidad = ProductoData.getProductosPorCantidad(selCantidad);

                    for(producto nc : namesCantidad){
                        System.out.println(nc);
                    }
                    break;

                //MODIFICAMOS LOS DATOS DE LA BBDD
                case "E"://Insertar un nuevo producto
                    System.out.println("Insertar un nuevo producto");
                    int id = myUtils.leerNumeroPantalla("Introduce el id del producto:");
                    String referencia = myUtils.leerTextoPantalla("Introduce la referencia del producto:");

                    if (referencias.contains(referencia)) {//Comprobamos si la referencia ya existe
                        System.out.println("La referencia ya existe. No se puede insertar el producto.");
                        break;
                    }

                    String nombre = myUtils.leerTextoPantalla("Introduce el nombre del producto:");
                    String descripcion = myUtils.leerTextoPantalla("Introduce la descripcion del producto:");
                    int tipo = myUtils.leerNumeroPantalla("Introduce el tipo del producto:");
                    int cantidad = myUtils.leerNumeroPantalla("Introduce la cantidad del producto:");
                    double precio = myUtils.leerNumeroPantalla("Introduce el precio del producto:");
                    int descuento = myUtils.leerNumeroPantalla("Introduce el descuento del producto:");
                    int iva = myUtils.leerNumeroPantalla("Introduce el IVA del producto:");
                    boolean aplicarDto = myUtils.leerTextoPantalla("¿Aplicar descuento? (true/false):").equalsIgnoreCase("true");

                    //Creamos el producto
                    miProducto = new producto(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                    
                    int response = ProductoData.insertProducto(miProducto);
                    System.out.println("Se han insertado " + response + " elementos");
                    break;

                case "F"://Eliminar Producto por referencia
                    System.out.println("F");
                    break;

                case "G"://Actualizar producto
                    System.out.println("Seleccionar producto a actualizar");
                    List<producto> namesAct = ProductoData.getProductos();

                    for(producto nm : namesAct){
                        System.out.println(nm);
                    }

                    String referenciaAct = myUtils.leerTextoPantalla("Introduce la referencia del producto:");

                    if (referencias.contains(referenciaAct)) {//Comprobamos si la referencia ya existe
                        System.out.println("La referencia ya existe. No se puede insertar el producto.");
                        break;
                    }
                    
                    String descripcionAct = myUtils.leerTextoPantalla("Introduce la descripcion del producto:");
                    int cantidadAct = myUtils.leerNumeroPantalla("Introduce la cantidad del producto:");
                    double precioAct = myUtils.leerNumeroPantalla("Introduce el precio del producto:");
                    int descuentoAct = myUtils.leerNumeroPantalla("Introduce el descuento del producto:");
                    boolean aplicarDtoAct = myUtils.leerTextoPantalla("¿Aplicar descuento? (true/false):").equalsIgnoreCase("true");

                    //Creamos el producto
                    
                    break;

                case "H"://Insertar nuevo tipo de producto
                    System.out.println("Insertar un nuevo tipo de producto");
                    int idTipo = myUtils.leerNumeroPantalla("Introduce el id del tipo de producto:");
                    String nombreTipo = myUtils.leerTextoPantalla("Introduce el nombre del tipo de producto:");

                    //Creamos el tipo de producto
                    TipoProducto = new tipo(idTipo, nombreTipo);
                    int responseTipo = ProductoData.insertTipo(TipoProducto);
                    System.out.println("Se han insertado " + responseTipo + " elementos");

                    //Mostramos los tipos de productos
                    System.out.println("\n" + "Tipos de productos en la base de datos: ");
                    List<tipo> tipos = ProductoData.getTipos();

                    for(tipo tp : tipos){
                        System.out.println(tp);
                    }
                    break;

                //SALIMOS DEL PROGRAMA
                case "S"://Salir
                    System.out.println("Saliendo del programa.");
                    break;

                default://Opcion por defecto
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida.");
                    break;
            }
        } while (!opcion.equals("S"));      
    }
}