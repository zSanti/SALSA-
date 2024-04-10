package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel BodyLayout;
    private JLabel logo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
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
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }
}
