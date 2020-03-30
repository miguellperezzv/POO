package sistemasolar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;

public class Principal extends JFrame {
	
	//Graphics g =getGraphics();
ActionListener oyenteMercurio = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 10, 10);
			x=Math.cos(Math.toRadians(ang))*60+500-5;
			y=Math.sin(Math.toRadians(ang))*60+400-5;	
			g.setColor(Color.GRAY);
			g.fillOval((int)x,(int) y, 10, 10);
			ang=ang+30;
		}
		
		
	};
	
ActionListener oyenteVenus = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 20, 20);
			x=Math.cos(Math.toRadians(ang))*80+500-10;
			y=Math.sin(Math.toRadians(ang))*80+400-10;	
			g.setColor(new Color(154,77,21));
			g.fillOval((int)x,(int) y, 20, 20);
			ang=ang+11.61;
		}
		
		
	};
ActionListener oyenteTierra = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 20, 20);
			x=Math.cos(Math.toRadians(ang))*120+500-10;
			y=Math.sin(Math.toRadians(ang))*120+400-10;
			g.setColor(Color.yellow);
			g.fillOval(450, 350, 100, 100);			
			g.setColor(Color.GREEN);
			g.fillOval((int)x,(int) y, 20, 20);
			ang=ang+7.2; 
		}
		
		
	};
	
ActionListener oyenteMarte = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 15, 15);
			x=Math.cos(Math.toRadians(ang))*150+500-7.5;
			y=Math.sin(Math.toRadians(ang))*150+400-7.5;	
			g.setColor(new Color(249,138,13));
			g.fillOval((int)x,(int) y, 15, 15);
			ang=ang+3.428;
		}
			
	};

ActionListener oyenteJupiter = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 50, 50);
			x=Math.cos(Math.toRadians(ang))*200+500-25;
			y=Math.sin(Math.toRadians(ang))*200+400-25;	
			g.setColor(new Color(249,138,13));
			g.fillOval((int)x,(int) y, 50, 50);
			ang=ang+0.60;
		}		
	};
	
ActionListener oyenteSaturno = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 40, 40);
			x=Math.cos(Math.toRadians(ang))*300+500-20;
			y=Math.sin(Math.toRadians(ang))*300+400-20;	
			g.setColor(new Color(249,188,82));
			g.fillOval((int)x,(int) y, 40, 40);
			ang=ang+0.2424;
		}		
	};
	
ActionListener oyenteUrano = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 25, 25);
			x=Math.cos(Math.toRadians(ang))*350+500-12.5;
			y=Math.sin(Math.toRadians(ang))*350+400-12.5;	
			g.setColor(new Color(196,234,237));
			g.fillOval((int)x,(int) y, 25, 25);
			ang=ang+0.08504;
		}		
	};
	
ActionListener oyenteNeptuno = new ActionListener() {
		
		double x=0;
		double y=0;
		double ang=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillOval((int)x,(int) y, 25, 25);
			x=Math.cos(Math.toRadians(ang))*380+500-12.5;
			y=Math.sin(Math.toRadians(ang))*380+400-12.5;	
			g.setColor(new Color(98,114,214));
			g.fillOval((int)x,(int) y, 25, 25);
			ang=ang+0.0436;
		}		
	};
	
	int miliseg=100;  //calculado con 20
	Timer tierra = new Timer(miliseg,oyenteTierra);
	Timer mercurio = new Timer(miliseg,oyenteMercurio);
	Timer venus = new Timer(miliseg,oyenteVenus);
	Timer marte = new Timer(miliseg,oyenteMarte);
	Timer jupiter = new Timer(miliseg,oyenteJupiter);
	Timer saturno = new Timer(miliseg,oyenteSaturno);
	Timer urano = new Timer(miliseg,oyenteUrano);
	Timer neptuno=new Timer(miliseg,oyenteNeptuno);
	
	Principal(){
		Container c = getContentPane();
		c.setBackground(Color.BLACK);
		tierra.start();
		mercurio.start();
		venus.start();
		marte.start();
		jupiter.start();
		saturno.start();
		urano.start();
		neptuno.start();
	}
	
	
	public static void main(String args[]) {
		Principal m = new Principal();
		m.setSize(1000, 800);
		m.setVisible(true);
		//m.setBackground(Color.BLACK);
	}
	
	
	
}

		





