/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//import com.mysql.jdbc.Connection;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
///http://panamahitek.com/los-7-pasos-seguir-para-el-manejo-de-mysql-con-java/


public class Borre {
//  72s0
    /**
     * @param args the command line arguments
     */
   Connection conex ;
    public static void main(String[] args) {
        // TODO code application logic here
        Borre pro=new Borre();
        //pro.createDB();
        pro.conectar();
       pro.createDB(); pro.cerrarconex();
        //pro.conectar();pro.createTable();pro.cerrarconex();
        //pro.conectar();pro.insertData("1", "cesar", "becerra", "24", "m");pro.cerrarconex();
        //pro.conectar();pro.escribir();pro.cerrarconex();
    }
    public void conectar() {
        //forName("com.mysql.jdbc.Driver");
        try {
            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            conex = (Connection)DriverManager.getConnection
                 ("jdbc:mysql://localhost:3306/mysql" ,"root","mysql2017");
            System.out.print("conectado....");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }
    public void cerrarconex() {
        try {
            conex.close();
            System.out.print("cerrada....");
            
        } catch (SQLException ex) {
            System.out.print("error en cerrar....");
        }
    }
    public void createDB() {
        try {
            String Query = "CREATE SCHEMA " + "uno";
            Statement st = conex.createStatement();
            st.executeUpdate(Query);
            conex.close();
            System.out.print("creada....");
            
        } catch (SQLException ex) {
            System.out.print("error en crear....");
        }
    }
    public void createTable() {
        try {
            String Query = "CREATE TABLE " + "tabla1"
                    + "(ID VARCHAR(25),Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " Edad VARCHAR(3), Sexo VARCHAR(1))";
 
            Statement st = conex.createStatement();
            st.executeUpdate(Query);
            System.out.print("tabla creada....");
//"\""+"f"+"\""
        } catch (SQLException ex) {
            System.out.print("error crear tabla ....");
        }
    }
    public void insertData(String ID, String name, String lastname, String age, String gender) {
         //= "CREATE TABLE " + "tabla1"
           //         + "(ID VARCHAR(25),Nombre VARCHAR(50), Apellido VARCHAR(50),"
             //       + " Edad VARCHAR(3), Sexo VARCHAR(1))";
        try {
            String Query = "INSERT INTO " + "tabla1" + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + lastname + "\", "
                    + "\"" + age + "\", "
                    + "\"" + gender + "\")";
            Statement st = conex.createStatement();
            st.executeUpdate(Query);
            System.out.print("inserto datos ....");
        } catch (SQLException ex) {
            System.out.print("eror inserto....");
        }
    }
    public void escribir() {
        try {
            String Query = "SELECT * FROM " + "tabla1";
            Statement st = conex.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID") + "\n"
                        + "Nombre: " + resultSet.getString("Nombre") + "\n" + 
                        resultSet.getString("Apellido") + "\n"
                        + "Edad: " + resultSet.getString("Edad") + "\n"
                        + "Sexo: " + resultSet.getString("Sexo"));
            }
 
        } catch (SQLException ex) {
            System.out.print("eror crear tabla....");
        }
    }
}