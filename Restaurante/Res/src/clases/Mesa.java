/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import interfaces.Ventana;

/**
 *
 * @author 1DAM
 */
public class Mesa extends JButton {
    private int numeroMesa;
    private ArrayList<Productos> productosConsumidos;
    private LocalDateTime fecha;
    private Camarero camarero;
    private Ventana ventana;
    

    public Mesa(Ventana v,int numeroMesa,ArrayList<Productos> productosConsumidos, LocalDateTime fecha, Camarero camarero) {
    	this.ventana=v;
    	setIcon(new ImageIcon("./table"+numeroMesa+"n.png"));
    	this.numeroMesa = numeroMesa;
        this.productosConsumidos = productosConsumidos;
        this.fecha = fecha;
        this.camarero = camarero;
        this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargaPrincipal(numeroMesa);
				if(getProductosConsumidos()!=null) {
					setIcon(new ImageIcon("./table"+numeroMesa+"r.png"));
				}
				
			}
		});
    }
    
    public void setLibre() {
    	setIcon(new ImageIcon("./table"+numeroMesa+"n.png"));
    }
    
    

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public ArrayList<Productos> getProductosConsumidos() {
        return productosConsumidos;
    }

    public void setProductosConsumidos(ArrayList<Productos> productosConsumidos) {
        this.productosConsumidos = productosConsumidos;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

	
	public void factura(int a) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        float total= 0;
        try
        {
        	
            fichero = new FileWriter("./Factura"+a+".txt");
            pw = new PrintWriter(fichero);
            /*
            pw.println("<!DOCTYPE html>\r\n" + 
            		"<html lang=\"en\" dir=\"ltr\">\r\n" + 
            		"  <head>\r\n" + 
            		"    <meta charset=\"utf-8\">\r\n" + 
            		"    <title></title>\r\n" + 
            		"  </head>\r\n" + 
            		"  <body>\r\n" + 
            		"    <h1>HOLOA</h1>\r\n" + 
            		"    \r\n" + 
            		"  </body>\r\n" + 
            		"</html>");
            
            */
            pw.println("            RESTAURANTE CENEC");
            pw.println();
            pw.println("___________________________________________________");
            pw.println("|  El numero de mesa es:  "+getNumeroMesa()+"                        |");
            pw.println("|                                                  |");
            pw.println("|  La fecha es :    "+getFecha()+"        |");
            pw.println("|  Le atendio  :    "+getCamarero().getNombre()+ "                        |");
            pw.println("|                                                  |");
            pw.println("|__________________________________________________|");
            pw.println("|____     Los productos consumidos son:     _______|");
            for (int i = 0; i < getProductosConsumidos().size(); i++) {
            	     pw.println(" "+i+" |"+getProductosConsumidos().get(i).getNombre()+"   "+getProductosConsumidos().get(i).getPrecio()+" ");
            	     total+=getProductosConsumidos().get(i).getPrecio();
            } 
            pw.println("__________________________________________________");
            
            pw.print(" TOTAL:               "+total+"€");
           

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
}
