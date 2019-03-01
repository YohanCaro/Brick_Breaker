package co.edu.uptc.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circulo {
	
	private int x, y, x2, y2;
	private Color colorFondo, colorBorde;
	private BasicStroke bs;
	private Ellipse2D elipse;
	
	public Circulo(int x, int y, int x2, int y2, Color colorFondo, Color colorBorde, BasicStroke bs) {
		this.colorFondo = colorFondo;
		this.colorBorde = colorBorde;
		this.bs = bs;
		elipse = new Ellipse2D.Double(x, y, x2, y2);
	}
	
	public Circulo() {
		
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(colorBorde);
		g2.fill(elipse);
		g2.setStroke(bs);
		g2.setColor(colorFondo);
		g2.draw(elipse);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}

	public Color getColorBorde() {
		return colorBorde;
	}

	public void setColorBorde(Color colorBorde) {
		this.colorBorde = colorBorde;
	}

	public Ellipse2D getElipse() {
		return elipse;
	}

	public void setElipse(Ellipse2D elipse) {
		this.elipse = elipse;
	}

}
