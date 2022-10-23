package javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
	public static void Conn() throws ClassNotFoundException, SQLException {
		conn = null;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:Test1.s3bd");
		
		System.out.println("Connected");
		
	}
	
	public static void CreateDB() throws ClassNotFoundException, SQLException {
		statmt = conn.createStatement();
		
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
		
		System.out.println("Table was created or has been already existing");
		
	}
	
	public static void WriteDB() throws SQLException {
		statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Micha', 12345);");
		System.out.println("Inserted");
	}
	
	public static void ReadDB() throws ClassNotFoundException, SQLException {
		resSet = statmt.executeQuery("SELECT * FROM users");
	
		while(resSet.next()) {
		int id = resSet.getInt("id");
		String name = resSet.getString("name");
		String phone = resSet.getString("phone");
			System.out.println("ID = " + id);
			System.out.println("name = " + name);
			System.out.println("phone = " + phone);
			System.out.println();
		
	}
	System.out.println("Printed");
	}
	
	public static void CloseDB() throws ClassNotFoundException, SQLException {
		conn.close();
		statmt.close();
		resSet.close();
		
		System.out.println("Connections closed");
	}
	
}
