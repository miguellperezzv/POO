package ajedrez;

public class Caballo extends Rey {

	int hx;
	int hy;
	Caballo(int x, int y, int x1, int y1) {
		super(x, y);
		this.hx=x1;
		this.hy=y1;
		// TODO Auto-generated constructor stub
	}
	
	Caballo(){
		
	}
	
	int[] getPosition(){
		int pos[] = {hx,hy};
		return pos;
	}
	

}
