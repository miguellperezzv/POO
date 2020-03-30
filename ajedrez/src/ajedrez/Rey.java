package ajedrez;

public class Rey {
	int xk;
	int yk;
	
	Rey(){
		
	}
	Rey(int x, int y){
		this.xk=x;
		this.yk=y;
	}
	
	int[] getPosition(){
		int pos[] = {xk,yk};
		return pos;
	}
	

}
