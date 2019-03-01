package co.edu.uptc.model;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bloques {

	private int bloques [][];
	private int ancho;
	private int alto;
	
	public Bloques(int fil, int col) {
		bloques = new int[fil][col];
		
		for (int i = 0; i < bloques.length; i++) {
			for (int j = 0; j < bloques[0].length; j++) {
				bloques[i][j] = 1;
			}
		}
		ancho = 570/col;
		alto = 170/fil;
	}
	
	public void dibujarBloques(Graphics2D g) {
		for (int i = 0; i < bloques.length; i++) {
			for (int j = 0; j < bloques[0].length; j++) {
				if (bloques[i][j] == 1) {
					if ((i+j)%2==0) {
						g.setColor(Color.YELLOW);
						g.fillRect(j* ancho + 20, i* alto + 50, ancho, alto);
					} else if ((i+j)%2!=0){
						g.setColor(Color.RED);
						g.fillRect(j* ancho + 20, i* alto + 50, ancho, alto);
					}
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.BLACK);
					g.drawRect(j* ancho + 20, i* alto + 50, ancho, alto);
				}
			}
		}
	}
	
	public void quitarBloque(int fill, int col) {
		bloques[fill][col] = 0;
	}

	public int[][] getBloques() {
		return bloques;
	}

	public void setBloques(int[][] bloques) {
		this.bloques = bloques;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
}
