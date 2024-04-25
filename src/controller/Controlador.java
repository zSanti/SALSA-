package controller;

import clases.Articulo;
import clases.Persona;
import model.ImpleDB;

public class Controlador {

	public Persona iniciarSesion(Persona per) {
		Dao dao = new ImpleDB();
		return dao.iniciarSesion(per);
	}

	public static boolean registrarUsuario(Persona per) {
		Dao dao = new ImpleDB();
		return dao.registrarUsuario(per);
	}
// verificar si esto es necesario o no 

	public static boolean altaArticulo(Articulo art) {
		Dao dao = new ImpleDB();
		return dao.altaArticulo(art);
	}

}