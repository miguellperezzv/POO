package precios;

public class Articulo {

	int p;
	int cantidad;
	String nombre;
	/*int pDolar;
	int pMex;
	int pYen;
	int pReal;*/
	
	
	Articulo(String nombre, int precio, int cantidad){
		this.nombre=nombre;
		this.p = precio;
		this.cantidad = cantidad;
	}
	
	int ConsultarCant() {
		return this.cantidad;
	}
	
	float ConsultarDolar() {
		float dolar;
		dolar= (float) (this.p * 0.000334);
		return dolar;
	}
	
	float ConsultarMex() {
		float mex;
		mex= (float) (this.p * 0.005927);
		return mex;
	}
	
	float ConsultarYen() {
		float yen;
		yen = (float)(this.p * 0.03670);
		return yen; 
	}
	
	float ConsultarEuro() {
		float euro;
		euro = (float)(this.p * 0.0002846);
		return euro;
	}
	
	float ConsultarReal() {
		float real;
		real = (float)(this.p * 0.001053);
		return real;
	}
	
	
}
