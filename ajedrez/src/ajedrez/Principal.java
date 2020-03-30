package ajedrez;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener{
	
	
	JMenuBar mb = new JMenuBar();
	JMenu menu1 = new JMenu("OPCIONES");
	JMenuItem rey  = new JMenuItem("Posicion Rey");
	JMenuItem caballo = new JMenuItem("Posicion Caballo");
	JMenuItem reina = new JMenuItem("Posicion Reina");
	JMenuItem jaque = new JMenuItem("JAQUE");
	JMenuItem pintar = new JMenuItem("Pintar");
	JTextField txtx = new JTextField();
	JTextField txty = new JTextField();
	Graphics g = getGraphics();
	Reina todos = new Reina();
	int[][] tablero = new int [8][8];
	
	Image reyimg = Toolkit.getDefaultToolkit().getImage("./img/rey.jpg");
	Image caballoimg = Toolkit.getDefaultToolkit().getImage("./img/caballo.jpg");
	Image reinaimg = Toolkit.getDefaultToolkit().getImage("./img/reina.jpg");

	
	int[][] pos = new int[2][3];
	
	Principal(){
		
		Container c=this.getContentPane();
		c.add(txtx);
		c.add(txty);
		//c.add(subx);
		
		txtx.setBounds(30, 60, 50, 40);
		txty.setBounds(80, 60, 50, 40);
		
		setLayout(null);
		setJMenuBar(mb);
		mb.add(menu1);
		rey.addActionListener(this);
		caballo.addActionListener(this);
		reina.addActionListener(this);
		menu1.add(rey);
		menu1.add(caballo);
		menu1.add(reina);
		menu1.add(jaque);
		menu1.add(pintar);
		jaque.addActionListener(this);
		pintar.addActionListener(this);
		
	}
	
	public void  paintComponent (Graphics g) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal m = new Principal();
		m.setSize(700, 700);
		m.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Graphics g = getGraphics();
		
		String txt1 = txtx.getText();
		String txt2 = txty.getText();
		int error = 0;
		for(int i=0; i<txt1.length();i++) {
			if(txt1.charAt(i)<'0' ||txt2.charAt(i)>'9'|| txtx.getText().isEmpty()||txty.getText().isEmpty()) {
				error=0;
			}
			else {
				if(Integer.parseInt(txt1)>8||Integer.parseInt(txt2)>8||Integer.parseInt(txt1)<1||Integer.parseInt(txt2)<1) {
					error=2;
				}
				else {
				error=1;
				}
			}
		}
		
		
		if(arg0.getSource()==rey) {
			
			if (error==0) {
				JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
			}
			else if (error==2) {
				JOptionPane.showMessageDialog(null, "solo numeros entre 1 y 8");
			}
			else {
				
				pos[0][0]=Integer.parseInt(txtx.getText());
				pos[1][0]=Integer.parseInt(txty.getText());		
			}
			
		}
		
		if(arg0.getSource()==caballo) {
			if (error==0) {
				JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
			}
			else if (error==2) {
				JOptionPane.showMessageDialog(null, "solo numeros entre 1 y 8");
			}
			else {
				
				pos[0][1]=Integer.parseInt(txtx.getText());
				pos[1][1]=Integer.parseInt(txty.getText());	
			}
			
		}
		
		if(arg0.getSource()==reina) {
			tablero=new int[8][8];
			
			if (error==0) {
				JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
			}
			else if (error==2) {
				JOptionPane.showMessageDialog(null, "solo numeros entre 1 y 8");
			}
			else {
				pos[0][2]=Integer.parseInt(txtx.getText());
				pos[1][2]=Integer.parseInt(txty.getText());	
				
				
			}
			
			
		}
		
		if(arg0.getSource()==pintar) {
			
			int xf=100;
			int yf=200;
			
			g.clearRect(1, 200, 500, 500);
			todos = new Reina(pos[0][0],pos[1][0],pos[0][1],pos[1][1],pos[0][2],pos[1][2]);
			//getContentPane().add(subx);
			
			g.drawRect(xf, yf, 400, 400);
			for(int i=1;i<8;i++) {
				g.drawLine(xf+(i*50), yf, xf+(i*50), yf+ 400);
				g.drawLine(xf, yf+(i*50), xf+400, yf+ (i*50));
				
				
			}
			/*
			g.drawString("K", xf+(todos.xk-1)*50, 600-(todos.yk-1)*50);
			g.drawString("Q", xf+(todos.qx-1)*50, 600-(todos.qy-1)*50);
			g.drawString("H", xf+(todos.hx-1)*50, 600-(todos.hy-1)*50);
			*/
			
			g.drawImage(reyimg,xf+(todos.xk-1)*50, 600-(todos.yk)*50, this);
			g.drawImage(reinaimg,xf+(todos.qx-1)*50, 600-(todos.qy)*50, this);
			g.drawImage(caballoimg,xf+(todos.hx-1)*50, 600-(todos.hy)*50, this);
	
		
		}
		
		if(arg0.getSource()==jaque) {
			
			tablero=new  int[8][8];
			
			int contx=pos[0][1]-1;
			int conty=pos[1][1]-1;
			
			
			if(contx+2>7||contx+2<0||conty+1>7||conty+1<0) {}
			else {tablero[contx+2][conty+1]=1;}
			
			if(contx+1<0 ||contx+1>7|| conty+2<0|| conty+2>7) {}
			else {tablero[contx+1][conty+2]=1;}
			
			if(contx-1>7|| contx-1<0|| conty-2>7|| conty-2<0) {}
			else {tablero[contx-1][conty-2]=1;}
			
			if(contx-2>7|| contx-2<0|| conty-1>7|| conty-1<0) {}
			else {tablero[contx-2][conty-1]=1;}
			
			if(contx-2>7|| contx-2<0|| conty+1>7|| conty+1<0) {}
			else {tablero[contx-2][conty+1]=1;}
			
			if(contx+2>7|| contx+2<0|| conty-1>7|| conty-1<0) {}
			else {tablero[contx+2][conty-1]=1;}
			
			if(contx-1>7|| contx-1<0|| conty+2>7|| conty+2<0) {}
			else {tablero[contx-1][conty+2]=1;}
			
			if(contx+1>7|| contx+1<0|| conty-2>7|| conty-2<0) {}
			else {tablero[contx+1][conty-2]=1;}
			
			tablero[contx][conty]=3;
			
			 contx=pos[0][2]-1;
			 conty=pos[1][2]-1;
			
			
			int cont=0;
			
			tablero[contx][conty]=5;
			while(contx+cont<=7 ||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx+cont][conty]=1;
				cont++;
			}
			cont=0;
			while(contx-cont>=0||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx-cont][conty]=1;
				cont++;
			}
			cont=0;
			while(conty+cont<=7||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx][conty+cont]=1;
				cont++;
			}
			cont=0;
			while(conty-cont>=0||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx][conty-cont]=1;
				cont++;
			}
			cont=0;
			while(conty+cont<=7&&contx+cont<=7||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx+cont][conty+cont]=1;
				cont++;
			}
			cont=0;
			while(contx-cont>=0&&conty+cont<=7||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx-cont][conty+cont]=1;
				cont++;
			}
			cont=0;
			while(contx+cont<=7&&conty-cont>=0||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx+cont][conty-cont]=1;
				cont++;
			}
			cont=0;
			while(contx-cont>=0&&conty-cont>=0||(contx==pos[0][1]&&conty==pos[1][1])) {
				tablero[contx-cont][conty-cont]=1;
				cont++;
			}
			
			/*
			 * eliminar unos en relacion cab reina
			 */
			if((pos[0][2]<pos[0][1])&&(pos[1][1]==pos[1][2])){
				
				for(int i=pos[0][1];i<8;i++){
					tablero[i-1][pos[1][1]-1]=0;
				}
			}
			
			if((pos[0][2]>pos[0][1])&&(pos[1][1]==pos[1][2])){
				
				for(int i=pos[0][1];i>0;i--){
					tablero[i-1][pos[1][1]-1]=0;
				}
			}
			
			if((pos[1][2]<pos[1][1])&&(pos[0][1]==pos[0][2])){
				
				for(int i=pos[1][1];i<8;i++){
					tablero[pos[0][1]-1][i-1]=0;
				}
			}
			
			if((pos[1][2]>pos[1][1])&&(pos[0][1]==pos[0][2])){
				
				for(int i=pos[1][1];i>0;i--){
					tablero[pos[0][1]-1][i-1]=0;
				}
			}
			
			
			
			int cont2=0;
			if(todos.qx-todos.hx==todos.qy-todos.hy&&todos.qx-todos.hx>0) {
				cont=0;
				contx=todos.hx-1;
				conty=todos.hy-1;
				while(contx-cont>=0&&conty-cont>=0) {
					tablero[contx-cont][conty-cont]=0;
					cont++;
				}
			}
			
			if(todos.qx-todos.hx==todos.qy-todos.hy&&todos.qx-todos.hx<0) {
				cont=0;
				contx=todos.hx-1;
				conty=todos.hy-1;
				while(contx+cont<8&&conty+cont<8) {
					tablero[contx+cont][conty+cont]=0;
					cont++;
				}
			}
			
			for(int i=7; i>=0;i--){
				for(int j=0; j<8;j++){
					System.out.print(tablero[j][i]+" ");
				}
				System.out.print("\n");
		}
			System.out.print("\n");
			
			if(tablero[pos[0][0]-1][pos[1][0]-1]==1) {
				contx=pos[0][0]-1;
				conty=pos[1][0]-1;
				int movreales=0; //cuantos espacios tiene alrededor
				int posib=0; //posibles espacios sin 1
				
				System.out.print(contx+" "+conty);
				
				if(contx+1<8&&conty+1<8) {
					movreales++;
					if(tablero[contx+1][conty+1]==1) {
						posib++;
					}
				}
				
				if(contx+1<8&&conty<8) {
					movreales++;
					if(tablero[contx+1][conty]==1) {
						posib++;
					}
				}
				
				if(contx+1<8&&conty-1>=0) {
					movreales++;
					if(tablero[contx+1][conty-1]==1) {
						posib++;
					}
				}
				
				if(contx<8&&conty-1>=0) {
					movreales++;
					if(tablero[contx][conty-1]==1) {
						posib++;
					}
				}
				
				if(contx-1>=0&&conty-1>=0) {
					movreales++;
					if(tablero[contx-1][conty-1]==1) {
						posib++;
					}
				}
				
				if(contx-1>=0&&conty>=0) {
					movreales++;
					if(tablero[contx-1][conty]==1) {
						posib++;
					}
				}
				
				if(contx<8&&conty+1<8) {
					movreales++;
					if(tablero[contx][conty+1]==1) {
						posib++;
					}
				}
				
				if(contx+1<8&&conty-1>=0) {
					movreales++;
					if(tablero[contx+1][conty-1]==1) {
						posib++;
					}
				}
				
				
				System.out.print("\nmovreales ="+movreales+"\nposib ="+posib+"\n");
				if(movreales==posib) {
					JOptionPane.showMessageDialog(null, "AHOGADO");
				}
				else if (posib>=1){
					JOptionPane.showMessageDialog(null, "ESTÁ EN JAQUE");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "NO ESTA EN JAQUE");
			}
			
		}
	}
	

}