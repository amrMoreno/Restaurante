package interfaces;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private Principal mesa;
	private Salon pantallaSalon;
	private Terraza pantallaTerraza;
	private Camareros camarero;
	
	
	public Ventana() {
		super();
		this.setTitle("Restaurante Cenec");
		pantallaInicio=new PantallaInicio(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1DAM\\Documents\\GitHub\\Restaurante\\Restaurante\\icono.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(465,330);
		this.setContentPane(pantallaInicio);
		
		
		
		setVisible(true);
	}

	public void cargaPantallaInicio() {
		//No hay por qu� comprobar si es nula.
		//Nunca lo va  a ser: es la pantalla por
		//defecto, y se inicializa en el constructor
		//de ventana.
		this.setTitle("Restaurante cenec");
		
		if(this.mesa!=null) {
			this.mesa.setVisible(false);
		}/*
		if(this.pantallaRegistro!=null) {
			this.pantallaRegistro.setVisible(false);
		}*/
		this.pantallaInicio.setVisible(true);
		this.setContentPane(this.pantallaInicio);
	
		
}
	public void cargaPrincipal(int n) {
		if(mesa==null) {
			mesa=new Principal(this);
			camarero=new Camareros(this);
			/*this.camarero.setVisible(true);
		 camarero.setSize(450,200);*/
		}	
		this.setTitle("Mesa"+ n);
		this.pantallaInicio.setVisible(false);
		this.mesa.setVisible(true);
		this.setContentPane(this.mesa);
		
	}
		
	
}
