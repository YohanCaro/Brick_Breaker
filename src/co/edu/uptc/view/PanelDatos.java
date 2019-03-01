package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelDatos extends JDialog{

	private JLabel tNick;
	private JTextField cNick;
	private JButton bAceptar;
	private VentanaPrincipal ventana;
	
	public PanelDatos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		this.setTitle("New Player!");
		this.setSize(250,200);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		tNick = new JLabel("Introduzca su nickname");
		tNick.setFont(new Font("Handle", 1, 17));
		tNick.setBounds(20, 20, 240, 40);
		
		cNick = new JTextField();
		cNick.setBounds(30, 80, 190, 30);
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(80, 130, 90, 30);
		bAceptar.setActionCommand("ACEPTAR");
		bAceptar.addActionListener(ventana.getEventos());
		
		this.add(tNick);
		this.add(cNick);
		this.add(bAceptar);
	}

	public JLabel gettNick() {
		return tNick;
	}

	public void settNick(JLabel tNick) {
		this.tNick = tNick;
	}

	public JTextField getcNick() {
		return cNick;
	}

	public void setcNick(JTextField cNick) {
		this.cNick = cNick;
	}

	public JButton getbAceptar() {
		return bAceptar;
	}

	public void setbAceptar(JButton bAceptar) {
		this.bAceptar = bAceptar;
	}

}
