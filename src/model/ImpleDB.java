package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import clases.Articulo;
import clases.Persona;
import controller.Dao;

public class ImpleDB implements Dao {

	// Objeto para crear conexión mysql
	private ConnectionMysql conexion = new ConnectionMysql();

	// Consultas a la Base de Datos
	private final String CONSULTA_COMPROBAR_USUARIO = "SELECT dni, nombre, apellido, rol FROM persona WHERE email = ? AND contrasena = ?";
	private final String CONSULTA_PERSONA = "INSERT INTO persona (dni, nombre, apellido, fechaNac, contrasena, direccion, email, genero, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String CONSULTA_TRABAJADOR = "INSERT INTO trabajador (dni) VALUES (?)";
	private final String CONSULTA_USUARIO = "INSERT INTO usuario (dni, fechaReg) VALUES (?, ?)";
	private final String ALTA_ARTICULO = "INSERT INTO articulo (cod_articulo, color, modelo, temporada, precio, descuento) VALUES (?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void iniciarSesion(Persona per) {
		String nombre, apellido, rol;

		try {
			conexion.openConnection();
			try (PreparedStatement stmtUsuario = ((Connection) conexion).prepareStatement(CONSULTA_COMPROBAR_USUARIO)) {
				stmtUsuario.setString(1, per.getEmail());
				stmtUsuario.setString(2, per.getContrasena());
				try (ResultSet resultSet = stmtUsuario.executeQuery()) {
					if (resultSet.next()) {
						nombre = resultSet.getString("nombre");
						apellido = resultSet.getString("apellido");
						rol = resultSet.getString("rol");

						System.out.println("Bienvenido, " + nombre + " " + apellido + ". Rol: " + rol);

						// Dependiendo del rol, podrías redirigir al usuario a diferentes partes de tu
						// aplicación
						if (rol.equals("ADMINISTRADOR")) {
							// Redirigir al panel de administrador
						} else if (rol.equals("INVITADO") || rol.equals("EMPLEADO")) {
							// Redirigir al panel de usuario normal
						}
					} else {
						System.out.println("Email/Contraseña inválidas. Por favor, inténtalo de nuevo.");
					}
				}
			}
		} catch (SQLException e) {
			// Manejar la excepción de manera más específica
			e.printStackTrace();
			System.out.println("Error al intentar comprobar el usuario.");
		} finally {
			conexion.closeConnection();
		}
	}

//	@Override
//	public void comprobarUsuario(Persona per) {
//		 compruebo el usuario y meto el rol en la clase usuario
//		Usuario usuarioC;
//		String dni;
//		dni = usuario.getDni();
//		conexion.openConnection(); 
//           
//		try {
//			stmt = con.prepareStatement(CONSULTA_USUARIO);
//			stmt.setString(1, dni);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				if (rs != null && rs.getString("PASSWD").equalsIgnoreCase(usuario.getPassword())) {
//					usuario.setRol(rs.getString("ROL"));
//				}
//			}
//			rs.close();
//		} catch (SQLException e) {
//			System.out.println("Error al intentar abrir la DB");
//		}
//		conexion.closeConnection();
//	}

	@Override
	public boolean registrarUsuario(Persona per) {
		conexion.openConnection();
		PreparedStatement stmtPersona = null;
		PreparedStatement stmtTrabajador = null;
		PreparedStatement stmtUsuario = null;

		try {
			// Inserción en la tabla persona
			stmtPersona = ((Connection) conexion).prepareStatement(CONSULTA_PERSONA);
			stmtPersona.setString(1, per.getDni());
			stmtPersona.setString(2, per.getNombre());
			stmtPersona.setString(3, per.getApellido());
			stmtPersona.setString(4, per.getFechaNacimiento().toString());
			stmtPersona.setString(5, per.getContrasena());
			stmtPersona.setString(6, per.getDireccion());
			stmtPersona.setString(7, per.getEmail());
			stmtPersona.setString(8, per.getGenero().toString());
			stmtPersona.setString(9, per.getRol());
			stmtPersona.executeUpdate();

			// Inserción en la tabla trabajador (simplemente inserta el DNI)
			stmtTrabajador = ((Connection) conexion).prepareStatement(CONSULTA_TRABAJADOR);
			stmtTrabajador.setString(1, per.getDni());
			stmtTrabajador.executeUpdate();

			// Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de
			// registro)
			stmtUsuario = ((Connection) conexion).prepareStatement(CONSULTA_USUARIO);
			stmtUsuario.setDate(1, java.sql.Date.valueOf(LocalDate.now())); // Fecha de registro actual
			stmtUsuario.executeUpdate();

			// Si todas las inserciones fueron exitosas, retorna true
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmtPersona != null) {
					stmtPersona.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmtTrabajador != null) {
					stmtTrabajador.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmtUsuario != null) {
					stmtUsuario.close();
				}
			} catch (SQLException e) {
			}
			if (conexion != null) {
				conexion.closeConnection();
			}
		}
	}

	@Override
	public boolean altaArticulo(Articulo art) {
		conexion.openConnection();
		PreparedStatement stmArticulo = null;
		try {
			// insercion de la tabla articulo
			stmArticulo = ((Connection) conexion).prepareStatement(ALTA_ARTICULO);
			stmArticulo.setInt(1, art.getCodArticulo());
			stmArticulo.setString(2, art.getColor());
			stmArticulo.setString(3, art.getModelo());
			stmArticulo.setString(4, art.getTemporada().toString());
			stmArticulo.setFloat(5, art.getPrecio());
			stmArticulo.setFloat(6, art.getPorcentajeDecuento());
			stmArticulo.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmArticulo != null) {
					stmArticulo.close();
				}
			} catch (SQLException e) {
			}
			if (conexion != null) {
				conexion.closeConnection();
			}
		}
	}
}