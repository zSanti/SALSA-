package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZoneId;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import clases.Persona;
import clases.Sexo;
import clases.Trabajador;
import clases.Usuario;
import controller.Controlador;

public class Register extends JFrame implements ActionListener{

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

	/**
	 * Create the frame.
	 */
	public Register(boolean oscuro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setSize(700, 722);
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().setBackground(new Color(255, 255, 255));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		getContentPane().setLayout(null);

		textNombre = new JTextField();
		textNombre.setBounds(64, 126, 237, 29);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		lblNombre = new JLabel("Nombre *");
		lblNombre.setBounds(64, 101, 78, 14);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblNombre);

		textEmail = new JTextField();
		textEmail.setBounds(64, 191, 237, 29);
		textEmail.setColumns(10);
		getContentPane().add(textEmail);

		lblEmail = new JLabel("Email *");
		lblEmail.setBounds(64, 166, 49, 14);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblEmail);

		lblContrasena = new JLabel("Contraseña*");
		lblContrasena.setBounds(64, 231, 147, 14);
		lblContrasena.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblContrasena);

		textContraseña = new JTextField();
		textContraseña.setBounds(64, 256, 237, 29);
		textContraseña.setColumns(10);
		getContentPane().add(textContraseña);

		textDni = new JTextField();
		textDni.setBounds(64, 321, 237, 29);
		textDni.setColumns(10);
		getContentPane().add(textDni);

		lblDni = new JLabel("DNI*");
		lblDni.setBounds(64, 296, 147, 14);
		lblDni.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblDni);

		// Grupo de sexo
		generoGrupo = new ButtonGroup();

		rBFemenino = new JRadioButton("Femenino");
		rBFemenino.setBounds(64, 395, 91, 23);
		generoGrupo.add(rBFemenino);
		rBFemenino.setBackground(new Color(255, 255, 255));
		getContentPane().add(rBFemenino);

		rBMasculino = new JRadioButton("Masculino");
		rBMasculino.setBounds(162, 395, 99, 23);
		generoGrupo.add(rBMasculino);
		rBMasculino.setBackground(new Color(255, 255, 255));
		getContentPane().add(rBMasculino);

		lblFecNa = new JLabel("Fecha de nacimiento ");
		lblFecNa.setBounds(407, 361, 147, 14);
		lblFecNa.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblFecNa);

		lblPrimerApellido = new JLabel("Primer apellido*");
		lblPrimerApellido.setBounds(407, 101, 131, 14);
		lblPrimerApellido.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblPrimerApellido);

		textApellido = new JTextField();
		textApellido.setBounds(407, 126, 237, 29);
		textApellido.setColumns(10);
		getContentPane().add(textApellido);

		tFEmailConfirmado = new JTextField();
		tFEmailConfirmado.setBounds(407, 191, 237, 29);
		tFEmailConfirmado.setColumns(10);
		getContentPane().add(tFEmailConfirmado);

		lblConfirmarEmail = new JLabel("Confirmar Email *");
		lblConfirmarEmail.setBounds(407, 166, 138, 14);
		lblConfirmarEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblConfirmarEmail);

		tFContraeñaConfirmada = new JTextField();
		tFContraeñaConfirmada.setBounds(407, 256, 237, 29);
		tFContraeñaConfirmada.setColumns(10);
		getContentPane().add(tFContraeñaConfirmada);

		lblConfirmeLaContrasea = new JLabel("Confirma la contraseña*");
		lblConfirmeLaContrasea.setBounds(407, 231, 147, 14);
		lblConfirmeLaContrasea.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblConfirmeLaContrasea);

		textDireccion = new JTextField();
		textDireccion.setBounds(407, 321, 237, 29);
		textDireccion.setColumns(10);
		getContentPane().add(textDireccion);

		lblDireccion = new JLabel("Dirección *");
		lblDireccion.setBounds(407, 296, 147, 14);
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblDireccion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(235, 11, 278, 62);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/assets/logo.png")));
		getContentPane().add(lblNewLabel);

		rBOtros = new JRadioButton("Otros");
		rBOtros.setBounds(64, 421, 111, 23);
		generoGrupo.add(rBOtros);
		rBOtros.setBackground(new Color(255, 255, 255));
		getContentPane().add(rBOtros);

		JLabel lblDireccion_1 = new JLabel("");
		lblDireccion_1.setBounds(321, 450, 147, 14);
		getContentPane().add(lblDireccion_1);

		lblSexo_1 = new JLabel("Sexo");
		lblSexo_1.setBounds(64, 374, 49, 14);
		lblSexo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblSexo_1);

		btnRegistro = new JButton("Enviar los datos");
		btnRegistro.setBounds(216, 591, 286, 38);
		btnRegistro.setForeground(new Color(255, 255, 255));
		btnRegistro.addActionListener(this);
		btnRegistro.setBackground(new Color(0, 0, 255));
		getContentPane().add(btnRegistro);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBounds(407, 386, 165, 23);
		dateFechaNacimiento.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(dateFechaNacimiento);

		lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setBounds(64, 569, 286, 14);
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblCamposObligatorios);
		// if (checkBoxUsuario.isSelected()) {
		checkBoxUsuario = new JCheckBox("Usuario");
		checkBoxUsuario.setBounds(64, 507, 99, 23);
		checkBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarUsuario();
			}

		});
		checkBoxUsuario.setBackground(new Color(255, 255, 255));
		generoGrupo.add(checkBoxUsuario);
		getContentPane().add(checkBoxUsuario);

		checkBoxTrabajador = new JCheckBox("Trabajador");
		checkBoxTrabajador.setBounds(162, 507, 99, 23);
		checkBoxTrabajador.setBackground(new Color(255, 255, 255));
		generoGrupo.add(checkBoxTrabajador);
		getContentPane().add(checkBoxTrabajador);

		Seleccione = new JLabel("Seleccione");
		Seleccione.setBounds(64, 467, 131, 14);
		Seleccione.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(Seleccione);

		lblFechaDeRegistro = new JLabel("Fecha de registro ");
		lblFechaDeRegistro.setBounds(407, 507, 147, 14);
		lblFechaDeRegistro.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblFechaDeRegistro);

		dateFRegistro = new JDateChooser();
		dateFRegistro.setBounds(407, 532, 165, 23);
		getContentPane().add(dateFRegistro);

		textNumeroSS = new JTextField();
		textNumeroSS.setBounds(403, 442, 237, 29);
		textNumeroSS.setColumns(10);
		getContentPane().add(textNumeroSS);

		lblNmeroSeguridadSocial = new JLabel("Número Seguridad Social *");
		lblNmeroSeguridadSocial.setBounds(407, 420, 214, 14);
		lblNmeroSeguridadSocial.setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().add(lblNmeroSeguridadSocial);
		
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
		
		if (oscuro) {
			cambioFondo();
	}

}
	private void cambioFondo() {
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
	}
	
	protected void inicioSesion(boolean oscuro) {
		Login log = new Login(oscuro);
		log.setVisible(true);
		setVisible(false);
		
	}
	
	private void seleccionarUsuario() {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistro)) {
			registrarPersona();
		}
	}
	private void cerrar() {
		this.dispose();

	}
	
	private void registrarPersona() {
		Persona persona = null;

		if (checkBoxUsuario.isSelected()) {
			persona = new Usuario();
			cargarDatosComunes(persona);

			((Usuario) persona)
					.setFechaRegistro(dateFRegistro.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			// Deshabilitar el campo de número de seguridad social
			textNumeroSS.setEnabled(false);

			lblFechaDeRegistro.setVisible(true);
			dateFRegistro.setVisible(true);

		} else if (checkBoxTrabajador.isSelected()) {
			persona = new Trabajador();

			cargarDatosComunes(persona);
			((Trabajador) persona).setNnss(textNumeroSS.getText());

			// Habilitar el campo de número de seguridad social
			textNumeroSS.setEnabled(true);
			// Mostrar el label y el campo de fecha de registro
			lblFechaDeRegistro.setVisible(false);
			dateFRegistro.setVisible(false);

		}

		cont.registrarUsuario(persona);
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
				String textRadio = radio.getText();
				sexo = Sexo.valueOf(textRadio);
			}

		}
	}
	}
