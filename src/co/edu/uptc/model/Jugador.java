package co.edu.uptc.model;

public class Jugador {

	private String nickName;
	private int puntaje;
	
	public Jugador(String nickName, int puntaje) {
		this.nickName = nickName;
		this.puntaje = puntaje;
	}
	
	public Jugador() {
		
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
}
