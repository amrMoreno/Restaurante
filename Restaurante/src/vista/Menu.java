package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Menu menu;
	private MainT terraza;
	 private JPanel panelSalon;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Menu frame = new Menu();
					frame.setVisible(true);
					//Menu ventana=this;
					Menu_2 frame1 = new Menu_2();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 * @return 
	 */

	public Menu() {
		this.menu=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1DAM\\Documents\\GitHub\\Restaurante\\Restaurante\\icono.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		terraza=new MainT();
		terraza.setVisible(false);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1, 0, 63, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{21, 32, 22, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Label label_1 = new Label("Restaurante Cenec");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 7;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		contentPane.add(label_1, gbc_label_1);
		
		Button button_6 = new Button("Salon");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terraza.setVisible(false);
		 		getContentPane().add(panelSalon);
		 		panelSalon.setVisible(true);
			}
		});
		button_6.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 0;
		gbc_button_6.gridy = 1;
		contentPane.add(button_6, gbc_button_6);
		 
		 Button button_7 = new Button("Terraza");
		 button_7.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelSalon.setVisible(false);
		 		getContentPane().add(terraza);
		 		terraza.setVisible(true);
		 	}
		 });
		 button_7.setBackground(Color.YELLOW);
		 GridBagConstraints gbc_button_7 = new GridBagConstraints();
		 gbc_button_7.insets = new Insets(0, 0, 5, 5);
		 gbc_button_7.gridx = 1;
		 gbc_button_7.gridy = 1;
		 contentPane.add(button_7, gbc_button_7);
		
		 panelSalon = new JPanel();
		panelSalon.setBackground(Color.YELLOW);
		GridBagConstraints gbc_panelSalon = new GridBagConstraints();
		gbc_panelSalon.gridheight = 4;
		gbc_panelSalon.gridwidth = 7;
		gbc_panelSalon.fill = GridBagConstraints.BOTH;
		gbc_panelSalon.gridx = 0;
		gbc_panelSalon.gridy = 2;
		contentPane.add(panelSalon, gbc_panelSalon);
		GridBagLayout gbl_panelSalon = new GridBagLayout();
		gbl_panelSalon.columnWidths = new int[]{0, 0, 51, 0};
		gbl_panelSalon.rowHeights = new int[]{0, 47, 0};
		gbl_panelSalon.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelSalon.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelSalon.setLayout(gbl_panelSalon);
		
		JButton Mesa1 = new JButton("1");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panelSalon.add(Mesa1, gbc_btnNewButton);
		
		JButton Mesa2 = new JButton("2");
		Mesa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_Mesa2 = new GridBagConstraints();
		gbc_Mesa2.insets = new Insets(0, 0, 5, 5);
		gbc_Mesa2.gridx = 1;
		gbc_Mesa2.gridy = 0;
		panelSalon.add(Mesa2, gbc_Mesa2);
		
		JButton Mesa3 = new JButton("3");
		GridBagConstraints gbc_Mesa3 = new GridBagConstraints();
		gbc_Mesa3.insets = new Insets(0, 0, 5, 0);
		gbc_Mesa3.gridx = 2;
		gbc_Mesa3.gridy = 0;
		panelSalon.add(Mesa3, gbc_Mesa3);
		
		JButton Mesa4 = new JButton("4");
		GridBagConstraints gbc_Mesa4 = new GridBagConstraints();
		gbc_Mesa4.insets = new Insets(0, 0, 0, 5);
		gbc_Mesa4.gridx = 0;
		gbc_Mesa4.gridy = 1;
		panelSalon.add(Mesa4, gbc_Mesa4);
		
		JButton Mesa5 = new JButton("5");
		GridBagConstraints gbc_Mesa5 = new GridBagConstraints();
		gbc_Mesa5.insets = new Insets(0, 0, 0, 5);
		gbc_Mesa5.gridx = 1;
		gbc_Mesa5.gridy = 1;
		panelSalon.add(Mesa5, gbc_Mesa5);
		
		JButton Mesa6 = new JButton("6");
		GridBagConstraints gbc_Mesa6 = new GridBagConstraints();
		gbc_Mesa6.gridx = 2;
		gbc_Mesa6.gridy = 1;
		panelSalon.add(Mesa6, gbc_Mesa6);
	}
}
