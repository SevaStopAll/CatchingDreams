package catching.dreams.ticketsbooking;

import java.sql.*;
import java.util.Scanner;


public class processes {
	public static Connection conn; 
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);

public static void Conn() throws ClassNotFoundException, SQLException {
	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:Booking.db");
}

}