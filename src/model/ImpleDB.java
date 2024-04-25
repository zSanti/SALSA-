package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Articulo;
import clases.Persona;
import clases.Trabajador;
import clases.Usuario;
import controller.Dao;

public class ImpleDB implements Dao {

	// Objeto para crear conexión mysql
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet resultSet;
	
	// Consultas a la Base de Datos
	private final String CONSULTA_COMPROBAR_USUARIO = "SELECT dni, nombre, apellido FROM persona WHERE email = ? AND contrasena = ?";
	private final String ALTA_PERSONA = "INSERT INTO persona (dni, nombre, apellido, fechaNac, contrasena, direccion, email, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String ALTA_TRABAJADOR = "INSERT INTO trabajador (dni, nss) VALUES (?, ?)";
	private final String ALTA_USUARIO = "INSERT INTO usuario (dni, fechaReg) VALUES (?, ?)";
	private final String ALTA_ARTICULO = "INSERT INTO articulo (cod_articulo, color, modelo, temporada, precio, descuento) VALUES (?, ?, ?, ?, ?, ?, ?)";
     
	@Override
	public Persona iniciarSesion(Persona persona) {
	    String nombre, apellido;
	    conn = ConnectionMysql.openConnection();
	    
	    if (persona.getEmail() == null || persona.getContrasena() == null) {
	        System.out.println("Email o contraseña no pueden ser nulos.");
	        return persona;
	    }

	    try {
	        stmt = conn.prepareStatement(CONSULTA_COMPROBAR_USUARIO);
	        stmt.setString(1, persona.getEmail());
	        stmt.setString(2, persona.getContrasena());
	        resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            nombre = resultSet.getString("nombre");
	            apellido = resultSet.getString("apellido");

	            System.out.println("Bienvenido, " + nombre + " " + apellido);
	            
	        } else {
	            System.out.println("Email/Contraseña inválidas. Por favor, inténtalo de nuevo.");
	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al intentar comprobar el usuario.");
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        ConnectionMysql.closeConnection();
	    }
	    return persona;
	}

	@Override
	public boolean registrarUsuario(Persona per) {
		conn = ConnectionMysql.openConnection();

		try {
			// Inserción en la tabla persona
			stmt = conn.prepareStatement(ALTA_PERSONA);
			stmt.setString(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setString(4, per.getFechaNacimiento().toString());
			stmt.setString(5, per.getContrasena());
			stmt.setString(6, per.getDireccion());
			stmt.setString(7, per.getEmail());
			stmt.setString(8, per.getGenero().toString());
			stmt.executeUpdate();

			// Inserción en la tabla trabajador (simplemente inserta el DNI)
			if (per instanceof Trabajador) {
				stmt = conn.prepareStatement(ALTA_TRABAJADOR);
				stmt.setString(1, per.getDni());
				stmt.setString(2, ((Trabajador) per).getNnss());
				stmt.executeUpdate();
			} else if (per instanceof Usuario) {
				// Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de 
				stmt = conn.prepareStatement(ALTA_USUARIO);
				stmt.setString(1, per.getDni());
				stmt.setString(2, ((Usuario) per).getFechaRegistro().toString()); // Fecha de registro actual
				stmt.executeUpdate();

			}

			// Si todas las inserciones fueron exitosas, retorna true
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {}
			if (conn != null)
				ConnectionMysql.closeConnection();
		}
	}

	@Override
	public boolean altaArticulo(Articulo art) {
		conn = ConnectionMysql.openConnection();

		try {
			// insercion de la tabla articulo
			stmt = (conn.prepareStatement(ALTA_ARTICULO));
			stmt.setInt(1, art.getCodArticulo());
			stmt.setString(2, art.getColor());
			stmt.setString(3, art.getModelo());
			stmt.setString(4, art.getTemporada().toString());
			stmt.setFloat(5, art.getPrecio());
			stmt.setFloat(6, art.getPorcentajeDecuento());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			if (conn != null) {
				ConnectionMysql.closeConnection();
			}
		}
	}

}