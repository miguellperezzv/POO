package triangulo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Triangulo extends JFrame implements ActionListener {
	
	
	
		JButton b =new JButton("CALCULAR");
		JTextField lado1 = new JTextField();
		JTextField lado2 = new JTextField();
		JTextField lado3 = new JTextField();
		JLabel texto= new JLabel();
		Graphics g=getGraphics();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangulo marco = new Triangulo();
		marco.setSize(1000,1000);
		marco.setVisible(true);
	}

	Triangulo(){
		super("TRIANGULO");
		
		Container c = getContentPane();
		c.setLayout(null);
		c.add(lado1);
		lado1.setBounds(10, 50, 100, 30);
		c.add(lado2);
		lado2.setBounds(10, 100, 100, 30);
		c.add(lado3);
		lado3.setBounds(10, 150, 100, 30);
		c.add(b);
		b.setBounds(10, 200, 150, 50);
		b.addActionListener(this);
		c.add(texto);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		
		Graphics g=getGraphics();
		this.paint(this.getGraphics());
		int l1=Integer.parseInt(lado1.getText());
		int l2=Integer.parseInt(lado2.getText());
		int l3=Integer.parseInt(lado3.getText());
		
		int a = 0,b=0,c=0;
		int valido=1;
		
		
		if(l1<=0 || l2<=0 || l3<=0) {
			valido=0;
		}
		
		else if((l2>=(l1+l3)||(l1>=(l3+l2))||(l3>=(l1+l2)))) {
			valido=0;
		}
		
		 if(l2<(l1+l3)){
			a=l2;
			c=l1;
			b=l3;
			if(Math.pow(a, 2)==(Math.pow(b, 2)+Math.pow(c, 2))) {
				valido=2;
			}
		}
		 if(l1<(l2+l3)) {
			a=l1;
			c=l2;
			b=l3;
			if(Math.pow(a, 2)==(Math.pow(b, 2)+Math.pow(c, 2))) {
				valido=2;
			}
		}
		 if(l3<(l2+l1)) {
			a=l3;
			c=l1;
			b=l2;
			if(Math.pow(a, 2)==(Math.pow(b, 2)+Math.pow(c, 2))) {
				valido=2;
			}
		}
		else if ((l1==l2)&&l1==l3&&l2==l3){
			a=l1;
			c=l2;
			b=l3;
		}
		else {
			valido=0;
		}
		
		
		switch(valido) {
		
		case 2:
			 int p0x=300,p0y=600, p1x,p1y,p2x,p2y;
			 p1x=300; p1y=b;
			 p2x=300+a; p2y=600;
			 
			 g.drawLine(p1x, p1y,(int) p2x,(int) p2y);
				g.drawLine(p0x, p0y,p1x,p1y);
				g.drawLine(p0x, p0y, (int) p2x,(int) p2y);
				
		        
				int[] vvy1= {p0y,p1y,(int) p2y};
				int[] vvx1= {p0x,p1x,(int) p2x};
				g.fillPolygon(vvx1, vvy1, 3);
				g.setColor(Color.blue);
				break;
		case 1:
			int x0=300,y0=600, x1,y1;
			double disty,h,x2,y2;
			
			this.paint(this.getGraphics());
			
			disty = ((Math.pow(c, 2))-(Math.pow(a, 2))+(Math.pow(b, 2)))/(2*a);
			h=Math.sqrt(((Math.pow(c, 2))-(Math.pow(disty, 2))));
			 
			x1=a+300;
			y1=600;
			x2=300+(a-disty);
			y2=600-h;
			
			
			g.drawLine(x1, y1,(int) x2,(int) y2);
			g.drawLine(x0, y0,x1,y1);
			g.drawLine(x0, y0, (int) x2,(int) y2);
			
	        
			int[] vy1= {y0,y1,(int) y2};
			int[] vx1= {x0,x1,(int) x2};
			g.fillPolygon(vx1, vy1, 3);
			g.setColor(Color.blue);
			break;
		
		case 0:
			
			JOptionPane.showMessageDialog(null, "No se puede construir el triángulo");
			lado1.setText(null);
			lado2.setText(null);
			lado3.setText(null);
			break;
		}
		
		
		
	}
	
}
