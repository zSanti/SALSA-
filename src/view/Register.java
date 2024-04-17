package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textContraseña;
	private JTextField textDni;
	private JTextField textApellido;
	private JTextField tFEmailConfirmado;
	private JTextField tFContraeñaConfirmada;
	private JTextField textDireccion;
	private ButtonGroup generoGrupo = new ButtonGroup();
	private JCheckBox checkBoxUsuario;
	private JCheckBox checkBoxTrabajador;
	private JTextField textNumeroSS;
	private JButton btnRegistro;
	private JDateChooser dateFRegistro;
	private JDateChooser dateFechaNacimiento;
	private JRadioButton rBFemenino;
	private JRadioButton rBMasculino;
	private JRadioButton rBOtros;
	private Controlador cont;

	public Register(Controlador cont) {
		this.cont = cont;
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().setBackground(new Color(255, 255, 255));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
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

		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(64, 256, 237, 29);
		getContentPane().add(textContraseña);

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
		rBMasculino.setBounds(162, 395, 111, 23);
		getContentPane().add(rBMasculino);

		JLabel lblSexo = new JLabel("Fecha de nacimiento ");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSexo.setBounds(407, 361, 147, 14);
		getContentPane().add(lblSexo);

		JLabel lblPrimerApellido = new JLabel("Primer apellido*");
		lblPrimerApellido.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPrimerApellido.setBounds(407, 101, 131, 14);
		getContentPane().add(lblPrimerApellido);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(407, 126, 237, 29);
		getContentPane().add(textApellido);

		tFEmailConfirmado = new JTextField();
		tFEmailConfirmado.setColumns(10);
		tFEmailConfirmado.setBounds(407, 191, 237, 29);
		getContentPane().add(tFEmailConfirmado);

		JLabel lblConfirmarEmail = new JLabel("Confirmar Email *");
		lblConfirmarEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConfirmarEmail.setBounds(407, 166, 138, 14);
		getContentPane().add(lblConfirmarEmail);

		tFContraeñaConfirmada = new JTextField();
		tFContraeñaConfirmada.setColumns(10);
		tFContraeñaConfirmada.setBounds(407, 256, 237, 29);
		getContentPane().add(tFContraeñaConfirmada);

		JLabel lblConfirmeLaContrasea = new JLabel("Confirma la contraseña*");
		lblConfirmeLaContrasea.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConfirmeLaContrasea.setBounds(407, 231, 147, 14);
		getContentPane().add(lblConfirmeLaContrasea);

		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(407, 321, 237, 29);
		getContentPane().add(textDireccion);

		JLabel lblDireccion = new JLabel("Dirección *");
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDireccion.setBounds(407, 296, 147, 14);
		getContentPane().add(lblDireccion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\vlede\\OneDrive\\Escritorio\\RetoTerceraEvaluacion\\src\\assets\\logo.png"));
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
		btnRegistro.addActionListener(this);
		btnRegistro.setBackground(new Color(0, 0, 255));
		btnRegistro.setBounds(221, 629, 286, 38);
		getContentPane().add(btnRegistro);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateFechaNacimiento.setBounds(407, 386, 165, 23);
		getContentPane().add(dateFechaNacimiento);

		JLabel lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCamposObligatorios.setBounds(64, 604, 286, 14);
		getContentPane().add(lblCamposObligatorios);

		checkBoxUsuario = new JCheckBox("Usuario");
		checkBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarUsuario();
			}

		});
		checkBoxUsuario.setBackground(new Color(255, 255, 255));
		generoGrupo.add(checkBoxUsuario);
		checkBoxUsuario.setBounds(64, 507, 99, 23);
		getContentPane().add(checkBoxUsuario);

		checkBoxTrabajador = new JCheckBox("Trabajador");
		checkBoxTrabajador.setBackground(new Color(255, 255, 255));
		generoGrupo.add(checkBoxTrabajador);
		checkBoxTrabajador.setBounds(162, 507, 99, 23);
		getContentPane().add(checkBoxTrabajador);

		JLabel Seleccione = new JLabel("Seleccione");
		Seleccione.setFont(new Font("Tahoma", Font.BOLD, 11));
		Seleccione.setBounds(64, 467, 131, 14);
		getContentPane().add(Seleccione);

		JLabel lblFechaDeRegistro = new JLabel("Fecha de registro ");
		lblFechaDeRegistro.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFechaDeRegistro.setBounds(407, 507, 147, 14);
		getContentPane().add(lblFechaDeRegistro);

		dateFRegistro = new JDateChooser();
		dateFRegistro.setBounds(407, 532, 165, 23);
		getContentPane().add(dateFRegistro);

		textNumeroSS = new JTextField();
		textNumeroSS.setColumns(10);
		textNumeroSS.setBounds(403, 442, 237, 29);
		getContentPane().add(textNumeroSS);

		JLabel lblNmeroSeguridadSocial = new JLabel("Número Seguridad Social *");
		lblNmeroSeguridadSocial.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNmeroSeguridadSocial.setBounds(407, 420, 214, 14);
		getContentPane().add(lblNmeroSeguridadSocial);
	}

	/**
	 * 
	 */

	private void seleccionarUsuario() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistro)) {
			registrarPersona();
		}

	}

	private void registrarPersona() {
		Persona persona;

		if (checkBoxUsuario.isSelected()) {
			persona = new Usuario();
			cargarDatosComunes(persona);

			((Usuario) persona)
					.setFechaRegistro(dateFRegistro.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		} else {
			persona = new Trabajador();

			cargarDatosComunes(persona);
			((Trabajador) persona).setNnss(textNumeroSS.getText());

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