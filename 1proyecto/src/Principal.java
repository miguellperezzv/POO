import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {

	static Hilo h;
	static Hilo2 h1;
	
	boolean DBcreada=false;
	
	
	SQLSentences ssql = new SQLSentences();
	JMenu opc = new JMenu("Opciones");
	JMenuBar menu = new JMenuBar();
	JMenuItem crearDB= new JMenuItem("Crear Base de Datos");
	JMenuItem crearTable= new JMenuItem("Crear tablas");
	
	JMenuItem consultarEst = new JMenuItem("Consultar Estudiantes");
	JMenuItem consultarUni=new JMenuItem("Consultar Universidades");
	JMenuItem consultarCant =new JMenuItem("Consultar Estuidiantes de alguna Univ");
	JMenuItem consultarNotaMayor = new JMenuItem("Estudiantes con nota mayor a 30");
	JMenuItem consultarNotaMenor = new JMenuItem("Estudiante con nota menor a 30");
	JMenuItem retirarEstudiante = new JMenuItem("Retirar Estudiante");
	JMenuItem retirarUniv = new JMenuItem("Retirar Univ");
	
	JTextArea consultas= new JTextArea();
	
	JLabel registrarlbl = new JLabel ("REGISTRAR ESTUDIANTE");JLabel codigolbl = new JLabel ("Codigo:");JLabel nombrelbl  =new JLabel ("Nombre:");JLabel notalbl = new JLabel ("Nota:");JLabel unilbl = new JLabel("Universidad:");
	JButton registrarEst=new JButton("Registrar"); 
	JButton registrarUni =  new JButton ("Registrar Uni");
	JTextField txtnombre = new JTextField();JTextField txtcodigo = new JTextField();JTextField txtnota = new JTextField();
	JComboBox<Object> cmbboxuni = new JComboBox<Object>();
	
	JLabel registrarunilbl =new JLabel ("REGISTRAR UNIVERSIDAD");JLabel nombreunilbl = new JLabel("Nombre: ");
	JTextField txtUni = new JTextField();
	
	JButton consultaInd=new JButton("Consultar Estudiante");
	JTextField txtconsultaInd=new JTextField();
	
	Principal(){
		
		Container c= getContentPane();
		c.setLayout(null);
		c.setVisible(true);
		
		crearDB.addActionListener(this);
		crearTable.addActionListener(this);
		consultarEst.addActionListener(this);
		consultarUni.addActionListener(this);
		consultarCant.addActionListener(this);
		consultarNotaMayor.addActionListener(this);
		consultarNotaMenor.addActionListener(this);
		retirarEstudiante.addActionListener(this);
		retirarUniv.addActionListener(this);
		
		setJMenuBar(menu);
		menu.add(opc);
		opc.add(crearDB);
		opc.add(crearTable);
		opc.add(consultarEst);
		opc.add(consultarUni);
		opc.add(consultarCant);
		opc.add(consultarNotaMayor);
		opc.add(consultarNotaMenor);
		opc.add(retirarEstudiante);
		opc.add(retirarUniv);
		
		c.add(registrarlbl);  registrarlbl.setBounds(50, 200, 200, 40);
		c.add(codigolbl);     codigolbl.setBounds(50, 250, 200, 40);
		c.add(nombrelbl);     nombrelbl.setBounds(50, 300, 100, 40);
		c.add(notalbl);       notalbl.setBounds(50, 350, 100, 40);
		c.add(unilbl);        unilbl.setBounds(50, 400, 100, 40);
		c.add(registrarEst);  registrarEst.setBounds(70, 450, 100, 40); registrarEst.addActionListener(this);
		c.add(txtcodigo);     txtcodigo.setBounds(150, 250, 100, 30);  
		c.add(txtnombre);     txtnombre.setBounds(150,300,100,30);    
		c.add(txtnota);       txtnota.setBounds(150, 350, 100, 30);
		c.add(cmbboxuni);
		
		c.add(registrarunilbl);registrarunilbl.setBounds(50, 500, 200, 40); 
		c.add(nombreunilbl); nombreunilbl.setBounds(50, 550, 100, 30);
		c.add(txtUni); txtUni.setBounds(150, 550, 100, 30);
		c.add(registrarUni);  registrarUni.setBounds(300, 550, 100, 40); registrarUni.addActionListener(this);
		
		cmbboxuni.setBounds(150, 400, 200, 30);
		cmbboxuni.removeAllItems();
		ArrayList<String> lista = new ArrayList<String>();
		ssql.conectar();
		lista = ssql.llenarComboBox();
		for(int i=0; i<lista.size();i++) {
			cmbboxuni.addItem(lista.get(i));
		}
		c.add(consultas);
		consultas.setBounds(500, 200, 500, 400);
		consultas.setFont(new Font("Monospaced",Font.BOLD,16));
		
		c.add(consultaInd);
		consultaInd.setBounds(200,650,200,40);
		consultaInd.addActionListener(this);
		c.add(txtconsultaInd);
		txtconsultaInd.setBounds(50,650,100,30);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SQLSentences ssql = new SQLSentences();
		//ssql.crearDB();
		Principal m = new Principal();
		m.setSize(1000, 800);
		m.setVisible(true);
		h=new Hilo(m.getGraphics(),m.getBackground());
		h1=new Hilo2(m.getGraphics(),m.getBackground());
		h.start();
		h1.start();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==crearDB) {
			ssql.crearDB();
			DBcreada= true;
		}
		
		if(arg0.getSource()==registrarEst) {
			int codigo;
			String nombre;
			int nota;
			int idU;
			int validez = 0;
			
			
			
			String Scodigo=txtcodigo.getText();
			String Snombre=txtnombre.getText();
			String Snota = txtnota.getText();
			if(txtcodigo.getText().isEmpty() || txtnombre.getText().isEmpty() || txtnota.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ingrese datos");
				validez++;
				
			}else {}
			
			for(int i=0; i<Scodigo.length();i++) {
				if(Scodigo.charAt(i)<'0' || Scodigo.charAt(i)>'9') {
					validez++;
					//JOptionPane.showMessageDialog(null, "Codigo invalido");
				}
				else {}
			}	
			for(int i=0; i<Snombre.length();i++) {
					if(Snombre.charAt(i)<'9') {
						validez++;
						System.out.print("PROBLEMAS CON EL nombre\n");
					}
					else {}	
				
			}
			
			for(int i=0; i<Snota.length();i++) {
				if(Snota.charAt(i)<'0' || Snota.charAt(i)>'9') {
					validez++;
					System.out.print("PROBLEMAS CON la nota\n");
				}
				else {
					int Scod=Integer.parseInt(txtnota.getText());
					if(Scod<0 || Scod>50) {
						System.out.print("PROBLEMAS CON EL nota conversion\n");
						validez++;
					}
					else {
					}
					}	
		}
			
			if(validez==0) {
				
				codigo=Integer.parseInt(txtcodigo.getText());
				nombre=txtnombre.getText();
				nota=Integer.parseInt(txtnota.getText());
				idU= cmbboxuni.getSelectedIndex()+1;
				ssql.conectar();
				ssql.registrarEstudiante(codigo, nombre, nota, idU);
				ssql.cerrar();
				//JOptionPane.showMessageDialog(null, "Datos registrados");
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos no registrados");
			}
			//
		}
		
		
		if(arg0.getSource()==crearTable) {
				ssql.conectar();
				ssql.crearTablaUni();
				ssql.crearTablaEst();
				ssql.cerrar();
		}
		
		if (arg0.getSource()==registrarUni) {
			int codigo = cmbboxuni.getItemCount()+1;
			boolean repetido=false;
			if(txtUni.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ingrese un nombre");
			}
			else {
				String nombre= txtUni.getText();
				
				ArrayList<String> universidades = new ArrayList<String>();
				universidades=ssql.llenarComboBox();
				for(int i=0;i<universidades.size();i++) {
					if(nombre.equalsIgnoreCase(universidades.get(i))) {
						System.out.print("La universidad ya existe");
						
						repetido=true;
						txtUni.setText(null);
					}
				}
				if(repetido==true) {
					JOptionPane.showMessageDialog(null, "La Universidad ya existe");
				}
				else {
					nombre=txtUni.getText();
					//JOptionPane.showMessageDialog(null, "Universidad registrada");
					ssql.conectar();
					ssql.registrarUniversidad(codigo, nombre);
					ssql.cerrar();
					ArrayList<String> lista = new ArrayList<String>();
					cmbboxuni.removeAllItems();
					ssql.conectar();
					lista = ssql.llenarComboBox();
					ssql.cerrar();
					for(int i=0; i<lista.size();i++) {
						cmbboxuni.addItem(lista.get(i));
					}
				}
			
			}	
		}
		
		if(arg0.getSource()==consultarEst) {
			ssql.conectar();
			ResultSet rs =ssql.consultar("ESTUDIANTE", "*");
			ResultSet rs2=null;
			String resultado="LISTADO DE ESTUDIANTES\n\n\nCODIGO\tNOMBRE\tNOTA\tUNIVERSIDAD\n\n";
			
			try {
				while(rs.next()) {
					int idU=0;
					resultado +=rs.getString("codigo")+"\t";
					resultado +=rs.getString("nombre")+"\t";
					resultado +=rs.getString("nota")+"\t";
					idU=Integer.parseInt(rs.getString("iduniversidad"));
					rs2 =ssql.consultarNombreU("UNIVERSIDAD", "NOMBRE",idU);
					while(rs2.next()) {
						resultado +=rs2.getString("nombre")+" \n";
					}
					
				}
			} catch (SQLException e) {
				System.out.print("Error en Listar Estudiantes "+e);
			}
			consultas.setText(resultado);
			ssql.cerrar();
		}
		
		if(arg0.getSource()==consultarUni) {
			ssql.conectar();
			ResultSet rs=ssql.consultar("UNIVERSIDAD", "*");
			String resultado = "LISTADO DE UNIVERSIDADES \n\n\nCODIGO\t\t NOMBRE \n";
			try {
				while(rs.next()) {
					resultado +=rs.getString("iduniversidad")+"\t\t";
					resultado +=rs.getString("nombre")+"\n";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			consultas.setText(resultado);
			ssql.cerrar();
		}
		
		if(arg0.getSource()==consultarCant) {
			
			ArrayList<String> lista = new ArrayList<String>();
			ssql.conectar();
			String mensaje="";
			lista = ssql.llenarComboBox();
			int codigo=0;
			int cantidad=0;
			
			String lista2[]=new String[cmbboxuni.getItemCount()];
			
			for(int i=0;i<lista.size();i++) {
				lista2[i]=lista.get(i);
			}
	
	       String resp = (String) JOptionPane.showInputDialog(null, "Seleccione una carrera a cursar", "Carrera", JOptionPane.DEFAULT_OPTION, null, lista2, lista2[0]);
	       System.out.println("opcion: "+resp);
	       ResultSet rs = ssql.consultaridU("UNIVERSIDAD", "IDuNIVERSIDAD", resp);
	       try {
	    	   while(rs.next()) {
	    		   System.out.println("RSGETSTRING RESP "+rs.getInt(1));
	    		   codigo=Integer.parseInt(rs.getString(1));
	    	   }
			
		} catch (SQLException e) {
			System.out.println("Error SQL "+ e);
		}
	       
	     ResultSet rs1 = ssql.consultarNum("estudiante","nombre",codigo);
	     try {
			while(rs1.next()) {
				  cantidad=Integer.parseInt(rs1.getString(1));
			 }
		} catch (SQLException e) {
			System.out.println("Error sql en consultar numero de estudiantes "+ e);
		}
	    mensaje+="ESTUDIANTES EN "+resp+": "+cantidad+"\n\n\n";
	    
	    ResultSet rs3 = ssql.consultarEst("ESTUDIANTE", "nombre", codigo);
	    try {
			while(rs3.next()) {
				mensaje+=rs3.getString("nombre")+"\n";
			}
		} catch (SQLException e) {
			System.out.println("Error SQL consultar nombres estudiantes "+ e);
		}
	    
	    consultas.setText(mensaje);
		}
		
		if(arg0.getSource()==consultarNotaMenor) {
			String resultados="ESTUDIANTES CON NOTA Menor A 30: \n\n\nCODIGO\t\tNOMBRE\t\tNOTA\n\n";
			ssql.conectar();
			ResultSet rs4;
			int base=30;
			rs4=ssql.consultarEstNota("estudiante", "*", "menor", base);
			try {
				while(rs4.next()) {
					resultados+=rs4.getString("CODIGO")+"\t\t";
					resultados+=rs4.getString("NOMBRE")+"\t\t";
					resultados+=rs4.getString("NOTA")+"\n";
				}
			} catch (SQLException e) {
				System.out.println("Error en resultados notas ");
			}
			consultas.setText(resultados);
		}
		
		if(arg0.getSource()==consultarNotaMayor) {
			String resultados="ESTUDIANTES CON NOTA Mayor A 30: \n\n\nCODIGO\t\tNOMBRE\t\tNOTA\n\n";
			ssql.conectar();
			ResultSet rs4;
			int base=30;
			rs4=ssql.consultarEstNota("estudiante", "*", "mayor", base);
			try {
				while(rs4.next()) {
					resultados+=rs4.getString("CODIGO")+"\t\t";
					resultados+=rs4.getString("NOMBRE")+"\t\t";
					resultados+=rs4.getString("NOTA")+"\n";
				}
			} catch (SQLException e) {
				System.out.println("Error en resultados notas ");
			}
			consultas.setText(resultados);
		}
		
		if(arg0.getSource()==consultaInd){
			String Scodigo =txtconsultaInd.getText();
			String resultado="";
			boolean valido=true;
			for(int i=0;i<Scodigo.length();i++){
				if(Scodigo.charAt(i)<'0' || Scodigo.charAt(i)>'9' ){
					valido=false;
				}
				else if(Scodigo.isEmpty()){
					valido=false;
				}
				else{}
				
			}
			if(valido==true){
				System.out.print("codigo correcto");
				int codigo =Integer.parseInt( txtconsultaInd.getText());
				ssql.conectar();
				ResultSet rs =ssql.consultarInd("ESTUDIANTE","*",codigo);
				try {
					while (rs.next()){
						resultado+=rs.getString("codigo")+"\t";
						resultado+=rs.getString("nombre")+"\t";
						resultado+=rs.getString("nota")+"\t";
						resultado+=rs.getString("iduniversidad")+"\t";
					}
				} catch (SQLException e) {
					System.out.print("Error en consulta Individual");
				}
				consultas.setText(resultado);
			}else{JOptionPane.showMessageDialog(null,"Codigo Incorrecto");}
		}
		
		if(arg0.getSource()==retirarEstudiante){
			String Scodigo = JOptionPane.showInputDialog(null,"Ingrese el codigo del estudiante ");
			for(int i=0;i<Scodigo.length();i++) {
				if(Scodigo.charAt(i)<'0' || Scodigo.charAt(i)>'9' || Scodigo==null) {
					JOptionPane.showMessageDialog(null, "Codigo invalido");
				}
				else {
					ssql.conectar();
					ssql.borrarEstudiante("ESTUDIANTE", Integer.parseInt(Scodigo));
					ssql.cerrar();
				}
			}
			
		}
		if(arg0.getSource()==retirarUniv){
			int codigo =Integer.parseInt( JOptionPane.showInputDialog(null,"Ingrese el codigo de la Universidad "));
			ssql.conectar();
			ssql.borrarUniv("universidad", codigo);
			ssql.cerrar();
		}
	}
}
