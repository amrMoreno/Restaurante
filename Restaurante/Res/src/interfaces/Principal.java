package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import clases.Productos;
import clases.Productos.TipoProducto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal extends JPanel {
	private Ventana ventana;
	private Principal thisRef;
	private Connection c;
	private Statement stmte;

	public Principal(Ventana v) {

		super();
		thisRef = this;
		this.ventana = v;
		this.c = ventana.cargaBd();
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBounds(0, 0, 450, 33);
		add(panel);

		JLabel lblRestauranteCenec = new JLabel("Restaurante Cenec");
		panel.add(lblRestauranteCenec);
		lblRestauranteCenec.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));

		JPanel lista = new JPanel();
		lista.setBorder(UIManager.getBorder("CheckBox.border"));
		lista.setBounds(0, 32, 127, 221);
		add(lista);
		lista.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 255, 204));
		panel_3.setBounds(0, 0, 127, 25);
		lista.add(panel_3);

		JLabel lblListaConsumo = new JLabel("Lista Consumo");
		lblListaConsumo.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		panel_3.add(lblListaConsumo);

		JPanel total = new JPanel();
		total.setBorder(UIManager.getBorder("CheckBox.border"));
		total.setBounds(0, 252, 127, 48);
		add(total);

		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		total.add(lblTotal);

		JPanel menu2 = new JPanel();
		menu2.setBorder(UIManager.getBorder("CheckBox.border"));
		menu2.setBounds(127, 252, 323, 48);
		add(menu2);
		menu2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton BCobrar = new JButton("Cobrar");
		BCobrar.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		BCobrar.setBackground(new Color(102, 204, 0));
		menu2.add(BCobrar);

		JButton BImprimir = new JButton("Imprimir Factura");
		BImprimir.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		menu2.add(BImprimir);

		JButton BPendiente = new JButton("Pendiente");
		BPendiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPantallaInicio();
			}
		});
		BPendiente.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		BPendiente.setBackground(new Color(135, 206, 250));
		menu2.add(BPendiente);

		JPanel menu1 = new JPanel();
		menu1.setLayout(new GridLayout(8, 0));
		menu1.setBorder(UIManager.getBorder("CheckBox.border"));
		menu1.setBounds(364, 32, 86, 221);
		add(menu1);

		JButton BBebidas = new JButton("Bebidas");

		BBebidas.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BBebidas);

		JButton BComida = new JButton("Comida");
		BComida.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BComida);

		JButton BEntrantes = new JButton("Entrantes");
		BEntrantes.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BEntrantes);

		JButton BMedias = new JButton("1/2");
		BMedias.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BMedias);

		JButton BLicores = new JButton("Licores");
		BLicores.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BLicores);

		JButton BCopas = new JButton("Copas");
		BCopas.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BCopas);

		JButton BVinos = new JButton("Vinos");
		BVinos.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BVinos);

		JButton BPostres = new JButton("Postres");
		BPostres.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BPostres);

		JPanel articulos = new JPanel();
		articulos.setBackground(Color.WHITE);
		articulos.setBorder(UIManager.getBorder("CheckBox.border"));
		articulos.setBounds(127, 32, 238, 221);
		add(articulos);
		articulos.setLayout(new GridLayout(2, 2, 0, 0));

		BBebidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.REFRESCO != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte.executeQuery("SELECT * FROM bebida WHERE tipo = 'REFRESCO'");

						while (rst.next()) {
							Productos Bebida = new Productos(rst.getString("nombre"), TipoProducto.REFRESCO,
									rst.getString("precio"));
							JButton producto = new JButton(Bebida.getNombre());
							producto.setFont(new Font("Agency FB", Font.ITALIC, 12));
							articulos.add(producto);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}
		});
		BComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.COMIDA_PRINCIPAL != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte
								.executeQuery("SELECT * FROM productos WHERE tipoDeProducto = 'COMIDA_PRINCIPAL'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.COMIDA_PRINCIPAL,
									rst.getString("precio"));
							JButton producto = new JButton(comida.getNombre());
							articulos.add(producto);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}
		});
		BCopas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.COPAS != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte.executeQuery("SELECT * FROM bebida WHERE tipo = 'COPA'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.COPAS,
									rst.getString("precio"));
							JButton copa = new JButton(comida.getNombre());
							articulos.add(copa);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}

		});

		BEntrantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.ENTRANTE != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte
								.executeQuery("SELECT * FROM productos WHERE tipoDeProducto = 'ENTRANTE'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.ENTRANTE,
									rst.getString("precio"));
							JButton entrantes = new JButton(comida.getNombre());
							articulos.add(entrantes);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}
		});
		BLicores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.LICORES != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte.executeQuery("SELECT * FROM bebida WHERE tipo = 'LICORES'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.LICORES,
									rst.getString("precio"));
							JButton licor = new JButton(comida.getNombre());
							articulos.add(licor);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);
			}
		});
		BMedias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();
				// Leer bebidas de base de datos
				for (int i = 0; i < 5; i++) {
					JButton producto = new JButton("producto " + i);
					articulos.add(producto);
				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}
		});
		BVinos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.VINOS != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte.executeQuery("SELECT * FROM bebida WHERE tipo = 'VINOS'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.VINOS,
									rst.getString("precio"));
							JButton vino = new JButton(comida.getNombre());
							articulos.add(vino);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}
		});
		BPostres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.POSTRES != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte
								.executeQuery("SELECT * FROM productos WHERE tipoDeProducto = 'POSTRES'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.POSTRES,
									rst.getString("precio"));
							JButton postres = new JButton(comida.getNombre());
							articulos.add(postres);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				articulos.setVisible(false);
				articulos.setVisible(true);

			}
		});

	}

}
