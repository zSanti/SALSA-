package controller;

import clases.Persona;
import model.ImpleDB;

public class Controlador {
	
	// creo puedo borrar esto :v

	public static boolean registrarUsuario(Persona per) {
		Dao dao = new ImpleDB();
		return dao.registrarUsuario(per);
	}

}