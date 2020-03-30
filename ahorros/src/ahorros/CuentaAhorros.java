package ahorros;

import java.util.Scanner;



public class CuentaAhorros {

	
	int codigo;
	int saldo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		
			System.out.println("Ingrese el código");
			int codigo = sc.nextInt();
			System.out.println("Ingrese el saldo inicial");
			int saldo =sc.nextInt();
			CuentaAhorros user = new CuentaAhorros(codigo, saldo);
			
			
			CuentaAhorros user2 = new CuentaAhorros(20, 2000);
			
		
			CuentaAhorros user3 = new CuentaAhorros(30,3000);
			
			
			 
			 
			 boolean entrada=true;
			 boolean ingreso =true;
			 boolean ingresoOpc = true;
			 while (entrada==true) {
			
			 
			CuentaAhorros usuario = new CuentaAhorros(0,0);
			while (ingreso==true) {
			
			
			 System.out.print("****BIENVENIDO*****\nIngrese codigo");
			 int codEnt=sc.nextInt();
			 
			 if (codEnt==user.codigo) {
				 usuario=user;
				 usuario.ConsultarSaldo();
				 ingreso =false;
			 }
			 else if (codEnt==user2.codigo) {
				 usuario=user2;
				 usuario.ConsultarSaldo();
				 ingreso =false;
			 }
			 else if(codEnt==user3.codigo) {
				 usuario= user3;
				 usuario.ConsultarSaldo();
				 ingreso =false;
			 }
			 else {System.out.print("Codigo inválido");}
			 
			}
		
		while(ingresoOpc==true) {
			
		
		System.out.println("Ingrese:\n1:retiro\n2:consignar\n3:consultar\n4:salir");
		int opcion= sc.nextInt();
		switch (opcion){
		case 1:
			System.out.print("Ingrese la cantidad a retirar");
			int retiro=sc.nextInt();
			usuario.retiro(retiro);
			break;
		case 2:
			System.out.print("Ingrese la cantidad a consignar");
			int consign=sc.nextInt();
			usuario.Consignacion(consign);
			break;
		case 3:
			usuario.ConsultarSaldo();
			break;
		case 4:
			System.out.print("Saliendo . . .");
			entrada=false;
			ingresoOpc=false;
			break;
		default: System.out.print("opcion inválida");
		break;
		}
		}
			 }
		}

		

	
	
CuentaAhorros(int codigo, int saldoInicial){
		
	this.codigo = codigo;
	this.saldo= saldoInicial;
	this.encriptar(this.saldo);
	this.des_encriptar(this.saldo);
	}
	
	void Consignacion(int x){
		this.des_encriptar(this.saldo);
		this.saldo += x;
		this.encriptar(this.saldo);		
	}
	
	void  ConsultarSaldo(){
		System.out.print("Usuario: "+this.codigo+", Su saldo actual es "+ des_encriptar(this.saldo)+"\n");
		this.encriptar(this.saldo);
	}
	void retiro (int x){
		
		
		if (this.des_encriptar(this.saldo)<x){
			System.out.print("Saldo insuficiente: ");
		}
		else{
			this.saldo = this.des_encriptar(this.saldo)-x;
			System.out.print("retiro exitoso ");
		}
		this.encriptar(this.saldo);
		this.ConsultarSaldo();
	}
	
	int encriptar(int x){
		
		int encriptado=0;
		if ((x & 4)==4){
			encriptado = x&0xfffffffb;
		}
		else{
			encriptado = x+4;
		}
		return encriptado;
		
		
	}
	int des_encriptar(int x){
		int encriptado= this.saldo;
		if ((x & 4)==4){
			
			this.saldo = encriptado+4;
		}
		//else if(x<)
		else{
			
			this.saldo= encriptado & 0xfffffffb;	
		}
		return this.saldo;
	}

}
