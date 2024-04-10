package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Register extends JFrame {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JPanel BodyLayout;
    private JLabel logo;
    private JTextField inputName;
    private JPasswordField inputRepeatPassword;
    private JPasswordField inputPassword;
    private JTextField inputSurname;
    private JTextField inputEmail;
    private JTextField inputDni;
    private JTextField inputDirection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 931, 842);
        BodyLayout = new JPanel();
        BodyLayout.setBackground(new Color(255, 255, 255));
        BodyLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(BodyLayout);
        BodyLayout.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/logo.png"));

        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(255, 255, 255));
        panelRight.setBounds(0, 0, 915, 792);
        BodyLayout.add(panelRight);
        panelRight.setLayout(null);
        
        // Logo centrado
        logo = new JLabel("");
        logo.setBounds(344, 66, 245, 51);
        panelRight.add(logo);
        ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(img);
        
        inputName = new JTextField();
        inputName.setBounds(62, 195, 378, 51);
        panelRight.add(inputName);
        inputName.setColumns(10);
        
        JLabel labelName = new JLabel("Nombre");
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName.setBounds(62, 170, 123, 14);
        panelRight.add(labelName);
        
        JLabel labelPassword = new JLabel("Contraseña");
        labelPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelPassword.setBounds(62, 464, 123, 14);
        panelRight.add(labelPassword);
        
        JButton btnLogin = new JButton("Registrarme");
        btnLogin.setBounds(278, 722, 378, 45);
        panelRight.add(btnLogin);
        
        JLabel labelRepeatPassword = new JLabel("Repite la contraseña");
        labelRepeatPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRepeatPassword.setBounds(492, 464, 205, 14);
        panelRight.add(labelRepeatPassword);
        
        inputRepeatPassword = new JPasswordField();
        inputRepeatPassword.setBounds(492, 489, 378, 51);
        panelRight.add(inputRepeatPassword);
        
        inputPassword = new JPasswordField();
        inputPassword.setBounds(62, 489, 378, 51);
        panelRight.add(inputPassword);
        
        JLabel labelFirstSurname = new JLabel("Primer apellido");
        labelFirstSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelFirstSurname.setBounds(492, 170, 123, 14);
        panelRight.add(labelFirstSurname);
        
        inputSurname = new JTextField();
        inputSurname.setColumns(10);
        inputSurname.setBounds(492, 195, 378, 51);
        panelRight.add(inputSurname);
        
        JLabel labelEmail = new JLabel("Correo electrónico");
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelEmail.setBounds(62, 275, 170, 14);
        panelRight.add(labelEmail);
        
        inputEmail = new JTextField();
        inputEmail.setColumns(10);
        inputEmail.setBounds(62, 300, 378, 51);
        panelRight.add(inputEmail);
        
        JLabel labelDNI = new JLabel("DNI");
        labelDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDNI.setBounds(492, 275, 183, 14);
        panelRight.add(labelDNI);
        
        inputDni = new JTextField();
        inputDni.setColumns(10);
        inputDni.setBounds(492, 300, 378, 51);
        panelRight.add(inputDni);
        
        JLabel labelDirection = new JLabel("Dirección");
        labelDirection.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDirection.setBounds(74, 372, 123, 14);
        panelRight.add(labelDirection);
        
        inputDirection = new JTextField();
        inputDirection.setColumns(10);
        inputDirection.setBounds(62, 396, 810, 51);
        panelRight.add(inputDirection);
        
        JLabel labelSexo = new JLabel("Sexo");
        labelSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelSexo.setBounds(62, 566, 123, 14);
        panelRight.add(labelSexo);
        
        JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
        lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblFechaDeNacimiento.setBounds(492, 568, 170, 14);
        panelRight.add(lblFechaDeNacimiento);
        
    }
}