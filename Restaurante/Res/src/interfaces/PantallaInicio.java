package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class PantallaInicio  extends JPanel{
	private Ventana ventana;
	private JPanel pantallaSalon;
	private JPanel pantallaTerraza;
	
	public PantallaInicio(Ventana v) {
		super();
		this.ventana=v;
		
		setLayout(null);
		
		JLabel Titulo = new JLabel("Restaurante Cenec");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 24));
		Titulo.setBounds(10, 11, 430, 22);
		add(Titulo);
		pantallaSalon=new Salon(ventana);
		add(pantallaSalon);
		pantallaTerraza=new Terraza(ventana);
		add(pantallaTerraza);
		
		JButton btnSalon = new JButton("Salon");
		btnSalon.setBackground(new Color(250, 235, 215));
		btnSalon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			cargaSalon();
			}
		});
		btnSalon.setBounds(10, 38, 89, 23);
		add(btnSalon);
		
		JButton btnTerraza = new JButton("Terraza");
		btnTerraza.setBackground(new Color(255, 255, 153));
		btnTerraza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			cargaTerraza();
			}
		});
		btnTerraza.setBounds(109, 38, 89, 23);
		add(btnTerraza);
		
	
	}
public void cargaSalon() {
		
		pantallaTerraza.setVisible(false);
	pantallaSalon.setVisible(true);
		
		}
	
	public void cargaTerraza() {
	pantallaSalon.setVisible(false);
	pantallaTerraza.setVisible(true);
		
		}
	
}
