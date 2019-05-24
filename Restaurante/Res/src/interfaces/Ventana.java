package interfaces;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import clases.Camarero;
import clases.Mesa;
import clases.Productos;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	private PantallaInicio pantallaInicio;
	private HashMap<Integer,Mesa> mesas;
	private ArrayList<Principal> pantallasPrincipal;
	private ArrayList<Camarero> camareros;
	private Salon pantallaSalon;
	private Terraza pantallaTerraza;
	private Camareros camarero;
	public Connection connection;
	private Mesa mesa;

	
	
	public Ventana() {
		super();
		this.setTitle("Restaurante Cenec");
		//inicializar todos los camareros
		this.mesas=new HashMap<Integer,Mesa>();
		this.mesas.put(1, new Mesa(1,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
		this.mesas.put(2, new Mesa(2,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
		this.mesas.put(3, new Mesa(3,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
		this.mesas.put(4, new Mesa(4,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
		this.mesas.put(5, new Mesa(5,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
		this.mesas.put(6, new Mesa(6,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
		this.mesas.put(7, new Mesa(7,new ArrayList<Productos>(),LocalDateTime.now(),null/*coger a un camarero del arrayLis*/));
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
		if(this.pantallasPrincipal==null) {
			this.pantallasPrincipal=new ArrayList<Principal>();
			Iterator it=mesas.entrySet().iterator();
			while(it.hasNext()) {
				pantallasPrincipal.add(new Principal(this,(Mesa)it.next()));
			}
		}
		/*if(this.pantallaRegistro!=null) {
			this.pantallaRegistro.setVisible(false);
		}*/
		this.pantallaInicio.setVisible(true);
		this.setContentPane(this.pantallaInicio);
	
		
}
	public void cargaPrincipal(int n) {

		if(this.pantallasPrincipal==null) {
			this.pantallasPrincipal=new ArrayList<Principal>();
			Iterator it=mesas.entrySet().iterator();
			while(it.hasNext()) {
				Entry<Integer,Mesa> actual=(Entry<Integer,Mesa>)it.next();
				pantallasPrincipal.add(new Principal(this,actual.getValue()));
			}
		}
		this.setTitle("Mesa"+ n);
		this.pantallaInicio.setVisible(false);
		this.pantallasPrincipal.get(n-1).setVisible(true);
		setContentPane(this.pantallasPrincipal.get(n-1));
		
	}
	/**
	 * Funcion que carga la base de dato para conectrase a ella
	 * @return
	 */
	public Connection  cargaBd () {
		
	        try {
	        	 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
	        	//setConnection(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", ""));
	        	   return connection;
	        } catch (SQLException ex) {
	            System.err.println("Imposible conectar");
	            ex.printStackTrace();
	            System.exit(0);
	        }
	        return connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
		
	
}
