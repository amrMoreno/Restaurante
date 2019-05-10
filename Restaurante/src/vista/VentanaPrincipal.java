package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import com.sun.glass.ui.Menu;

public class VentanaPrincipal extends JFrame{
	private VentanaPrincipal inicio;
	private Salon salon;
	private Terraza terraza;
	private Mesa mesa;
	private JPanel titulo ;
	
	public VentanaPrincipal() {
		super();
		this.inicio=this;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1DAM\\Documents\\GitHub\\Restaurante\\Restaurante\\icono.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		getContentPane().setLayout(null);
	
mesa =new Mesa();
	this.add(mesa);

	mesa.setVisible(true);
		
	}	
		
}
