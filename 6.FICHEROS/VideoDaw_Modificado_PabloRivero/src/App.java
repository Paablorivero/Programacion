import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App{

	public static void main(String[] args) throws ExcepcionesVideodaw {
		// TODO Auto-generated method stub

	//VARIABLES
		Scanner entrada = new Scanner(System.in);
		
		VideoDaw miFranquicia = null; //Variable para el videoclub
		Pelicula nuevaPelicula = null; //Variable para las peliculas
		Videojuego nuevoVideojuego = null;
		Cliente nuevoCliente = null; //Variable para los clientes

	//PATRONES DE DATOS
		final String patronCif = "[A-Z]{1}[0-9]{8}"; //Patron para el CIF
		final String patronDNI = "[0-9]{8}[A-Z]{1}"; //Patron para el DNI

	//MENU DE OPCIONES
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

//PROGRAMA GESTION VIDEODAW
	do{
	//MENU PRINCIPAL
		
		opcion = myUtils.generarMenu(opciones1);
		//OPCIONES DEL MENU POR SELECCION
			switch (opcion) {
			//REGISTRAR NUEVA FRANQUICIA
				case "1": 
				System.out.println("\nCREAR NUEVA FRANQUICIA");

				//Recogemos datos
				String cif = myUtils.comprobarPatronRepetidamente(patronCif, "\nPara empezar escribe el cif de la empresa");
				String direccion = myUtils.leerTextoPantalla("\nAhora añade la direccion");

				//Creamos la franquicia
				miFranquicia = new VideoDaw(cif, direccion);
				System.out.println("\nFRANQUICIA REGISTRADA, ¡FELICIDADES!\n" + miFranquicia.mostrarInfoVideoClub());
					break;

			//REGISTRAR NUEVA PELICULA
				case "2": 
				if(miFranquicia != null){
					System.out.println("\nREGISTRAR NUEVO ARTICULO");	

					System.out.println("¿Vas a registrar una Pelicula o un Videojuego" + "\n 1.-Pelicula \n 2.-Videojuego");
					String tipoRegistro = entrada.nextLine();

					switch (tipoRegistro){
						case "1" :
					//Leemos datos
					String titulo = myUtils.leerTextoPantalla("\nEscribe el titulo de la pelicula");

					//Leemos el genero y creamos la pelicula
					for(int i = 0; i < 1; i++){
						System.out.println("\n¿Cual es el genero de la pelicula? " + "\n1.-ACCION" + 
						"\n2.-COMEDIA" + "\n3.-DRAMA" + "\n4.-FANTASIA" + "\n5.-TERROR " + "\n6.-DOCUMENTALES");
						
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

						//evitamos seleccionar un numero equivocado
						else if(nGenero > 6 || nGenero < 1){
							System.out.println("ERROR. El dato introducido es invalido");
							i -= 1;
						}
					}

					//Comprobamos que se haya registrado y mostramos pelicula
					if (nuevaPelicula != null){
						System.out.println("Pelicula registrada correctamente");
						System.out.println(nuevaPelicula.toString());
						miFranquicia.registrarArticulo(nuevaPelicula);
					}
					else{
					System.out.println("Antes de añadir una pelicula, registre una franquicia por favor.");
					}				
							break;
						case "2" :
						System.out.println("Registrar Videojuego");
						String tituloVideoJuego = myUtils.leerTextoPantalla("\nEscribe el titulo del Videojuego");

					//Leemos el genero y creamos la pelicula
					for(int i = 0; i < 1; i++){
						System.out.println("\n¿Cual es el genero de la pelicula? " + "\n1.-SANDBOX" + 
						"\n2.-ESTRATEGIA" + "\n3.-SHOOTER" + "\n4.-ROL" + "\n5.-SIMULACION " + "\n6.-PUZZLE");
						
						int nGenero = entrada.nextInt();

						if (nGenero == 1){
							nuevoVideojuego = new Videojuego(tituloVideoJuego, GenerosVideojuego.SANDBOX);	
						}
						if (nGenero == 2){
							nuevoVideojuego = new Videojuego(tituloVideoJuego, GenerosVideojuego.ESTRATEGIA);
						}
						if (nGenero == 3){
							nuevoVideojuego = new Videojuego(tituloVideoJuego, GenerosVideojuego.SHOOTER);
						}
						if (nGenero == 4){
							nuevoVideojuego = new Videojuego(tituloVideoJuego, GenerosVideojuego.ROL);
						}
						if (nGenero == 5){
							nuevoVideojuego = new Videojuego(tituloVideoJuego, GenerosVideojuego.SIMULACION);
						}
						if (nGenero == 6){
							nuevoVideojuego = new Videojuego(tituloVideoJuego, GenerosVideojuego.PUZZLE);
						}

						//evitamos seleccionar un numero equivocado
						else if(nGenero > 6 || nGenero < 1){
							System.out.println("ERROR. El dato introducido es invalido");
							i -= 1;
						}
					}

					//Comprobamos que se haya registrado y mostramos pelicula
					if (nuevoVideojuego != null){
						System.out.println("Videojuego registrado correctamente");
						System.out.println(nuevoVideojuego.toString());
						miFranquicia.registrarArticulo(nuevoVideojuego);
					}
					else{
					System.out.println("Antes de añadir un videojuego, registre una franquicia por favor.");
					}				
							break;

						default:
						System.out.println("Seleccione una opcion valida por favor");
							break;
					}

					break;
				}
			//REGISTRAR CLIENTE
				case "3":
				if (miFranquicia != null){
					entrada = new Scanner(System.in);
					System.out.println("\nREGISTRAR NUEVO CLIENTE");	

					//Leemos los datos
					String dni = myUtils.comprobarPatronRepetidamente(patronDNI, "\nIntroduce el DNI");
					String nombre = myUtils.leerTextoPantalla("\nEscribe el nombre");
					String direccionCliente = myUtils.leerTextoPantalla("\nEscribe una direccion");
					LocalDate fechaNacimiento = myUtils.leerFecha();

					//Comrpobamos que sea mayor de 18 años
					LocalDate hoy = LocalDate.now();
					Period Años = Period.between(fechaNacimiento, hoy);
					if (Años.getYears() > 18){

						//Registramos el cliente
						nuevoCliente = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);

						//Comprobamos que el dni no coincide
						if (miFranquicia.registrarCliente(nuevoCliente) == true){
							//Mostramos el cliente
							System.out.println("Cliente registrado con exito");
							System.out.println(nuevoCliente.toString());
						}
						else{
							System.out.println("cliente ya registrado");
						}
					}
					else{
						System.out.println("El cliente debe ser mayor de edad");
					}
				}
				else {
					System.out.println("Antes de añadir un cliente, registre una franquicia por favor.");
				}
					break;

			//ALQUILAR PELICULA
				case "4": 
				entrada = new Scanner(System.in);

				//Comprobamos que se haya una franquicia con clientes y peliculas
				if(miFranquicia != null && nuevaPelicula != null && nuevoCliente != null){

					//Seleccionamos un cliente
					System.out.println("Quien va a alquilar la pelicula");
					System.out.println(miFranquicia.mostrarClientesRegistrados());	 
					int cliente = entrada.nextInt();
				
					//Seleccionamos una pelicula
					System.out.println("¿Que pelicula quieres alquilar?");
					System.out.println(miFranquicia.mostrarArticulosDisponibles());
					int pelicula = entrada.nextInt();

						//alquilamos la pelicula
						miFranquicia.alquilar(miFranquicia.obtenerClientePorPosicion(cliente), miFranquicia.obtenerArticuloPorPosicion(pelicula));
						miFranquicia.obtenerClientePorPosicion(cliente).addArticulo
						(miFranquicia.obtenerArticuloPorPosicion(pelicula));

						//Mostramos las peliculas del cliente
						System.out.println(miFranquicia.obtenerClientePorPosicion(cliente).mostrarPeliculas());	
					}else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas en el videoclub.");
					}
				
					break;

			//DEVOLVER PELICULA
				case "5": 

				//Comprobamos que haya registrada una franquicia con clientes y peliculas
				if( miFranquicia != null && nuevaPelicula != null && nuevoCliente != null){

					//Seleccionamos cliente
					System.out.println("Quien va a devolver la pelicula");
					System.out.println(miFranquicia.mostrarClientesRegistrados());	 
					int bajacliente = entrada.nextInt();

					//Comprobamos que tenga peliculas alquiladas
					if(miFranquicia.obtenerClientePorPosicion(bajacliente).getNalquiladas() > 0){

						//Seleccionamos la pelicula
						System.out.println("Selecciona pelicula a devolver");
						System.out.println(miFranquicia.obtenerClientePorPosicion(bajacliente).mostrarPeliculas());
						int bajapelicula = entrada.nextInt();

						//Devolvemos la pelicula
						miFranquicia.devolver(miFranquicia.obtenerClientePorPosicion(bajacliente),miFranquicia.obtenerArticuloPorPosicion(bajapelicula));
						miFranquicia.obtenerClientePorPosicion(bajacliente).elimArticulo(miFranquicia.obtenerArticuloPorPosicion(bajapelicula));

						//Mostramos el registro de peliculas del cliente
						System.out.println("Registro movimientos: ");
						miFranquicia.obtenerClientePorPosicion(bajacliente).mostrarPeliculas();
					} else{
						System.out.println("No hay peliculas alquiladas, alquila alguna pelicula.");
						}	
				} else {
					System.out.println("Para alquilar la pelicula, registra primero Peliculas en el videoclub.");
					}
				break;

			//DAR DE BAJA CLIENTE
				case "6": 
				entrada = new Scanner(System.in);

				//Comprobamos que haya franquicia 
				if(miFranquicia != null ){

				//Seleccionamos cliente a dar de baja
				System.out.println(miFranquicia.mostrarClientesRegistrados());
				System.out.println("Introduce la posicion del cliente a dar de baja");
		    	int numSocio = entrada.nextInt();

				//Damos de baja al cliente seleccionado
				miFranquicia.darBajaCliente(miFranquicia.obtenerClientePorPosicion(numSocio));
				} else{
					System.out.println("No hay clientes registrados");
				}
					break;

			//DAR DE BAJA PELICULA
				case "7": 
				entrada = new Scanner(System.in);

				//Comprobamos que haya franquicuia
				if(miFranquicia != null){

				//Seleccionamos pelicula a dar de baja
				System.out.println("Introduce la posicion del articulo a dar de baja");
				System.out.println(miFranquicia.mostrarArticulosRegistrados());
				int cod = entrada.nextInt();
				
				//Damos de baja la pelicula
				miFranquicia.darBajaArticulo(cod);
				} else {
					System.out.println("No hay peliculas registradas");
				}
					break;

			//SALIR
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