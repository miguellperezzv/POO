import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Principal extends JFrame implements ActionListener {
	
	JButton calcular = new JButton("CALCULAR");
	JTextField equis1=new JTextField();
	JTextField equis=new JTextField();
	JTextField ye=new JTextField();
	JTextField ye1=new JTextField();

	Graphics g=getGraphics();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal  m = new Principal();
		m.setSize(500, 900);
		m.setLayout(null);
		m.setVisible(true);
	}
	
	Principal(){
		Container c = getContentPane();
		c.add(equis);
		equis.setBounds(150, 650, 25, 25);
		c.add(equis1);
		equis1.setBounds(150, 680, 25, 25);
		c.add(ye1);
		ye1.setBounds(210, 680, 25, 25);
		c.add(ye);
		ye.setBounds(210, 650, 25, 25);
		JLabel xy = new JLabel("(x           ,          y)");
		c.add(xy);xy.setBounds(150, 615, 300, 50);
		JLabel coord = new JLabel("<html>COORD 1<br><br>COORD 2");
		c.add(coord);coord.setBounds(20, 605, 300, 150);
		c.add(calcular);
		calcular.setBounds(270, 650, 100, 50);
		calcular.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Graphics g = getGraphics();
		String x = equis.getText();
		String x1 = equis1.getText();
		String y = ye.getText();
		String y1 = ye1.getText();
		
		int ix = 0;
		int ix1 = 0;
		int iy = 0;
		int iy1 = 0;
		int error=0;
		
		for(int i=0; i<x.length();i++) {
			if(x.charAt(i)<'0' || x.charAt(i)>'9') {
				error++;
			}
		}
		
		for(int i=0; i<x1.length();i++) {
			if(x1.charAt(i)<'0' || x1.charAt(i)>'9') {
				error++;
			}
		}
		
		for(int i=0; i<y.length();i++) {
			if(y.charAt(i)<'0' || y.charAt(i)>'9') {
				error++;
			}
		}
		
		for(int i=0; i<y1.length();i++) {
			if(y1.charAt(i)<'0' || y1.charAt(i)>'9') {
				error++;
			}
		}
		
		if(error>=1 || x.isEmpty() || x1.isEmpty() || y.isEmpty() || y1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
		else {
			ix = Integer.parseInt(equis.getText());
			ix1 = Integer.parseInt(equis1.getText());
			iy = Integer.parseInt(ye.getText());
			iy1 = Integer.parseInt(ye1.getText());
			System.out.print("datos ingresados");
		}
		
		A a = new A(ix,iy,ix1,iy1,g);
		a.pintar();
		a.info();
	}

}
