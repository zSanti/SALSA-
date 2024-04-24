package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Dao;

public class Ajustes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logo, labelTema, labelClaro, labelOscuro, lblTiendaIdioma, lblEmail, lblUsuario;
	private JSlider slider;
	private JComboBox comboBox;
	private JSeparator separator_2;
	private JTextField textField, textField_1;

	// Comprobar si anda en modo diurno o nocturno
	private boolean oscuro;

	public Ajustes(Dao dao, boolean oscuro) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/assets/logo.png")));
		logo.setBounds(177, 42, 245, 51);
		logo.setBackground(Color.WHITE);
		contentPane.add(logo);

		slider = new JSlider();
		slider.setBounds(203, 188, 200, 22);
		slider.setMinimum(0);
		slider.setMaximum(1);
		slider.setValue(oscuro ? 1 : 0);
		slider.setOpaque(false);
		contentPane.add(slider);

		labelTema = new JLabel("Tema");
		labelTema.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelTema.setBounds(281, 162, 59, 21);
		contentPane.add(labelTema);

		labelClaro = new JLabel("Claro");
		labelClaro.setBounds(164, 185, 38, 22);
		contentPane.add(labelClaro);

		labelOscuro = new JLabel("Oscuro");
		labelOscuro.setBounds(409, 185, 48, 22);
		contentPane.add(labelOscuro);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(dao ,oscuro);
			}
		});
		btnVolver.setBounds(10, 10, 85, 21);
		contentPane.add(btnVolver);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 125, 592, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(164, 239, 276, 2);
		contentPane.add(separator_1);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Español", "Portugués", "Inglés", "Ruso", "Alemán", "Sueco" }));
		comboBox.setToolTipText("");
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(269, 251, 134, 21);
		contentPane.add(comboBox);

		lblTiendaIdioma = new JLabel("Idioma Tienda");
		lblTiendaIdioma.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiendaIdioma.setBounds(177, 255, 93, 13);
		contentPane.add(lblTiendaIdioma);

		separator_2 = new JSeparator();
		separator_2.setBounds(164, 282, 276, 2);
		contentPane.add(separator_2);

		lblUsuario = new JLabel("Nombre de Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsuario.setBounds(149, 298, 99, 13);
		contentPane.add(lblUsuario);

		textField = new JTextField();
		textField.setBounds(258, 291, 145, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(217, 344, 31, 13);
		contentPane.add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(258, 337, 145, 28);
		contentPane.add(textField_1);

		// Registra un ChangeListener para detectar cambios en el JSlider
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiarTema(slider.getValue()); // Llama al método cambiarTema con el valor actual del slider
			}
		});

		cargarPreferenciaTema();
	}

	private void cargarPreferenciaTema() {
		// Obtener las preferencias compartidas para la clase Ajustes
		Preferences prefs = Preferences.userNodeForPackage(Ajustes.class);
		// Obtener la preferencia del tema guardada, con un valor predeterminado de
		// falso (tema claro)
		oscuro = prefs.getBoolean("temaOscuro", true);
		// Aplicar el tema según la preferencia cargada
		cambiarTema(oscuro ? 1 : 0);
	}

	protected void volver(Dao dao, boolean oscuro) {
		Hamburger ham = new Hamburger(dao, oscuro);
		ham.setVisible(true);
		setVisible(false);
	}

	// Método para cambiar el tema de la aplicación según el valor del slider
	private void cambiarTema(int valor) {
		if (valor == 0) {
			// Cambiar al tema claro
			contentPane.setBackground(Color.WHITE);
			labelTema.setForeground(Color.BLACK);
			labelClaro.setForeground(Color.BLACK);
			labelOscuro.setForeground(Color.BLACK);
			lblTiendaIdioma.setForeground(Color.BLACK);
			lblUsuario.setForeground(Color.BLACK);
			lblEmail.setForeground(Color.BLACK);

			// Guardar selección tema claro
			oscuro = false;

		} else if (valor == 1) {
			// Cambiar al tema oscuro
			contentPane.setBackground(Color.DARK_GRAY);
			labelTema.setForeground(Color.WHITE);
			labelClaro.setForeground(Color.WHITE);
			labelOscuro.setForeground(Color.WHITE);
			lblTiendaIdioma.setForeground(Color.WHITE);
			lblUsuario.setForeground(Color.WHITE);
			lblEmail.setForeground(Color.WHITE);

			// Guardar selección tema oscuro
			oscuro = true;
		}
	}

	// Método para guardar la selección del tema
	private void guardarPreferenciaTema() {
		// Obtener las preferencias compartidas para la clase Ajustes
		Preferences prefs = Preferences.userNodeForPackage(Ajustes.class);
		// Guardar la preferencia del tema
		prefs.putBoolean("temaOscuro", oscuro);
	}

	// Sobreescribe el método setVisible para guardar la preferencia del tema al
	// cerrar la ventana
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		// Si la ventana se está cerrando, guardar la preferencia del tema
		if (!visible) {
			guardarPreferenciaTema();
		}
	}
}
