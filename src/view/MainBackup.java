package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainBackup extends JFrame {

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
					MainBackup frame = new MainBackup();
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
	public MainBackup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 836);
		BodyLayout = new JPanel();
		BodyLayout.setBackground(new Color(255, 255, 255));
		BodyLayout.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(BodyLayout);
		BodyLayout.setLayout(null);

		// Colocar imagenes con el tamaño que nosotros queramos
		logo = new JLabel("");
		logo.setBounds(397, 38, 326, 66);
		ImageIcon icon = new ImageIcon(getClass().getResource("/assets/logo.png"));
		ImageIcon img = new ImageIcon(
				icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
		logo.setIcon(img);
		BodyLayout.add(logo);

		JPanel Header = new JPanel();
		Header.setBounds(0, 150, 1066, 172);
		BodyLayout.add(Header);

		JPanel Header_1 = new JPanel();
		Header_1.setBounds(42, 361, 216, 166);
		BodyLayout.add(Header_1);

		JPanel Header_1_2 = new JPanel();
		Header_1_2.setBounds(300, 361, 216, 166);
		BodyLayout.add(Header_1_2);

		JPanel Header_1_2_1 = new JPanel();
		Header_1_2_1.setBounds(558, 361, 216, 166);
		BodyLayout.add(Header_1_2_1);

		JPanel Header_1_2_2 = new JPanel();
		Header_1_2_2.setBounds(816, 361, 216, 166);
		BodyLayout.add(Header_1_2_2);
	}
}
