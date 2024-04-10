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
		
        JButton btnNewButton = createButton("Inicio");
        contentPane.add(btnNewButton);

        JButton btnAjustes = createButton("Ajustes");
        contentPane.add(btnAjustes);

        JButton btnContacto = createButton("Contacto");
        contentPane.add(btnContacto);

        JButton btnAdministracin = createButton("Administración");
        contentPane.add(btnAdministracin);

        JButton btnCerrarSesin = createButton("Cerrar sesión");
        contentPane.add(btnCerrarSesin);
        
        JButton btnSettings = new JButton("Ajustes");
        btnSettings.setOpaque(false);
        btnSettings.setForeground(Color.BLACK);
        btnSettings.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnSettings.setContentAreaFilled(false);
        btnSettings.setBorderPainted(false);
        btnSettings.setBounds(254, 247, 176, 42);
        contentPane.add(btnSettings);
        
        JButton btnAdministration = new JButton("Administración");
        btnAdministration.setOpaque(false);
        btnAdministration.setForeground(Color.BLACK);
        btnAdministration.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnAdministration.setContentAreaFilled(false);
        btnAdministration.setBorderPainted(false);
        btnAdministration.setBounds(240, 373, 202, 42);
        contentPane.add(btnAdministration);
        
        JButton btnContact = new JButton("Contacto");
        btnContact.setOpaque(false);
        btnContact.setForeground(Color.BLACK);
        btnContact.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnContact.setContentAreaFilled(false);
        btnContact.setBorderPainted(false);
        btnContact.setBounds(254, 309, 176, 42);
        contentPane.add(btnContact);
        
        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.setOpaque(false);
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setBounds(254, 437, 176, 42);
        contentPane.add(btnLogout);
    }

    private JButton createButton(String text) {
        JButton btnIndex = new JButton(text);
        btnIndex.setBounds(254, 183, 176, 42);
        btnIndex.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnIndex.setContentAreaFilled(false); // Establece el área de contenido del botón como no relleno
        btnIndex.setOpaque(false); // Hace que el botón sea transparente
        btnIndex.setBorderPainted(false); // Oculta el borde del botón
        btnIndex.setForeground(Color.BLACK); // Establece el color del texto del botón
        return btnIndex;
	}
}
