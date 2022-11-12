package CinemaFunSite;

import java.sql.SQLException;
import java.util.Scanner;


public class MainClass {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		DB_work.Conn();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our CinemaReview fun site.");
		System.out.println("1. Add film  2. Write review  3.Watch reviews");
		int operation = sc.nextInt();
		switch (operation) {
			case(1):
				DB_work.AddFilm();
			case(2):
				DB_work.WriteReview();
			case(3):
				DB_work.WatchReview();
		}
	}
}
