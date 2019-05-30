package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import clases.Mesa;
import clases.Productos;
import clases.Productos.TipoProducto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal extends JPanel {
	private Ventana ventana;
	private Principal thisRef;
	private Connection c;
	private Statement stmte;
	protected  Mesa mesa;
	private JPanel lista;
	private JLabel labelTotal;
	
	public Principal(Ventana v,Mesa m) {

		super();
		mesa=m;
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

		lista = new JPanel();
		lista.setBorder(UIManager.getBorder("CheckBox.border"));
		lista.setBounds(0, 56, 127, 197);
		add(lista);
		lista.setLayout(null);
		//----
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 184, -108, -178);
		lista.add(scrollPane);
		
		JPanel total = new JPanel();
		total.setBorder(UIManager.getBorder("CheckBox.border"));
		total.setBounds(0, 252, 127, 48);
		add(total);

		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		total.add(lblTotal);
		
		 labelTotal = new JLabel("0");
		total.add(labelTotal);

		JPanel menu2 = new JPanel();
		menu2.setBorder(UIManager.getBorder("CheckBox.border"));
		menu2.setBounds(127, 252, 323, 48);
		add(menu2);
		menu2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton BCobrar = new JButton("Cobrar");
		BCobrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cobrar();
			}
		});
		BCobrar.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		BCobrar.setBackground(new Color(102, 204, 0));
		menu2.add(BCobrar);

		JButton BImprimir = new JButton("Imprimir Factura");
		BImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				factura(mesa.getNumeroMesa());
			}
		});
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
		articulos.setOpaque(false);
		
		articulos.setBackground(Color.WHITE);
		articulos.setBorder(UIManager.getBorder("CheckBox.border"));
		articulos.setBounds(127, 32, 238, 221);
		add(articulos);
		articulos.setLayout(new GridLayout(2, 2, 0, 0));
				
				JPanel imagen = new JPanel();
				imagen.setBorder(UIManager.getBorder("CheckBox.border"));
				imagen.setBounds(127, 32, 238, 221);
				add(imagen);
				imagen.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("./Sin t\u00EDtulo.png"));
				lblNewLabel.setBounds(60, 54, 178, 132);
				imagen.add(lblNewLabel);
			
		
				JLabel lblListaConsumo = new JLabel("Lista Consumo");
				lblListaConsumo.setBackground(new Color(50, 205, 50));
				lblListaConsumo.setBounds(0, 32, 127, 20);
				add(lblListaConsumo);
				lblListaConsumo.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));

		BBebidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				articulos.removeAll();

				if (Productos.TipoProducto.REFRESCO != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte.executeQuery("SELECT * FROM bebida WHERE tipo = 'REFRESCO'");

						while (rst.next()) {
							Productos bebida = new Productos(rst.getString("nombre"), TipoProducto.REFRESCO,
									rst.getFloat("precio"));
							JButton producto = new JButton(bebida.getNombre());
							producto.setFont(new Font("Agency FB", Font.ITALIC, 12));
							articulos.add(producto);
							producto.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(bebida);
									repintarListaProductos();
								}
								
							});
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
									rst.getFloat("precio"));
							JButton producto = new JButton(comida.getNombre());
							articulos.add(producto);	
							producto.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(comida);
									repintarListaProductos();
								}
								
							});
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
							Productos copa = new Productos(rst.getString("nombre"), TipoProducto.COPAS,
									rst.getFloat("precio"));
							JButton productos = new JButton(copa.getNombre());
							articulos.add(productos);	
							
							productos.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(copa);
									repintarListaProductos();
								}
								
							});
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
									rst.getFloat("precio"));
							JButton entrantes = new JButton(comida.getNombre());
							articulos.add(entrantes);
							entrantes.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(comida);
									repintarListaProductos();
								}
								
							});
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
									rst.getFloat("precio"));
							JButton licor = new JButton(comida.getNombre());
							articulos.add(licor);	
							licor.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(comida);
									repintarListaProductos();
								}
								
							});
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

				if (Productos.TipoProducto.MEDIO_ENTRANTE != null) {
					try {
						stmte = c.createStatement();
						ResultSet rst = stmte.executeQuery("SELECT * FROM productos WHERE tipoDeProducto = ' MEDIO_ENTRANTE'");

						while (rst.next()) {
							Productos comida = new Productos(rst.getString("nombre"), TipoProducto.MEDIO_ENTRANTE,
									rst.getFloat("precio"));
							JButton entrantes = new JButton(comida.getNombre());
							articulos.add(entrantes);
							entrantes.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(comida);
									repintarListaProductos();
								}
								
							});
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

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
									rst.getFloat("precio"));
							JButton vino = new JButton(comida.getNombre());
							articulos.add(vino);	
							vino.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(comida);
									repintarListaProductos();
								}
								
							});
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
									rst.getFloat("precio"));
							JButton postres = new JButton(comida.getNombre());
							articulos.add(postres);
							postres.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent arg0) {
									mesa.getProductosConsumidos().add(comida);
									repintarListaProductos();
								}
								
							});
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
	
	public void repintarListaProductos() {
		lista.removeAll();
		System.out.println(lista.getComponentCount());
		lista.setLayout(new GridLayout(mesa.getProductosConsumidos().size(),1));
		float total=0;
		for(int i=0;i<mesa.getProductosConsumidos().size();i++) {
			
			lista.add(new JLabel(mesa.getProductosConsumidos().get(i).getNombre()+""+mesa.getProductosConsumidos().get(i).getPrecio()+"€"+add(new JButton("+"))+add(new JButton("-"))));

			total+=mesa.getProductosConsumidos().get(i).getPrecio();
		}
		labelTotal.setText(total+"");
		lista.setVisible(false);
	
		lista.setVisible(true);
	}
	
	public void cobrar() {
		mesa.setLibre();
	}
	/**
	 * Imprime en un Fichero .TXT la factura total 
	 * @param a numero de la mesa pasado por parametros
	 */
	public void factura(int a) {
		if(mesa.getCamarero()==null) {
			Camareros c=new Camareros(mesa);
			c.setVisible(true);
		}
		FileWriter fichero = null;
        PrintWriter pw = null;
        float total= 0;
        try
        {
        	
            fichero = new FileWriter("./Factura"+a+".txt");
            pw = new PrintWriter(fichero);
            
            pw.println("RESTAURANTE CENEC");
            pw.println();
            pw.println("__________________________");
            pw.println("   El numero de mesa es:  "+mesa.getNumeroMesa());
            pw.println("|                            |");
            pw.println("   La fecha es :    "+mesa.getFecha());
            pw.println("|                            |");
            pw.println("__________________________");
            for (int i = 0; i < mesa.getProductosConsumidos().size(); i++) {
            	     pw.println(i+" |"+mesa.getProductosConsumidos().get(i).getNombre()+"  "+mesa.getProductosConsumidos().get(i).getPrecio());
            	     total+=mesa.getProductosConsumidos().get(i).getPrecio();
            }
            pw.print("---------------");
            pw.print("                "+total+"€");
           

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
	}
}
