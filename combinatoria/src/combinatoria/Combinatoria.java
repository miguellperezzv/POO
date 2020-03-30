package combinatoria;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Combinatoria extends JFrame implements ActionListener{
	
	JButton boton = new JButton ("CALCULAR");
	JTextField num1 = new JTextField ();
	JTextField num2 = new JTextField ();
	JTextField resultado = new JTextField();
	JLabel texto1 = new JLabel ("Ingrese n ");
	JLabel texto2 = new JLabel ("Ingrese r ");
	JLabel texto3= new JLabel("combinatoria: ");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinatoria marco = new Combinatoria();
		marco.setSize(500,500);
		marco.setVisible(true);
	}
	
	Combinatoria(){
		super ("COMBINATORIA");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.add(texto1);
		texto1.setBounds(30, 30, 100, 20);
		
		c.add(texto2);
		texto2.setBounds(30, 80, 100, 20);
		
		c.add(num1);
		num1.setBounds(150, 30, 100, 20);
		
		c.add(num2);
		num2.setBounds(150, 80, 100, 20);
		
		c.add(boton);
		boton.setBounds(30,200, 100, 50);
		boton.addActionListener(this);
		
		c.add(texto3);
		texto3.setBounds(30, 100, 200, 100);
		
		c.add(resultado);
		resultado.setBounds(250, 140, 100, 20);
	}

	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		int validez=0;
		
		int n=Integer.parseInt(num1.getText());
		int r = Integer.parseInt(num2.getText());
		
		
		if(n<r) {
			JOptionPane.showMessageDialog(null, "n debe ser mayor a r, intente de nuevo");
	        validez=0;	
		}
		else if(n<=0 || r<=0) {

			JOptionPane.showMessageDialog(null, "Los numeros deben ser mayores a 0");
            validez =0;		
		}
		else {validez=1;}
		
	
	switch(validez) {
	
	case 1:
		int[] nArreglo = new int[r];
		int[] rArreglo = new int[r];
		
		
		
		for(int i=1; i<r+1; i++){
			rArreglo[i-1]=i;
			
		}
		
		for(int i=0; i<r; i++){
			
				nArreglo[i]=i+(n-r+1);
				
			}
		
		int numR=0;
		int numN=0;
		do {
			numR=0;
			do {
				if (nArreglo[numN]%rArreglo[numR]==0){
					nArreglo[numN]=nArreglo[numN]/rArreglo[numR];
					rArreglo[numR]=1;
					numR++;
					}else {numR++;}
			}while(numR<rArreglo.length);
			numN++;
		}while(numN<nArreglo.length);
		
		
		int combinatoria =1;
		int x=0;
			while(x<r) {
				combinatoria=combinatoria*nArreglo[x];
				x++;
			}
		
		System.out.print("c "+combinatoria);
		resultado.setText(Integer.toString(combinatoria));
		num1.setText(null);
		num2.setText(null);
		texto3.setText("combinatoria\n ("+n+","+r+")");
		break;
		
	case 0:
		num1.setText(null);
		num2.setText(null);
		break;
	}
}
}
