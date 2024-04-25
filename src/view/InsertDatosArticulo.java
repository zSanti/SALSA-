package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JTextField tfModelo, tfNombre, tfPrecio, tfStock, tfColor, tfCodArticulo, tfPorcentaje;
	private JComboBox<Temporada> comboBoxTemporada;
	private JButton btnSubirDatos;
	
	// Lógica para la conexión
	private Controlador controladorRutas;

	/**
	 * Create the dialog.
	 */
	public InsertDatosArticulo(Controlador controladorRutas, boolean oscuro) {
		this.controladorRutas = controladorRutas;
		
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

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(107, 316, 56, 35);
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblPrecio);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(536, 409, 84, 35);
		lblStock.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPanel.add(lblStock);

		tfPrecio = new JTextField();
		tfPrecio.setBounds(103, 366, 225, 35);
		tfPrecio.setColumns(10);
		contentPanel.add(tfPrecio);

		tfStock = new JTextField();
		tfStock.setBounds(537, 454, 142, 35);
		tfStock.setColumns(10);
		contentPanel.add(tfStock);

		btnSubirDatos = new JButton("Subir Datos");
		btnSubirDatos.setBounds(250, 552, 359, 60);
		btnSubirDatos.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPanel.add(btnSubirDatos);

		JLabel lblPorcentaje = new JLabel("Porcentaje de descuento");
		lblPorcentaje.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPorcentaje.setBounds(103, 409, 196, 35);
		contentPanel.add(lblPorcentaje);

		tfPorcentaje = new JTextField();
		tfPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tfPorcentaje.setColumns(10);
		tfPorcentaje.setBounds(103, 454, 225, 35);
		contentPanel.add(tfPorcentaje);

		comboBoxTemporada = new JComboBox<>();
		comboBoxTemporada.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxTemporada.setModel(new DefaultComboBoxModel<>(Temporada.values()));
		comboBoxTemporada.setToolTipText("");
		comboBoxTemporada.setEditable(true);
		comboBoxTemporada.setBounds(103, 256, 196, 28);
		contentPanel.add(comboBoxTemporada);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSubirDatos)) {
			subirDatos();
		}
	}

	private void subirDatos() {
		Articulo art = new Articulo();
		controladorRutas.altaArticulo(art);
	}

	public void cargarDatosArticulo(Articulo articulo) throws CreateException {

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
		articulo.setTemporada((Temporada) comboBoxTemporada.getSelectedItem());
		// para la creacion de un a excepcion pero hay que mirarlo, no se si esta bien
		Controlador.altaArticulo(articulo);
	}
}
