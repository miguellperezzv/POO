package puntosEquipo;

public class A {
	Equipo[] equipos = new Equipo[10];
	int ind;
	
	A(){
		
	}
	
	void AgregarEquipo(Equipo e){ //Agrega
		equipos[ind] = e;
		ind++;
	}
	
	Equipo getEquipo(int i){
		return equipos[i];
	}
	
	void ActualizarEquipo(String nombre, int puntos){
		
		int i=0;
		while(equipos[i].nombre!= nombre){
			i++;
		}
		
		equipos[i].puntos=+puntos;
	}
}
