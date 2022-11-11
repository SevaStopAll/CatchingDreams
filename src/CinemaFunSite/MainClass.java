package CinemaFunSite;

import java.sql.SQLException;


public class MainClass {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		DB_Connection.Conn();
		DB_AddFilm.AddFilm();
		
	}
}
