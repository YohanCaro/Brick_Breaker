package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

public class ListaPuntajes {
	
	private VentanaPrincipal ventana;
	
	public ListaPuntajes(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public void dibujar(Graphics2D g) {
		List<String> cad = ventana.getControl().cadenaPuntajes();
		
		g.setColor(Color.WHITE);
		g.fillRect(610, 80, 230, 260);
		g.setColor(Color.CYAN);
		g.drawRect(610, 80, 230, 260);
		
		g.setColor(Color.RED);	
		g.setFont(new Font("Arial", 1, 19));
		g.drawString("Mejores Puntajes", 640, 110);
		
		if (!cad.isEmpty()) {
			g.setColor(Color.BLACK);	
			g.setFont(new Font("Arial", 1, 15));
			g.drawString("1." +cad.get(0), 620, 145);
		
			if (cad.size() > 1) {
				g.setColor(Color.BLACK);	
				g.setFont(new Font("Arial", 1, 15));
				g.drawString("2. " + cad.get(1), 620, 185);
			}
		
			if (cad.size() > 2) {
				g.setColor(Color.BLACK);	
				g.setFont(new Font("Arial", 1, 15));
				g.drawString("3." + cad.get(2), 620, 225);
			}
		
			if (cad.size() > 3) {
				g.setColor(Color.BLACK);	
				g.setFont(new Font("Arial", 1, 15));
				g.drawString("4." +cad.get(3), 620, 265);
			}
		
			if (cad.size() > 4) {
				g.setColor(Color.BLACK);	
				g.setFont(new Font("Arial", 1, 15));
				g.drawString("5." +cad.get(4), 620, 305);
			}
		}
		g.setColor(Color.WHITE);
		g.fillRect(610, 360, 230, 290);
		g.setColor(Color.CYAN);
		g.drawRect(610, 360, 230, 290);
		
		g.setColor(Color.RED);	
		g.setFont(new Font("Arial", 1, 19));
		g.drawString("Ayuda!", 690, 390);
		
		//inst
		g.setColor(Color.RED);
		g.fillRect(630, 405, 25, 25);
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 13));
		g.drawString("Mina!", 670, 420);
		
		g.setColor(Color.BLUE);
		g.fillRect(630, 435, 25, 25);
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 13));
		g.drawString("Más grande!", 670, 450);
		
		g.setColor(Color.MAGENTA);
		g.fillRect(630, 465, 25, 25);
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 13));
		g.drawString("Más lento o más rápido!", 670, 480);
		
		g.setColor(Color.PINK);
		g.fillRect(630, 495, 25, 25);
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 13));
		g.drawString("Más pequeño!", 670, 510);
		
		//Ayu
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 12));
		g.drawString("Presiona ESC para salir y guardar!", 620, 550);
		
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 12));
		g.drawString("Presiona ENTER para pausar!", 620, 580);
		
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 12));
		g.drawString("Presiona G para guardar puntaje!", 620, 610);
		
		g.setColor(Color.BLACK);	
		g.setFont(new Font("Arial", 1, 12));
		g.drawString("Presiona SPACE para volver a jugar!", 620, 640);
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
}
