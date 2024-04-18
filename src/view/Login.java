package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Persona;
import controller.Dao;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JPanel BodyLayout;
    private JLabel logo, labelEmail, labelPassword, labelNoRegister, linkRegister;
    private JTextField inputEmail;
    private JPasswordField inputPassword;
    private JButton toggleButton, btnLogin;
    
    // 
    private Dao dao;

	/**
	 * Create the frame.
	 */
	public Login(Dao dao) {
		this.dao = dao;
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 931, 574);
        BodyLayout = new JPanel();
        BodyLayout.setBackground(new Color(255, 255, 255));
        BodyLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(BodyLayout);
        BodyLayout.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/logo.png"));
        
        
        
        // Division Login
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(0, 128, 255));
        panelLeft.setBounds(0, 0, 416, 539);
        BodyLayout.add(panelLeft);
        panelLeft.setLayout(null);

        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(255, 255, 255));
        panelRight.setBounds(414, 0, 501, 539);
        BodyLayout.add(panelRight);
        panelRight.setLayout(null);
        
        toggleButton = new JButton(new ImageIcon(getClass().getResource("/assets/icons/nover.png"))); // Establece el icono "nover" por defecto
        toggleButton.setBounds(412, 313, 29, 20);
        toggleButton.addActionListener(this);
        toggleButton.setOpaque(false); // Establece el botón como transparente
        toggleButton.setContentAreaFilled(false); // No rellena el área del botón
        toggleButton.setBorderPainted(false);
        panelRight.add(toggleButton);
        
        // Logo centrado
        logo = new JLabel("");
        logo.setBounds(132, 66, 245, 51);
        panelRight.add(logo);
        ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
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
        btnLogin.addActionListener(this);
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
        linkRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Crear una instancia de la vista Login
                Register registro = new Register(dao);
                registro.setVisible(true);
                setVisible(false);
            }
        });
        panelRight.add(linkRegister);
        
    }
	
	// Método para ahorrar los action listener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(toggleButton)) {
			 togglePasswordVisibility();
		}
		if (e.getSource().equals(btnLogin)) {
			conectarseUsuario();
		}
	}
	
	// Metodo para que el usuario se conecte y inicie sesion
	private void conectarseUsuario() {
		// Creamos un nuevo objeto usuario
		Persona persona = new Persona();
		persona.setEmail(inputEmail.getText().toLowerCase().trim());
		persona.setContrasena(String.valueOf(inputPassword.getPassword()).trim());
		
		// Comprobamos a traves de la interfaz si la cuenta existe
		dao.comprobarUsuario(persona);
		
		// Si el usuario tiene un rol le mostramos la ventana, si no le mostramos que no existe
//		if (persona.getRol() != null) {
//			Main ventanaPrincipal = new Main(true, this, dao, persona);
//			ventanaPrincipal.setLocationRelativeTo(this);
//			ventanaPrincipal.setVisible(true);
//		} else {
//			JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
//		}
		borrar();
		
	}
	
	// Borramos los datos tecleados del formulario
	private void borrar() {
		inputEmail.setText("");
		inputEmail.requestFocus();
		inputPassword.setText("");
	}
	
	// Visualizar/Desvisualizar la contraseña
	private void togglePasswordVisibility() {
		// Si el echoChar es '•', cambiar a mostrar texto, de lo contrario, ocultar texto
	    char echoChar = (inputPassword.getEchoChar() == '\u2022') ? '\u0000' : '\u2022';
	    // Establecer el echoChar según la lógica anterior
	    inputPassword.setEchoChar(echoChar);
	    // Cambiar el icono según el echoChar
	    toggleButton.setIcon((echoChar == '\u2022') ? new ImageIcon(getClass().getResource("/assets/icons/ver.png")) : new ImageIcon(getClass().getResource("/assets/icons/nover.png")));
	}

}