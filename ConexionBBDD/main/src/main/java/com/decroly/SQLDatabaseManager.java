package com.decroly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseManager {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL;
    private static String SCHEMA;
    private static String USUARIO;
    private static String CLAVE;

    static {
        try (InputStream inputStream = SQLDatabaseManager.class.getClassLoader().getResourceAsStream("conexionBBDD.dat");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

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
