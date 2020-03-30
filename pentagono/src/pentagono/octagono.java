package pentagono;

import java.awt.Graphics;

import javax.swing.JFrame;

public class octagono  extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int R = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		octagono m = new octagono();
		m.setSize(500, 500);
		m.setVisible(true);
		A a=new A(R,m.getGraphics());
		a.F();
	}
	public void paint(Graphics g) {
		
	}

}

class A extends JFrame{
	
	Graphics g;
	int R;
	A(int R, Graphics g){
		this.R=R;
		this.g=g;
	}
	void F() {
		B obj=new B(g, R);
		obj.g();
	}
}

class B extends JFrame{
	
	Graphics g;
	int R;
	B(Graphics g, int R){
		this.g=g;
		this.R=R;
	}
	
	void g() {
		float ang =0;
		float[] x = new float[8];
		float[] y = new float[8];
		for(int i = 0; i<8;i++) {
			x[i]=(float) (R*Math.cos(ang));
			y[i]=(float) (R*Math.sin(ang));
			//ang+= (45*Math.PI)/180;
			ang+= Math.toRadians(45);
		}
		
		for(int i = 0; i<8;i++) {
			x[i] +=250;
			y[i] +=250; //-y[i];
		}
		
		int xp[] = new int[9];
		int yp[]=new int[9];
		for(int i = 0; i<8;i++) {
			xp[i]=(int)x[i];
			yp[i]=(int)y[i];
		}
		g.drawPolygon(xp, yp, 8);
		xp[8]=xp[0];
		yp[8]=yp[0];
	}
	
	
}