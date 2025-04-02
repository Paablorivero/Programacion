package com.decroly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SQLAcessProducto {
    
    public List<String> getNombreProducto(){
        List<String> NombreProducto = new LinkedList<>();

        //Setencia SQL
        String getProducto = "SELECT nombre FROM Producto";

        try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getProducto);) {
            while(dataSet.next()){
                NombreProducto.add(dataSet.getNString(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return NombreProducto;
    }
}
