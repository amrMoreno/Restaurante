/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
}
