package SchoolDairy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WorkDB {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;

	public static void connect() {
		try {
			Scanner sc = new Scanner(System.in);
			conn = null;
		    Class.forName("org.sqlite.JDBC");
		    System.out.println("Please, enter the name of new or existing DB!");
		    String baseName = sc.nextLine();
		    conn = DriverManager.getConnection("jdbc:sqlite:" + baseName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {}
	}
	
	






}


