package controller;

import clases.Persona;
import model.ImpleDB;

public class Controlador {
	private Dao dao = new ImpleDB();
	
	public boolean iniciarSesion(String nombreUsuario, String contrasena) {
		return false;
	}

	public static boolean registrarUsuario(Persona per) {
		Dao dao = new ImpleDB();

		return dao.registrarUsuario(per);

	}

}