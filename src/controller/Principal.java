package controller;

import view.Main;

public class Principal {
	
	public static void main(String[] args) {
		// Llamamos a la ventana principal desde la vista
        Main ventanaPrincipal = new Main();
        
        // Hacemos visible la ventana principal
        ventanaPrincipal.setVisible(true);
	}
	
}