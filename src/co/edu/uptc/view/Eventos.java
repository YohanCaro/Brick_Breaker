package co.edu.uptc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.uptc.model.Bloques;

public class Eventos implements ActionListener, KeyListener{
	
	private VentanaPrincipal ventana;
	private PanelDatos panelD;
	
	public Eventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals("ACEPTAR")) {
			System.out.println("Juagdor");
			String nick = panelD.getcNick().getText();
			ventana.getControl().agregarJugador(nick, ventana.getPanelJ().getPuntuacion());
			System.out.println(nick);
			panelD.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("Tecla :" + key);
		if (key == KeyEvent.VK_SPACE) {
			if (!ventana.getPanelJ().isPlay() && !ventana.getPanelJ().isPause()) {
				ventana.getPanelJ().setPower(false);
				ventana.getPanelJ().setPower2(false);
				ventana.getPanelJ().setPower3(false);
				ventana.getPanelJ().setPower4(false);
				ventana.getPanelJ().setPlay(true);
				ventana.getPanelJ().setBolaX(300);
				ventana.getPanelJ().setBolaY(550);
				ventana.getPanelJ().setPuntuacion(0);
				ventana.getPanelJ().setRectX(300);
				ventana.getPanelJ().setBloques(new Bloques(5, 7));
				ventana.getPanelJ().setnBloques(35);
				ventana.getPanelJ().setGro1(99);
				ventana.setActivar(false);
				
				Random rnd = new Random();
				ventana.getPanelJ().setnAl(5 +rnd.nextInt(28));
				ventana.getPanelJ().setnAl2(5 + rnd.nextInt(28));
				ventana.getPanelJ().setnAl3(5 + rnd.nextInt(28));
				ventana.getPanelJ().setnAl4(5 + rnd.nextInt(28));
				
				Hilo hilo = new Hilo(ventana);
				hilo.start();
				ventana.setHilo2(hilo);
			}
		} else if (key == KeyEvent.VK_LEFT) {
			if (ventana.getPanelJ().getRectX() > 1) {
				ventana.getPanelJ().setRectX(ventana.getPanelJ().getRectX() - 12);
			}
		} else if (key == KeyEvent.VK_RIGHT) {
			if (ventana.getPanelJ().getRectX() < 500) {
				ventana.getPanelJ().setRectX(ventana.getPanelJ().getRectX() + 12);
			}
		} if (key == KeyEvent.VK_ENTER){
			if (!ventana.getPanelJ().isPlay()) {
				Hilo hilo = new Hilo(ventana);
				hilo.start();
				ventana.getPanelJ().setPlay(true);
				ventana.getPanelJ().setPause(false);
				if (ventana.getPanelJ().isDes()) {
					ventana.getPanelJ().setDirX(1);
					ventana.getPanelJ().setDirY(2);
					ventana.getPanelJ().setDes(false);
				}
				ventana.setHilo2(hilo);
			} else {
				ventana.getPanelJ().setPlay(false);
				ventana.getPanelJ().setPause(true);
			}
		} else if (key == KeyEvent.VK_G){
			panelD = new PanelDatos(ventana);
		}
		else if (key == KeyEvent.VK_ESCAPE) {
			int valor = e.getID();
			String a = e.paramString();
			
			Object [] opciones ={"Aceptar","Cancelar"};
			int eleccion = JOptionPane.showOptionDialog(null, "¿Desea salir del juego?","Mensaje de Confirmacion!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
			if (eleccion == JOptionPane.YES_OPTION) {
				try {
					ventana.getControl().guardar(ventana.getPanelJ().getBolaX(), ventana.getPanelJ().getBolaY(), 12);
					System.out.println("Se guardo!");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No se guardaron los datos del juego!");
				}
				System.exit(0);
			}
		}   
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) { 
		
	}


}
