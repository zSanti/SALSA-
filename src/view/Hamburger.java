package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class Hamburger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hamburger frame = new Hamburger();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hamburger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(337, 11, 6, 144);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(337, 499, 6, 158);
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1);
		
        JButton btnIndex = createButton("Inicio");
        btnIndex.setBounds(254, 183, 176, 42);
        contentPane.add(btnIndex);

        JButton btnSettings = createButton("Ajustes");
        btnSettings.setBounds(254, 247, 176, 42);
        contentPane.add(btnSettings);

        JButton btnContact = createButton("Contacto");
        btnContact.setBounds(254, 309, 176, 42);
        contentPane.add(btnContact);

        JButton btnAdministration = createButton("Administración");
        btnAdministration.setBounds(240, 373, 202, 42);
        contentPane.add(btnAdministration);

        JButton btnLogout = createButton("Cerrar sesión");
        btnLogout.setBounds(254, 437, 176, 42);
        contentPane.add(btnLogout);
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
}
