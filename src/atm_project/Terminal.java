package atm_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.HashMap;

public class Terminal {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	public static HashMap <String, String> usersList = new HashMap<>();


public static void Conn() throws ClassNotFoundException, SQLException {
	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:ATM_DB.db");
	System.out.println("You entered in manager's terminal! Please follow the instructions.");
}

public static void AddUser() throws SQLException {
	statmt = conn.createStatement();
	String logIn = sc.next();
	String password = sc.next();
	// Here you have to add Log and Password for users
	statmt.execute("INSERT INTO 'users' (userName, userPassword) VALUES ('" + logIn + "' , '" + password + "' );");
	System.out.println("User account created.");
}

public static HashMap CreateUserList() throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from users");
	while (resSet.next()) {
		String logIn = resSet.getString("userName");
		String password = resSet.getString("userPassword");
		usersList.put(logIn, password);
	}
	return usersList;
	}
}

