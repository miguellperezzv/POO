package factorial;

import java.util.Scanner;

public class Factorial {

	static int cantidad;
	static int grupo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese numero de elementos ");
		int cantidad = sc.nextInt();
		System.out.print("Ingrese la cantidad de elementos que deben tener los grupos ");
		int grupo = sc.nextInt();
		Factorial factorial  =new Factorial(cantidad, grupo);
		System.out.println("Posibles combinaciones: " + factorial.Calcular(cantidad,grupo));
	}
	
	Factorial(int n, int r) {
		Factorial.cantidad = n;
		Factorial.grupo= r;
		
	}
	int Calcular(int n, int r) {
		int h= n-r;
		int x=1;
		int y=1;
		for(int i=n; i>h;i--){
			x=x*i;
		}
		for(int i=1;i<=r;i++) {
			y=y*i;
		}
		return (x/y);
	}

}
