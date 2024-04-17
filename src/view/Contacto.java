package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Contacto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblIconoTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Contacto dialog = new Contacto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Contacto() {
		setBounds(100, 100, 815, 993);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbLogo = new JLabel("");
			lbLogo.setBounds(270, 39, 240, 49);
			lbLogo.setBackground(new Color(240, 240, 240));
			lbLogo.setIcon(new ImageIcon(
					"C:\\Users\\vlede\\OneDrive\\Escritorio\\RetoTerceraEvaluacion\\src\\assets\\logo.png"));
			contentPanel.add(lbLogo);
		}
		{
			JLabel lbImagen = new JLabel("");
			lbImagen.setBounds(10, 422, 781, 450);
			lbImagen.setIcon(new ImageIcon(
					"C:\\Users\\vlede\\OneDrive\\Escritorio\\RetoTerceraEvaluacion\\src\\assets\\ImagenContacto.jpg"));
			contentPanel.add(lbImagen);
		}
		{
			JLabel lblTitulo = new JLabel("¿Quieres saber más?");
			lblTitulo.setBounds(280, 99, 326, 81);
			lblTitulo.setBackground(new Color(255, 255, 255));
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 21));
			contentPanel.add(lblTitulo);
		}
		{
			JLabel lblNumero = new JLabel("900800970");
			lblNumero.setBounds(157, 261, 162, 70);
			lblNumero.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNumero);
		}
		{
			JLabel lBTelefono = new JLabel("Teléfono ");
			lBTelefono.setBounds(157, 272, 99, 14);
			lBTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lBTelefono);
		}
		{
			JLabel lblNmeroGratutito = new JLabel("Número gratutito");
			lblNmeroGratutito.setBounds(157, 308, 142, 14);
			lblNmeroGratutito.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNmeroGratutito);
		}
		{
			JLabel lblNumero = new JLabel("+351 925507494");
			lblNumero.setBounds(462, 261, 275, 70);
			lblNumero.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNumero);
		}
		{
			JLabel lBWhatsapp = new JLabel("Whatsapp");
			lBWhatsapp.setBounds(462, 272, 99, 14);
			lBWhatsapp.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lBWhatsapp);
		}
		{
			lblIconoTelefono = new JLabel("");
			lblIconoTelefono.setIcon(new ImageIcon(
					"C:\\Users\\vlede\\OneDrive\\Escritorio\\RetoTerceraEvaluacion\\src\\assets\\icon-157358_640_resized.png"));
			lblIconoTelefono.setBounds(109, 261, 11, 70);
			contentPanel.add(lblIconoTelefono);
		}
		{
			JLabel lblIconoTelefono_1 = new JLabel("");
			lblIconoTelefono_1.setIcon(new ImageIcon(
					"C:\\Users\\vlede\\OneDrive\\Escritorio\\RetoTerceraEvaluacion\\src\\assets\\icon-157358_640_resized.png"));
			lblIconoTelefono_1.setBounds(418, 240, 43, 101);
			contentPanel.add(lblIconoTelefono_1);
		}
		{
			JLabel lblAyudamos = new JLabel("¡Ayúdamos!");
			lblAyudamos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAyudamos.setBounds(359, 166, 234, 25);
			contentPanel.add(lblAyudamos);
		}
		{
			JLabel lblNewLabel = new JLabel("De las 8h a las 23h, del lunes a viernes");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(252, 200, 326, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(
					"C:\\Users\\vlede\\OneDrive\\Escritorio\\RetoTerceraEvaluacion\\src\\assets\\588a6507d06f6719692a2d15_resized.png"));
			lblNewLabel_1.setBounds(694, 39, 59, 43);
			contentPanel.add(lblNewLabel_1);
		}
	}
}
