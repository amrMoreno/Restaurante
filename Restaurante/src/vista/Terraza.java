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
		
		JButton button = new JButton("1");
		button.setBounds(48, 56, 55, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBounds(184, 56, 55, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBounds(310, 56, 62, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(48, 116, 55, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(184, 116, 55, 23);
		panel.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(310, 116, 62, 23);
		panel.add(button_5);

	}

}
