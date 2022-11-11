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
	
	public static void WriteReview() throws SQLException {
		statmt = conn.createStatement();
		System.out.println("Film's name");
		String cinemaName = sc.nextLine();
		System.out.println("Write your review, than press ENTER");
		String yourReview = sc.nextLine();
		System.out.println("Add your score, please!");
		int rating = sc.nextInt();
		statmt.execute("INSERT INTO 'reviews' (cinema_name, review, rating) VALUES ('" + cinemaName + "','" + yourReview + "', " + rating + ");");
		System.out.println("Done");
	}
	
	public static void WatchReview() throws SQLException {
		statmt = conn.createStatement();
		System.out.println("Film's name");
		String cinemaName = sc.nextLine();
		resSet = statmt.executeQuery("Select * from reviews WHERE cinema_name = '" + cinemaName + "';");
		int reviewNumber = 1;
			while(resSet.next()) {
				System.out.println(reviewNumber);
				reviewNumber++;
				String review = resSet.getString("review");
				int rating = resSet.getInt("rating");
				System.out.println(review + "User's rating: " + rating);
			}
	}
	
	public static void AddFilm() throws SQLException {
		statmt = conn.createStatement();
		System.out.println("Add film's name");
		String cinemaName = sc.nextLine();
		statmt.execute("INSERT INTO 'films' (cinema_name) VALUES ('" + cinemaName + "');");
		System.out.println("Film added. Now users can write their own reviews.");
	}
	
}
