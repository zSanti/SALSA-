package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InsertDatosArticulo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup btnTemporadaGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public InsertDatosArticulo() {
		setBounds(100, 100, 859, 704);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(262, 35, 254, 69);
		logo.setIcon(new ImageIcon(getClass().getResource("/assets/logo.png")));
		contentPanel.add(logo);

		JLabel lblCodArticulo = new JLabel("Codigo del articulo");
		lblCodArticulo.setBounds(103, 118, 155, 35);
		lblCodArticulo.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblCodArticulo);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(537, 118, 51, 35);
		lblColor.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblColor);

		textField = new JTextField();
		textField.setBounds(103, 163, 155, 35);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(537, 163, 225, 35);
		textField_1.setColumns(10);
		contentPanel.add(textField_1);

		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setBounds(103, 208, 84, 35);
		lblTemporada.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblTemporada);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(536, 208, 84, 35);
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblModelo);

		textField_2 = new JTextField();
		textField_2.setBounds(537, 253, 225, 35);
		textField_2.setColumns(10);
		contentPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(537, 352, 225, 35);
		textField_3.setColumns(10);
		contentPanel.add(textField_3);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(537, 316, 84, 35);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblNombre);

		JRadioButton rbtVerano = new JRadioButton("Verano");
		btnTemporadaGroup.add(rbtVerano);
		rbtVerano.setBounds(103, 249, 103, 21);
		rbtVerano.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(rbtVerano);

		JRadioButton rbtPrimavera = new JRadioButton("Primavera");
		btnTemporadaGroup.add(rbtPrimavera);
		rbtPrimavera.setBounds(103, 288, 103, 21);
		rbtPrimavera.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(rbtPrimavera);

		JRadioButton rbtOtonio = new JRadioButton("Otoño");
		btnTemporadaGroup.add(rbtOtonio);
		rbtOtonio.setBounds(103, 324, 103, 21);
		rbtOtonio.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(rbtOtonio);

		JRadioButton rbtInvierno = new JRadioButton("Invierno");
		btnTemporadaGroup.add(rbtInvierno);
		rbtInvierno.setBounds(103, 358, 103, 21);
		rbtInvierno.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(rbtInvierno);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(103, 409, 56, 35);
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblPrecio);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(536, 409, 84, 35);
		lblStock.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblStock);

		textField_4 = new JTextField();
		textField_4.setBounds(169, 409, 225, 35);
		textField_4.setColumns(10);
		contentPanel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBounds(598, 410, 142, 35);
		textField_5.setColumns(10);
		contentPanel.add(textField_5);

		JButton btnSubirDatos = new JButton("Subir Datos");
		btnSubirDatos.setBounds(274, 519, 359, 60);
		btnSubirDatos.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPanel.add(btnSubirDatos);
	}
}
