import java.time.LocalDate;
import java.util.Scanner;

public class Gestion {
    public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub

	//VARIABLES
        //Scanner y menu
		Scanner entrada = new Scanner(System.in);
		String opcion; //Creamos un String opcion para la seleccion del menu
        String opcion2;
        String opcion3;
        Empresa empresa = null;

        //Contadores trabajadores y creacion de personas
        int nDirector = 0;
        int nGerente = 0;
        Persona persona;
        Director director = null;
        GerenteDep gerente;
        Trabajador trabajador;
		
//PROGRAMA GESTION EMPRESA
    try{
        System.out.println("Para empezar vamos a registrar la empresa");
        String nombreEmpresa = myUtils.leerTextoPantalla("Introduce el nombre de la empresa");
        String cif = myUtils.leerTextoPantalla("Introduce el cif de la empresa");
        System.out.println("introduce la fecha de fundacion");
        LocalDate fundacion = myUtils.leerFecha();

        empresa = new Empresa(nombreEmpresa, cif, fundacion);
        empresa.comprobarcif(cif);

    }catch(ExcepcionesEmpresa e){
        System.out.println(e.getMessage());
    }

    
    if(empresa != null){
	do{
	//MENU PRINCIPAL
		entrada = new Scanner(System.in);
		System.out.println("\nBienvenido a GestionEmpresa, ¿Que deseas hacer?" +
		"\n1.-Registrar trabajador en la empresa" + "\n2.-Mostrar informacion de la empresa" +
		"\n3.-Mostrar el numero de trabajadores actuales y organigrama" + "\n4.-Mostrar informacion de un departamento" +
		"\n5.-Eliminar trabajador de la empresa" + "\n6.-Agenda Director" +
		"\n7.-Salir del programa");
		opcion = entrada.nextLine();

		//OPCIONES DEL MENU POR SELECCION
			switch (opcion) {
			//Registrar trabajador en la empresa
				case "1": 
                    System.out.println("\n1. Registrar director \n" +  "2. Registrar GerenteDep \n" + "3. Registrar Trabajador normal ");
                        opcion2 = entrada.nextLine();
                    try{
                        System.out.println("Vamos a comenzar con el registro");
                        String nombre = myUtils.leerTextoPantalla("Dime el nombre");
                        System.out.println("Introduce el cumpleaños");
                        LocalDate nacimiento = myUtils.leerFecha();
                        String dni = myUtils.leerTextoPantalla("Introduce el DNI");
                        String direccion = myUtils.leerTextoPantalla("Introduce la direccion");
                        
                        persona = new Persona(nombre, nacimiento, dni, direccion);
                        persona.comprobarDni(dni);
                    
                        switch (opcion2) {
                            case "1":
                            if(nDirector < 1){
                                int nTelefono = myUtils.leerNumeroPantalla("Para terminar introduce un numero de telefono");
                                director = new Director(nombre, nacimiento, dni, direccion, nTelefono);
                                empresa.registrarDirector(director);
                                nDirector++;
                            }else {System.out.println("Ya hay un director en la empresa");}

                                break;

                            case "2":
                            if(nGerente < 3){
                                System.out.println("Vamos a continuar con los datos del Gerente");
                                String nSS = myUtils.leerTextoPantalla("Introduce el numero de la seguridad social");
                                String email = myUtils.leerTextoPantalla("Introduce el email");
                                int salario = myUtils.leerNumeroPantalla("Introduce el salario");
                                Departamento departamento = seleccionDepartamento();
                                int telefono = myUtils.leerNumeroPantalla("Introduce el telefono");
                                
                                gerente = new GerenteDep(nombre, nacimiento, dni, direccion, nSS, email, salario, departamento, telefono);
                                empresa.registrarGerente(gerente);
                                nGerente++;

                            }else{System.out.println("Ya hay 3 gerentes en la empresa");}

                                break;

                            case "3":
                                System.out.println("Vamos a continuar con los datos del trabajador");
                                String nSS = myUtils.leerTextoPantalla("Introduce el numero de la seguridad social");
                                String email = myUtils.leerTextoPantalla("Introduce el email");
                                int salario = myUtils.leerNumeroPantalla("Introduce el salario");
                                Departamento departamento = seleccionDepartamento();
                    
                                trabajador = new Trabajador(nombre, nacimiento, dni, direccion, nSS, email, salario, departamento);
                                empresa.registrarTrabajador(trabajador);

                                break;

                            default:
					            System.out.println("Seleccione una opcion valida por favor");
					            break;
                        }
                    }catch(ExcepcionesEmpresa e){
                        System.out.println(e.getMessage());
                    }
					break;

			//Mostrar informacion de la empresa
				case "2": 
					System.out.println(empresa.toString());
					break;
				
			//Mostrar el numero de trabajadores actuales y organigrama
				case "3":
                System.out.println("Trabajadores en la empresa: ");
                System.out.println(empresa.nTrabajadores());
                System.out.println("DIRECTOR DE LA EMPRESA");
				System.out.println(empresa.infoDirector());
                System.out.println("GERENTES DE LA EMPRESA");
                System.out.println(empresa.infoGerente());
                System.out.println("TRABAJADORES NORMALES");
                System.out.println(empresa.infoTrabajadores());
					break;

			//Mostrar informacion de un departamento
				case "4": 
				Departamento deptOpcion = seleccionDepartamento();
                System.out.println(empresa.infoDepartamento(deptOpcion));
					break;

			//Eliminar trabajador de la empresa
				case "5": 
                try{
				String dni = myUtils.leerTextoPantalla("Selecciona el dni del trabajador a eliminar de la empresa");
                empresa.eliminarTrabajador(dni);
                }catch(ExcepcionesEmpresa e){
                    System.out.println(e.getMessage());
                }

				break;

			//Agenda Director
				case "6": 
                if(director != null){
			        System.out.println("\n1. Reunión" + "\n2. Fuera de la oficina" + "\n3. Convocar a toda la empresa");
                        opcion3 = entrada.nextLine();
                        
                        switch (opcion3) {
                            case "1":
                            String opcion4 = myUtils.leerTextoPantalla("¿El director esta en una reunion?" + "\n1.-Si" + "\n2.-No");
                            switch (opcion4) {
                                case "1":
                                    director.setReunido(true);                                      
                                    break;

                                case "2":
                                    director.setReunido(false);                                     
                                    break;
                                default:
                                    System.out.println("El dato introducido no es correcto");
                            }
                            if (director.isFueraOficina() == false){
                                System.out.println("El director no esta reunido");
                            }else if(director.isFueraOficina() == true){
                                System.out.println("El director esta reunido");
                            }
                                break;

                            case "2":
                                String opcion5 = myUtils.leerTextoPantalla("¿El director esta en la oficina?" + "\n1.-Si" + "\n2.-No");
                                switch (opcion5) {
                                    case "1":
                                        director.setFueraOficina(false);                                        
                                        break;

                                    case "2":
                                        director.setFueraOficina(true);                                        
                                        break;
                                    default:
                                        System.out.println("El dato introducido no es correcto");
                                }
                                if (director.isFueraOficina() == false){
                                    System.out.println("El director esta en la oficina");
                                }else if(director.isFueraOficina() == true){
                                    System.out.println("El director no esta en la oficina");
                                }
                                break;

                            case "3":
                                System.out.println(empresa.reunirEmpresa());
                                break;

                            default:
					            System.out.println("Seleccione una opcion valida por favor");
					            break;
                        }
                    }
					break;

			//SALIR
				case "7": 
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
    public static Departamento seleccionDepartamento(){
        Departamento departamento = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecciona departamento");
        System.out.println("1.-INFORMATICA\n 2.-GESTION \n3.-MARKETING");
        String opcionDept = sc.nextLine();

        switch (opcionDept) {
            case "1":
                departamento = Departamento.INFORMATICA;
                break;

            case "2":
                departamento = Departamento.GESTION;
                break;

            case "3":
                departamento = Departamento.MARKETING;
                break;

            default:
                System.out.println("Selecciona una opcion valida");
                break;
        }
        return departamento;
        
    }
}



