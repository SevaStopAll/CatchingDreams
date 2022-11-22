package SchoolDairy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class WorkDB {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Set <String> setUsers = new HashSet<>();

	public static void connect() {
		try (Scanner sc = new Scanner(System.in)){
			conn = null;
		    Class.forName("org.sqlite.JDBC");
		    conn = DriverManager.getConnection("jdbc:sqlite: SchoolDairies.db");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {}
	}
	
	public static Set <String> CreateUserList() throws ClassNotFoundException, SQLException {
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("Select * from STUDENTS");
		while (resSet.next()) {
			String logIn = resSet.getString("Student_Login");
			setUsers.add(logIn);
		}
		return setUsers;
	}
	
	public static void AddUser() throws SQLException {
		try (Scanner sc = new Scanner (System.in)) {
			statmt = conn.createStatement();
		String logIn = sc.next();
		if (setUsers.contains(logIn)) {
			System.out.println("This login is already exist. Please, try another login");
			WorkDB.AddUser();
		} 
		String password = sc.next();
		statmt.execute("INSERT INTO 'users' (userName, userPassword) VALUES ('" + logIn + "' , '" + password + "' );");
		} 
		System.out.println("User account created.");
	}
}
