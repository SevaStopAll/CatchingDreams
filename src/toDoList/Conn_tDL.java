package toDoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Conn_tDL {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);

	public static void Conn() throws ClassNotFoundException, SQLException {
	   conn = null;
	   Class.forName("org.sqlite.JDBC");
	   conn = DriverManager.getConnection("jdbc:sqlite:toDoList.db" );
	   System.out.println("The base was connected or created!");
	}
	
	public static void WriteDB() throws SQLException {
		statmt = conn.createStatement();
		String query = sc.nextLine();
		statmt.execute("INSERT into 'ToDoList' ('name') VALUES ('" + query + "');");
		System.out.println("Done");
	}
	
	public static void Delete() throws SQLException {
		statmt = conn.createStatement();
		int toDelete = sc.nextInt();
		statmt.execute("DELETE FROM ToDoList WHERE ID =" + toDelete + ";");
	}

	public static void ReadDB() throws ClassNotFoundException, SQLException{
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("SELECT * from ToDoList");
		
		while (resSet.next()) {
			int id = resSet.getInt("ID");
			String name = resSet.getString("Name");
			System.out.println( "Taask №  " + id );
	        System.out.println( "What to do? -  " + name );
	        System.out.println();
		}
			
		
	}
}