package excepciones;

import javax.swing.JOptionPane;

public class CreateException extends Exception {

	private static final long serialVersionUID = 1L;

	public void mostrarAviso() {
		JOptionPane.showMessageDialog(null, "Error en el alta del articulo");

	}
}
