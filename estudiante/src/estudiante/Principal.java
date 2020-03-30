package estudiante;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {
	
	JTextField codigo = new JTextField();
	JTextField nota1 = new JTextField();
	JTextField nota2 = new JTextField();
	JTextField nota3 = new JTextField();
	JTextField nota4 = new JTextField();
	JTextField nombre = new JTextField();
	JButton registrar = new JButton("REGISTRAR");
	JButton consultar = new JButton("CONSULTAR");
	JButton enlistar = new JButton("ENLISTAR");
	JLabel lblcodigo = new JLabel("CODIGO");
	JLabel lblnombre = new JLabel("NOMBRE");
	JLabel lblnotas = new JLabel("<html>NOTA 1:<br><br><br>NOTA 2:<br><br><br>NOTA 3:<br><br>NOTA 4:</html>");
	JTextArea textarea =new JTextArea(50,100);
	
	//HashMap<String,String> hm = new HashMap<String, String>();
	Datos datos = new Datos();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal  m = new Principal();
		m.setSize(500, 1000);
		m.setLayout(null);
		m.setVisible(true);
	}
	Principal(){
		Container c = getContentPane();
		c.add(lblnotas);
		lblnotas.setBounds(30, -60, 200, 500);
		c.add(codigo);
		codigo.setBounds(100, 50, 100, 30);
		c.add(lblcodigo);
		lblcodigo.setBounds(30, 50, 100, 40);
		c.add(lblnombre);
		lblnombre.setBounds(220, 50, 100, 40);
		c.add(nombre);
		nombre.setBounds(320, 50, 100, 30);
		c.add(nota1);
		nota1.setBounds(100,120,30,30);
		c.add(nota2);
		nota2.setBounds(100,160,30,30);
		c.add(nota3);
		nota3.setBounds(100,200,30,30);
		c.add(nota4);
		nota4.setBounds(100,240,30,30);
		c.add(consultar);
		consultar.setBounds(250, 100, 150, 50);
		consultar.addActionListener(this);
		
		c.add(registrar);
		registrar.setBounds(250, 160, 150, 50);
		registrar.addActionListener(this);
		
		c.add(enlistar);
		enlistar.setBounds(250, 210, 150, 50);
		enlistar.addActionListener(this);
		
		c.add(textarea);
		textarea.setBounds(30, 400, 470, 600);
		
	}

	
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource()==registrar){
			int errorN =0;	
			int error =0;
			String Snota1 = nota1.getText();
			String Snota2 = nota2.getText();
			String Snota3 = nota3.getText();
			String Snota4 = nota4.getText();
			String Scodigo = codigo.getText();
			
		

			for(int i=0; i<Snota1.length() ;i++){
				if (Snota1.charAt(i)<'0'||Snota1.charAt(i)>'9' ){
					errorN++;	
				}
			}
			
			for(int i=0; i<Snota2.length() ;i++){
				if (Snota2.charAt(i)<'0'||Snota2.charAt(i)>'9' ){
					errorN++;	
				}
			}
			
			for(int i=0; i<Snota3.length() ;i++){
				if (Snota3.charAt(i)<'0'||Snota3.charAt(i)>'9' ){
					errorN++;	
				}
			}
			
			for(int i=0; i<Snota1.length() ;i++){
				if (Snota4.charAt(i)<'0'||Snota4.charAt(i)>'9' ){
					errorN++;	
				}
			}
			
			for(int i=0; i<Scodigo.length() ;i++){
				if (Scodigo.charAt(i)<'0'||Scodigo.charAt(i)>'9'){
					error++;	
				}
			}
			
			if(nota1.getText().isEmpty()||nota2.getText().isEmpty()||nota3.getText().isEmpty()||nota4.getText().isEmpty() || errorN>=1){
				JOptionPane.showMessageDialog(null, "DATOS ERRONEOS, REVISE NOTAS");
			}
			
			else if(codigo.getText().isEmpty() || error>=1){
				JOptionPane.showMessageDialog(null, "codigo erroneo");
			}
			
			else{
				double iNota1 = Double.parseDouble(nota1.getText());
				double iNota2 = Double.parseDouble(nota2.getText());
				double iNota3 = Double.parseDouble(nota4.getText());
				double iNota4 = Double.parseDouble(nota4.getText());
				if (iNota1>5 || iNota2>5 || iNota3>5 || iNota4>5  ){
					JOptionPane.showMessageDialog(null, "Notas deben ser menores a 50");
				}
				else{
				//textarea.setText(null);
				JOptionPane.showMessageDialog(null, "Datos Registrados");
				datos.registrar(codigo.getText(),nombre.getText(),nota1.getText(),nota2.getText(),nota3.getText(),nota4.getText());
				}
			}
			
		}
		if (arg0.getSource()==consultar){
			datos.consultar();
		}
		if(arg0.getSource()==enlistar) {
			
			textarea.setText(null);
			textarea.setFont(new Font("Monospaced",Font.BOLD,18));
			datos.enlistar();
			textarea.setText(datos.todo);
			datos.todo= "";
			
			
			
		}
	}}

	
	

