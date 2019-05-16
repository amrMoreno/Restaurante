package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Terraza  extends JPanel {
	private Ventana ventana;
	
	public Terraza(Ventana v) {
		super();
		setBackground(new Color(255, 255, 153));
		this.ventana=v;
		this.setBounds(10, 72, 430, 217);
		setLayout(null);
		
		JButton btnMesa5 = new JButton("");
ImageIcon mesa5=new ImageIcon("./table5n.png");	
		btnMesa5.setIcon(mesa5);
		btnMesa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMesa5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(5);
			}
		});
		btnMesa5.setBounds(10, 39, 75, 75);
		add(btnMesa5);
		
		JButton btnMesa6 = new JButton("");
ImageIcon mesa6=new ImageIcon("./table6n.png");
		btnMesa6.setIcon(mesa6);
		btnMesa6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(6);
			}
		});
		btnMesa6.setBounds(10, 125, 75, 75);
		add(btnMesa6);
		
		
		JButton btnMesa7 = new JButton("");
ImageIcon mesa7=new ImageIcon("./table7n.png");		
		btnMesa7.setIcon(mesa7);
		btnMesa7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(7);
			}
		});
		btnMesa7.setBounds(178, 39, 75, 75);
		add(btnMesa7);
		
		
		
	}
}
