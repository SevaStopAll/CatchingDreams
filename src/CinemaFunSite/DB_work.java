package CinemaFunSite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB_work {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:cinema.db");
		   
		   System.out.println("The base was connected or created!");
	   }
	
	public static void WriteReview() throws SQLException
	{
		statmt = conn.createStatement();
		String cinemaName = sc.nextLine();
		String yourReview = sc.nextLine();
		int rating = sc.nextInt();
		statmt.execute("INSERT INTO 'reviews' (cinema_name, review, rating) VALUES ('" + cinemaName + "','" + yourReview + "', " + rating + ");");
		System.out.println("Done");
	}
	
	
}
