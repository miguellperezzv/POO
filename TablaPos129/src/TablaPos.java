import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TablaPos extends JFrame implements ActionListener{
	int pressActualizar=0;
	JButton actualizar = new JButton("ACTUALIZAR");
	JButton enlistar = new JButton("ENLISTAR");
	JTextField Equipo1 = new JTextField();
	JTextField Equipo2 = new JTextField();
	JTextField Puntos1 = new JTextField();
	JTextField Puntos2 = new JTextField();
	
	JLabel labelNombre = new JLabel("Equipo:");
	JLabel lblNombre   = new JLabel ("Equipo2:");
	JLabel labelPuntos = new JLabel("Marcadores");
	
	JLabel txt1 = new JLabel ();
	JLabel txt2 = new JLabel ();
	JLabel txt3 = new JLabel ();
	JLabel txt4 = new JLabel ();
	JLabel txt5 = new JLabel ();
	JLabel txt6 = new JLabel ();
	JLabel txt7 = new JLabel ();
	JLabel txt8 = new JLabel ();
	JLabel txt9 = new JLabel ();
	JLabel txt10 = new JLabel ();
	JTable tabla = new JTable();
	
	
    Agrega ag = new Agrega();
    boolean agregados=false;
    public static void main(String[] args)
    {
        
        TablaPos hm=new TablaPos();
        hm.setSize(600,1000);
        hm.setVisible(true);
        hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    TablaPos() {
        Container c=getContentPane();
        c.setLayout(null);
        
        c.add(labelNombre);
        labelNombre.setBounds(50, 30, 150, 40);
        c.add(lblNombre);
        lblNombre.setBounds(250, 30, 150, 40);
        
        c.add(Equipo1);
        Equipo1.setBounds(50, 60, 100, 30);
        
        c.add(Equipo2);
        Equipo2.setBounds(250, 60, 100, 30);
        
        c.add(labelPuntos);
        labelPuntos.setBounds(170, 30, 150, 40);
       
        c.add(Puntos1);
        Puntos1.setBounds(150,60,30,30);
        
        c.add(Puntos2);
        Puntos2.setBounds(220,60,30,30);
        
        c.add(actualizar);
        actualizar.setBounds(50, 150, 150, 50);
		actualizar.setActionCommand("actualiza");
		actualizar.addActionListener(this);
        
        c.add(enlistar);
        enlistar.setBounds(200, 150, 150, 50);
		enlistar.setActionCommand("enlista");
		enlistar.addActionListener(this);
        
		c.add(txt1);
		txt1.setBounds(30, 200, 150,50);
		txt1.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt2);
		txt2.setBounds(30, 230, 150,50);
		txt2.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt3);
		txt3.setBounds(30, 260, 150,50);
		txt3.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt4);
		txt4.setBounds(30, 290, 150,50);
		txt4.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt5);
		txt5.setBounds(30, 320, 150,50);
		txt5.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt6);
		txt6.setBounds(30, 350, 150,50);
		txt6.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt7);
		txt7.setBounds(30, 380, 150,50);
		txt7.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt8);
		txt8.setBounds(30, 410, 150,50);
		txt8.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt9);
		txt9.setBounds(30, 440, 150,50);
		txt9.setFont(new java.awt.Font("Arial", 20, 20));
		c.add(txt10);
		txt10.setBounds(30, 470, 150,50);
		txt10.setFont(new java.awt.Font("Arial", 20, 20));
		
		
    }
    public void actionPerformed (ActionEvent e1){
        if(e1.getSource()==actualizar){
        	
        	pressActualizar++;
        if	(agregados==false) {
        	
            Equipo eq1=new Equipo("Brasil", 37, new Color(0,118,0));
            Equipo eq2=new Equipo("Uruguay", 27, new Color(0,56,118) );
            Equipo eq3=new Equipo("Colombia", 26, new Color(244,169,000));
            Equipo eq4=new Equipo("Peru",24, new Color(196,16,16));
            Equipo eq5=new Equipo("Argentina",24, new Color(120,206,223));
            Equipo eq6=new Equipo("Chile", 23, new Color(196,10,10));
            Equipo eq7=new Equipo("Paraguay",21, new Color(220,4,4));
            Equipo eq8=new Equipo("Ecuador",20, new Color(244,169,000) );
            Equipo eq9=new Equipo("Bolivia", 13, new Color(0,118,0));
            Equipo eq10=new Equipo("Venezuela", 8, new Color (114-020-034));
            
            ag.agregar(eq1);
            ag.agregar(eq2);
            ag.agregar(eq3);
            ag.agregar(eq4);
            ag.agregar(eq5);
            ag.agregar(eq6);
            ag.agregar(eq7);
            ag.agregar(eq8);
            ag.agregar(eq9);
            ag.agregar(eq10);
            agregados=true;    
        }
       
        	int caso=0;
        	if(Equipo1.getText().equals(null)==true||Equipo2.getText().equals(null)==true||Puntos1.getText().equals(null)==true||Puntos2.getText().equals(null)==true) {
        		caso=5;
        	}
        	else {
            String n1 = Equipo1.getText();
            String n2 = Equipo2.getText();
            int p1 = Integer.parseInt(Puntos1.getText());
            int p2 = Integer.parseInt(Puntos2.getText());
        	
            
         if(n1.equalsIgnoreCase(n2)==true||p1<0||p2<0) {
        	 caso =5;
         }
         else if(ag.buscarNombre(n1)==false||ag.buscarNombre(n2)==false) {
        	 caso = 4;
         }
         else {
        	 if(p1==p2) {
        		 caso=1;
        	 }
        	 else if(p1>p2) {
        		 caso=2;
        	 }
        	 else if (p2>p1) {
        		 caso=3;
        	 }
         }
        
         switch(caso) {
         
         case 1:
        	 ag.actualizar(n1, 1);
        	 ag.actualizar(n2, 1);
        	 break;
         case 2:
        	 ag.actualizar(n1, 3);
        	 break;
         case 3:
        	 ag.actualizar(n2, 3);
        	 break;
         case 4:
        	 JOptionPane.showMessageDialog(null, "No se encontró país");
        	 Equipo1.setText(null);
        	 Equipo2.setText(null);
        	 Puntos1.setText(null);
        	 Puntos2.setText(null);
        	 break;
         case 5:
        	 JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
        	 Equipo1.setText(null);
        	 Equipo2.setText(null);
        	 Puntos1.setText(null);
        	 Puntos2.setText(null);
        	 break;
     
         }
        	}
        
        
        }
        if(e1.getSource()==enlistar){
        	
        	JLabel[] listado  = {txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10};
        	
        	Arrays.sort(ag.a);
        	String[] columnas = {"Pais", "Marcador"};
        	Object[][] datos = {
        			{"COLOMBIA", 3},
        			{"COLOMBIA", 3},
        			{ag.a[1].retornarNombre(), ag.a[1].retornarPuntos()},
        			{ag.a[2].retornarNombre(), ag.a[2].retornarPuntos()},
        	};
        	
            for(int i=0;i<10;i++){
                Equipo tempo =  ag.devolver(i);
                listado[i].setText(tempo.retornarNombre() +" "+tempo.retornarPuntos());
                listado[i].setForeground(tempo.color);        
            }
        }
    }
	
}
class Equipo implements Comparable<Equipo>{
	String nombre;
    int x;
    Color color;
    
    Equipo(){
        // constructor vacio para 
        // crear la tabla vacia
    }
    Equipo(String nombre, int x, Color color){
        this.x=x;
        this.nombre=nombre;
        this.color=color;
    }
    int retornarPuntos()
    {
        return x;
    }
    
    String retornarNombre() {
    	return nombre;
    }
	@Override
	public int compareTo(Equipo o) {
		if(x<o.x) {
			return 1;
		}
		if (x>o.x)
		{
			return -1;
		}
		return 0;
	}
}
class Agrega{
    Equipo []a=new Equipo[10];
    int d=0;
    Agrega(){
        //crea la tabla vacia
        for(int i=0;i<10;i++){
            a[i]=new Equipo();
        }
    }
    void agregar(Equipo k){
        a[d]= k;
        d++;
    }
    Equipo devolver(int i){
        return  a[i];
    }
    
    void actualizar(String nombre, int puntos) {
    	int cont=0;
    	while(cont<10) {
    		if(this.a[cont].nombre.equalsIgnoreCase(nombre)==true) {
    			this.a[cont].x+=puntos;
    		}
    		
    		cont++;
    		
    	}
    }
    boolean buscarNombre(String nombre) {
    	    	int cont=0;
    	    	boolean encontrado=false;
    	    	while(cont<10) {
    	    		if(this.a[cont].nombre.equalsIgnoreCase(nombre)==true) {
    	    			encontrado=true;
    	    		}	
    	    		cont++;
    	    	}
    	    	if (cont>10) {
    	    		encontrado = false;
    	    	}
    	return encontrado;
    }
    
}