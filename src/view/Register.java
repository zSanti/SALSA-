package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.ZoneId;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
	private JTextField textDni;
	private JTextField textApellido;
	private JTextField tFEmailConfirmado;
	private JTextField textDireccion;
	private ButtonGroup perfilGrupo = new ButtonGroup();
	private JCheckBox checkBoxUsuario, checkBoxTrabajador;

	private JTextField textNumeroSS;
	private JButton btnRegistro;
	private JDateChooser dateFRegistro;
	private JDateChooser dateFechaNacimiento;
	private JLabel lblFechaDeRegistro;
	private JLabel lblNmeroSeguridadSocial;
	private JPasswordField passConfirmar;
	private JPasswordField passContrasena;

	private JComboBox<Sexo> comboBoxGenero;

	public Register(Login padre, boolean modal) {
		super(padre);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				padre.setVisible(true);
			}
		});
		setModal(modal);
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
		checkBoxUsuario = new JCheckBox("Usuario", false);
		checkBoxUsuario.addActionListener(this);
		checkBoxUsuario.setBackground(new Color(255, 255, 255));
		getContentPane().add(checkBoxUsuario);
		checkBoxUsuario.setBounds(64, 507, 99, 23);
		getContentPane().add(checkBoxUsuario);

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

		comboBoxGenero = new JComboBox<>();
		comboBoxGenero.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxGenero.setModel(new DefaultComboBoxModel<>(Sexo.values()));
		comboBoxGenero.setToolTipText("");
		comboBoxGenero.setEditable(true);
		comboBoxGenero.setBounds(64, 406, 131, 21);
		getContentPane().add(comboBoxGenero);

		// No se muestran los campos específicos de cada perfil
		// Deshabilitar el campo de número de seguridad social
		lblNmeroSeguridadSocial.setVisible(false);
		textNumeroSS.setVisible(false);
		// Mostrar el label y el campo de fecha de registro
		lblFechaDeRegistro.setVisible(false);
		dateFRegistro.setVisible(false);
	}

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
			} else if (btnRegistro.isShowing() && camposObligatoriosCompletos() == true) {
				this.dispose();
			}
		}
	}

	private boolean camposObligatoriosCompletos() {

		boolean correcto = false;
		char[] contrasena = passContrasena.getPassword();
		char[] confirmarContrasena = passConfirmar.getPassword();
		// comprobacion de que todos los campos que sean rellenados
		// si los campos obligatorios no estan rellenados salta el mensaje de error
		if (!textNombre.getText().isEmpty() && contrasena.length > 0 && !textEmail.getText().isEmpty()
				&& confirmarContrasena.length > 0 && (checkBoxUsuario.isSelected() || checkBoxTrabajador.isSelected())
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

		persona.setApellido(textApellido.getText());
		persona.setNombre(textNombre.getText());
		persona.setDni(textDni.getText());
		persona.setEmail(textEmail.getText());
		persona.setFechaNacimiento(
				dateFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		persona.setDireccion(textDireccion.getText());
		persona.setContrasena(new String(passContrasena.getPassword()));
		persona.setGenero((Sexo) comboBoxGenero.getSelectedItem());

	}
	// }

}