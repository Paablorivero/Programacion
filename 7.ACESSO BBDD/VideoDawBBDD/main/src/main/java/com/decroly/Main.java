package com.decroly;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.Alquiler;
import com.Articulo;
import com.Cliente;
import com.Pelicula;

public class Main {
    public static void main(String[] args) {
        SQLAcessVideoDaw VideoDawData = new SQLAcessVideoDaw();
        Pelicula miPelicula;
        List<Alquiler> alquileres = new LinkedList<>();
        
        //MENU
        List<String> principal = new LinkedList<>();
        principal.add("A - Mostrar todos los Articulos en el Inventario.");
        principal.add("B - Mostrar articulos disponibles.");
        principal.add("C - Buscar articulo por codigo.");
        principal.add("D - Buscar cliente por codigo");
        principal.add("E - Alquilar articulo.");
        principal.add("F - Devolver articulo.");
        principal.add("G - Añadir nuevo cliente.");
        principal.add("H - Dar de baja cliente");
        principal.add("S - SALIR");
        String Principal = "";

        do {
            Principal = myUtils.generarMenu(principal);
            System.out.println("Opcion escogida: "+Principal);
            switch (Principal) {
                
                case "A": //MOSTRAMOS todos los articulos
                    System.out.println("\n" + "Articulos en el inventario: ");
                    List<Articulo> names = VideoDawData.getArticulos();

                    for(Articulo nm : names){
                        System.out.println(nm);
                    }
                    break;

                case "B": //Mostramos articulos disponibles
                    System.out.println("Peliculas disponibles: \n");
                        List<Articulo> pelisNA = VideoDawData.getPeliculasNoAlquiladas();

                        for(Articulo nm : pelisNA){
                            System.out.println(nm);
                        }

                    System.out.println("\nVideojuegos disponibles: \n");
                        List<Articulo> videojuegossNA = VideoDawData.getVideoJuegosNA();

                        for(Articulo nm : videojuegossNA){
                            System.out.println(nm);
                        }
                    break;
                
                case "C": //Buscamos articulo por codigo
                    System.out.println("Buscar articulo por codigo");
                    int cod = myUtils.leerNumeroPantalla("Introduce el codigo del articulo");

                    List<Articulo> artCod = VideoDawData.getArticuloCodigo(cod);

                    for(Articulo nm : artCod){
                        System.out.println(nm);
                    }
                    break;
                
                case "D": //Buscamos cliente por codigo
                    System.out.println("Buscar cliente por codigo");
                    int codCliente = myUtils.leerNumeroPantalla("Introduce el codigo del cliente");

                    List<Cliente> clienteCod = VideoDawData.getClienteCod(codCliente);

                    for(Cliente c : clienteCod){
                        System.out.println(c);
                    }
                    break;

                case "E": //Alquilar articulo
                    System.out.println("Alquilar articulo");
                    int Cliente = myUtils.leerNumeroPantalla("Introduce el codigo del cliente que va a alquilar");
                    int Art = myUtils.leerNumeroPantalla("Introduce el codigo del articulo a alquilar");

                    Alquiler alquiler = new Alquiler(Cliente, Art);
                    alquileres.add(alquiler);
                    int response = VideoDawData.insertAlquiler(alquiler);
                    int estado = VideoDawData.actEstadoTrue(Art);

                    System.out.println("Se ha insertado " + response + " elementos");
                    break;

                case "F": //Devolver articulo

                    for (Alquiler a : alquileres){
                        System.out.println(a);
                    }
                    int codAlquiler = myUtils.leerNumeroPantalla("Introduce el id del alquiler");
                    Alquiler alq = alquileres.get(codAlquiler);

                    int response2 = VideoDawData.insertDevolucion(alq);
                    System.out.println("Se ha insertado " + response2 + " elementos");
                    
                    break;


                case "G"://Registrar nuevo cliente
                    System.out.println("Regsitrar nuevo cliente");
                    String dni = myUtils.leerTextoPantalla("Introduce el dni del cliente");
                    String nombre = myUtils.leerTextoPantalla("Introduce el nombre del cliente");
                    String direccion = myUtils.leerTextoPantalla("Introduce la direccion");
                    Date fNacimiento = myUtils.leerFechaSql("Introduce la fecha de cumpleaños");

                    Cliente cliente = new Cliente(dni, nombre, direccion, fNacimiento);
                    int insertCliente = VideoDawData.insertarCliente(cliente);
                    System.out.println("Se ha insertado " + insertCliente + " elementos");
                    break;
                    
                case"H"://Dar de baja cliente
                    System.out.println("Dar de baja cliente");
                    System.out.println("\n" + "Clientes registrados:");
                    List<Cliente> Clientes = VideoDawData.getClientes();

                    for(Cliente nm : Clientes){
                        System.out.println(nm);
                    }

                    int codigo = myUtils.leerNumeroPantalla("Introduce el codigo del cliente");
                    int bajaCliente = VideoDawData.bajaCliente(codigo);
                    System.out.println("Se ha insertado " + bajaCliente + " elementos");
                    break;
                    
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