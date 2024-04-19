package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionMysql {
    // Atributos
    private Connection conn;
    private PreparedStatement stmt;

    // Credenciales para conexion a la base de datos
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final Integer PORT = 3306;
    private static final String DATABASE = "salsa";

    // Abrir la conexion de la base de datos
    public Connection openConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT + "/" + DATABASE + "?serverTimezone=Europe/Madrid&useSSL=false", USERNAME, PASSWORD);
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
            e.printStackTrace();
            return null;
        }
    }

    // Cerrar la conexion de la base de datos
    public void closeConnection() {
        try {
            if (stmt != null) {
                stmt.close();
            } else if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}