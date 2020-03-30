import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener  {

	JTextField nombreUsuario = new JTextField();
	JLabel lblNombre = new JLabel("Nombre Usuario");
	JButton asignar = new JButton("Asignar Turno");
	JButton atender = new JButton("ATENDER");
	JTextField siguiente = new JTextField();
	JButton mostrar = new JButton("Mostrar Lista");
	Queue<String> usuarios=new LinkedList<>();
	JTextArea TxtUsuarios = new JTextArea(200,200);
	int contTurnos=0;
	int cantUsuarios=0;
	String todo="";
	String[] lista=new String[100];
	
	public static void main(String args[]) {
		Principal m = new Principal();
		m.setSize(800, 700);
		m.setLayout(null);
		m.setVisible(true);
	}
	
	Principal(){
		
		Container c = getContentPane();
		c.add(lblNombre);
		lblNombre.setBounds(100, 40, 100, 50);
		c.add(nombreUsuario);
		nombreUsuario.setBounds(250, 50, 150, 30);
		c.add(asignar);
		asignar.addActionListener(this);
		asignar.setBounds(450, 40, 150, 40);
		c.add(atender);
		atender.addActionListener(this);
		atender.setBounds(100, 150, 100, 40);
		c.add(siguiente);
		siguiente.setBounds(250, 150, 150, 30);
		c.add(mostrar);
		mostrar.addActionListener(this);
		mostrar.setBounds(100, 200, 150, 40);
		c.add(TxtUsuarios);
		TxtUsuarios.setBounds(50, 300, 300, 300);
		TxtUsuarios.setFont(new Font("Monospaced", Font.BOLD, 14));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==asignar) {
				
				if(nombreUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingrese un nombre");
				}
			
				else {
				String usuario = nombreUsuario.getText();
				usuarios.add(usuario);
				lista[cantUsuarios]=usuario;
				cantUsuarios++;
				todo="";
				for(int i =contTurnos; i<cantUsuarios;i++) {
					todo+=lista[i]+"\n";
				}
				System.out.print(todo);
				
				
			}
			
		}
		
		else if(arg0.getSource()==atender) {
			TxtUsuarios.setText("");
			//if(siguiente.getText().isEmpty()|| siguiente.getText().contains(null)) {
				//JOptionPane.showMessageDialog(null, "No hay mas usuarios en espera");
			//}
			//else {
			siguiente.setText("Sigue "+usuarios.poll());
			contTurnos++;
			todo="";
			for(int i =contTurnos; i<cantUsuarios;i++) {
				todo+=lista[i]+"\n";
			}
			TxtUsuarios.setText(todo);
			}
		//}
		
		else if(arg0.getSource()==mostrar) {
			todo="";
			for(int i =contTurnos; i<cantUsuarios;i++) {
				todo+=lista[i]+"\n";
			}
			TxtUsuarios.setText(todo);
			
		}
		
	}

}
