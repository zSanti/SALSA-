package controller;

import view.Main;

public class Principal {
	
	public static void main(String[] args) {
		Dao dao = null;
		// Llamamos a la ventana principal desde la vista
        Main ventanaPrincipal = new Main(dao);
        
        // Hacemos visible la ventana principal
        ventanaPrincipal.setVisible(true);
	}
	
}