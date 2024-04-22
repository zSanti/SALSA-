package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Dao;

public class Main extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel BodyLayout, emptyRow, itemsPanel;
	private JLabel logo;
	private JButton btnCamisetas, btnSudaderas, btnPantalones, btnIniciarSesion;

	// Interfaz
	private Dao dao;

	public Main(Dao dao) {
		this.dao = dao;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1082, 836);
		BodyLayout = new JPanel();
		BodyLayout.setBackground(new Color(255, 255, 255));
		BodyLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BodyLayout);
		BodyLayout.setLayout(null);

		// Logo centrado
		logo = new JLabel("");
		logo.setBounds(378, 38, 326, 66);
		ImageIcon icon = new ImageIcon(getClass().getResource("/assets/logo.png"));
		ImageIcon img = new ImageIcon(
				icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
		logo.setIcon(img);
		BodyLayout.add(logo);

		// Añadir fila vacía debajo del logo
		emptyRow = new JPanel();
		emptyRow.setBounds(0, 150, 1066, 171); // Ajusta los valores según tu diseño
		BodyLayout.add(emptyRow);

		// Contenedor para la rejilla de articulos
		itemsPanel = new JPanel();
		itemsPanel.setBounds(45, 435, 982, 318);
		BodyLayout.add(itemsPanel);
		itemsPanel.setLayout(new GridLayout(0, 4, 8, 10));

		btnCamisetas = new JButton("Camisetas");
		btnCamisetas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCamisetas.setBounds(226, 363, 165, 46);
		BodyLayout.add(btnCamisetas);

		btnSudaderas = new JButton("Sudaderas");
		btnSudaderas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSudaderas.setBounds(656, 363, 165, 46);
		BodyLayout.add(btnSudaderas);

		btnPantalones = new JButton("Pantalones");
		btnPantalones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPantalones.setBounds(449, 363, 165, 46);
		BodyLayout.add(btnPantalones);

		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setBounds(10, 38, 113, 30);
		BodyLayout.add(btnIniciarSesion);

		// Agrego un evento al botón para enviar a la pagina de Login
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Crear una instancia de la vista Login
				Login login = new Login(dao);
				login.setVisible(true);
				setVisible(false);
			}
		});

		// Agrega los elementos a la rejilla de artículos
		for (int i = 0; i < 8; i++) { // Por ejemplo, aquí se agregan 8 elementos
			JPanel item = new JPanel();
			item.setBackground(Color.GRAY); // Cambia el color de fondo según tu diseño
			itemsPanel.add(item);
		}
	}
}
