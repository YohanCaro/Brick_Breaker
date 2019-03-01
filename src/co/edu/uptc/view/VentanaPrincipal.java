package co.edu.uptc.view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.uptc.controller.Control;

public class VentanaPrincipal extends JFrame{
	
	private PanelJuego panelJ;
	private Hilo hilo2;
	private Eventos eventos;
	private Control control;
	private boolean activar;
	
	public VentanaPrincipal() {	
		this.setTitle("Juego!");
		this.setSize(850,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		control = new Control();		
		
		eventos = new Eventos(this);
		this.addKeyListener(eventos);
		
		hilo2 = new Hilo(this);
		activar = false;
		
		panelJ = new PanelJuego(this);
		panelJ.repaint();
		this.add(panelJ);
	}
	
	public boolean isActivar() {
		return activar;
	}

	public void setActivar(boolean activar) {
		this.activar = activar;
	}

	public PanelJuego getPanelJ() {
		return panelJ;
	}

	public void setPanelJ(PanelJuego panelJ) {
		this.panelJ = panelJ;
	}

	public Hilo getHilo2() {
		return hilo2;
	}

	public void setHilo2(Hilo hilo) {
		this.hilo2 = hilo;
	}

	public Eventos getEventos() {
		return eventos;
	}

	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}
	
}
