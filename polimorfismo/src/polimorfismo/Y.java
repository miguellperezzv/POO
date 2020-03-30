package polimorfismo;

import java.awt.Graphics;
import java.util.Random;

abstract class Y {

	int u;
	Y(int x){
		u=x;	
	}
	abstract String F();
}

class A extends Y{

	int largo=0;
	int aciertos=0;
	Graphics g;
	A(int a, int l, Graphics gr) {
		super(a);
		largo=l;
		g=gr;
	}

	
	String F() {
		int coord[]=new int[2];
		int intentos = 10000000;
		Random rnd = new Random();
		aciertos=0;
		double pi=0;
		
		for(int i=0;i<intentos+1;i++) {
			coord[0]=(int)(rnd.nextInt(largo/2));
			coord[1]=(int)(rnd.nextInt(largo/2));
			
			if(Math.random()<=0.5) {
				coord[0]=coord[0]*-1;
			}
			if(Math.random()<=0.5) {
				coord[1]=coord[1]*-1;
			}
			
			if(Math.sqrt(Math.pow(coord[0], 2)+Math.pow(coord[1], 2))<=largo/2) {
				aciertos++;
				//System.out.print(coord[0]+","+coord[1]+"está dentro del circ\n");
			}
			else {
				//System.out.print(coord[0]+","+coord[1]+"no está dentro del circ\n");
			}
			
			//g.drawString(".", coord[0]+100, 100-coord[1]);
		}
		pi=4*aciertos;
		pi=(double)pi/intentos;
		return  ("Pi es:  " + pi + " (calculado por método Montecarlo)");
	}
}
	
class B extends Y{

	B(int a) {
		super(a);
	}

	@Override
	String F() {
		double pi=0;
		double div=0;
		int exponente=0;
		for (int i=1; i<10; i++) {
			div=(4/(i*2-1));
			exponente=(int) -(Math.pow(-1, i));
			div=exponente*div;
			pi=pi + div ;
		}
		return ("Pi es:  "+ pi + " (calculado por sumatoria)");
		
	}
	
}

class C extends Y{

	C(int x) {
		super(x);
		
	}


	String F() {
		double pi=0;
		for(int i=1;i<3001;i++)
		{
			pi=pi+(1/(Math.pow(i, 2)));
		}
		pi=(double)(Math.sqrt(6*pi));
		return ("Pi es: "+pi+" (calculado por raiz a sumatoria)");
		
	}
	
}
	
