package precios;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Ingrese la cantidad de pantalones: ");
		int cantidad = sc.nextInt();
		Articulo pantalon = new Articulo("Pantalón", 200000,cantidad);
		System.out.println("Ingrese la cantidad de camisas: ");
		cantidad = sc.nextInt();
		Articulo camisa = new Articulo("Camisa",40000, cantidad);
		System.out.println("Ingrese la cantidad de zapatos: ");
		cantidad = sc.nextInt();
		Articulo zapato = new Articulo("Zapato ",60000,cantidad);
		
		
		boolean entrar=true;
		boolean entrarOpc = true;
		while (entrar==true) {
			
			Articulo prueba= new Articulo("null",0,0);
			int opcion;
			System.out.println("elija una prenda:\n 1. pantalon\n2. camisa\3. zapato\n 4. salir");
			opcion= sc.nextInt();
			if (opcion==1) {
				prueba = pantalon;	
				
			}else if (opcion==2) {
				prueba = camisa;
				
			}else if (opcion==3) {
				prueba = zapato;
				
			}
			else if(opcion==4){
				entrar=false;
			}else {System.out.print("Opcion inválida");}
			
			
			
			while(entrarOpc==true&&entrar==true) {
				opcion=0;
				System.out.println("elija una opcion: 1.consultar precio en Dolar\n"
												   + "2.consultar precio en Euro\n"
												   + "3 consultar precio en Real\n"
												   + "4.consultar precio en Yen\n"
												   + "5.consultar precio en Peso Col\n"
												   + "6.consultar precio en Peso Mex\n"
												   + "7.consultar cantidad\n"
												   + "8. salir");
				opcion=sc.nextInt();
				
				switch(opcion) {
				
				case 1:
					System.out.println("Precio de "+prueba.nombre+" en Dolar: "+prueba.ConsultarDolar()+"\n");
					break;
					
				case 2:
					System.out.println("Precio de "+prueba.nombre+" en Euro: "+prueba.ConsultarEuro()+"\n");
					break;
					
				case 3:
					System.out.println("Precio de "+prueba.nombre+" en Real: "+prueba.ConsultarReal()+"\n");
					break;
					
				case 4:
					System.out.println("Precio de "+prueba.nombre+" en Yen: "+prueba.ConsultarYen()+"\n");
					break;
					
				case 5:
					System.out.println("Precio de "+prueba.nombre+" en Peso Colombiano: "+prueba.p+"\n");
					break;
					
				case 6:
					System.out.println("Precio de "+prueba.nombre+" en Peso Mexicano: "+prueba.ConsultarMex()+"\n");
					break;
					
				case 7:
					System.out.println("Cantidad "+prueba.nombre+": "+prueba.cantidad+"\n");
					break;
					
				case 8:
					entrarOpc=false;
					break;
				default: System.out.println("Opcion inavalida");
				break;
				}
			}
		}
			
	
		
	}

}
