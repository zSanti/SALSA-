package controller;

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
    private static final String DATABASE = "";

    // Abrir la conexion de la base de datos
    public void openConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT + "/" + DATABASE +"?serverTimezone=Europe/Madrid&useSSL=false", USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
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