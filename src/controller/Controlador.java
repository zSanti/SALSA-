package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.ConnectionMysql;

public class Controlador implements Dao {
	private ConnectionMysql imp = new ConnectionMysql();
	
    @Override
    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
    	ConnectionMysql imp = new ConnectionMysql();
		return false;
    }

    @Override
    public boolean registrarUsuario(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String genero) {
        Connection conexion = null;
        PreparedStatement statementPersona = null;
        PreparedStatement statementTrabajador = null;
        PreparedStatement statementUsuario = null;

        try {
            conexion = imp.openConnection();

            // Inserción en la tabla persona
            String consultaPersona = "INSERT INTO persona (dni, nombre, apellido, fechaNac, contrasena, direccion, email, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statementPersona = conexion.prepareStatement(consultaPersona);
            statementPersona.setString(1, dni);
            statementPersona.setString(2, nombre);
            statementPersona.setString(3, apellido);
            statementPersona.setString(4, fechaNacimiento.toString());
            statementPersona.setString(5, contrasena);
            statementPersona.setString(6, direccion);
            statementPersona.setString(7, email);
            statementPersona.setString(8, genero);
            statementPersona.executeUpdate();

            // Inserción en la tabla trabajador (simplemente inserta el DNI)
            String consultaTrabajador = "INSERT INTO trabajador (dni) VALUES (?)";
            statementTrabajador = conexion.prepareStatement(consultaTrabajador);
            statementTrabajador.setString(1, dni);
            statementTrabajador.executeUpdate();

            // Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de registro)
            String consultaUsuario = "INSERT INTO usuario (dni, fechaReg) VALUES (?, ?)";
            statementUsuario = conexion.prepareStatement(consultaUsuario);
            statementUsuario.setString(1, dni);
            statementUsuario.setDate(2, java.sql.Date.valueOf(LocalDate.now())); // Fecha de registro actual
            statementUsuario.executeUpdate();

            // Si todas las inserciones fueron exitosas, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (statementPersona != null) statementPersona.close(); } catch (SQLException e) { }
            try { if (statementTrabajador != null) statementTrabajador.close(); } catch (SQLException e) { }
            try { if (statementUsuario != null) statementUsuario.close(); } catch (SQLException e) { }
            try { if (conexion != null) conexion.close(); } catch (SQLException e) { }
        }
    }

}