package vista;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;

import com.sun.glass.ui.Menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Salon extends JPanel {
	private Mesa mesa;

	private Salon salon;
	private Terraza terraza;
	private VentanaPrincipal inicio;

	/**
	 * Create the panel.
	 */
	public Salon() {
		super();
		setLayout(null);
		
		JPanel panel = new JPanel();		
		panel.setBounds(3, 2, 447, 226);
		panel.setBackground(new Color(255, 51, 51));
		add(panel);
		panel.setLayout(null);
		
		JButton m1 = new JButton("1");
		m1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
		
			}
		});
		m1.setBounds(48, 56, 55, 23);
		panel.add(m1);
		
		JButton m2 = new JButton("2");
		m2.setBounds(184, 56, 55, 23);
		panel.add(m2);
		
		JButton m3 = new JButton("3");
		m3.setBounds(310, 56, 62, 23);
		panel.add(m3);
		
		JButton m4 = new JButton("4");
		m4.setBounds(48, 116, 55, 23);
		panel.add(m4);
		
		JButton m5 = new JButton("5");
		m5.setBounds(184, 116, 55, 23);
		panel.add(m5);
		
		JButton m6 = new JButton("6");
		m6.setBounds(310, 116, 62, 23);
		panel.add(m6);

	}
	}
