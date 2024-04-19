package controller;

import view.Login;

public class Principal {
	
	public static void main(String[] args) {
		Dao dao = null;
		// Llamamos a la ventana principal desde la vista
        Login ventanaPrincipal = new Login(dao);
        
        // Hacemos visible la ventana principal
        ventanaPrincipal.setVisible(true);
	}
	
}