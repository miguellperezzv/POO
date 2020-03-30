import java.awt.Color;
import java.awt.Graphics;

public class Hilo2 extends Thread{
	Graphics g;
	Color f;
	Hilo2(Graphics g, Color f){
		this.g=g;
		this.f=f;
	}
	
	public void run() {
		
		double x=0;
		double y=0;
		double ang=0;
		while(true) {
			g.setColor(Color.BLACK);
			g.fillRect(250, 100, 200, 100);
			g.setColor(Color.green);
			g.fillOval(340, 140, 20, 20);
			g.setColor(Color.blue);
			
			x=Math.cos(Math.toRadians(ang))*30;
			y=Math.sin(Math.toRadians(ang))*30;
			g.fillOval((int)x-5+350, (int)y-5+150, 10, 10);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				
			}
			g.setColor(Color.black);
			//g.fillOval((int)x-5, (int)y-5, 10, 10);
			ang=ang+10;
			
		}
	}
}
