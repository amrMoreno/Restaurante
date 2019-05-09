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
	if (salon==null) {
		salon = new Salon();
		salon.setBounds(0, 79, 434, 216);
		//getContentPane().add(salon);
		salon.setLayout(null);
	}
		this.setContentPane(salon);
		
		if (terraza==null) {
		terraza =new Terraza();
		terraza.setBounds(0, 79, 434, 216);
		//getContentPane().add(terraza);
		terraza.setLayout(null);
		}
		this.setContentPane(terraza);
		
		if (titulo==null) {
		 titulo = new JPanel();
		titulo.setBounds(0, 0, 434, 80);
		//getContentPane().add(menu);
		titulo.setLayout(null);
		}
		this.setContentPane(titulo);
		
		JButton TerrazaM = new JButton("Terraza");
		TerrazaM.setBackground(new Color(255, 255, 153));
		TerrazaM.setBounds(0, 49, 102, 23);
		TerrazaM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				salon.setVisible(false);
		 		getContentPane().add(terraza);
		 		terraza.setVisible(true);
			}
		});
		
		JButton SalonM = new JButton("Salon");
		SalonM.setBounds(112, 49, 102, 23);
		SalonM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		SalonM.setBackground(new Color(255, 51, 51));
		SalonM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				terraza.setVisible(false);
		 		getContentPane().add(salon);
		 		salon.setVisible(true);
			}
		});
		inicio.add(SalonM);
		inicio.add(TerrazaM);
		
		
		JLabel Titulo = new JLabel("Restaurante Cenec");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(0, 10, 434, 33);
		inicio.add(Titulo);
		Titulo.setAlignmentY(Label.CENTER);
		Titulo.setAlignmentX(Label.CENTER);
		Titulo.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		
		
		
		
		
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 7;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;

	}
public void cargaMesa() {

	    if(mesa==null) {
	      mesa=new Mesa();
	    }
	    
	titulo.setVisible(false);
	 salon.setVisible(false);
	 terraza.setVisible(false); 
	inicio.add(mesa);
	  this.mesa.setVisible(true); 
	  
	  inicio.setTitle("Mesa");
}

		
		
}
