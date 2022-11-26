package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class LogPass {
	static Connection conn;
	static Statement statmt;
	static ResultSet resSet;
	static Set<String> setUsers = new HashSet<>();
	static HashMap<String, String> usersList = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	static String userLogin;

	
public static void Conn() throws ClassNotFoundException, SQLException {
	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:ChatLight.db");
}

public static HashMap<String, String> CreateUserList() throws ClassNotFoundException, SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from users");
	while (resSet.next()) {
		String logIn = resSet.getString("User_Login");
		String password = resSet.getString("User_Password");
		usersList.put(logIn, password);
		setUsers.add(logIn);
	}
	return usersList;
}
	public static void AddUser() throws SQLException {
		statmt = conn.createStatement();
		userLogin = sc.next();
		if (setUsers.contains(userLogin)) {
			System.out.println("This login is already exist. Please, try another login");
			LogPass.AddUser();
		} 
		String password = sc.next();
		 String sql = "INSERT INTO 'users' (User_Login, User_Password) Values (?, ?)";
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1, userLogin);
         preparedStatement.setString(2, password);
		System.out.println("Registration success.");
		menu();
	}
	
	public static void LogIn() {
		System.out.println("Please add your name and password!");
		userLogin = sc.next();
		String password = sc.next();
		sc.nextLine();
		try {
			if (password.equals(LogPass.CreateUserList().get(userLogin))) {
				System.out.println("Success");
				userMenu();
			} else {
				System.out.println("Not correct");
				LogIn();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendMessage() throws SQLException {
		System.out.println("Enter the Recipient");
		String recipient = sc.nextLine();
		if (setUsers.contains(recipient)) {
			System.out.println("Now enter you message");
			String message = sc.nextLine();
			statmt = conn.createStatement();
			String time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
			statmt.execute("INSERT INTO 'Messages' (Sender, Recipient, Message, Date, Written) VALUES('" + userLogin + "', '" + recipient + "', '" + message + "', '" 
			+ time + "',  + 0);");
		} else {
			System.out.println("Can't find this user registered");
			sendMessage();
		}
		
	}
	
	public static void readMessages() throws SQLException {
		//System.out.println("Enter the Recipient");  - LATER
		// String sender = sc.nextLine(); - LATER
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("Select * from Messages WHERE Recipient = '" + userLogin + "';");
		int numbOfMessage = 1;
		while (resSet.next()) {
			String sender = resSet.getString("Sender");
			String message = resSet.getString("Message");
			String date = resSet.getString("Date");
			System.out.println("Message " + numbOfMessage);
			System.out.println("Date: " + date);
			System.out.println("From: " + sender + ": " + message);
			numbOfMessage++;
			System.out.println();
		}
	}
	
	public static void menu() throws SQLException {
		try {
			LogPass.Conn();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			LogPass.CreateUserList();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("1. Login   2.Sign Up");
		int operation = sc.nextInt();
		switch(operation) {
			case(1): 
				LogPass.LogIn();
				break;
			case(2):
				LogPass.AddUser();
				break;
		}
	}
		
	public static void userMenu() throws SQLException {	
		System.out.println("What do you want to do? \n1.Send a message \n2.Inbox \n3.Exit ");	
		try (Scanner sc = new Scanner(System.in))
		{
		int operation = sc.nextInt();
		
		switch(operation) {
			case(1):
				LogPass.sendMessage();
				userMenu();
				break;
			
			case(2):
				LogPass.readMessages();
				userMenu();
				break;
				
			case(3):
				System.exit(0);
				userMenu();
				break;
		}
		}
		
}
}
