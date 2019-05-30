package interfaces;

import javax.swing.JPanel;

import clases.Mesa;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JLabel;

public class SalonTerraza extends JPanel {
	private Ventana ventana;
	
	public SalonTerraza(Ventana v) {
		super();
		setBackground(new Color(250, 235, 215));
		this.ventana=v;
		this.setBounds(10, 72, 430, 217);
		setLayout(null);
		
		JPanel zonaSalon = new JPanel();
		zonaSalon.setBackground(new Color(255, 153, 102));
		zonaSalon.setBounds(0, 0, 209, 217);
		add(zonaSalon);
		
		JPanel zonaTerraza = new JPanel();
		zonaTerraza.setBackground(new Color(102, 204, 153));
		zonaTerraza.setBounds(207, 0, 223, 217);
		add(zonaTerraza);
		
		Iterator i=ventana.getMesas().keySet().iterator();
		while(i.hasNext()) {
			int nmesa=(Integer)i.next();
			if(nmesa<5) {
				zonaSalon.add(ventana.getMesas().get(nmesa));
			}else {
				zonaTerraza.add(ventana.getMesas().get(nmesa));
			}
		}
		
	}
}
