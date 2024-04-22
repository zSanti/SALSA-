package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Articulo;
import clases.Temporada;
import controller.Controlador;
import controller.Dao;
import excepciones.CreateException;

public class InsertDatosArticulo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfModelo, tfNombre, tfPrecio, tfStock, tfColor, tfCodArticulo;
	private final ButtonGroup btnTemporadaGroup = new ButtonGroup();
	private JTextField tfPorcentaje;
	JButton btnSubirDatos;
	private static Dao dao;

	/**
	 * Create the dialog.
	 */
	public InsertDatosArticulo(Dao dao) {
		this.dao = dao;
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

		tfCodArticulo = new JTextField();
		tfCodArticulo.setBounds(103, 163, 155, 35);
		contentPanel.add(tfCodArticulo);
		tfCodArticulo.setColumns(10);

		tfColor = new JTextField();
		tfColor.setBounds(537, 163, 225, 35);
		tfColor.setColumns(10);
		contentPanel.add(tfColor);

		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setBounds(103, 208, 84, 35);
		lblTemporada.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblTemporada);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(536, 208, 84, 35);
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblModelo);

		tfModelo = new JTextField();
		tfModelo.setBounds(537, 253, 225, 35);
		tfModelo.setColumns(10);
		contentPanel.add(tfModelo);

		tfNombre = new JTextField();
		tfNombre.setBounds(537, 352, 225, 35);
		tfNombre.setColumns(10);
		contentPanel.add(tfNombre);

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

		tfPrecio = new JTextField();
		tfPrecio.setBounds(169, 409, 225, 35);
		tfPrecio.setColumns(10);
		contentPanel.add(tfPrecio);

		tfStock = new JTextField();
		tfStock.setBounds(598, 410, 142, 35);
		tfStock.setColumns(10);
		contentPanel.add(tfStock);

		btnSubirDatos = new JButton("Subir Datos");
		btnSubirDatos.setBounds(262, 564, 359, 60);
		btnSubirDatos.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPanel.add(btnSubirDatos);

		JLabel lblPorcentaje = new JLabel("Porcentaje de descuento");
		lblPorcentaje.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPorcentaje.setBounds(198, 474, 196, 35);
		contentPanel.add(lblPorcentaje);

		tfPorcentaje = new JTextField();
		tfPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tfPorcentaje.setColumns(10);
		tfPorcentaje.setBounds(418, 476, 225, 35);
		contentPanel.add(tfPorcentaje);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSubirDatos)) {
			subirDatos();
		}
	}

	private void subirDatos() {
		Articulo art = new Articulo();
		dao.altaArticulo(art);
	}

	public void cargarDatosArticulo(Articulo articulo) throws CreateException {
		Temporada temp;
		// guardamos el texto de tf en una variable
		String cod = tfCodArticulo.getText();
		// luego parseamos dicha variable
		int codigoArt = Integer.parseInt(cod);
		// y la ponemos para cargar los datos
		articulo.setCodArticulo(codigoArt);
		articulo.setColor(tfColor.getText());
		String porcentaje = tfPorcentaje.getText();
		float porcent = Float.parseFloat(porcentaje);
		articulo.setPorcentajeDecuento(porcent);
		String precio = tfPrecio.getText();
		int precio2 = Integer.parseInt(precio);
		articulo.setPrecio(precio2);
		articulo.setModelo(tfModelo.getText());
		Enumeration<AbstractButton> botonesTemporada = btnTemporadaGroup.getElements();
		while (botonesTemporada.hasMoreElements()) {

			JRadioButton btnTempo = (JRadioButton) botonesTemporada.nextElement();

			if (btnTempo.isSelected()) {
				String texTemporada = btnTempo.getText();

				temp = Temporada.valueOf(texTemporada);
			}

		}
		// para la creacion de un a excepcion pero hay que mirarlo, no se si esta bien
		Controlador.altaArticulo(articulo);
	}
}
