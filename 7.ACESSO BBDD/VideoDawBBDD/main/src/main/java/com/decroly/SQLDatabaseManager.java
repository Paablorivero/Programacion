package com.decroly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseManager {

    private static  String DRIVER;
    private static String URL;
    private static String SCHEMA;
    private static String USUARIO;
    private static String CLAVE;

    static {
        try (InputStream inputStream = SQLDatabaseManager.class.getClassLoader().getResourceAsStream("conexionBBDD.dat");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            DRIVER = br.readLine();
            URL = br.readLine();
            SCHEMA = br.readLine();
            USUARIO = br.readLine();
            CLAVE = br.readLine();

        } catch (IOException | NullPointerException e) {
            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de acceso al driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }

        return connection;
    }
}


public List<Articulo> getArticulos(){//METODO PARA MOSTRAR TODOS LOS ARTICULOS
    List<Articulo> Articulos = new LinkedList<>();

    String getArticulos =   "SELECT a.cod, a.titulo, a.descripcion," + 
    " a.fecha_registro, a.tipo, a.alquilada FROM Articulo a WHERE a.fecha_baja = '9999-01-01';";

    try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
    ResultSet dataSet = statement.executeQuery(getArticulos);) {
        while(dataSet.next()){
            int cod = dataSet.getInt(1);
            String titulo = dataSet.getNString(2);
            String descripcion = dataSet.getNString(3);
            Date fechaRegistro = dataSet.getDate(4);
            String tipo = dataSet.getNString(5);
            boolean isAlquilada = dataSet.getBoolean(6);
            

            Articulo p1 =  new Articulo(cod, titulo, descripcion, fechaRegistro, tipo, isAlquilada);
            Articulos.add(p1);
        }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return Articulos;
}

public List<Articulo> getPeliculasNoAlquiladas(){//METODO PARA MOSTRAR PELICULAS DISPONIBLES
    List<Articulo> PeliculasNA = new LinkedList<>();

    String getPeliculasNA =   "SELECT a.cod, a.titulo, a.descripcion, a.tipo " + 
                    "FROM Articulo a JOIN Pelicula p ON a.cod = p.cod " + 
                    "WHERE a.fecha_baja = '9999-01-01' AND p.alquilada = FALSE;";

    try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
    ResultSet dataSet = statement.executeQuery(getPeliculasNA);) {
        while(dataSet.next()){
            int cod = dataSet.getInt(1);
            String titulo = dataSet.getNString(2);
            String descripcion = dataSet.getNString(3);
            String tipo = dataSet.getNString(4);

           Articulo p1 =  new Articulo(cod, titulo, descripcion, tipo);
           PeliculasNA.add(p1);
        }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return PeliculasNA;
}

public List<Articulo> getVideoJuegosNA(){//METODO PARA MOSTRAR VIDEOJUEGOS DISPONIBLES
    List<Articulo> VideojuegosNA = new LinkedList<>();

    String VideoJuegosNA =  "SELECT a.cod, a.titulo, a.descripcion, a.tipo " + 
                    "FROM Articulo a JOIN Videojuego v ON a.cod = v.cod " + 
                    "WHERE a.fecha_baja = '9999-01-01' AND v.alquilado = FALSE;";

    try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
    ResultSet dataSet = statement.executeQuery(VideoJuegosNA);) {
        while(dataSet.next()){
            int cod = dataSet.getInt(1);
            String titulo = dataSet.getNString(2);
            String descripcion = dataSet.getNString(3);
            String tipo = dataSet.getNString(4);

           Articulo p1 =  new Articulo(cod, titulo, descripcion, tipo);
           VideojuegosNA.add(p1);
        }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return VideojuegosNA;
}

public List<Articulo> getArticuloCodigo(int selCod) { 
    List<Articulo> ArticuloCod = new LinkedList<>();

    String getArticuloCod = "SELECT a.cod, a.titulo, a.descripcion, a.fecha_registro, a.tipo, a.alquilada " + 
                    "FROM Articulo a WHERE a.cod = ?";

    try (Connection connection = SQLDatabaseManager.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(getArticuloCod)) {

        statement.setInt(1, selCod); 
        ResultSet dataSet = statement.executeQuery();

        while(dataSet.next()) {
            int cod = dataSet.getInt(1);
            String titulo = dataSet.getString(2); 
            String descripcion = dataSet.getString(3); 
            Date fechaRegistro = dataSet.getDate(4);
            String tipo = dataSet.getString(5); 
            boolean isAlquilada = dataSet.getBoolean(6);
            
            Articulo articulo = new Articulo(cod, titulo, descripcion, fechaRegistro, tipo, isAlquilada);
            ArticuloCod.add(articulo);
        }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return ArticuloCod;
}

public List<Cliente> getClienteCod(int codCliente) { 
    List<Cliente> ClienteCod = new LinkedList<>();

    String getArticuloCod = "SELECT * FROM Cliente WHERE cod = ?";

    try (Connection connection = SQLDatabaseManager.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(getArticuloCod)) {

        statement.setInt(1, codCliente); 
        ResultSet dataSet = statement.executeQuery();

        while(dataSet.next()) {
            String dni = dataSet.getString(2); 
            String nombre = dataSet.getString(3); 
            String direccion = dataSet.getNString(4);
            Date fechaNacimiento = dataSet.getDate(5); 

            
            Cliente c1 = new Cliente(dni, nombre, direccion, fechaNacimiento);
            ClienteCod.add(c1);
        }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return ClienteCod;
}



public int actEstadoTrue (int cod) { 
    int response = -1;
    String getAlquiler = "UPDATE Articulo SET alquilada = TRUE WHERE cod = ?";

    try (Connection connection = SQLDatabaseManager.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(getAlquiler)) {

            statement.setInt(1, cod); 
            
            statement.executeUpdate();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return response;
}

public int insertDevolucion(Alquiler alquiler) { 
    int response = -1;
    String getAlquiler = "UPDATE Alquiler SET fecha_devolucion = CURDATE(), alquilada = FALSE " +
    "WHERE cod_articulo = ? AND fecha_devolucion IS NULL;";

    try (Connection connection = SQLDatabaseManager.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(getAlquiler)) {

        statement.setInt(1, alquiler.getCodArticulo()); 

        response = statement.executeUpdate();
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return response;
}

public int insertarCliente (Cliente cliente){
    int response = -1;
    String getCliente = "INSERT INTO Cliente (cod, dni, nombre, direccion, fecha_nacimiento) " +
    "VALUES (?, ?, ?, ?, ?);";

    try (Connection connection = SQLDatabaseManager.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(getCliente)) {

        statement.setInt(1, cliente.getCod());
        statement.setString(2, cliente.getDni()); 
        statement.setString(3, cliente.getNombre());
        statement.setString(4, cliente.getDireccion());
        statement.setDate(5, (java.sql.Date) cliente.getFechaNacimiento());

        response = statement.executeUpdate();
        
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return response;
}

public int bajaCliente (int cod) { 
    int response = -1;
    String getAlquiler = "UPDATE Cliente SET fecha_baja = CURDATE() WHERE cod = ?";

    try (Connection connection = SQLDatabaseManager.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(getAlquiler)) {

            statement.setInt(1, cod); 
            
            statement.executeUpdate();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return response;
}

public List<Cliente> getClientes(){//METODO PARA MOSTRAR TODOS LOS ARTICULOS
    List<Cliente> Cliente = new LinkedList<>();

    String getCLientes =   "SELECT c.cod, c.dni, c.nombre FROM Cliente c WHERE c.fecha_baja = '9999-01-01';";

    try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
    ResultSet dataSet = statement.executeQuery(getCLientes);) {
        while(dataSet.next()){
            int cod = dataSet.getInt(1);
            String dni = dataSet.getNString(2);
            String nombre = dataSet.getNString(3);


            Cliente p1 =  new Cliente(cod, dni, nombre);
            Cliente.add(p1);
        }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return Cliente;
}
