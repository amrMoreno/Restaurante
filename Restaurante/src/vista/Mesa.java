package vista;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import com.sun.glass.ui.Menu;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Mesa extends JPanel {
	private VentanaPrincipal menu;
	private Mesa mesa;

	
	public Mesa() {
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBounds(0, 0, 450, 33);
		add(panel);
		
		JLabel lblRestauranteCenec = new JLabel("Restaurante Cenec");
		panel.add(lblRestauranteCenec);
		lblRestauranteCenec.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		
		JPanel lista = new JPanel();
		lista.setBorder(UIManager.getBorder("CheckBox.border"));
		lista.setBounds(0, 32, 127, 221);
		add(lista);
		lista.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 255, 204));
		panel_3.setBounds(0, 0, 127, 25);
		lista.add(panel_3);
		
		JLabel lblListaConsumo = new JLabel("Lista Consumo");
		lblListaConsumo.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		panel_3.add(lblListaConsumo);
		
		JPanel total = new JPanel();
		total.setBorder(UIManager.getBorder("CheckBox.border"));
		total.setBounds(0, 252, 127, 48);
		add(total);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		total.add(lblTotal);
		
		JPanel menu2 = new JPanel();
		menu2.setBorder(UIManager.getBorder("CheckBox.border"));
		menu2.setBounds(127, 252, 323, 48);
		add(menu2);
		menu2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton BCobrar = new JButton("Cobrar");
		BCobrar.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		BCobrar.setBackground(new Color(102, 204, 0));
		menu2.add(BCobrar);
		
		JButton BImprimir = new JButton("Imprimir Factura");
		BImprimir.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		menu2.add(BImprimir);
		
		JButton BPendiente = new JButton("Pendiente");
		BPendiente.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 16));
		BPendiente.setBackground(new Color(0, 51, 255));
		menu2.add(BPendiente);
		
		
		JPanel menu1 = new JPanel();
		menu1.setLayout(new GridLayout(7, 0));
		menu1.setBorder(UIManager.getBorder("CheckBox.border"));
		menu1.setBounds(364, 32, 86, 221);
		add(menu1);
		
		JButton BBebidas = new JButton("Bebidas");
		BBebidas.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BBebidas);
		
		JButton BComida = new JButton("Comida");
		BComida.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BComida);
		
		JButton BEntrantes = new JButton("Entrantes");
		BEntrantes.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BEntrantes);
		
		JButton BMedias = new JButton("1/2");
		BMedias.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BMedias);
		
		JButton BLicores = new JButton("Licores");
		BLicores.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BLicores);
		
		JButton BCopas = new JButton("Copas");
		BCopas.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BCopas);
		
		JButton BVinos = new JButton("Vinos");
		BVinos.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 13));
		menu1.add(BVinos);
		
		JPanel articulos = new JPanel();
		articulos.setBackground(Color.WHITE);
		articulos.setBorder(UIManager.getBorder("CheckBox.border"));
		articulos.setBounds(127, 32, 238, 221);
		add(articulos);
	}
	
	public void cargarMesa (int numero) {
		
		Mesa nMesa = null;
		if(mesa==null) {
			nMesa=new Mesa();
		nMesa.setVisible(true);
		}else {
			nMesa.setVisible(true);
		}
	menu.setVisible(false);
			
	}
}
