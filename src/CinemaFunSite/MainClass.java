package CinemaFunSite;

import java.sql.SQLException;


public class MainClass {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		DB_work.Conn();
		DB_work.WriteReview();
	}
}
