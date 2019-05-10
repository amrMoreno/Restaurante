package interfaces;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Salon extends JPanel {
	private Ventana ventana;
	
	public Salon(Ventana v) {
		super();
		setBackground(new Color(250, 235, 215));
		this.ventana=v;
		this.setBounds(10, 72, 430, 217);
		setLayout(null);
		
		JButton btnMesa1 = new JButton("");
		ImageIcon mesa1=new ImageIcon("./table.png");
		
		
		btnMesa1.setIcon(mesa1);
	
		btnMesa1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(1);
			}
		});
		btnMesa1.setBounds(10, 39, 100, 75);
		add(btnMesa1);
		
		JButton btnMesa2 = new JButton("2");
		btnMesa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(2);
			}
		});
		
		btnMesa2.setBounds(10, 137, 89, 23);
		add(btnMesa2);
		
		JButton btnMesa3 = new JButton("3");
		btnMesa3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(3);
			}
		});
		btnMesa3.setBounds(178, 65, 89, 23);
		add(btnMesa3);
		
		JButton btnMesa4 = new JButton("4");
		btnMesa4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(4);
			}
		});
		btnMesa4.setBounds(178, 137, 89, 23);
		add(btnMesa4);
		
		
		
	}
}
