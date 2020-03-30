package encriptar;

import java.util.Scanner;

public class Encriptar {

	int numero;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int numero;
		System.out.println("Ingrese el numero de 4 digitos");
		numero=sc.nextInt();
		Encriptar num = new Encriptar(numero);
		System.out.println("Numero encriptado");
		num.encriptar();
		System.out.println("Numero desencriptado");
		num.desencriptar();
	}
	
	Encriptar(int numero){
		this.numero=numero;
	}
	
	void encriptar() {
		int numero=this.numero;
		String[] letras= {"d","c","b","a"};
		
		int[] encriptado = new int[4];
		
		for(int i=0;i<4;i++) {
			encriptado[i]=numero%10;
			numero=numero/10;
		}
		
		System.out.println(encriptado[3]+letras[3]+encriptado[2]+letras[2]+encriptado[1]+letras[1]+encriptado[0]+letras[0]);
		
	}
	
	void desencriptar() {
		
		System.out.println(this.numero);
	}
}
