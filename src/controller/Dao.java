package controller;

import java.time.LocalDate;

import clases.Persona;

public interface Dao {
	boolean iniciarSesion(String nombreUsuario, String contraseña);

	boolean registrarUsuario(Persona per);
}