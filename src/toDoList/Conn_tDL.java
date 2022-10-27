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
		statmt.execute("INSERT into 'ToDoList' ('name', 'IsDone') VALUES ('" + query + "', 0);");
		System.out.println("Done");
	}
	
	public static void MakeItDone() throws SQLException {
		statmt = conn.createStatement();
		int done = sc.nextInt();
		statmt.execute("UPDATE ToDoList SET IsDone = 1 WHERE ID =" + done + ";");
	}

	public static void ReadDB() throws ClassNotFoundException, SQLException{
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("SELECT * from ToDoList");
		int toDoQueue = 1;
		while (resSet.next()) {
			int id = resSet.getInt("ID");
			String name = resSet.getString("Name");
			boolean isDone = resSet.getBoolean("IsDone");
			System.out.println( "Task №  " + toDoQueue);
			toDoQueue++;
	        System.out.println( "What to do? -  " + name );
	        System.out.println("Is it done? " + isDone);
	        System.out.println("General number of this task:" + id);
	        System.out.println();
		}	
	}
	public static void Drop() throws SQLException {
		statmt = conn.createStatement();
		statmt.execute("DROP TABLE ToDoList;");
		statmt.execute("CREATE TABLE ToDoList (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME text, isDone boolean);");
	}
}