package model;

import java.time.LocalDate;

import clases.Persona;
import controller.Dao;

public class ImpleBD implements Dao {

	@Override
	public boolean iniciarSesion(String nombreUsuario, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarUsuario(Persona per) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean registrarUsuario(String dni, String nombre, String apellido, LocalDate fechaNacimiento,
			String contrasena, String direccion, String email, String genero) {
		// TODO Auto-generated method stub
		return false;
	}

}
