package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.producto;
import com.tipo;

public class SQLAcessProducto {
    
    public List<producto> getProductos(){//METODO PARA MOSTRAR TODOS LOS PRODUCTOS
        List<producto> Productos = new LinkedList<>();

        String getProductos = "SELECT * FROM Producto";

        try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getProductos);) {
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

    public List<producto> getProductosPorReferencia(String selReferencia){//METODO PARA MOSTRAR TODOS LOS PRODUCTOS POR REFERENCIA
        List<producto> ProductosReferencia = new LinkedList<>();

        String getProductoReferencia = "SELECT * FROM Producto WHERE referencia = ?";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getProductoReferencia);) {

            statement.setString(1, selReferencia);
            ResultSet dataSet = statement.executeQuery();

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
                ProductosReferencia.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ProductosReferencia;
    }

    public List<producto> getProductosPorTipo(String selTipo){//METODO PARA MOSTRAR TODOS LOS PRODUCTOS POR TIPO
        List<producto> productosTipo = new LinkedList<>();

        String getProductoTipo = "SELECT * FROM Producto WHERE tipo = ?";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getProductoTipo);) {

            statement.setString(1, selTipo);
            ResultSet dataSet = statement.executeQuery();

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
                productosTipo.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productosTipo;
    }

    public List<producto> getProductosPorCantidad(int selCantidad){//METODO PARA MOSTRAR TODOS LOS PRODUCTOS POR CANTIDAD
        List<producto> productosCantidad = new LinkedList<>();

        String getProductoCantidad = "SELECT * FROM Producto WHERE cantidad = ?";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getProductoCantidad);) {

            statement.setInt(1, selCantidad);
            ResultSet dataSet = statement.executeQuery();

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
                productosCantidad.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productosCantidad;
    }

    public List<String> getReferencias(){//METODO PARA MOSTRAR TODAS LAS REFERENCIAS
        List<String> Referencias = new LinkedList<>();

        String getReferencias = "SELECT referencia FROM producto";

        try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getReferencias);) {
            while(dataSet.next()){
                String referencia = dataSet.getNString(1);
                Referencias.add(referencia);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Referencias;
    }

    public List<tipo> getTipos(){//METODO PARA MOSTRAR TODOS LOS PRODUCTOS
        List<tipo> tipos = new LinkedList<>();

        String getTipos = "SELECT * FROM tipo";

        try (Connection connection = SQLDatabaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getTipos);) {
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String nombre = dataSet.getNString(2);

                tipo p1 =  new tipo(id, nombre);
                tipos.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tipos;
    }

    public int insertProducto(producto producto){//INSERTAR UN NUEVO PRODUCTO
        int response = -1;
        String sqlStatement = "INSERT INTO producto (id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setInt(1, producto.getId());
            statement.setNString(2, producto.getReferencia());
            statement.setNString(3, producto.getNombre());
            statement.setNString(4, producto.getDescripcion());
            statement.setInt(5, producto.getTipo());
            statement.setInt(6, producto.getCantidad());
            statement.setDouble(7, producto.getPrecio());
            statement.setInt(8, producto.getDescuento());
            statement.setInt(9, producto.getIva());
            statement.setBoolean(10, producto.isAplicarDto());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }

    public int insertTipo(tipo tipo){//INSERTAR UN NUEVO TIPO
        int response = -1;
        String sqlStatement = "INSERT INTO tipo (id, nombre)" + "VALUES (?, ?)";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setInt(1, tipo.getId());
            statement.setNString(2, tipo.getNombre());
            
            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }

    public int deleteProducto(String referencia){//INSERTAR UN NUEVO PRODUCTO
        int element = -1;
        String sqlStatement = "DELETE FROM producto WHERE referencia = ?";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setNString(1,referencia);
            element = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    public int uptProducto(producto producto){//ACTUALIZAR UN PRODUCTO
        int response = -1;
        String sqlStatement = "UPDATE producto set descripcion = ? , cantidad = ?, precio = ?, descuento = ?, aplicarDto = ? where referencia = ?";

        try (Connection connection = SQLDatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setNString(1, producto.getDescripcion());
            statement.setInt(2, producto.getCantidad());
            statement.setDouble(3, producto.getPrecio());
            statement.setInt(4, producto.getDescuento());
            statement.setBoolean(5, producto.isAplicarDto());
            statement.setNString(6, producto.getReferencia());

            statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
        return response;
    }
}
