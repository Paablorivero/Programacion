package com.decroly;

import java.util.LinkedList;
import java.util.List;

import com.Articulo;
import com.Pelicula;

public class Main {
    public static void main(String[] args) {
        SQLAcessVideoDaw ProductoData = new SQLAcessVideoDaw();
        Pelicula miPelicula;
        //tipo TipoProducto;
        //List<String> referencias = ProductoData.getReferencias();

        //MENUS 
        List<String> principal = new LinkedList<>();
        principal.add("A - Mostrar datos de la franquicia.");
        principal.add("B - Buscar datos en la franquicia.");
        principal.add("C - Actualizar datos de la franquicia.");
        principal.add("D - Alquilar articulo.");
        principal.add("S - SALIR");
        String Principal = "";

        List<String> menuInfo = new LinkedList<>();
        menuInfo.add("A - Mostrar todos los Articulos en el Inventario.");
        menuInfo.add("B - Mostrar todos los empleados en la franquicia.");
        menuInfo.add("C - Mostrar todos los clientes en la franquicia.");
        menuInfo.add("D - Mostrar Articulos disponibles para alquilar.");
        String seleccionInfo = "";

        List<String> menuBuscar = new LinkedList<>();
        menuBuscar.add("A - Buscar articulo por codigo.");
        menuBuscar.add("B - Buscar cliente por codigo");
        menuBuscar.add("C - Buscar empleado por codigo.");
        menuBuscar.add("D - Buscar articulo por fecha de registro.");
        menuBuscar.add("E - Buscar peliculas alquiladas de un cliente.");
        String seleccionBuscar = "";
        
        List<String> menuUpdt = new LinkedList<>();
        menuUpdt.add("A - Añadir cliente en la franquicia.");
        menuUpdt.add("B - Añadir empleado en la franquicia.");
        menuUpdt.add("C - Dar de baja un cliente.");
        menuUpdt.add("D - Dar de baja un empleado.");
        menuUpdt.add("D - Añadir un articulo a la franquicia.");
        menuUpdt.add("E - Dar de baja un articulo.");
        String seleccionUpdt = "";

        do {
            Principal = myUtils.generarMenu(principal);
            System.out.println("Opcion escogida: "+Principal);

            switch (Principal) {
                //MOSTRAMOS INFORMACION 
                case "A":
                    seleccionInfo = myUtils.generarMenu(menuInfo);
                    System.out.println("Opcion escogida: "+seleccionInfo);

                    switch (seleccionInfo) {
                        case "A":
                            System.out.println("Mostrar todos los Articulos en el Inventario.");
                            List<Articulo> peliculas = ProductoData.getPeliculas();

                            for(Articulo p : peliculas){
                                System.out.println(p);
                            }
                            break;

                        default:
                            System.out.println("Opcion no valida, por favor seleccione una opcion valida.");
                            break;
                    
                    
                    }
                    

                    break;

                //BUSCAMOS INFORMACION 
                case "B":
                    seleccionBuscar = myUtils.generarMenu(menuBuscar);
                    System.out.println("Opcion escogida: "+seleccionBuscar);

                    break;

                //ACTUALIZAMOS INFORMACION
                case "C":
                    seleccionUpdt = myUtils.generarMenu(menuUpdt);
                    System.out.println("Opcion escogida: "+seleccionUpdt);

                    break;

                //ALQUILAMOS ARTICULOS
                case "D":
                    System.out.println("Alquilar Articulo");
                    break;

                //SALIMOS DEL PROGRAMA
                case "S"://Salir
                    System.out.println("Saliendo del programa.");
                    break;

                default://Opcion por defecto
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida.");
                    break;
            }
        } while (!Principal.equals("S"));
    }

}