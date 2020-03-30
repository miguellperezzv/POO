package puntosEquipo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ficha  extends JFrame implements ActionListener{
		JButton actualizar = new JButton("ACTUALIZAR");
		JButton enlistar = new JButton("ENLISTAR");
		JTextField tFieldnombre = new JTextField();
		JTextField tFieldpuntos = new JTextField();
		JLabel labelNombre = new JLabel("Ingrese Nombre Equipo:");
		JLabel labelPuntos = new JLabel("Ingrese puntos del equipo:");
		
		Equipo eq1 = new Equipo("Brasil", 36);
		Equipo eq2 = new Equipo("Colombia", 25);
		Equipo eq3 = new Equipo("Uruguay", 24);
		Equipo eq4 = new Equipo("Chile", 23);
		Equipo eq5 = new Equipo("Argentina", 23);
		Equipo eq6 = new Equipo("Peru", 21);
		Equipo eq7 = new Equipo("Paraguay", 21);
		Equipo eq8 = new Equipo("Ecuador", 20);
		Equipo eq9 = new Equipo("Bolivia", 10);
		Equipo eq10 = new Equipo("Venezuela", 7);
		
		
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ficha m=new Ficha();
		m.setSize(600,800);
		m.setVisible(true);
		
		
	}
				
	Ficha(){
		Container c = getContentPane();
		c.setLayout(null);
		c.add(actualizar);
		actualizar.setBounds(50, 300, 150, 50);
		actualizar.setActionCommand("actualiza");
		actualizar.addActionListener(this);
		
		
		c.add(enlistar);
		enlistar.setBounds(200, 300, 150, 50);
		actualizar.setActionCommand("enlista");
		actualizar.addActionListener(this);
		
		c.add(labelNombre);
		labelNombre.setBounds(30, 30, 150, 50);
		
		c.add(labelPuntos);
		labelPuntos.setBounds(30, 100, 150, 50);
		
		c.add(tFieldnombre);
		tFieldnombre.setBounds(200, 40, 200, 30);
		
		c.add(tFieldpuntos);
		tFieldpuntos.setBounds(200, 120, 200, 30);
	}
	
	
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		if(e1.getActionCommand().equals("actualiza")){
			
			int i=0;
			String nombreIngresado=tFieldnombre.getText();
			int puntoIngresado =Integer.parseInt(tFieldpuntos.getText());
			agrega.getEquipo(1);
		
			
			
		}
	}

}
