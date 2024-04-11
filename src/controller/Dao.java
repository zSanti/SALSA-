package controller;

import java.time.LocalDate;

public interface Dao {
	boolean iniciarSesion(String nombreUsuario, String contraseña);
	boolean registrarUsuario(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String contrasena, String direccion, String email, String genero);
}