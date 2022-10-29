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
	System.out.println("DB connected.");
}


public static void AddUser() throws SQLException {
	statmt = conn.createStatement();
	String logIn = sc.next();
	String password = sc.next();
	statmt.execute("INSERT INTO 'users' (userName, userPassword) VALUES ('" + logIn + "' , '" + password + "' );");
	System.out.println("User account created.");
}


public static HashMap<String, String> CreateUserList() throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from users");
	while (resSet.next()) {
		String logIn = resSet.getString("userName");
		String password = resSet.getString("userPassword");
		usersList.put(logIn, password);
	}
	return usersList;
}


public static void WatchUserList() throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from users");
	while (resSet.next()) {
		String logIn = resSet.getString("userName");
		String password = resSet.getString("userPassword");
		int account = resSet.getInt("Account");
		System.out.println("Login " + logIn);
		System.out.println("Password " + password);
		System.out.println("Account " + account);
		System.out.println();
	}
	conn.close();
	statmt.close();
	resSet.close();
}


public static double ShowMyBalance(String logIn) throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	int account = resSet.getInt("Account");
	conn.close();
	statmt.close();
	resSet.close();
	return account;	
}


public static void GetMoney(String logIn) throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	System.out.println("What somm would you like to get?");
	int summ = sc.nextInt();
	resSet = statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	int accountBefore = resSet.getInt("Account");
	int accountAfter = accountBefore - summ;
	statmt.executeUpdate("UPDATE users SET Account = " + accountAfter + " WHERE UserName = '" + logIn + "';");
	System.out.println("Done");
	conn.close();
	statmt.close();
	resSet.close();	
}


public static void AddMoney(String logIn) throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	System.out.println("Add your summ!");
	int summ = sc.nextInt();
	resSet = statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	int accountBefore = resSet.getInt("Account");
	int accountAfter = accountBefore + summ;
	statmt.executeUpdate("UPDATE users SET Account = " + accountAfter + " WHERE UserName = '" + logIn + "';");
	System.out.println("Done");
	conn.close();
	statmt.close();
	resSet.close();
}

public static void SendMoney(String logIn) throws SQLException {
	statmt = conn.createStatement();
	statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	System.out.println("What somm would you like to get?");
	int summ = sc.nextInt();
	System.out.println("Who would you like to send money?");
	String reciever = sc.next();
	resSet = statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + logIn + "'");
	int accountBefore = resSet.getInt("Account");
	int accountAfter = accountBefore - summ;
	statmt.executeUpdate("UPDATE users SET Account = " + accountAfter + " WHERE UserName = '" + logIn + "';");
	resSet = statmt.executeQuery("Select Account from 'users' WHERE UserName = '" + reciever + "'");
	int accountBeforeReciever = resSet.getInt("Account");
	int accountAfterReciever = accountBeforeReciever + summ;
	statmt.executeUpdate("UPDATE users SET Account = " + accountAfterReciever + " WHERE UserName = '" + reciever + "';");
	System.out.println("Done");
	conn.close();
	statmt.close();
	resSet.close();
}

}

