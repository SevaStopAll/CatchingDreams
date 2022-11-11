package CinemaFunSite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB_WatchReview {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in); 
	
	public static void WatchReview() throws SQLException, ClassNotFoundException {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:cinema.db");
		   System.out.println("The base was connected or created!");
		   
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

}
