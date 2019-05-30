package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Camarero;
import clases.Mesa;
import clases.Productos;
import clases.Productos.TipoProducto;
import excepciones.DniInvalidoException;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

public class Camareros extends JDialog {
	private JDialog thisRef;
	private Connection c;
 private JPanel contentPane;

	public Camareros(Mesa mesa) {
		super();
		this.thisRef=this;
		setSize(480,200);
		setTitle("Camareros");
		setLocation(400,300);
		 contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Nuevo Camarero");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistroCamarero rc=new RegistroCamarero();
				rc.setVisible(true);
			
			}
		});
		btnRegistrar.setBounds(305, 83, 119, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thisRef.setVisible(false);
			}
		});
		btnAtras.setBounds(305, 128, 119, 23);
		contentPane.add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 295, 140);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10, 0));
		
		
		try {
			Connection c=Ventana.cargaBd();
			Statement stmte = c.createStatement();
			ResultSet rst = stmte
				.executeQuery("SELECT * FROM camarero");
			while (rst.next()) {
				Camarero camarero = new Camarero(rst.getString("dni"),rst.getString("nombre"),rst.getString("tipoDeCamarero"));
				
				JButton camarer = new JButton(camarero.getNombre());
				camarer.setFont(new Font("Agency FB", Font.ITALIC, 12));
				panel.add(camarer);
			
			camarer.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						mesa.setCamarero(camarero);
					}
					
				});
		} 
			c.close();	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DniInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		}
	
}
