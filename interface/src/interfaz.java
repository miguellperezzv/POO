import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

interface I {
	int u=7;
	
	abstract void F(Graphics gr);
}

class Tierra implements I{

	public void F(Graphics g) {
		int[] x= {1287+12+40,1287+12+50,1287+60,1287+12+40};
		int[] y= {285,300,285,285};
		String ua = "13 Px : 0.01 UA";
		g.setColor(Color.BLACK);
		g.fillRect(0, 100, 1400, 600);
		g.setColor(Color.YELLOW);
		g.fillOval(50, 300, 12, 12);
		/*g.setColor(Color.red);
		g.fillRect(1287+12+50, 250, 5, 35);
		g.fillPolygon(x, y, 4);*/
		g.setColor(Color.white);
		g.drawString("T", 1287+11+50, 300);
		g.setFont(new Font("Monospaced", Font.BOLD,18));
		g.drawString(ua, 100, 600);
	}
}
	
class Venus implements I{

		@Override
		public void F(Graphics g) {
			String ua = "13 Px : 0.0072 UA";
			g.setColor(Color.BLACK);
			g.fillRect(0, 100, 1400, 600);
			g.setColor(Color.YELLOW);
			g.fillOval(50, 300, 17, 17);
			g.fillOval(1299, 300, (int)0.10, (int)0.10);
			g.setColor(Color.white);
			g.drawString("V", 1283+50, 300);
			g.setFont(new Font("Monospaced", Font.BOLD,18));
			g.drawString(ua, 100, 600);
			
		}
	
}

class Mercurio implements I{

	Graphics g;
	@Override
	public void F(Graphics g) {
		String ua = "13 Px : 0.0039 UA";
		g.setColor(Color.BLACK);
		g.fillRect(0, 100, 1400, 600);
		g.setColor(Color.YELLOW);
		g.fillOval(50, 300, 31, 31);
		g.fillOval(1299, 300, (int)0.10, (int)0.10);
		g.setColor(Color.white);
		g.drawString("M", 1269+50, 300);
		g.setFont(new Font("Monospaced", Font.BOLD,18));
		g.drawString(ua, 100, 600);
	}

}

