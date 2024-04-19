package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administracion extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelAdvise;
    private JLabel lblAdvise1, lblAdvise2, lblAdvise3;

    public Administracion(boolean oscuro) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 692);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Creamos un JPanel para contener los JLabel
        panelAdvise = new JPanel();
        panelAdvise.setForeground(Color.RED);
        panelAdvise.setBounds(26, 170, 608, 80); // Establecemos las dimensiones y la posición del panel
        panelAdvise.setBorder(new LineBorder(new Color(255, 0, 0), 3, true)); // Establecemos el borde para el panel
        contentPane.add(panelAdvise);
        panelAdvise.setLayout(null);

        lblAdvise1 = new JLabel("Has iniciado sesión como usuario de administración,");
        lblAdvise1.setForeground(Color.BLACK);
        lblAdvise1.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
        lblAdvise1.setBounds(67, 10, getWidth() - 40, 20);
        panelAdvise.add(lblAdvise1);

        lblAdvise2 = new JLabel("cualquier cambio que se realice es recomendable");
        lblAdvise2.setForeground(Color.BLACK);
        lblAdvise2.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
        lblAdvise2.setBounds(67, 30, getWidth() - 40, 20);
        panelAdvise.add(lblAdvise2);

        lblAdvise3 = new JLabel("consultarlo previamente con el resto de desarrolladores.");
        lblAdvise3.setForeground(Color.BLACK);
        lblAdvise3.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
        lblAdvise3.setBounds(67, 50, getWidth() - 40, 20);
        panelAdvise.add(lblAdvise3);

        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon("C:\\PGR\\3eva\\SALSA--dev\\src\\assets\\logo.png"));
        logo.setBounds(194, 52, 245, 51);
        contentPane.add(logo);

        JButton btnMoDatosU = new JButton("Modificar Datos Usuario");
        btnMoDatosU.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		moDatosUsuario(oscuro);
        	}
        });
        btnMoDatosU.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnMoDatosU.setBounds(194, 287, 234, 60);
        contentPane.add(btnMoDatosU);

        JButton btnModificarDatosArtculo = new JButton("Modificar Datos Artículo");
        btnModificarDatosArtculo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		moDatosArticulo(oscuro);
        	}
        });
        btnModificarDatosArtculo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnModificarDatosArtculo.setBounds(194, 388, 234, 60);
        contentPane.add(btnModificarDatosArtculo);

        JButton btnInsertarNuevoArtculo = new JButton("Insertar Nuevo Artículo");
        btnInsertarNuevoArtculo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		insertDat(oscuro);
        	}
        });
        btnInsertarNuevoArtculo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnInsertarNuevoArtculo.setBounds(194, 492, 234, 60);
        contentPane.add(btnInsertarNuevoArtculo);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		volver(oscuro);
        	}
        });
        btnVolver.setBounds(10, 10, 85, 21);
        contentPane.add(btnVolver);
        
        if (oscuro) {
        cambioFondo();
        }
    }

	private void cambioFondo() {
		contentPane.setBackground(Color.DARK_GRAY);
		panelAdvise.setBackground(Color.DARK_GRAY);
		lblAdvise1.setForeground(Color.WHITE);
		lblAdvise2.setForeground(Color.WHITE);
		lblAdvise3.setForeground(Color.WHITE);
	}

	protected void insertDat(boolean oscuro) {
		InsertDatosArticulo insert = new InsertDatosArticulo(oscuro);
		insert.setVisible(true);
		setVisible(false);
	}

	protected void moDatosArticulo(boolean oscuro) {
		MoDatosArticulo modArt = new MoDatosArticulo(oscuro);
		modArt.setVisible(true);
		setVisible(false);
		
	}
	protected void moDatosUsuario(boolean oscuro) {
		MoDatosUsuario mod = new MoDatosUsuario(oscuro);
		mod.setVisible(true);
		setVisible(false);
		
	}

	protected void volver(boolean oscuro) {
		Hamburger ham = new Hamburger(oscuro);
		ham.setVisible(true);
		setVisible(false);
	}
}
