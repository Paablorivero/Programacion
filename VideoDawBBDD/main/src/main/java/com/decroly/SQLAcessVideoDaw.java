package com.decroly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.Articulo;
import com.Pelicula;

public class SQLAcessVideoDaw {

    public List<Articulo> getPeliculas(){//METODO PARA MOSTRAR TODOS LOS ARTICULOS
        List<Articulo> Peliculas = new LinkedList<>();

        String getPeliculas =   "SELECT a.cod, a.titulo, a.descripcion, a.fecha_registro, p.genero, p.alquilada FROM Articulo a JOIN Pelicula p ON p.cod = a.cod WHERE a.fecha_baja = '9999-01-01';";

        try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getPeliculas);) {
            while(dataSet.next()){
                int cod = dataSet.getInt(1);
                String titulo = dataSet.getNString(2);
                String descripcion = dataSet.getNString(3);
                Date fechaRegistro = dataSet.getDate(4);
                String genero = dataSet.getNString(5);
                boolean alquilada = dataSet.getBoolean(6);

                Articulo p1 =  new Pelicula(cod, titulo, descripcion, fechaRegistro, genero, alquilada);
                Peliculas.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Peliculas;
    }
}
