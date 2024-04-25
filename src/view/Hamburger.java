package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;

public class Hamburger extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIndex;
	private JButton btnSettings;
	private JButton btnContact;
	private JButton btnAdministration;
	private JButton btnLogout;
	private JPanel panel;
	private JPanel panel2;

	// Controlador
	private Controlador cont;
	// private Dao dao;

	/**
	 * Create the frame.
	 */
	public Hamburger() {
		Hamburguesa(dao, false);
	}

	public Hamburger(Dao dao, boolean oscuro) {
		Hamburguesa(dao, oscuro);
	}


	public void Hamburguesa(boolean oscuro) {

		setBounds(100, 100, 700, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(337, 11, 6, 144);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);

		panel2 = new JPanel();
		panel2.setBounds(337, 499, 6, 158);
		panel2.setBackground(Color.BLACK);
		contentPane.add(panel2);

		btnIndex = createButton("Inicio");
		btnIndex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inicio(oscuro);
			}
		});
		btnIndex.setBounds(254, 183, 176, 42);
		contentPane.add(btnIndex);

		btnSettings = createButton("Ajustes");
		btnSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajustes(oscuro);
			}
		});
		btnSettings.setBounds(254, 247, 176, 42);
		contentPane.add(btnSettings);

		btnContact = createButton("Contacto");
		btnContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contacto();
			}
		});
		btnContact.setBounds(254, 309, 176, 42);
		contentPane.add(btnContact);

		btnAdministration = createButton("Administración");
		btnAdministration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				administracion(oscuro);
			}
		});
		btnAdministration.setBounds(240, 373, 202, 42);
		contentPane.add(btnAdministration);

		btnLogout = createButton("Cerrar sesión");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logout(oscuro);
			}
		});
		btnLogout.setBounds(254, 437, 176, 42);
		contentPane.add(btnLogout);
		if (oscuro) {
			cambioFondo();
		}

	}

	private JButton createButton(String text) {
		JButton btn = new JButton(text);
		btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn.setContentAreaFilled(false); // Establece el área de contenido del botón como no relleno
		btn.setOpaque(false); // Hace que el botón sea transparente
		btn.setBorderPainted(false); // Oculta el borde del botón
		btn.setForeground(Color.BLACK); // Establece el color del texto del botón
		return btn;
	}

	protected void logout(boolean oscuro) {
		Login log = new Login(cont, oscuro);
		log.setVisible(true);
		setVisible(false);
	}

	protected void administracion(boolean oscuro) {
		Administracion admin = new Administracion(dao, oscuro);
		admin.setVisible(true);
		setVisible(false);

	}

	protected void contacto() {
		Contacto contact = new Contacto();
		contact.setVisible(true);
		setVisible(false);
	}

	protected void ajustes(boolean oscuro) {
		Ajustes settings = new Ajustes(dao ,oscuro);
		settings.setVisible(true);
		setVisible(false);
	}

	protected void inicio(boolean oscuro) {
		Main index = new Main(null, oscuro, cont);
		index.setVisible(true);
		setVisible(false);
	}

	private void cambioFondo() {
		panel.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		btnIndex.setForeground(Color.WHITE);
		btnAdministration.setForeground(Color.WHITE);
		btnContact.setForeground(Color.WHITE);
		btnLogout.setForeground(Color.WHITE);
		btnSettings.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);

	}
}