import java.time.LocalDate;
import java.util.Scanner;

public class gestion {
    public static void main(String[] args) throws Exception {
        
        //VARIABLES
        Scanner entrada = new Scanner(System.in);
        String opcion; //Seleccion menu
        trabajador [] personas = new trabajador[100];
        int nPersonas = 0;

        empresa nuevaEmpresa;
        trabajador nuevaPersona;
        trabajador nuevoTrabajador;
        //PATRONES
        final String patronCif = "[A-Z]{1}[0-9]{10}"; //Patron para el CIF
        final String patronDNI = "[0-9]{8}[A-Z]{1}"; //Patron para el DNI
        final String patronSS = "[0-9]{10}";

        //COMENZAMOS EL PROGRAMA
            //Registramos los datos de la empresa
        System.out.println("Para iniciar el programa primero debemos registrar una empresa");
        String nombre = myUtils.leerTextoPantalla("Escribe el nombre de la empresa");

        String cif = 
        myUtils.comprobarPatronRepetidamente(patronCif, "\nahora escribe el cif de la empresa");

        LocalDate fechaFundacion = 
        myUtils.leerFecha("introduce la fecha de fundacion en formato dd/MM/AAAA");

        System.out.println("Por ultimo introduce el numero maximo de trabajadores");
        int nTrabajadores = entrada.nextInt();

            //Registramos la empresa
        nuevaEmpresa = new empresa(nombre, cif, fechaFundacion, nTrabajadores);
        nuevaEmpresa.valorMaximoTrabajadores(nTrabajadores);

            //Mostramos la informacion de la empresa
        System.out.println("Empresa registrada correctamente");
        String infoEmpresa = nuevaEmpresa.mostrarInfoEmpresa();
        System.out.println(infoEmpresa);

        do{
        entrada = new Scanner(System.in);
		System.out.println("\nBienvenido al programa de gestion de empresas, selecciona la opcion que desees hacer.");
		System.out.println("1.-Crear persona");
		System.out.println("2.-Registrar trabajador en empresa");
		System.out.println("3.-Mostrar información general de la empresa");
		System.out.println("4.-Mostrar el número de trabajadores actuales");
		System.out.println("5.-Mostrar información de todos los trabajadores");
		System.out.println("6.-Eliminar trabajador de la empresa");
		System.out.println("7.-Eliminar persona del programa.");
		System.out.println("8.-SALIR");
		opcion = entrada.nextLine();

        switch (opcion) {
            case "1":
                    //Recogemos los datos de la persona
                System.out.println("Vamos a crear una nueva persona");
                String nombrePersona = myUtils.leerTextoPantalla("Para empezar dime un nombre");

                LocalDate fechaNacimiento = 
                myUtils.leerFecha("introduce la fecha de nacimiento en formato dd/MM/AAAA");

                String dni = 
                myUtils.comprobarPatronRepetidamente(patronDNI, "introduce el dni");

                String direccion = myUtils.leerTextoPantalla("introduce una direccion");

                    //Registramos una persona nueva
                nuevaPersona = new trabajador(nombrePersona, fechaNacimiento, dni, direccion);
                System.out.println("Persona registrada con exito");
                System.out.println(nuevaPersona.InfoTrabajador());
                
                personas[nPersonas] = nuevaPersona;
                nPersonas++;
                break;

            case "2":
                System.out.println("Registrar trabajador");
                System.out.println("¿Esta registrado ya en el sistema aunque no trabaje?");
                System.out.println("1-SI");
                System.out.println("2.-NO");
                String registro = entrada.nextLine();
                
                switch (registro) {
                    case "1":
                        String mostrarPersonas = "";
                        for(int i = 0; i < nPersonas; i++){
                            mostrarPersonas += (i + "-" + personas[i].getDni());
                        }
                        System.out.println(mostrarPersonas);
                        System.out.println("Seleccione la posicion de su dni");
                        int num = entrada.nextInt();
                        System.out.println("Dime tu numero de la Seguridad Social (10 digitos)");
                        int numSS = entrada.nextInt();
                        nuevoTrabajador = new trabajador(personas[num].getNombre(), personas[num].getNacimiento(),
                        personas[num].getDni(), personas[num].getDireccion(), numSS);
                        personas[num] = null;
                        nPersonas--;
                        if(nuevaEmpresa.nuevoTrabajador(nuevoTrabajador) == true){
                            System.out.println("Persona registrada con exito");
                            System.out.println(nuevoTrabajador.InfoTrabajador());
                            }
                            else{
                                System.out.println("Cliente ya registrado");
                            }
                        break;
            
                    case "2":
                            //Recogemos los datos del trabajador
                        String nTrabajador = myUtils.leerTextoPantalla("Para empezar dime un nombre");

                        LocalDate fNacimientoTrabajador = 
                        myUtils.leerFecha("introduce la fecha de nacimiento en formato dd/MM/AAAA");

                        String dniTrabajador = 
                        myUtils.comprobarPatronRepetidamente(patronDNI, "introduce el dni");

                        String dirTrabajador = myUtils.leerTextoPantalla("introduce una direccion");

                        System.out.println("Introduce el numero de la Seguridad Social(10 digitos)");
                        int nSS = entrada.nextInt();

                            //Registramos un nuevo trabajador
                        nuevoTrabajador = new trabajador(nTrabajador, fNacimientoTrabajador, dniTrabajador, dirTrabajador, nSS);
                        if(nuevaEmpresa.nuevoTrabajador(nuevoTrabajador) == true){
                        System.out.println("Persona registrada con exito");
                        System.out.println(nuevoTrabajador.InfoTrabajador());
                        }
                        else{
                            System.out.println("Cliente ya registrado");
                        }
                            break;

                    default:
                    System.out.println("Seleccion no valida");
                            break;
                    }
                break;
            case "3":
            System.out.println(nuevaEmpresa.mostrarInfoEmpresa());
                break;

            case "4":
            if(nuevaEmpresa.getNtrabajadores() > 0){
            int numTrabajadores = nuevaEmpresa.getNtrabajadores();
            System.out.println("La empresa actualmente tiene: " + numTrabajadores + " trabajadores.");
            }else{
                System.out.println("No hay trabajadores en la empresa");
            }
                break;

            case "5":
            System.out.println(nuevaEmpresa.mostrarInfoTrabajadores());
             break;

            case "6":
            if(nuevaEmpresa.getTrabajadores()!= null){
                System.out.println(nuevaEmpresa.mostrarInfoTrabajadores());
                System.out.println("Selecciona la posicion del trabajador a eliminar");
                int eliminarTrabajador = entrada.nextInt();
                nuevaEmpresa.eliminarTrabajador(eliminarTrabajador);
                System.out.println("Trabajador eliminado");
            }
            else{
                System.out.println("No hay trabajadores registrados");
            }
                break;

            case "7":
                if(personas !=null){
                    String mostrarPersonas = "";
                    for(int i = 0; i < nPersonas; i++){
                        mostrarPersonas += (i + "-" + personas[i].getDni());
                    }
                    System.out.println(mostrarPersonas);
                    System.out.println("Que persona quieres eliminar");
                    int elimPersona = entrada.nextInt();

                    personas[elimPersona] = null;
                    for(int i = elimPersona + 1; i < nPersonas; i++){
                        personas [i-1] = personas[i];
                    }

                    personas[nPersonas - 1] = null;
                    nPersonas--;
                    System.out.println("Persona eliminada");
                }
                else{System.out.println("No hay personas registradas");
                }
                break;

            case "8":
            System.out.println("Saliendo de la aplicaion. ¡Hasta pronto!");
                break;

            default:
            System.out.println("Seleccione una opcion valida por favor");
                break;
        }
        }while(!opcion.equals("8"));
        entrada.close();
    }
}
