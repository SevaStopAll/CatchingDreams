package ChatLight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import atm_project.Terminal;


public class LogPass {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	public static HashMap <String, String> usersList = new HashMap<>();
	public static Set <String> setUsers = new HashSet<>();
	
public static void Conn() throws ClassNotFoundException, SQLException {
	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:ATM_DB.db");
}

public static HashMap<String, String> CreateUserList() throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from users");
	while (resSet.next()) {
		String logIn = resSet.getString("userName");
		String password = resSet.getString("userPassword");
		usersList.put(logIn, password);
		setUsers.add(logIn);
	}
	return usersList;
}
	public static void AddUser() throws SQLException {
		statmt = conn.createStatement();
		String logIn = sc.next();
		if (setUsers.contains(logIn)) {
			System.out.println("This login is already exist. Please, try another login");
			LogPass.AddUser();
		} 
		String password = sc.next();
		statmt.execute("INSERT INTO 'users' (userName, userPassword) VALUES ('" + logIn + "' , '" + password + "' );");
		System.out.println("User account created.");
	}
	
	public static void LogIn() {
	System.out.println("Please add your name and password!");
	String login = sc.next();
	String password = sc.next();
	try {
		if (password.equals(LogPass.CreateUserList().get(login))) {
			//LogIn();
		}
		else {
		System.out.println("Not correct");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	LogIn();
	}
}
