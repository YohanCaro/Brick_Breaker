package co.edu.uptc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.dao.DatosCSVDAO;
import co.edu.uptc.exceptions.ComExceptions;
import co.edu.uptc.model.Jugador;

public class Control {

	private List<Jugador> jugadores;
	private DatosCSVDAO dao;
	private int[] datos;
	
	public Control() {
		jugadores = new ArrayList<>();
		dao = new DatosCSVDAO();
		datos = new int[3];
		for (int i = 0; i < datos.length; i++) {
			datos[i] = 0;
		}
	}
	
	public void agregarJugador(String nickName, int puntaje) {
		if (buscarJugador(nickName) == null) {
			Jugador jugador = new Jugador(nickName, puntaje);
			this.jugadores.add(jugador);
		} else {
			Jugador jugador = new Jugador(nickName, puntaje);
			this.jugadores.set(numeroJugador(nickName), jugador);
		}
	}

	public Jugador buscarJugador(String nickName) {
		Jugador jugador = null;
		for (int j = 0; j < this.jugadores.size(); j++) {
			if (nickName.equals(jugadores.get(j).getNickName())) {
				jugador = jugadores.get(j);
			}
		}
		return jugador;
	}
	
	public int numeroJugador(String nickName) {
		int jugador = 0;
		for (int j = 0; j < this.jugadores.size(); j++) {
			if (nickName.equals(jugadores.get(j).getNickName())) {
				jugador = j;
			}
		}
		return jugador;
	}
	
	public void ordenarPuntajes() {
		for (int i = 0; i < jugadores.size() -1; i++) {
			for (int j = i+1; j < jugadores.size(); j++) {
				if (jugadores.get(i).getPuntaje() < jugadores.get(j).getPuntaje()) {
					Jugador temp = jugadores.get(i);
					jugadores.set(i, jugadores.get(j));
					jugadores.set(j, temp);
				}
			}
		}
	}
	
	public List<String> cadenaPuntajes() {
		List<String> lista = new ArrayList<>();
		this.ordenarPuntajes();
		
		if (jugadores != null && !jugadores.isEmpty()) {
			for (Jugador jugador : jugadores) {
				StringBuilder cadena = new StringBuilder();
				cadena.append(jugador.getNickName());
				cadena.append(" - " + jugador.getPuntaje() + " puntos!");
				lista.add(cadena.toString());
			}
		}
		
		return lista;
	}
	
	public void guardar(int posX, int posY, int cantBloques) throws IOException {
		dao.escribir(posX, posY, cantBloques);
	}
	
	public void cargar() throws NumberFormatException, IOException {
		for (int i = 0; i < datos.length; i++) {
			int a = Integer.parseInt(dao.leerDatos()[i]);
			this.datos[i] = a;
		}
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public DatosCSVDAO getDao() {
		return dao;
	}

	public void setDao(DatosCSVDAO dao) {
		this.dao = dao;
	}

	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datos) {
		this.datos = datos;
	}
	
}