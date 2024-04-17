package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import clases.Persona;
import controller.Dao;

public class ImpleDB implements Dao {
	private ConnectionMysql conexion = new ConnectionMysql();
	
	@Override
    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
		return false;
    }
	
	@Override
	public boolean registrarUsuario(Persona per) {
		conexion.openConnection();
        PreparedStatement stmtPersona = null;
        PreparedStatement stmtTrabajador = null;
        PreparedStatement stmtUsuario = null;

        try {
            // Inserción en la tabla persona
            String consultaPersona = "INSERT INTO persona (dni, nombre, apellido, fechaNac, contrasena, direccion, email, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmtPersona = ((Connection) conexion).prepareStatement(consultaPersona);
            stmtPersona.setString(1, per.getDni());
            stmtPersona.setString(2, per.getNombre());
            stmtPersona.setString(3, per.getApellido());
            stmtPersona.setString(4, per.getFechaNacimiento().toString());
            stmtPersona.setString(5, per.getContraseña());
            stmtPersona.setString(6, per.getDireccion());
            stmtPersona.setString(7, per.getEmail());
            stmtPersona.setString(8, per.getGenero().toString());
            stmtPersona.executeUpdate();

            // Inserción en la tabla trabajador (simplemente inserta el DNI)
            String consultaTrabajador = "INSERT INTO trabajador (dni) VALUES (?)";
            stmtTrabajador = ((Connection) conexion).prepareStatement(consultaTrabajador);
            stmtTrabajador.setString(1, per.getDni());
            stmtTrabajador.executeUpdate();

            // Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de registro)
            String consultaUsuario = "INSERT INTO usuario (dni, fechaReg) VALUES (?, ?)";
            stmtUsuario = ((Connection) conexion).prepareStatement(consultaUsuario);
            stmtUsuario.setString(1, per.getDni());
            stmtUsuario.setDate(2, java.sql.Date.valueOf(LocalDate.now())); // Fecha de registro actual
            stmtUsuario.executeUpdate();

            // Si todas las inserciones fueron exitosas, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (stmtPersona != null) stmtPersona.close(); } catch (SQLException e) { }
            try { if (stmtTrabajador != null) stmtTrabajador.close(); } catch (SQLException e) { }
            try { if (stmtUsuario != null) stmtUsuario.close(); } catch (SQLException e) { }
            if (conexion != null) conexion.closeConnection();
        }
	}
}