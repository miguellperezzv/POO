package ajedrez;

public class Reina extends Caballo {

	int qx;
	int qy;
	Reina(int x, int y, int x1, int y1, int x2,int y2) {
		
		super(x, y, x1, y1);
		this.qx=x2;
		this.qy=y2;
		// TODO Auto-generated constructor stub
	}
	public Reina() {
		// TODO Auto-generated constructor stub
	}

}
