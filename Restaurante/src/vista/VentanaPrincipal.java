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

public class VentanaPrincipal extends JFrame{
	private VentanaPrincipal menu;
	private Salon salon;
	private Terraza terraza;
	
	public VentanaPrincipal() {
		this.menu=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1DAM\\Documents\\GitHub\\Restaurante\\Restaurante\\icono.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		getContentPane().setLayout(null);
		
		
		
		
			
		
		
		salon = new Salon();
		salon.setBounds(0, 79, 434, 216);
		getContentPane().add(salon);
		salon.setLayout(null);
		
		
		terraza =new Terraza();
		terraza.setBounds(0, 79, 434, 216);
		getContentPane().add(terraza);
		terraza.setLayout(null);
		
		JPanel Menu = new JPanel();
		Menu.setBounds(0, 0, 434, 80);
		getContentPane().add(Menu);
		Menu.setLayout(null);
		
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
		Menu.add(SalonM);
		Menu.add(TerrazaM);
		
		
		Label Titulo = new Label("Restaurante Cenec");
		Titulo.setBounds(0, 10, 434, 33);
		Menu.add(Titulo);
		Titulo.setAlignment(Label.CENTER);
		Titulo.setFont(new Font("Bauhaus 93", Font.BOLD | Font.ITALIC, 20));
		
		
		
		
		
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 7;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;

	}

}
