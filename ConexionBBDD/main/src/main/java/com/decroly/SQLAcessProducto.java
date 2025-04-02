package com.decroly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.producto;

public class SQLAcessProducto {
    
    public List<producto> getProductos(){
        List<producto> Productos = new LinkedList<>();

        //Setencia SQL
        String getChNames = "SELECT * FROM Producto";

        try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getChNames);) {
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String referencia = dataSet.getNString(2);
                String nombre = dataSet.getNString(3);
                String descripcion = dataSet.getNString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                producto p1 =  new producto(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                Productos.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Productos;
    }
}
