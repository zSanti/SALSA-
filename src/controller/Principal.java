package controller;

import view.Login;

public class Principal {

	public static void main(String[] args) {

		Controlador cont = new Controlador();
		boolean oscuro = false;
		Login ven = new Login(cont, oscuro);
		ven.setVisible(true);

	}

}