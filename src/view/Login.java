
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Persona;
import controller.Controlador;

public class Login extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel BodyLayout, panelLeft, panelRight;
	private JLabel logo, labelEmail, labelPassword, labelNoRegister, linkRegister;
	private JTextField inputEmail;
	private JPasswordField inputPassword;
	private JButton toggleButton, btnLogin;

	// Lógica para la conexión
	private Controlador controladorRutas;
	private Persona persona;
	private boolean oscuro;

	// Página de Inicio
	public Login(Controlador controladorRutas, Persona persona, boolean oscuro) {
		this.controladorRutas = controladorRutas;
		this.persona = persona;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 574);
		BodyLayout = new JPanel();
		BodyLayout.setBackground(new Color(255, 255, 255));
		BodyLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BodyLayout);
		BodyLayout.setLayout(null);
		ImageIcon icon = new ImageIcon(getClass().getResource("/assets/logo.png"));

		// Division Login
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(0, 128, 255));
		panelLeft.setBounds(0, 0, 416, 539);
		BodyLayout.add(panelLeft);
		panelLeft.setLayout(null);

		panelRight = new JPanel();
		panelRight.setBackground(new Color(255, 255, 255));
		panelRight.setBounds(414, 0, 501, 539);
		BodyLayout.add(panelRight);
		panelRight.setLayout(null);

		// Establece el icono "nover" por defecto
		toggleButton = new JButton(new ImageIcon(getClass().getResource("/assets/icons/nover.png")));
		toggleButton.setBounds(412, 313, 29, 20);
		// Establece el botón como transparente
		toggleButton.setOpaque(false);
		// No rellena el área del botón
		toggleButton.setContentAreaFilled(false);
		toggleButton.setBorderPainted(false);
		panelRight.add(toggleButton);

		// Logo centrado
		logo = new JLabel("");
		logo.setBounds(132, 66, 245, 51);
		panelRight.add(logo);
		ImageIcon img = new ImageIcon(
				icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
		logo.setIcon(img);

		labelEmail = new JLabel("Correo electrónico");
		labelEmail.setBounds(74, 171, 123, 14);
		panelRight.add(labelEmail);

		inputEmail = new JTextField();
		inputEmail.setBounds(74, 196, 378, 51);
		inputEmail.setColumns(10);
		panelRight.add(inputEmail);

		labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(74, 270, 123, 14);
		panelRight.add(labelPassword);

		inputPassword = new JPasswordField();
		inputPassword.setBounds(74, 295, 378, 51);
		panelRight.add(inputPassword);

		btnLogin = new JButton("Iniciar sesión");
		btnLogin.setBounds(74, 381, 378, 45);
		panelRight.add(btnLogin);

		labelNoRegister = new JLabel("¿No tienes cuenta? Click aquí para");
		labelNoRegister.setBounds(74, 454, 227, 14);
		labelNoRegister.setHorizontalAlignment(SwingConstants.LEFT);
		panelRight.add(labelNoRegister);

		linkRegister = new JLabel("registrarme");
		linkRegister.setBounds(274, 454, 75, 14);
		linkRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		linkRegister.setForeground(new Color(0, 128, 255));
		linkRegister.setHorizontalAlignment(SwingConstants.LEFT);
		panelRight.add(linkRegister);

		// Botones de eventos
		linkRegister.addMouseListener(this);
		btnLogin.addActionListener(this);
		toggleButton.addActionListener(this);

	}

	// Visualizar/Desvisualizar la contraseña
	private void togglePasswordVisibility() {
		// Si el echoChar es '•', cambiar a mostrar texto, de lo contrario, ocultar
		// texto
		char echoChar = (inputPassword.getEchoChar() == '\u2022') ? '\u0000' : '\u2022';
		// Establecer el echoChar según la lógica anterior
		inputPassword.setEchoChar(echoChar);
		// Cambiar el icono según el echoChar
		toggleButton.setIcon((echoChar == '\u2022') ? new ImageIcon(getClass().getResource("/assets/icons/ver.png"))
				: new ImageIcon(getClass().getResource("/assets/icons/nover.png")));
	}

	// Métodos para ahorrar los action listener
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(linkRegister)) {
			Register registro = new Register(this, controladorRutas, true, oscuro);
			registro.setVisible(true);
			setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(toggleButton)) {
			togglePasswordVisibility();
		}
		if (e.getSource().equals(btnLogin)) {
			logicaLogin();
		}
	}

	public void logicaLogin() {
		// Obtener los valores de correo electrónico y contraseña de los campos de
		// entrada
		String email = inputEmail.getText().trim();
		String password = new String(inputPassword.getPassword());
		boolean correcto = false;
		// Establezco los datos introducidos en los campos de email y contraseña al
		// objeto persona
		persona.setEmail(email);
		persona.setContrasena(password);

		// Comprobamos a traves de la interfaz si la cuenta existe
		controladorRutas = new Controlador();
		persona = controladorRutas.iniciarSesion(persona);

		// Si la persona no tiene ningún dato le mandamos error
		correcto = camposVacios(correcto);
		if (correcto == true) {
			borrar();
			JOptionPane.showMessageDialog(this, "Por favor, introduzca todos los campos obligatorios.",
					"Campos obligatorios incompletos", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error
		} else {

			if (persona != null) {
				Main ven = new Main(this, true, controladorRutas);
				super.dispose();
				ven.setVisible(true);
			}
		}

	}

	// Metodo para recoger los campos vacios de los input
	private boolean camposVacios(boolean correcto) {
		if (inputEmail.getText().trim().isEmpty() || new String(inputPassword.getPassword()).trim().isEmpty()) {
			correcto = true;
		} else {
			correcto = false;
		}
		return correcto;

	}

	// Limpiamos los datos tecleados del formulario
	private void borrar() {
		inputEmail.setText("");
		inputEmail.requestFocus();
		inputPassword.setText("");
	}

	// Implementación de los métodos MouseListener (no son necesarios, pero necesito
	// implemenetarlos en la clase si quiero hacer lo de los eventos)
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}