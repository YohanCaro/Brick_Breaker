package co.edu.uptc.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Rectangulo {

	private int x, y, x2, y2;
	private Color colorFondo, colorBorde;
	private BasicStroke bs;
	private Rectangle rectangulo;
	
	public Rectangulo(int x, int y, int x2, int y2, Color colorFondo, Color colorBorde, BasicStroke bs) {
		rectangulo = new Rectangle(x, y, x2, y2);
		this.colorFondo = colorFondo;
		this.colorBorde = colorBorde;
		this.bs = bs;
	}
	
	public void dibujar(Graphics2D g) {
		 g.setPaint(colorFondo);
	     g.fill(rectangulo);
	     g.setStroke(bs);
	     g.setPaint(colorBorde);
	     g.draw(rectangulo);
	     
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

	public Rectangle getRectangulo() {
		return rectangulo;
	}

	public void setRectangulo(Rectangle rectangulo) {
		this.rectangulo = rectangulo;
	}

	public BasicStroke getBs() {
		return bs;
	}

	public void setBs(BasicStroke bs) {
		this.bs = bs;
	}
	
}
