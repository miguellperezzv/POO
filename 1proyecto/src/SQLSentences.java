import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

public class SQLSentences {
	
//private BDConexion BDconn;
 Connection conn=null;
 static String nombreBD="proyecto2";
 String user ="root";
 String pass = "";
 
 		public void crearDB() {
	 boolean creada=false;
	// while(creada==false) {
		 
		 //nombreBD=JOptionPane.showInputDialog("Ingrese un nombre para la base de datos");
		 try {
			 
			try {
				Class.forName("com.mysql.jdbc.Driver"); //Class.forName("com.mysql.jdbc.Connection");
				System.out.print("clase conectada, ");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("error en la Clase,  "+e);
			}
			
			
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/"/*+nombreBD*/, user, pass);
			System.out.println("Conexión realizada\n");	
	         String Query = "CREATE schema "+nombreBD ; 
	         Statement st = conn.createStatement();
	         st.executeUpdate(Query);
	         //conn.close();
	         System.out.print("base de datos (notas) creada\n");
	         creada=true;
	         JOptionPane.showMessageDialog(null, "Base de datos "+nombreBD+ " creada\n");
	         
	     } catch (SQLException ex) {
	         System.out.print("error en crear base de datos!! " +ex);
	         String error=ex.getMessage();
	         if(error.contains("exist")) {
	        	 JOptionPane.showMessageDialog(null, "La base de datos ya existe");
	         }
	     }
	 //}
	 
 }
 
 		public void BorrarDB() {
 
 }
 		public void crearTablaEst(){
	 try {
         String Query = "CREATE TABLE "+nombreBD + ".Estudiante"
                 + "(codigo INT not null,"
                 + "nombre VARCHAR(25) not null,"
                 + " NOTA INT not null,"
                 + "iduniversidad int not null,"
                 + "primary key (codigo),"
                 + "index (iduniversidad),"
                 + "FOREIGN KEY (IDUNIVERSIDAD) references universidad(idUniversidad))";

         Statement st = conn.createStatement();
         st.executeUpdate(Query);
         System.out.print("\ntabla estudiante creada, ");

     } catch (SQLException ex) {
         System.out.print("error crear tabla estudiante: "+ ex);
     }
 }
 
 		public void crearTablaUni(){
	 try {
	 
         String Query = "CREATE TABLE "+nombreBD + ".universidad"
                 + "(iduniversidad INT NOT NULL,"
                 + "nombre VARCHAR(25) NOT NULL,"
                 + " PRIMARY KEY (idUniversidad))";

         Statement st = conn.createStatement();
         st.executeUpdate(Query);
         System.out.print("tabla Universidad creada \n");

     } catch (SQLException ex) {
    	 String error=ex.getMessage();
    	 if(error.contains("exist")) {
    		 JOptionPane.showMessageDialog(null, "Las tablas Estudiante Universidad ya existen");
    	 }
     }
 }
		public  Connection conectar() {
		//if(conn==null) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost/"+ nombreBD, user, pass);
				System.out.println("Conexión realizada. .  .   . ");
			}catch(Exception e) {
				System.out.print("Error en conectar: "+ e);
			}
		//}
		
		return conn;	
	}
	
		public void cerrar() {
		
		try {
			if(conn!=null) {
				conn.close();
				System.out.println("Conexion cerrada");
			}
		}catch(Exception e) {
			System.out.println("Error en cerrar: "+e);
		}
	}
		public void registrarEstudiante (int codigo, String nombre, int nota, int idU){
		try {
			//Connection conn = BDconn.conectar();
			Statement stm = conn.createStatement();
			String sql= "INSERT INTO ESTUDIANTE VALUES("+ codigo+",'"+nombre+"',"+nota+","+idU+")";
			stm.execute(sql);
			//BDconn.cerrar();
			JOptionPane.showMessageDialog(null, "Estudiante registrado");
		}catch (Exception e) {
			String error =e.getMessage();
			System.out.println("Error en registrar : "+ e);
			if(error.contains("Duplicate")) {
				JOptionPane.showMessageDialog(null, "Existe un estudiante con el código: "+ codigo);
			}
			
		}
	}
	
		public void registrarUniversidad(int codigo, String nombre) {
		try {
			//Connection conn = BDconn.conectar();
			Statement stm = conn.createStatement();
			String sql = "INSERT INTO UNIVERSIDAD VALUES("+codigo+",'"+nombre+"')";
			stm.execute(sql);
			//BDconn.cerrar();
			JOptionPane.showMessageDialog(null, "Universidad registrada ");
		}catch(Exception e) {
			System.out.print("Error en registrar Universidad: "+ e.getMessage());
		}
	}

		public ArrayList<String> llenarComboBox() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<String> lista = new ArrayList<String>();
		String sql ="SELECT * FROM `universidad`";
		try {
			Statement stm = conn.createStatement();
			rs =stm.executeQuery(sql);
			System.out.print("\nDatos para combobox\n");
		}catch(Exception e) {
			System.out.print("\nError en ComboBox: "+e+"\n");
		}
		try {
			while(rs.next()) {
				lista.add(rs.getString("Nombre"));
		}}catch(Exception e) {
			System.out.println("error en: "+e);
			}
		return lista;
	}
	
		public ResultSet consultar(String tabla,String columna ) {
		try {
			//Connection conn = this.conectar();
			Statement st = conn.createStatement();
			String sql = "SELECT "+columna+" FROM "+tabla;
			ResultSet rs = st.executeQuery(sql);
			/*while(rs.next()) {
				String nombre = rs.getString("NOMBRE");
	                
			}*/
			return rs;
		}catch(Exception e) {
			System.out.print("\nError en consultar "+e);
			return null;}
		}
		
		public ResultSet consultarNum(String tabla,String columna,int id ) {
			try {
				//Connection conn = this.conectar();
				Statement st = conn.createStatement();
				String sql = "SELECT count("+columna+") FROM "+tabla+" where iduniversidad="+id;
				ResultSet rs = st.executeQuery(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				return rs;
			}catch(Exception e) {
				System.out.print("\nError en consultar cantidad "+e);
				return null;}
			}
			
		public ResultSet consultarEst(String tabla,String columna,int id ) {
				try {
					//Connection conn = this.conectar();
					Statement st = conn.createStatement();
					String sql = "SELECT " +columna+" FROM "+tabla+" where iduniversidad="+id;
					ResultSet rs = st.executeQuery(sql);
					/*while(rs.next()) {
						String nombre = rs.getString("NOMBRE");
			                
					}*/
					return rs;
				}catch(Exception e) {
					System.out.print("\nError en consultar estudiantes "+e);
					return null;
				}
		
	}
		
		public ResultSet consultaridU(String tabla,String columna,String uni ) {
			try {
				//Connection conn = this.conectar();
				Statement st = conn.createStatement();
				String sql = "SELECT "+columna+" FROM "+tabla+" where nombre='"+uni+"'";
				ResultSet rs = st.executeQuery(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				return rs;
			}catch(Exception e) {
				System.out.print("\nError en consultar idUniversidad "+e);
				return null;
			}
		
		}
		
		public ResultSet consultarNombreU(String tabla,String columna,int idU ) {
			try {
				//Connection conn = this.conectar();
				Statement st = conn.createStatement();
				String sql = "SELECT "+columna+" FROM "+tabla+" where iduniversidad="+idU;
				ResultSet rs = st.executeQuery(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				return rs;
			}catch(Exception e) {
				System.out.print("\nError en consultar nombre U "+e);
				return null;
			}
		
		}
	
		public ResultSet consultarEstNota(String tabla, String columna, String razon, int base) {
			try {
				
				Statement st = conn.createStatement();
				String sql = null;
				if(razon.equals("mayor")) {
					sql = "SELECT "+columna+" FROM "+tabla+" where nota>="+base+"";
				}
				else if(razon.equals("menor")) {
					sql = "SELECT "+columna+" FROM "+tabla+" where nota<"+base+"";
				}
				
				ResultSet rs = st.executeQuery(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				return rs;
			}catch(Exception e) {
				System.out.print("\nError en consultar estudiantes con menor o mayor nota  "+e);
				return null;
			}
		}
		
		public ResultSet consultarInd(String tabla, String columna, int id) {
			try {
				
				Statement st = conn.createStatement();
				String sql = null;
				sql = "SELECT "+columna+" FROM "+tabla+" where codigo = "+id;
				
				
				ResultSet rs = st.executeQuery(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				return rs;
			}catch(Exception e) {
				System.out.print("\nError en consultar estudiantes con menor o mayor nota  "+e);
				return null;
			}
		}
		
		public void borrarEstudiante(String tabla, int id) {
			try {
				
				Statement st = conn.createStatement();
				String sql = "DELETE FROM "+tabla+" where codigo = "+id;
				st.executeUpdate(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				System.out.print("\nEstudiante retirado ");
				JOptionPane.showMessageDialog(null,"Estudiante Retirado");
			}catch(Exception e) {
				System.out.print("\nError en retirar estudiantes "+e);
			}
		}
		
		public void borrarUniv(String tabla, int id) {
			try {
				
				Statement st = conn.createStatement();
				String sql = "DELETE FROM "+tabla+" where iduniversidad = "+id;
				st.executeUpdate(sql);
				/*while(rs.next()) {
					String nombre = rs.getString("NOMBRE");
		                
				}*/
				System.out.print("\nUniversidad Retirada ");
				JOptionPane.showMessageDialog(null,"Universidad Retirada");
			}catch(Exception e) {
				System.out.print("\nError en retirar estudiantes "+e);
			}
		}
	
	
}
