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

	// Consultas a la Base de Datos
	private final String ALTA_COMPROBAR_USUARIO = "SELECT dni, nombre, apellido, rol FROM persona WHERE email = ? AND contrasena = ?";
	private final String ALTA_PERSONA = "INSERT INTO persona (dni, nombre, apellido, fechaNac, contrasena, direccion, email, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String ALTA_TRABAJADOR = "INSERT INTO trabajador (dni, nss) VALUES (?, ?)";
	private final String ALTA_USUARIO = "INSERT INTO usuario (dni, fechaReg) VALUES (?, ?)";
	private final String ALTA_ARTICULO = "INSERT INTO articulo (cod_articulo, color, modelo, temporada, precio, descuento) VALUES (?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void iniciarSesion(Persona per) {
		String nombre, apellido, rol;

		try {
			conn = ConnectionMysql.openConnection();
			try (PreparedStatement stmtUsuario = conn.prepareStatement(ALTA_COMPROBAR_USUARIO)) {
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
		}
	}

//	@Override
//	public void comprobarUsuario(Persona per) {
////		 compruebo el usuario y meto el rol en la clase usuario
//		Usuario usuarioC;
//		String dni;
//		dni = usuarioC.getDni();
//		conn = ConnectionMysql.openConnection();
//		try {
//			stmt = conn.prepareStatement(ALTA_USUARIO);
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
//		ConnectionMysql.closeConnection()
//	}

	@Override
	public boolean registrarUsuario(Persona per) {
		conn = ConnectionMysql.openConnection();
		PreparedStatement stmtPersona = null;
		PreparedStatement stmtTrabajador = null;
		PreparedStatement stmtUsuario = null;

		try {
			// Inserción en la tabla persona
			stmtPersona = conn.prepareStatement(ALTA_PERSONA);
			stmtPersona.setString(1, per.getDni());
			stmtPersona.setString(2, per.getNombre());
			stmtPersona.setString(3, per.getApellido());
			stmtPersona.setString(4, per.getFechaNacimiento().toString());
			stmtPersona.setString(5, per.getContrasena());
			stmtPersona.setString(6, per.getDireccion());
			stmtPersona.setString(7, per.getEmail());
			stmtPersona.setString(8, per.getGenero().toString());
			// stmtPersona.setString(9, per.getRol());
			stmtPersona.executeUpdate();
			stmtPersona.close();
			// Inserción en la tabla trabajador (simplemente inserta el DNI)

			stmtTrabajador = conn.prepareStatement(ALTA_TRABAJADOR);
			stmtTrabajador.setString(1, per.getDni());
			stmtTrabajador.setString(2, ((Trabajador) per).getNnss());
			stmtTrabajador.executeUpdate();
			stmtTrabajador.close();
			// Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de
			// registro)

			stmtUsuario = conn.prepareStatement(ALTA_USUARIO);
			stmtUsuario.setString(1, per.getDni());
			stmtUsuario.setString(2, ((Usuario) per).getFechaRegistro().toString()); // Fecha de registro actual
			stmtUsuario.executeUpdate();
			stmtUsuario.close();
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
			if (conn != null) {
				ConnectionMysql.closeConnection();
			}
		}
	}

	@Override
	public boolean altaArticulo(Articulo art) {
		conn = ConnectionMysql.openConnection();
		PreparedStatement stmArticulo = null;
		try {
			// insercion de la tabla articulo
			stmArticulo = (conn.prepareStatement(ALTA_ARTICULO));
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
			if (conn != null) {
				ConnectionMysql.closeConnection();
			}
		}
	}

}