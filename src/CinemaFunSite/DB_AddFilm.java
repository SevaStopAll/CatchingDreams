package CinemaFunSite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB_AddFilm {
	public static Connection conn;
	public static Statement statmt;
	public static Scanner sc = new Scanner(System.in);
	
	public static void AddFilm() throws SQLException, ClassNotFoundException {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:cinema.db");
		   System.out.println("The base was connected or created!");
		   
		statmt = conn.createStatement();
		System.out.println("Add film's name");
		String cinemaName = sc.nextLine();
		statmt.execute("INSERT INTO 'films' (cinema_name) VALUES ('" + cinemaName + "');");
		System.out.println("Film added. Now users can write their own reviews.");
	}
}
