package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

import javax.swing.JPanel;

import co.edu.uptc.model.Bloques;
import co.edu.uptc.model.Circulo;
import co.edu.uptc.model.Rectangulo;

public class PanelJuego extends JPanel{
	
	private Rectangulo rectangulo, mini, mini2, mini3, mini4;
	private Circulo bola;
	private int bolaX, bolaY, dirX, dirY, rectX, gro1, gro2;
	private int puntuacion;
	private Bloques bloques;
	private ListaPuntajes lista;
	private boolean play, pause, des, dead, power, power2, power3, power4;
	private int nBloques, ale, ale2, ale3, ale4, bajar, bajar2, bajar3, bajar4, cub, cub2, cub3, cub4;
	private int nAl, nAl2, nAl3, nAl4;
	private Random rnd;
	private VentanaPrincipal ventana;
	
	public PanelJuego(VentanaPrincipal ventana) {
		this.ventana = ventana;
		this.setLayout(null);
		this.setBounds(0, 0, 850, 700);
		nBloques = 35;
		
		System.out.println("A");
		try {
			ventana.getControl().cargar();
		} catch (NumberFormatException | IOException e) {
			System.out.println("No cargo el archivo");
		}
		System.out.println("C");
		
		if (ventana.getControl().getDatos()[0] > 0 || ventana.getControl().getDatos()[1] > 0|| ventana.getControl().getDatos()[2] > 1) {
			System.out.println("Cargo!");
			this.setBolaX(ventana.getControl().getDatos()[0]);
			this.setBolaY(ventana.getControl().getDatos()[1]);
		} else {
			bolaX = 300;
			bolaY = 550;
			System.out.println("No cargo");
		}
		
		rnd = new Random();
		inicializadorRand();
		inicializadorPoderes();
		inicializarBooleanos();
		
		puntuacion = 0;
		bloques = new Bloques(5, 7);
		lista = new ListaPuntajes(ventana);
		this.addKeyListener(ventana.getEventos());
		
		
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 671);
		g.setColor(Color.CYAN);
		g.drawRect(0, 0, 600, 671);
		
		lista.dibujar((Graphics2D) g);
		
		rectangulo = new Rectangulo(rectX, 600, gro1, 20, new Color(2, 177, 255), Color.CYAN, new BasicStroke(2));
		rectangulo.dibujar((Graphics2D) g);
		
		bola = new Circulo(bolaX, bolaY, 30, 30,new Color(7, 246, 94), Color.GREEN, new BasicStroke(2));
		bola.dibujar((Graphics2D) g);
		
		g.setColor(Color.BLACK);		
		g.setFont(new Font("Arial Black", 1, 20));
		g.drawString("Tú puntuación: " + puntuacion, 620, 50);
		
		bloques.dibujarBloques((Graphics2D) g);
		boolean act = true;
		
		if (power) {
			mini = new Rectangulo(ale, cub, 30, 30, Color.RED, Color.BLACK, new BasicStroke(2));
			mini.dibujar((Graphics2D) g);
		} else if (power2) {
			mini2 = new Rectangulo(ale2, cub2, 30, 30, Color.BLUE, Color.BLACK, new BasicStroke(2));
			mini2.dibujar((Graphics2D) g);
		} else if (power3) {
			mini3 = new Rectangulo(ale3, cub3, 30, 30, Color.MAGENTA, Color.BLACK, new BasicStroke(2));
			mini3.dibujar((Graphics2D) g);
		} else if (power4) {
			mini4 = new Rectangulo(ale4, cub4, 30, 30, Color.PINK, Color.BLACK, new BasicStroke(2));
			mini4.dibujar((Graphics2D) g);
		}
		
		if (bolaY > 630) {
			g.setColor(Color.WHITE);		
			g.setFont(new Font("Arial Black", 1, 25));
			g.drawString("Game Over!", 220, 300);
			
			g.setColor(Color.WHITE);	
			g.setFont(new Font("Arial Black", 1, 25));
			g.drawString("Puntuación final: " + puntuacion, 200, 350);
			
			g.setColor(Color.WHITE);	
			g.setFont(new Font("Arial Black", 1, 22));
			g.drawString("Presiona Space para volver a jugar", 100, 390);
			dirX = 0;
			dirY = 0;
			play = false;
			act = false;
			des = true;
			dead = true;
		} 
		else if (nBloques == 0) {
			g.setColor(Color.WHITE);		
			g.setFont(new Font("Arial Black", 1, 25));
			g.drawString("Felicidades has ganado!", 200, 300);
			
			g.setColor(Color.WHITE);	
			g.setFont(new Font("Arial Black", 1, 25));
			g.drawString("Puntuación final: " + puntuacion, 200, 350);
			
			dirX = 0;
			dirY = 0;
			play = false;
			des = true;
			dead = true;
		} 
		else if (pause) {
			g.setColor(Color.WHITE);		
			g.setFont(new Font("Arial Black", 1, 25));
			g.drawString("Pausa!", 250, 300);
		} else if (!pause && !play && act){
			g.setColor(Color.WHITE);		
			g.setFont(new Font("Arial Black", 1, 25));
			g.drawString("Presiona Enter para jugar!", 100, 300);
		}
	}
	
	/**
	 * Metodos inicializadores!
	 */
	
	public void inicializarBooleanos() {
		play = false;
		pause = false;
		des = false;
		power = false;
		power2 = false;
		power3 = false;
		power4 = false;
	}
	
	public void inicializadorRand() {
		ale = 10 + rnd.nextInt(540);
		ale2 = 10 +rnd.nextInt(540);
		ale3 = 10 + rnd.nextInt(540);
		ale4 = 10 + rnd.nextInt(540);
		
		nAl = 5 + rnd.nextInt(29);
		nAl2 = 5 + rnd.nextInt(29);
		nAl3 = 5 + rnd.nextInt(29);
		nAl4 = 5 + rnd.nextInt(29);
	}
	
	public void inicializadorPoderes() {
		bajar = 1;
		bajar2 = 1;
		bajar3 = 1;
		bajar4 = 1;
		
		cub = 250;
		cub2 = 250;
		cub3 = 250;
		cub4 = 250;
		
		dirX = 1;
		dirY = 2;
		rectX = 300;
		gro1 = 99;
	}

	
	/**
	 * Getters and Setters!
	 * @return
	 */

	public Rectangulo getMini3() {
		return mini3;
	}

	public int getGro2() {
		return gro2;
	}

	public void setGro2(int gro2) {
		this.gro2 = gro2;
	}

	public void setMini3(Rectangulo mini3) {
		this.mini3 = mini3;
	}

	public Rectangulo getMini4() {
		return mini4;
	}

	public void setMini4(Rectangulo mini4) {
		this.mini4 = mini4;
	}

	public boolean isPower3() {
		return power3;
	}

	public void setPower3(boolean power3) {
		this.power3 = power3;
	}

	public boolean isPower4() {
		return power4;
	}

	public void setPower4(boolean power4) {
		this.power4 = power4;
	}

	public int getAle3() {
		return ale3;
	}

	public void setAle3(int ale3) {
		this.ale3 = ale3;
	}

	public int getAle4() {
		return ale4;
	}

	public void setAle4(int ale4) {
		this.ale4 = ale4;
	}

	public int getBajar3() {
		return bajar3;
	}

	public void setBajar3(int bajar3) {
		this.bajar3 = bajar3;
	}

	public int getBajar4() {
		return bajar4;
	}

	public void setBajar4(int bajar4) {
		this.bajar4 = bajar4;
	}

	public int getCub3() {
		return cub3;
	}

	public void setCub3(int cub3) {
		this.cub3 = cub3;
	}

	public int getCub4() {
		return cub4;
	}

	public void setCub4(int cub4) {
		this.cub4 = cub4;
	}

	public int getnAl() {
		return nAl;
	}

	public void setnAl(int nAl) {
		this.nAl = nAl;
	}

	public int getnAl2() {
		return nAl2;
	}

	public void setnAl2(int nAl2) {
		this.nAl2 = nAl2;
	}

	public int getnAl3() {
		return nAl3;
	}

	public void setnAl3(int nAl3) {
		this.nAl3 = nAl3;
	}

	public int getnAl4() {
		return nAl4;
	}

	public void setnAl4(int nAl4) {
		this.nAl4 = nAl4;
	}

	public Random getRnd() {
		return rnd;
	}

	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}

	public int getGro1() {
		return gro1;
	}

	public void setGro1(int gro1) {
		this.gro1 = gro1;
	}

	public int getAle2() {
		return ale2;
	}

	public void setAle2(int ale2) {
		this.ale2 = ale2;
	}

	public int getBajar2() {
		return bajar2;
	}

	public void setBajar2(int bajar2) {
		this.bajar2 = bajar2;
	}

	public boolean isPower2() {
		return power2;
	}

	public void setPower2(boolean power2) {
		this.power2 = power2;
	}

	public Rectangulo getMini2() {
		return mini2;
	}

	public void setMini2(Rectangulo mini2) {
		this.mini2 = mini2;
	}

	public int getCub2() {
		return cub2;
	}

	public void setCub2(int cub2) {
		this.cub2 = cub2;
	}

	public int getCub() {
		return cub;
	}

	public void setCub(int cub) {
		this.cub = cub;
	}

	public int getAle() {
		return ale;
	}

	public void setAle(int ale) {
		this.ale = ale;
	}

	public int getBajar() {
		return bajar;
	}

	public void setBajar(int bajar) {
		this.bajar = bajar;
	}

	public Rectangulo getMini() {
		return mini;
	}

	public void setMini(Rectangulo mini) {
		this.mini = mini;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public Rectangulo getRectangulo() {
		return rectangulo;
	}

	public void setRectangulo(Rectangulo rectangulo) {
		this.rectangulo = rectangulo;
	}

	public Circulo getBola() {
		return bola;
	}

	public void setBola(Circulo bola) {
		this.bola = bola;
	}

	public int getBolaX() {
		return bolaX;
	}

	public void setBolaX(int bolaX) {
		this.bolaX = bolaX;
	}

	public int getBolaY() {
		return bolaY;
	}

	public void setBolaY(int bolaY) {
		this.bolaY = bolaY;
	}

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public int getRectX() {
		return rectX;
	}

	public void setRectX(int rectX) {
		this.rectX = rectX;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Bloques getBloques() {
		return bloques;
	}

	public void setBloques(Bloques bloques) {
		this.bloques = bloques;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public int getnBloques() {
		return nBloques;
	}

	public void setnBloques(int nBloques) {
		this.nBloques = nBloques;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isDes() {
		return des;
	}

	public void setDes(boolean des) {
		this.des = des;
	}

	public ListaPuntajes getLista() {
		return lista;
	}

	public void setLista(ListaPuntajes lista) {
		this.lista = lista;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

}
