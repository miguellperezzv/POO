package polimorfismo;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Principal extends JFrame implements ActionListener {
	JButton montecarlo = new JButton("MONTECARLO");
	JButton sumatoria = new JButton("SUMATORIA");
	JButton raiz = new JButton("RAIZ DE SUMATORIA");
	JLabel resultado = new JLabel("Pi es:");
	
	Graphics g = getGraphics();
	
	A o1 =new A(3,200,getGraphics());
	B o2  =new B(5);
	C o3 = new C(7);
	Y P;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal m  = new Principal();
		m.setSize(700, 400);
		m.setVisible(true);
		m.setLayout(null);
	}
	
	Principal(){
		Container c=getContentPane();
		c.setLayout(null);
		c.add(montecarlo);
		montecarlo.addActionListener(this);
		montecarlo.setBounds(10, 50, 200, 50);
		c.add(sumatoria);
		sumatoria.addActionListener(this);
		sumatoria.setBounds(220, 50, 200, 50);
		c.add(raiz);
		raiz.addActionListener(this);
		raiz.setBounds(430, 50, 200, 50);
		c.add(resultado);
		resultado.setBounds(30,150,400,50);
		resultado.setFont(new Font("Serif", Font.BOLD, 14));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Graphics g = getGraphics();
		
		if(arg0.getSource()==montecarlo) {
			P = o1;
		}
		
		if(arg0.getSource()==sumatoria) {
			P = o2;
		}
		
		if(arg0.getSource()==raiz) {
			P=o3;
		}
		resultado.setText(P.F());
	}

}
