package com.decroly;

import java.util.LinkedList;
import java.util.List;

import com.producto;

public class Main {
    public static void main(String[] args) {

        SQLAcessProducto ProductoData = new SQLAcessProducto();
        
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
                case "A":

                System.out.println("\n" + "Productos en el inventario: ");
                    List<producto> names = ProductoData.getProductos();

                    for(producto nm : names){
                        System.out.println(nm);
                    }
        
                    break;
                case "B":
                    System.out.println("B");
                    break;
                case "C":
                    System.out.println("C");
                    break;
                case "D":
                    System.out.println("D");
                    break;
                case "E":
                    System.out.println("E");
                    break;
                case "F":
                    System.out.println("F");
                    break;
                case "G":
                    System.out.println("G");
                    break;
                case "H":
                    System.out.println("H");
                    break;
                case "S":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida.");
                    break;
            }
        } while (!opcion.equals("S"));      
    }
}