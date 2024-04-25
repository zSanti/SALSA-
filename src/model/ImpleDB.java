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
	private PreparedStatement stm;
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

		try {
			// Inserción en la tabla persona
			stm = conn.prepareStatement(ALTA_PERSONA);
			stm.setString(1, per.getDni());
			stm.setString(2, per.getNombre());
			stm.setString(3, per.getApellido());
			stm.setString(4, per.getFechaNacimiento().toString());
			stm.setString(5, per.getContrasena());
			stm.setString(6, per.getDireccion());
			stm.setString(7, per.getEmail());
			stm.setString(8, per.getGenero().toString());
			// stmtPersona.setString(9, per.getRol());
			stm.executeUpdate();

			// Inserción en la tabla trabajador (simplemente inserta el DNI)
			if (per instanceof Trabajador) {

				stm = conn.prepareStatement(ALTA_TRABAJADOR);
				stm.setString(1, per.getDni());
				stm.setString(2, ((Trabajador) per).getNnss());
				stm.executeUpdate();

			} else if (per instanceof Usuario) {
				// Inserción en la tabla usuario (simplemente inserta el DNI y la fecha de
				// registro)

				stm = conn.prepareStatement(ALTA_USUARIO);
				stm.setString(1, per.getDni());
				stm.setString(2, ((Usuario) per).getFechaRegistro().toString()); // Fecha de registro actual
				stm.executeUpdate();

			}

			// Si todas las inserciones fueron exitosas, retorna true
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stm != null) {
					stm.close();
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

		try {
			// insercion de la tabla articulo
			stm = (conn.prepareStatement(ALTA_ARTICULO));
			stm.setInt(1, art.getCodArticulo());
			stm.setString(2, art.getColor());
			stm.setString(3, art.getModelo());
			stm.setString(4, art.getTemporada().toString());
			stm.setFloat(5, art.getPrecio());
			stm.setFloat(6, art.getPorcentajeDecuento());
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
			if (conn != null) {
				ConnectionMysql.closeConnection();
			}
		}
	}

}