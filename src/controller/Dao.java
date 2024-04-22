package controller;

import clases.Articulo;
import clases.Persona;

public interface Dao {

	// Comprobacion de inicio de sesion
	void iniciarSesion(Persona per);

	boolean registrarUsuario(Persona per);

	void altaArticulo(Articulo art);

}