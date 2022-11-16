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

public static void WatchFlightTable() throws SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from Flights");
		while(resSet.next()) {
			int flNumber = resSet.getInt("flight_number");
			String destination = resSet.getString("flight_destination");
			int freeSeats = resSet.getInt("free_seats");
			// Add date 
			System.out.printf("Number %-5s" + " | " + "Destination: %-20s" + " | " + "Free Seats: %-3d\n" , flNumber, destination, freeSeats );
		}	
		conn.close();
		statmt.close();
		resSet.close();
		sc.close();
}

public static void BuyTicket() throws SQLException {
	statmt = conn.createStatement();
	System.out.println("Please choose the flight!");
	int flight = sc.nextInt();
	sc.nextLine();
	System.out.println("Please enter your name and surname");
	String nameSurname = sc.nextLine();
	System.out.println("Do you have a baggage?");
	boolean baggage = sc.nextBoolean();				
	statmt.execute("INSERT INTO 'Flight_passangers' (Flight, Name_Surname, Baggage) VALUES (" + flight + ", '" + nameSurname+ "' , '"+ baggage + "');");
	resSet = statmt.executeQuery("Select free_seats from 'Flights' WHERE flight_number = '" + flight + "'");
	int seatsBefore = resSet.getInt("free_seats");
	int seatsAfter = seatsBefore - 1;
	statmt.executeUpdate("UPDATE Flights SET free_seats = " + seatsAfter + " WHERE flight_number = '" + flight + "';");	
	conn.close();
	statmt.close();
	resSet.close();
	sc.close();
}

public static void WatchPassangers() throws SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select * from Flight_passangers ORDER BY Flight, Name_Surname");
	while(resSet.next()) {
		int flNumber = resSet.getInt("Flight");
		String nameSurname = resSet.getString("Name_Surname");
		boolean baggage = resSet.getBoolean("baggage");
		if (baggage == true) {
			System.out.printf("Flight  %-5s | Name  %-20s | Baggage YES\n", flNumber, nameSurname);
		} else {
			System.out.printf("Flight  %-5s | Name  %-20s | Baggage NO\n", flNumber, nameSurname);
		}
	
	}
	conn.close();
	statmt.close();
	resSet.close();
	sc.close();
}
}