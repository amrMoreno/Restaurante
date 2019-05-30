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
import javax.swing.ImageIcon;

public class PantallaInicio  extends JPanel{
	private Ventana ventana;
	private JPanel pantallaSalon;
	private JPanel pantallaTerraza;
	
	public PantallaInicio(Ventana v) {
		super();
		setBackground(new Color(0, 255, 255));
		this.ventana=v;
		
		setLayout(null);
		
		JLabel Titulo = new JLabel("Restaurante Cenec");
		Titulo.setBackground(new Color(0, 0, 0));
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 32));
		Titulo.setBounds(10, 7, 430, 50);
		add(Titulo);
		pantallaSalon=new SalonTerraza(ventana);
		add(pantallaSalon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./Sin t\u00EDtulo.png"));
		lblNewLabel.setBounds(0, 0, 138, 76);
		add(lblNewLabel);
		
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
