package interfaces;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private Principal[] mesa;
	private Salon pantallaSalon;
	private Terraza pantallaTerraza;
	private Camareros camarero;

	
	
	public Ventana() {
		super();
		this.setTitle("Restaurante Cenec");
		pantallaInicio=new PantallaInicio(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(465,330);
		this.setContentPane(pantallaInicio);
		setVisible(true);
		this.setLocation(400,200);
		try {
			this.setIconImage(ImageIO.read(new File("./icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void cargaPantallaInicio() {
		//No hay por qué comprobar si es nula.
		//Nunca lo va  a ser: es la pantalla por
		//defecto, y se inicializa en el constructor
		//de ventana.
		this.setTitle("Restaurante cenec");
		
		if(this.mesa!=null) {
			for (int i = 0; i < mesa.length; i++) {
				this.mesa[i].setVisible(false);
			}
		}/*
		if(this.pantallaRegistro!=null) {
			this.pantallaRegistro.setVisible(false);
		}*/
		this.pantallaInicio.setVisible(true);
		this.setContentPane(this.pantallaInicio);
	
		
}
	public void cargaPrincipal(int n) {
		
		if(mesa==null) {
			mesa=new Principal[7];
			for (int i = 0; i < mesa.length; i++) {
				mesa[i]=new Principal(this);
			}
			camarero=new Camareros(this);
			/*this.camarero.setVisible(true);
		 camarero.setSize(450,200);*/
		}	
		this.setTitle("Mesa"+ n);
		this.pantallaInicio.setVisible(false);
		this.mesa[n].setVisible(true);
		setContentPane(this.mesa[n]);
		
	}
		
	
}
