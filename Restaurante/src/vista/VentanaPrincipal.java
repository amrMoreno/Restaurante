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

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class VentanaPrincipal extends JFrame{
	private VentanaPrincipal menu;
	private Salon salon;
	private Terraza terraza;
	
	public VentanaPrincipal() {
		this.menu=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1DAM\\Documents\\GitHub\\Restaurante\\Restaurante\\icono.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("434px"),},
			new RowSpec[] {
				RowSpec.decode("56px"),
				RowSpec.decode("238px"),
				RowSpec.decode("12px"),}));
		
		JPanel Menu = new JPanel();
		getContentPane().add(Menu, "1, 1, fill, top");
		Menu.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton TerrazaM = new JButton("Terraza");
		TerrazaM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				salon.setVisible(false);
		 		getContentPane().add(terraza);
		 		terraza.setVisible(true);
			}
		});
		Menu.add(TerrazaM, "1, 2");
		Label Titulo = new Label("Restaurante Cenec");
		Titulo.setAlignment(Label.CENTER);
		Titulo.setFont(new Font("Bauhaus 93", Font.BOLD | Font.ITALIC, 20));
		Menu.add(Titulo, "3, 2, 1, 3, left, top");
		
		JButton SalonM = new JButton("Salon");
		SalonM.setBackground(new Color(255, 51, 51));
		SalonM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				terraza.setVisible(false);
		 		getContentPane().add(salon);
		 		salon.setVisible(true);
			}
		});
		Menu.add(SalonM, "1, 4");
		
		
		
		
			
		
		
		salon = new Salon();
		getContentPane().add(salon, "1, 2, 1, 2, fill, fill");
		
		
		
		
		
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 7;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;

	}

}
