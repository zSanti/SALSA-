package controller;

import view.Login;

public class Principa {

	public static void main(String[] args) {

		Controlador cont = new Controlador();

		Login ven = new Login(cont);
		ven.setVisible(true);

	}

}
