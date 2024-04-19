package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel BodyLayout;
    private JLabel logo;

    /**
     * Create the frame.
     * @param oscuro 
     */
    public Main(boolean oscuro) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1082, 836);
        BodyLayout = new JPanel();
        BodyLayout.setBackground(new Color(255, 255, 255));
        BodyLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(BodyLayout);
        BodyLayout.setLayout(null);

        JButton btnIniciarSesion = new JButton("Iniciar sesión");
        btnIniciarSesion.setBounds(10, 38, 113, 30);
        btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciarSesion.setForeground(Color.WHITE);
        btnIniciarSesion.setBackground(new Color(59, 89, 182));
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Espacio interior
        btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIniciarSesion.setBorder(new RoundedBorder(15)); // Borde redondo con radio de 15 píxeles
        BodyLayout.add(btnIniciarSesion);

        // Agregar ActionListener al botón btnIniciarSesion
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de la vista "Login"
                Login login = new Login(oscuro);
                // Hacer visible la vista Login
                login.setVisible(true);
                setVisible(false);
            }
        });
        
        // Logo centrado
        logo = new JLabel("");
        logo.setBounds(378, 38, 326, 66);
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/logo.png"));
        ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
        logo.setIcon(img);
        BodyLayout.add(logo);

        // Añadir fila vacía debajo del logo
        JPanel emptyRow = new JPanel();
        emptyRow.setBounds(0, 150, 1066, 171); // Ajusta los valores según tu diseño
        BodyLayout.add(emptyRow);
        
        // Contenedor para la rejilla de articulos
        JPanel itemsPanel = new JPanel();
        itemsPanel.setBounds(45, 435, 982, 318);
        BodyLayout.add(itemsPanel);
        itemsPanel.setLayout(new GridLayout(0, 4, 8, 10));
        
        JButton btnCamisetas = new JButton("Camisetas");
        btnCamisetas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCamisetas.setBounds(226, 363, 165, 46);
        BodyLayout.add(btnCamisetas);
        
        JButton btnSudaderas = new JButton("Sudaderas");
        btnSudaderas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSudaderas.setBounds(656, 363, 165, 46);
        BodyLayout.add(btnSudaderas);
        
        JButton btnPantalones = new JButton("Pantalones");
        btnPantalones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnPantalones.setBounds(449, 363, 165, 46);
        BodyLayout.add(btnPantalones);

        // Agrega los elementos a la rejilla de artículos
        for (int i = 0; i < 8; i++) { // Por ejemplo, aquí se agregan 8 elementos
            JPanel item = new JPanel();
            item.setBackground(Color.GRAY); // Cambia el color de fondo según tu diseño
            itemsPanel.add(item);
        }
        
        if (oscuro) {
        	cambioFondo();
        }
    }

	private void cambioFondo() {
		BodyLayout.setBackground(Color.DARK_GRAY);
	}

}

class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0); // No se añaden márgenes al borde
    }

    public boolean isBorderOpaque() {
        return false;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(c.getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2d.dispose();
    }
}

