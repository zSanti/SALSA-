package controller;

import clases.Persona;
import model.ImpleBD;

public class Controlador {
	private Dao dao = new ImpleBD();

	public boolean iniciarSesion(String nombreUsuario, String contrasena) {
		return false;
	}

	public boolean registrarUsuario(Persona per) {

		return dao.registrarUsuario(per);

	}

}