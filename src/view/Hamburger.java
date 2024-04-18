package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Dao;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.ModuleLayer.Controller;
import java.awt.event.ActionEvent;

public class Hamburger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIndex;
	private JButton btnSettings;
	private JButton btnContact;
	private JButton btnAdministration;
	private JButton btnLogout;
	private JPanel panel;
	private JPanel panel2;
	
	// Interfaz
	private Dao dao;
	

	public Hamburger () {
		Hamburguesa(false);
	}
	
	public Hamburger (boolean oscuro) {
		Hamburguesa(oscuro);
	}
	
	public void Hamburguesa(boolean oscuro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        	public void actionPerformed(ActionEvent e) {
        		inicio();
        	}
        });
        btnIndex.setBounds(254, 183, 176, 42);
        contentPane.add(btnIndex);

        btnSettings = createButton("Ajustes");
        btnSettings.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ajustes(oscuro);
        	}
        });
        btnSettings.setBounds(254, 247, 176, 42);
        contentPane.add(btnSettings);

        btnContact = createButton("Contacto");
        btnContact.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		contacto();
        	}
        });
        btnContact.setBounds(254, 309, 176, 42);
        contentPane.add(btnContact);

        btnAdministration = createButton("Administración");
        btnAdministration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		administracion();
        	}
        });
        btnAdministration.setBounds(240, 373, 202, 42);
        contentPane.add(btnAdministration);

        btnLogout = createButton("Cerrar sesión");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		logout();
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

	protected void logout() {
		Login log = new Login(dao);
		log.setVisible(true);
		setVisible(false);
	}
	
	protected void administracion() {
		Administracion admin = new Administracion();
		admin.setVisible(true);
		setVisible(false);
		
	}
	
	protected void contacto() {
		Contacto contact = new Contacto();
		contact.setVisible(true);
		setVisible(false);
	}
	
    protected void ajustes(boolean oscuro) {
		Ajustes settings = new Ajustes(oscuro);
		settings.setVisible(true);
		setVisible(false);
	}
	
	protected void inicio() {
		Main index = new Main(dao);
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
