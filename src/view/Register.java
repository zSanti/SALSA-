package view;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.ZoneId;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import clases.Persona;
import clases.Sexo;
import clases.Trabajador;
import clases.Usuario;
import controller.Controlador;

public class Register extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre, textEmail, textContraseña, textDni, textApellido, tFEmailConfirmado, tFContraeñaConfirmada, textDireccion, textNumeroSS;
	private ButtonGroup generoGrupo = new ButtonGroup();
	private JCheckBox checkBoxUsuario, checkBoxTrabajador;
	private JButton btnRegistro;
	private JDateChooser dateFRegistro, dateFechaNacimiento;
	private JRadioButton rBFemenino, rBMasculino, rBOtros;
	private static Controlador cont;
	private JLabel lblFechaDeRegistro, lblIniciaSesion, lblPregunta, lblInicioSesion, lblNombre, lblEmail, lblContrasena, lblDni, lblSexo_1, lblPrimerApellido, lblConfirmarEmail, lblConfirmeLaContrasea, lblDireccion, lblNmeroSeguridadSocial, Seleccione, lblCamposObligatorios, lblFecNa;
	private JPasswordField passConfirmar;
	private JPasswordField passContrasena;

	public Register(Controlador cont, Login padre, boolean modal, boolean oscuro) {
		super(padre);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				padre.setVisible(true);
			}
		});
		setModal(modal);
		this.cont = cont;
		setSize(729, 700);
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().setBackground(new Color(255, 255, 255));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		getContentPane().setLayout(null);

		textNombre = new JTextField();
		textNombre.setBounds(64, 126, 237, 29);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombre.setBounds(64, 101, 78, 14);
		getContentPane().add(lblNombre);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(64, 191, 237, 29);
		getContentPane().add(textEmail);

		JLabel lblEmail = new JLabel("Email *");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEmail.setBounds(64, 166, 49, 14);
		getContentPane().add(lblEmail);

		JLabel lblContrasena = new JLabel("Contraseña*");
		lblContrasena.setFont(new Font("Dialog", Font.BOLD, 12));
		lblContrasena.setBounds(64, 231, 147, 14);
		getContentPane().add(lblContrasena);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(64, 321, 237, 29);
		getContentPane().add(textDni);

		JLabel lblDni = new JLabel("DNI*");
		lblDni.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDni.setBounds(64, 296, 147, 14);
		getContentPane().add(lblDni);

		// Grupo de sexo
		generoGrupo = new ButtonGroup();

		rBFemenino = new JRadioButton("Femenino");
		generoGrupo.add(rBFemenino);
		rBFemenino.setBackground(new Color(255, 255, 255));
		rBFemenino.setBounds(64, 395, 111, 23);
		getContentPane().add(rBFemenino);

		rBMasculino = new JRadioButton("Masculino");
		generoGrupo.add(rBMasculino);
		rBMasculino.setBackground(new Color(255, 255, 255));
		rBMasculino.setBounds(190, 395, 111, 23);
		getContentPane().add(rBMasculino);

		JLabel lblSexo = new JLabel("Fecha de nacimiento ");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSexo.setBounds(456, 361, 147, 14);
		getContentPane().add(lblSexo);

		JLabel lblPrimerApellido = new JLabel("Primer apellido*");
		lblPrimerApellido.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPrimerApellido.setBounds(456, 101, 131, 14);
		getContentPane().add(lblPrimerApellido);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(456, 126, 237, 29);
		getContentPane().add(textApellido);

		tFEmailConfirmado = new JTextField();
		tFEmailConfirmado.setColumns(10);
		tFEmailConfirmado.setBounds(456, 191, 237, 29);
		getContentPane().add(tFEmailConfirmado);

		JLabel lblConfirmarEmail = new JLabel("Confirmar Email *");
		lblConfirmarEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConfirmarEmail.setBounds(456, 166, 138, 14);
		getContentPane().add(lblConfirmarEmail);

		JLabel lblConfirmeLaContrasea = new JLabel("Confirma la contraseña*");
		lblConfirmeLaContrasea.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConfirmeLaContrasea.setBounds(456, 231, 147, 14);
		getContentPane().add(lblConfirmeLaContrasea);

		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(456, 321, 237, 29);
		getContentPane().add(textDireccion);

		JLabel lblDireccion = new JLabel("Dirección *");
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDireccion.setBounds(456, 296, 147, 14);
		getContentPane().add(lblDireccion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/assets/logo.png")));
		lblNewLabel.setBounds(235, 11, 278, 62);
		getContentPane().add(lblNewLabel);

		rBOtros = new JRadioButton("Otros");
		generoGrupo.add(rBOtros);
		rBOtros.setBackground(new Color(255, 255, 255));
		rBOtros.setBounds(64, 421, 111, 23);
		getContentPane().add(rBOtros);

		JLabel lblDireccion_1 = new JLabel("");
		lblDireccion_1.setBounds(321, 450, 147, 14);
		getContentPane().add(lblDireccion_1);

		JLabel lblSexo_1 = new JLabel("Sexo");
		lblSexo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSexo_1.setBounds(64, 374, 49, 14);
		getContentPane().add(lblSexo_1);

		btnRegistro = new JButton("Enviar los datos");
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.addActionListener(this);
		btnRegistro.setBackground(new Color(0, 0, 255));
		btnRegistro.setBounds(227, 575, 286, 38);
		getContentPane().add(btnRegistro);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.getCalendarButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateFechaNacimiento.setBounds(456, 386, 165, 23);
		getContentPane().add(dateFechaNacimiento);

		JLabel lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCamposObligatorios.setBounds(122, 550, 286, 14);
		getContentPane().add(lblCamposObligatorios);
		// if (checkBoxUsuario.isSelected()) {
//		checkBoxUsuario = new JCheckBox("Usuario");
//		checkBoxUsuario.addActionListener(this);
//		checkBoxUsuario.setBackground(new Color(255, 255, 255));
//		perfilGrupo.add(checkBoxUsuario);
//		checkBoxUsuario.setBounds(64, 507, 99, 23);
//		getContentPane().add(checkBoxUsuario);
		checkBoxUsuario = new JCheckBox("Usuario", false);
		checkBoxUsuario.addActionListener(this);
		checkBoxUsuario.setBackground(new Color(255, 255, 255));
		getContentPane().add(checkBoxUsuario);
		checkBoxUsuario.setBounds(64, 507, 99, 23);
		getContentPane().add(checkBoxUsuario);

//		checkBoxTrabajador = new JCheckBox("Trabajador");
//		checkBoxTrabajador.setBackground(new Color(255, 255, 255));
//		perfilGrupo.add(checkBoxTrabajador);
//		checkBoxTrabajador.setBounds(162, 507, 99, 23);
//		getContentPane().add(checkBoxTrabajador);
//		checkBoxTrabajador.addActionListener(this);
		checkBoxTrabajador = new JCheckBox("Trabajador", false);
		checkBoxTrabajador.setBackground(new Color(255, 255, 255));
		getContentPane().add(checkBoxTrabajador);
		checkBoxTrabajador.setBounds(162, 507, 99, 23);
		getContentPane().add(checkBoxTrabajador);
		checkBoxTrabajador.addActionListener(this);

		JLabel Seleccione = new JLabel("Seleccione");
		Seleccione.setFont(new Font("Tahoma", Font.BOLD, 11));
		Seleccione.setBounds(64, 467, 131, 14);
		getContentPane().add(Seleccione);

		lblFechaDeRegistro = new JLabel("Fecha de registro ");
		lblFechaDeRegistro.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFechaDeRegistro.setBounds(456, 497, 147, 14);
		getContentPane().add(lblFechaDeRegistro);

		dateFRegistro = new JDateChooser();
		dateFRegistro.setBounds(456, 522, 165, 23);
		getContentPane().add(dateFRegistro);

		textNumeroSS = new JTextField();
		textNumeroSS.setColumns(10);
		textNumeroSS.setBounds(456, 450, 237, 29);
		getContentPane().add(textNumeroSS);

		lblNmeroSeguridadSocial = new JLabel("Número Seguridad Social *");
		lblNmeroSeguridadSocial.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNmeroSeguridadSocial.setBounds(456, 424, 214, 14);
		getContentPane().add(lblNmeroSeguridadSocial);

		passConfirmar = new JPasswordField();
		passConfirmar.setBounds(456, 256, 237, 29);
		getContentPane().add(passConfirmar);

		passContrasena = new JPasswordField();
		passContrasena.setBounds(64, 256, 237, 29);
		getContentPane().add(passContrasena);

		// No se muestran los campos específicos de cada perfil
		// Deshabilitar el campo de número de seguridad social
		lblNmeroSeguridadSocial.setVisible(false);
		textNumeroSS.setVisible(false);
		// Mostrar el label y el campo de fecha de registro
		lblFechaDeRegistro.setVisible(false);
		dateFRegistro.setVisible(false);
		
		lblPregunta = new JLabel("¿Ya tienes cuenta?");
		lblPregunta.setBounds(262, 650, 114, 13);
		getContentPane().add(lblPregunta);
		
		lblInicioSesion = new JLabel("Inicia Sesion");
		lblInicioSesion.setBounds(375, 650, 78, 13);
		lblInicioSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inicioSesion(oscuro);
			}
		});
		lblInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInicioSesion.setForeground(new Color(0, 51, 255));
		getContentPane().add(lblInicioSesion);
		
		//if (oscuro) {
		//	cambioFondo();
//	}
	}


	protected void inicioSesion(boolean oscuro) {
		Login log = new Login(cont, oscuro);
		log.setVisible(true);
		setVisible(false);
		
	}
	
/*	private void cambioFondo() {
		contentPane.setBackground(Color.DARK_GRAY);
		lblFechaDeRegistro.setForeground(Color.WHITE);
		lblConfirmarEmail.setForeground(Color.WHITE);
		lblConfirmeLaContrasea.setForeground(Color.WHITE);
		lblContrasena.setForeground(Color.WHITE);
		lblDireccion.setForeground(Color.WHITE);
		lblDni.setForeground(Color.WHITE);
		lblEmail.setForeground(Color.WHITE);
		lblNombre.setForeground(Color.WHITE);
		lblPrimerApellido.setForeground(Color.WHITE);
		lblFecNa.setForeground(Color.WHITE);
		lblCamposObligatorios.setForeground(Color.WHITE);
		Seleccione.setForeground(Color.WHITE);
		lblNmeroSeguridadSocial.setForeground(Color.WHITE);
		lblPregunta.setForeground(Color.WHITE);
		lblSexo_1.setForeground(Color.WHITE);
		
	}*/
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistro)) {
			if (camposObligatoriosCompletos() == true) {
				registrarPersona();
			}

		}
		if (e.getSource().equals(checkBoxUsuario)) {
			seleccionarUsuario();
		}
		if (e.getSource().equals(checkBoxTrabajador)) {
			seleccionarTrabajador();
		}
		if (e.getSource().equals(btnRegistro)) {
			if (btnRegistro.isShowing() && camposObligatoriosCompletos() == false) {
				JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.",
						"Campos obligatorios incompletos", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private boolean camposObligatoriosCompletos() {
		boolean correcto = false;
		char[] contrasena = passContrasena.getPassword();
		char[] confirmarContrasena = passConfirmar.getPassword();
		if (!textNombre.getText().isEmpty() && contrasena.length > 0 && !textEmail.getText().isEmpty()
				&& confirmarContrasena.length > 0
				&& (rBFemenino.isSelected() || rBMasculino.isSelected() || rBOtros.isSelected())
				&& (checkBoxUsuario.isSelected() || checkBoxTrabajador.isSelected())
				&& dateFechaNacimiento.getDate() != null) {
			correcto = true;

		}
		return correcto;
	}

	private void seleccionarUsuario() {
		if (checkBoxUsuario.isSelected()) {
			// Deshabilitar el campo de número de seguridad social
			lblNmeroSeguridadSocial.setVisible(false);
			textNumeroSS.setVisible(false);
			// Mostrar el label y el campo de fecha de registro
			lblFechaDeRegistro.setVisible(true);
			dateFRegistro.setVisible(true);

		}
	}

	private void seleccionarTrabajador() {
		if (checkBoxTrabajador.isSelected()) {
			// Deshabilitar el campo de número de seguridad social
			lblNmeroSeguridadSocial.setVisible(true);
			textNumeroSS.setVisible(true);
			// Mostrar el label y el campo de fecha de registro
			lblFechaDeRegistro.setVisible(false);
			dateFRegistro.setVisible(false);

		}

	}

	private void registrarPersona() {
		Persona persona = null;
		if (checkBoxUsuario.isSelected()) {
			persona = new Usuario();
			cargarDatosComunes(persona);

			((Usuario) persona)
					.setFechaRegistro(dateFRegistro.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		} else if (checkBoxTrabajador.isSelected()) {
			persona = new Trabajador();

			cargarDatosComunes(persona);
			((Trabajador) persona).setNnss(textNumeroSS.getText());

		}

		Controlador.registrarUsuario(persona);
	}

	private void cargarDatosComunes(Persona persona) {
		Sexo sexo;
		persona.setApellido(textApellido.getText());
		persona.setNombre(textNombre.getText());
		persona.setDni(textDni.getText());
		persona.setEmail(textEmail.getText());
		persona.setFechaNacimiento(
				dateFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		persona.setDireccion(textDireccion.getText());

		// Lo que hace es pasar esto a una lista todos los radio buttons
		Enumeration<AbstractButton> radios = generoGrupo.getElements();
		// Luego lo que haremos es recorrer todos los elementos de esta lista
		while (radios.hasMoreElements()) {
			// Obtiene el próximo elemento de laenumeración y lo asignamos a una variable
			// radio
			JRadioButton radio = (JRadioButton) radios.nextElement();

			// Si coincide que el botón de radio esta seleccionado, agregamos su texto(que
			// representa el sexo) al área de texto.

			if (radio.isSelected()) {
				String textRadio = radio.getText().toUpperCase();
				sexo = Sexo.valueOf(textRadio);
			}

		}

	}
}