import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Principal extends JFrame implements ActionListener{

	Graphics g=getGraphics();
	JButton mercurio = new JButton("MERCURIO");
	JButton venus = new JButton("VENUS");
	JButton tierra = new JButton("TIERRA");
	I P;
	Tierra t = new Tierra();
	Venus v = new Venus();
	Mercurio m = new Mercurio();
	
	Principal(){
		Container c= getContentPane();
		c.setLayout(null);
		c.add(mercurio);
		mercurio.addActionListener(this);
		mercurio.setBounds(20, 20, 100, 40);
		c.add(tierra);
		tierra.addActionListener(this);
		tierra.setBounds(150, 20, 100, 40);
		c.add(venus);
		venus.addActionListener(this);
		venus.setBounds(280, 20, 100, 40);
		
		
	}
	
	public static void Paint() {
		
	}
	
	public static void main(String args[]) {
		Principal m = new Principal();
		m.setVisible(true);
		m.setLayout(null);
		m.setSize(1400, 750);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Graphics g=getGraphics();
		
		if(arg0.getSource()==tierra) {
			P=t;		
		}
		if(arg0.getSource()==mercurio) {
			P=m;
		}
		if(arg0.getSource()==venus) {
			P=v;
		}
		P.F(g);
	}

	
}
