package interfaces;

import javax.swing.JPanel;

import clases.Camarero;
import clases.Mesa;
import excepciones.DniInvalidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class RegistroCamarero extends JDialog {
	private JDialog thisRef;
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldDni;
	private JTextField textFieldTipodecamarero;
private Mesa  mesa;
	
	
public RegistroCamarero() {
	super();
	setTitle("Registro camareros");
	setSize(500,300);
	setLocation(400,300);
	getContentPane().setLayout(null);
	
	JLabel registro = new JLabel("Registro Camarero");
	registro.setBounds(98, 11, 96, 14);
	getContentPane().add(registro);
	
	textFieldNombre = new JTextField();
	textFieldNombre.setBounds(173, 56, 86, 20);
	getContentPane().add(textFieldNombre);
	textFieldNombre.setColumns(10);
	
	textFieldDni = new JTextField();
	textFieldDni.setBounds(173, 87, 86, 20);
	getContentPane().add(textFieldDni);
	textFieldDni.setColumns(10);
	
	textFieldTipodecamarero = new JTextField();
	textFieldTipodecamarero.setBounds(173, 115, 86, 20);
	getContentPane().add(textFieldTipodecamarero);
	textFieldTipodecamarero.setColumns(10);
	
	JLabel lblNombre = new JLabel("Nombre : ");
	lblNombre.setBounds(72, 59, 86, 14);
	getContentPane().add(lblNombre);
	
	JLabel lblDni = new JLabel("DNI :");
	lblDni.setBounds(72, 90, 46, 14);
	getContentPane().add(lblDni);
	
	JLabel lblTipoDeCamarero = new JLabel("Tipo de camarero");
	lblTipoDeCamarero.setBounds(72, 118, 118, 14);
	getContentPane().add(lblTipoDeCamarero);
	
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
	JOptionPane.showMessageDialog(ventana, "Camarero Registrado","Registro",JOptionPane.INFORMATION_MESSAGE);
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
	getContentPane().add(btnAceptar);
	
	
	
	JLabel fotoCamarero = new JLabel("");
	fotoCamarero.setIcon(new ImageIcon("./camarero.png"));
	fotoCamarero.setBounds(268, 11, 216, 251);
	getContentPane().add(fotoCamarero);
	
	

	}
}
