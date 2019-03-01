package co.edu.uptc.view;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Hilo extends Thread {

	private VentanaPrincipal gui;

	public Hilo(VentanaPrincipal gui) {
		this.gui = gui;
	}

	public void run() {
		while (gui.getPanelJ().isPlay()) {
			
			if (new Rectangle2D.Double(gui.getPanelJ().getBolaX(), gui.getPanelJ().getBolaY(), 30, 30).intersects
					(new Rectangle2D.Double(gui.getPanelJ().getRectX(), 600, gui.getPanelJ().getGro1(), 20))) {
				gui.getPanelJ().setDirY(-gui.getPanelJ().getDirY());
			}
			
			A: for (int i = 0; i < gui.getPanelJ().getBloques().getBloques().length; i++) {
				for (int j = 0; j < gui.getPanelJ().getBloques().getBloques()[0].length; j++) {
					if (gui.getPanelJ().getBloques().getBloques()[i][j] == 1) {
						int posX = j*gui.getPanelJ().getBloques().getAncho() + 20;
						int posY = i*gui.getPanelJ().getBloques().getAlto() +50;
						int ancho = gui.getPanelJ().getBloques().getAncho();
						int alto = gui.getPanelJ().getBloques().getAlto();
						
						Rectangle rect = new Rectangle(posX, posY, ancho, alto);
						Rectangle rectBall = new Rectangle(gui.getPanelJ().getBolaX(), gui.getPanelJ().getBolaY(), 30, 30);
//						Rectangle rectangulo = rect;
						
						if (rectBall.intersects(rect)) {
							gui.getPanelJ().setnBloques(gui.getPanelJ().getnBloques()-1);
							gui.getPanelJ().getBloques().quitarBloque(i, j);
							gui.getPanelJ().setPuntuacion(gui.getPanelJ().getPuntuacion()+1);
							System.out.println("Llego " + gui.getPanelJ().getPuntuacion());
							
							if (gui.getPanelJ().getBolaX() + 19 <= rect.x || gui.getPanelJ().getBolaX() + 1 >= rect.x + rect.width) {
								gui.getPanelJ().setDirX(-gui.getPanelJ().getDirX());
							} else {
								gui.getPanelJ().setDirY(-gui.getPanelJ().getDirY());
							}
							
							break A;
						}
					}
				}
			}
			
			/*
			 * Movimiento de la bola
			 */
			gui.getPanelJ().setBolaX(gui.getPanelJ().getBolaX() + gui.getPanelJ().getDirX());
			gui.getPanelJ().setBolaY(gui.getPanelJ().getBolaY() + gui.getPanelJ().getDirY());
			
			if(gui.getPanelJ().getBolaX() < 0) {
				gui.getPanelJ().setDirX(- gui.getPanelJ().getDirX());
			} if(gui.getPanelJ().getBolaY() < 0) {
				gui.getPanelJ().setDirY(-gui.getPanelJ().getDirY());
			} if(gui.getPanelJ().getBolaX() > 570) {
				gui.getPanelJ().setDirX(- gui.getPanelJ().getDirX());
			} if(gui.getPanelJ().getBolaY() > 650) {
				gui.getPanelJ().setDirY(-gui.getPanelJ().getDirY());
			}
			
			poderes();
			
			if (!gui.isActivar()) {
			try {
				if (gui.getPanelJ().getnBloques() > 25 ) {
					sleep(9);
				} else if(gui.getPanelJ().getnBloques() <= 25 && gui.getPanelJ().getnBloques() > 19) {
					sleep(7);
				} else if (gui.getPanelJ().getnBloques() <= 19 && gui.getPanelJ().getnBloques() > 12){
					sleep(5);
				} else if (gui.getPanelJ().getnBloques() <= 12 && gui.getPanelJ().getnBloques() > 6){
					sleep(3);
				} else {
					sleep(2);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			} else {
				try {
					sleep(6);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			gui.repaint();
		}
	}
	
	public void poderes() {
		/*
		 * Poderes
		 */
		int posX = gui.getPanelJ().getRectX();
		
		Rectangle rect = new Rectangle(posX, 600, gui.getPanelJ().getGro1(), 20);
		Rectangle rectRed = new Rectangle(gui.getPanelJ().getAle(), gui.getPanelJ().getCub(), 30, 30);
		Rectangle rectRed2 = new Rectangle(gui.getPanelJ().getAle2(), gui.getPanelJ().getCub2(), 30, 30);
		Rectangle rectRed3 = new Rectangle(gui.getPanelJ().getAle3(), gui.getPanelJ().getCub3(), 30, 30);
		Rectangle rectRed4 = new Rectangle(gui.getPanelJ().getAle4(), gui.getPanelJ().getCub4(), 30, 30);
		
		//Rojo
		if (rect.intersects(rectRed)) {
			gui.getPanelJ().setPower(false);
			gui.getPanelJ().setCub(-40);
			gui.getPanelJ().setBajar(0);
			gui.getPanelJ().setBolaY(720);
			gui.getPanelJ().setPlay(false);
			gui.getPanelJ().setPause(false);
		} 
		//Blue
		else if (rect.intersects(rectRed2)) {
			gui.getPanelJ().setGro1(gui.getPanelJ().getGro1()+26);
			gui.getPanelJ().setCub2(-40);
			gui.getPanelJ().setBajar2(0);
		} 
		//Magenta
		else if (rect.intersects(rectRed3)) {
			try {
				sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gui.setActivar(true);
			gui.getPanelJ().setCub3(-40);
			gui.getPanelJ().setBajar3(0);
		} 
		//Pink
		else if (rect.intersects(rectRed4)) {
			gui.getPanelJ().setGro1(gui.getPanelJ().getGro1() - 30);
			gui.getPanelJ().setCub4(-40);
			gui.getPanelJ().setBajar4(0);
		}
		
		/*
		 * Accion poder
		 */
		if (gui.getPanelJ().getnBloques() == gui.getPanelJ().getnAl()) {
			gui.getPanelJ().setPower(true);
			gui.getPanelJ().setCub(gui.getPanelJ().getCub() + gui.getPanelJ().getBajar());
		} 
		else if (gui.getPanelJ().getnBloques() == gui.getPanelJ().getnAl()-2) {
			gui.getPanelJ().setPower(false);
			gui.getPanelJ().setCub(300);
		} 
		//2
		else if (gui.getPanelJ().getnBloques() == gui.getPanelJ().getnAl2()) {
			gui.getPanelJ().setPower2(true);
			gui.getPanelJ().setCub2(gui.getPanelJ().getCub2() + gui.getPanelJ().getBajar2());
		} else if (gui.getPanelJ().getnBloques() == gui.getPanelJ().getnAl2()-2) {
			gui.getPanelJ().setPower2(false);
			gui.getPanelJ().setCub2(300);
		} 
		//3
		else if (gui.getPanelJ().getnBloques() < gui.getPanelJ().getnAl3()) {
			gui.getPanelJ().setPower3(true);
			gui.getPanelJ().setCub3(gui.getPanelJ().getCub3() + gui.getPanelJ().getBajar3());
		} else if (gui.getPanelJ().getnBloques() == gui.getPanelJ().getnAl3()-2) {
			gui.getPanelJ().setPower3(false);
			gui.getPanelJ().setCub3(300);
		}
		// 4
		else if (gui.getPanelJ().getnBloques() < gui.getPanelJ().getnAl4()) {
			gui.getPanelJ().setPower4(true);
			gui.getPanelJ().setCub4(gui.getPanelJ().getCub4() + gui.getPanelJ().getBajar4());
		} else if (gui.getPanelJ().getnBloques() == gui.getPanelJ().getnAl4()-2) {
			gui.getPanelJ().setPower4(false);
			gui.getPanelJ().setCub4(300);
		}
	}
	
}
