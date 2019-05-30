package interfaces;

import javax.swing.JPanel;

import clases.Camarero;
import clases.Mesa;
import excepciones.DniInvalidoException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistroCamarero extends JDialog {
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldDni;
	private JTextField textFieldTipodecamarero;

	
	
public RegistroCamarero() {
	super();
	setSize(480,200);
	setLayout(null);
	
	JLabel registro = new JLabel("Registro Camarero");
	registro.setBounds(98, 11, 96, 14);
	add(registro);
	
	textFieldNombre = new JTextField();
	textFieldNombre.setBounds(173, 56, 86, 20);
	add(textFieldNombre);
	textFieldNombre.setColumns(10);
	
	textFieldDni = new JTextField();
	textFieldDni.setBounds(173, 87, 86, 20);
	add(textFieldDni);
	textFieldDni.setColumns(10);
	
	textFieldTipodecamarero = new JTextField();
	textFieldTipodecamarero.setBounds(173, 115, 86, 20);
	add(textFieldTipodecamarero);
	textFieldTipodecamarero.setColumns(10);
	
	JLabel lblNombre = new JLabel("Nombre : ");
	lblNombre.setBounds(72, 59, 86, 14);
	add(lblNombre);
	
	JLabel lblDni = new JLabel("DNI :");
	lblDni.setBounds(72, 90, 46, 14);
	add(lblDni);
	
	JLabel lblTipoDeCamarero = new JLabel("Tipo de camarero");
	lblTipoDeCamarero.setBounds(72, 118, 118, 14);
	add(lblTipoDeCamarero);
	
	JButton btnAceptar = new JButton("Aceptar");
	btnAceptar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		ventana.cargaBd();
		String nombre =textFieldNombre.getText();
		String dni=textFieldDni.getText();
		String tipo =textFieldTipodecamarero.getText();
		
		try {
			Camarero cam =new Camarero(dni,nombre,tipo);
			 Statement stmte = ventana.getConnection().createStatement();
			 stmte.executeUpdate("insert into camarero(dni,nombre,tipoDeCamarero) values('"+dni+"','"+nombre+"','"+tipo+"')");
	stmte.close();
		} catch (DniInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	});
	btnAceptar.setBounds(203, 166, 89, 23);
	add(btnAceptar);
	
	JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			

			
			
			
			//TODO se pilla 
		}
	});
	btnCancelar.setBounds(98, 166, 89, 23);
	add(btnCancelar);
	
	

	}
}
