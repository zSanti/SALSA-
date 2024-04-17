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
        PreparedStatement statementPersona = null;
        PreparedStatement statementTrabajador = null;
        PreparedStatement statementUsuario = null;

        try {
            // Inserción en la tabla persona
            String consultaPersona = "INSERT INTO persona (dni, nombre, apellido, fechaNac, contrasena, direccion, email, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statementPersona = conexion.prepareStatement(consultaPersona);
            statementPersona.setString(1, per.getDni());
            statementPersona.setString(2, per.getNombre());
            statementPersona.setString(3, per.getApellido());
            statementPersona.setString(4, per.getFechaNacimiento().toString());
            statementPersona.setString(5, per.getContraseña());
            statementPersona.setString(6, per.getDireccion());
            statementPersona.setString(7, per.getEmail());
            statementPersona.setString(8, per.getGenero().toString());
            statementPersona.executeUpdate();

            // Inserción en la tabla trabajador (simplemente inserta el DNI)
            String consultaTrabajador = "INSERT INTO trabajador (dni) VALUES (?)";
            statementTrabajador = conexion.prepareStatement(consultaTrabajador);
            statementTrabajador.setString(1, per.getDni());
            statementTrabajador.executeUpdate();

            // Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de registro)
            String consultaUsuario = "INSERT INTO usuario (dni, fechaReg) VALUES (?, ?)";
            statementUsuario = conexion.prepareStatement(consultaUsuario);
            statementUsuario.setString(1, per.getDni());
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