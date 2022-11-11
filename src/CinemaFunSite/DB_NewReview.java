package CinemaFunSite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB_NewReview {
	public static Connection conn;
	public static Statement statmt;
	public static Scanner sc = new Scanner(System.in);
	
	public static void WriteReview() throws SQLException, ClassNotFoundException {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:cinema.db");
		   System.out.println("The base was connected or created!");
		   
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
}
