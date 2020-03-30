package puntosEquipo;

public class Equipo {

	String nombre;
	int puntos;
	
	Equipo(String nombre, int puntos){
		this.nombre = nombre;
		this.puntos=puntos;
	}
	
	String getNombre(){
		
		return this.nombre;
	}
	
	int getPuntos(){
		return this.puntos;
	}
}
