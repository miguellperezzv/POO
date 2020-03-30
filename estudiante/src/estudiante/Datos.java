package estudiante;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Datos {
	
	String datos;
	String dataArray[];
	HashMap<String,String> hm = new HashMap<String, String>();
	String cod;
	String todo= "";
	double[] promedio = new double[100];
	double promedioMayor =0;
	
	int i=0;
	Datos(){
		
	}
	void registrar(String codigo,String nombre, String n1,String n2,String n3,String n4) {
		double promedioLocal=0;
		datos =nombre;
		cod=codigo;
		datos+=",";
		datos+=n1;
		datos+=",";
		datos+=n2;
		datos+=",";
		datos+=n3;
		datos+=",";
		datos+=n4;
		hm.put(cod, datos);
		System.out.print(datos);
		String s = (String)hm.get(cod);
		
		dataArray= s.split(",");
		double[] notas = new double[4];
		for(int i=0; i<4; i++){
			notas[i]= Double.parseDouble(dataArray[i+1]);
			
		}
		promedioLocal = notas[0]*0.1+notas[1]*0.3+notas[2]*0.3+notas[3]*0.3;
		promedioLocal = (int)(promedioLocal*10);
		promedioLocal = promedioLocal/10;
		if (promedioLocal*10>=promedioMayor*10){
			promedioMayor=promedioLocal;
			
		}
		
	}
	void consultar(){
		

		double promedio=0;
		double[] notas = new double[4];
		for(int i=0; i<4; i++){
			notas[i]= Double.parseDouble(dataArray[i+1]);
			
		}
		
		
		promedio=notas[0]*0.1+notas[1]*0.3+notas[2]*0.3+notas[3]*0.3;
		promedio=(int)(promedio*10);
		promedio = promedio/10;
		JOptionPane.showMessageDialog(null, promedio);

	}
	
	void enlistar() {
		
		Collection<String> colec=hm.values();

		Iterator<String> it=colec.iterator();
		
		
		
		while (it.hasNext()) {
		  String dt = (String)it.next();
		  String []datos;
		  datos = dt.split(","); // separa los datos
		  
		  String n0 = datos[0];
		  String n1=datos[1];
		  String n2=datos[2];
		  String n3=datos[3];
		  String n4=datos[4];
		  
		  double nuevopromedio = Integer.parseInt(datos[1])*0.1+Integer.parseInt(datos[2])*0.3+Integer.parseInt(datos[3])*0.3+Integer.parseInt(datos[4])*0.3;
		  nuevopromedio=(int)(nuevopromedio*10);
		  nuevopromedio=nuevopromedio/10;
		
		  todo =  todo + n0+" " +n1+" " + n2+" "+ n3+" "+ n4+"       " + nuevopromedio;
		  if(nuevopromedio==promedioMayor){
			  todo+=" * "+"\r"+ "\n";;//salto de linea
		  }
		  else{
			  todo+="\r"+ "\n";
		  }
		  
			}
		

		
	}}
	


