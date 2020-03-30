import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class A extends Recta{

	Graphics g;
	A(int a, int b, int c, int d, Graphics g) {
		// TODO Auto-generated constructor stub
		super(a, b, c, d);//pasa los parametros al constructor de la recta	
		this.g=g;
	}

	

	void pintar() {
		g.setColor(Color.lightGray);
		g.fillRect(0,0, 500, 500);
		g.setColor(Color.black);
		g.drawLine(100, 10, 100, 490);
		g.drawLine(10, 250, 490, 250);
		g.setColor(Color.blue);
		g.drawLine(x+100, 250-y, x1+100, 250-y1);
		g.setColor(Color.red);
		if(x<x1) {
		g.drawLine(100, (250 -(int)  altura()), x+100, 250-y);
		}
		else if(x1<x) {
		g.drawLine(100, (250 -(int)  altura()), x1+100, 250-y1);	
		}
		g.setColor(Color.black);
		g.setFont(new Font("Monospaced", Font.BOLD,14));
		g.drawString("PC = "+ this.altura(), 300, 400);
		g.drawString("m="+ this.pendiente(), 300, 450);
		g.drawString("long ="+this.distancia(), 20, 400);
	}
}
