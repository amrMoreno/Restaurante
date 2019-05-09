package interfaces;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Terraza  extends JPanel {
	private Ventana ventana;
	
	public Terraza(Ventana v) {
		super();
		setBackground(new Color(255, 255, 153));
		this.ventana=v;
		this.setBounds(10, 72, 430, 217);
		setLayout(null);
		
		JButton btnMesa7 = new JButton("7");
		btnMesa7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(7);
			}
		});
		btnMesa7.setBounds(10, 65, 89, 23);
		add(btnMesa7);
		
		JButton btnMesa8 = new JButton("8");
		btnMesa8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(8);
			}
		});
		btnMesa8.setBounds(10, 139, 89, 23);
		add(btnMesa8);
		
		
		
	}
}
