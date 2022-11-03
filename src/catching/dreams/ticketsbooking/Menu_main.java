package catching.dreams.ticketsbooking;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu_main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		processes.Conn();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to CathingDreams Airlines. Soon here will be our service to book your airticket. \nWhat do we want to realise \n1.Flights list with destination and time. 2. You can registrate youself and buy a ticket. \n3. Our employers will be able to watch passangers list for security reasons.");
		int operation = sc.nextInt();
		if (operation == 1) {
			processes.WatchFlightTable();
		} 
		else if (operation == 2) {
			processes.BuyTicket();
		}
		else if (operation == 3) {
			processes.WatchPassangers();
		}
	}
}
