package controller;

import clases.Articulo;
import clases.Persona;

public interface Dao {

	// Comprobacion de inicio de sesion
	public Persona iniciarSesion(Persona per);

	boolean registrarUsuario(Persona per);

	boolean altaArticulo(Articulo art);

	// void comprobarUsuario(Persona per);

}