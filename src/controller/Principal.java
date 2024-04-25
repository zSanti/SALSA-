package controller;

import clases.Persona;
import view.Login;

public class Principal {

	public static void main(String[] args) {
		// Instanciamos y creamos un objeto para el controlador y para la persona
		Controlador controladorRutas = new Controlador();
		Persona persona = new Persona();
		
		// Definimos que el modo sea oscuro
		boolean oscuro = false;
		
		// Le pasamos la ventana principal que en nuestro caso es el Login
		Login login = new Login(controladorRutas, persona, oscuro);
		login.setVisible(true);

	}

}