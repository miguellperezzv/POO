import java.awt.Color;
import java.awt.Graphics;

public class Hilo extends Thread{
	Graphics g;
	Color f;
	Hilo(Graphics g, Color f){
		this.f=f;
		this.g=g;
	}
	public void run() {
		double x=0;
		double y =0;
		double x2=0;
		double y2 =0;
		double ang=270;
		double ang1=300;
		
		while(true) {
			g.setColor(Color.BLACK);
			for(int i=1;i<13;i++) {
				
				x2= Math.cos(Math.toRadians(ang1))*50+650;
				y2 = Math.sin(Math.toRadians(ang1))*50+150;
			
				g.drawString(Integer.toString(i), (int)x2, (int)y2);
				ang1=ang1+30;
				
			}
			g.setColor(Color.blue);
			x= Math.cos(Math.toRadians(ang))*40+650;
			y = Math.sin(Math.toRadians(ang))*40+150;
			g.drawLine(650, 150, (int)x, (int)y);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			g.setColor(f);
			g.drawLine(650, 150, (int)x, (int)y);
			ang=ang+(6);
			
		}
	}
	
	public void detener() {
		g.setColor(f);
		g.drawRect(600, 100, 200, 200);
	}
}


