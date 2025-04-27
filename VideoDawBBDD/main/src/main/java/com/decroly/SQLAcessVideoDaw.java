package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.Alquiler;
import com.Articulo;
import com.Cliente;
import com.Pelicula;

public class SQLAcessVideoDaw {

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
                int cod = dataSet.getInt(1);
                String dni = dataSet.getString(2); 
                String nombre = dataSet.getString(3); 
                String direccion = dataSet.getNString(4);
                Date fechaNacimiento = dataSet.getDate(5); 

                
                Cliente c1 = new Cliente(cod, dni, nombre, direccion, fechaNacimiento);
                ClienteCod.add(c1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ClienteCod;
    }

    public int insertAlquiler (Alquiler alquiler) { 
        int response = -1;
        String getAlquiler = "INSERT INTO Alquiler (cod_cliente, cod_articulo, fecha_alquiler) " +
        "VALUES (?, ?, CURDATE());";
    
        try (Connection connection = SQLDatabaseManager.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(getAlquiler)) {
    
            statement.setInt(1, alquiler.getCodCliente());
            statement.setInt(2, alquiler.getCodArticulo()); 

            response = statement.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
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
        String getAlquiler = "UPDATE Alquiler SET fecha_devolucion = CURDATE() " +
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

    public int actEstadoFalse (int cod) { 
        int response = -1;
        String getAlquiler = "UPDATE Articulo SET alquilada = FALSE WHERE cod = ?";
    
        try (Connection connection = SQLDatabaseManager.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(getAlquiler)) {

                statement.setInt(1, cod); 
                
                statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
    
}
