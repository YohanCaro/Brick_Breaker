package co.edu.uptc.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DatosCSVDAO {

		
	/**
	 * Datos[1] -> Pos bola x
	 * Datos[2] -> Pos bola y
	 * Datos[3] -> Dir bola x
	 * Datos[4] -> Dir bola y
	 * Datos[5] -> Cantidad de bloques
	 * @throws IOException 
 	 */
	public String[] leerDatos() throws IOException {
		String[] datos = new String[3];
		BufferedReader br = new BufferedReader(new FileReader("./data/datos.csv"));
	    String linea = br.readLine();
	    datos = linea.split(" ");
   	 	br.close();
		return datos;
	}

	public void escribir(int posX, int posY, int cantBloques) throws IOException {
		if (posX > 0 && posY > 0 && cantBloques > 1) {
			File  file = new File("./data/datos.csv");
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream);
			
			writer.write(posX + " " + posY + " " + cantBloques);
			
			writer.close();
			outputStream.close();
		}
	}
	
	//Metodo Colleccion.sort(Arr...) Para ordenar!

}
