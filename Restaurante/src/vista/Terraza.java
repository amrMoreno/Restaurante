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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Terraza extends JPanel {

	/**
	 * Create the panel.
	 */
	public Terraza() {
		super();
		setLayout(null);
		
		JPanel panel = new JPanel();		
		panel.setBounds(3, 2, 447, 237);
		panel.setBackground(new Color(255, 255, 153));
		add(panel);
		panel.setLayout(null);
		
		JButton m7 = new JButton("7");
		m7.setBounds(48, 56, 55, 23);
		panel.add(m7);
		
		JButton m8 = new JButton("8");
		m8.setBounds(184, 56, 55, 23);
		panel.add(m8);
		
		JButton m9 = new JButton("9");
		m9.setBounds(310, 56, 62, 23);
		panel.add(m9);
		
		JButton m10 = new JButton("10");
		m10.setBounds(48, 116, 55, 23);
		panel.add(m10);
		
		JButton m11 = new JButton("11");
		m11.setBounds(184, 116, 55, 23);
		panel.add(m11);
		
		JButton m12 = new JButton("12");
		m12.setBounds(310, 116, 62, 23);
		panel.add(m12);

	}

}
