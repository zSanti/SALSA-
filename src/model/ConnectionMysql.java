package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
	// Atributos
	private static Connection conn;
	// Credenciales para conexion a la base de datos
	private static final String USERNAME = "root";
	private static final String PASSWORD = "abcd*1234";
	private static String url = "jdbc:mysql://localhost:3306/salsa?serverTimezone=Europe/Madrid&useSSL=false";

	// Abrir la conexion de la base de datos
	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
			return conn;
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return conn;
		}
	}

	// Cerrar la conexion de la base de datos
	public static Connection closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}