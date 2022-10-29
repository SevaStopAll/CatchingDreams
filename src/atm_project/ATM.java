package atm_project;


//
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ATM {
	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		Scanner sc = new Scanner(System.in);
		Terminal.Conn();
		Terminal.CreateUserList();
		System.out.println("Welcome to ATM. Please select option.");
		System.out.println("1.Log in. 2. Register new member (only for employers). 3.Watch users list (only for employers). 4. Exit.");
		int operationNumber = sc.nextInt();
		String managerPassword = "Qwerty";
		switch(operationNumber) {
		
		case(1):
			System.out.println("Please add your name and password!");
			String login = sc.next();
			String password = sc.next();
			if (password.equals(Terminal.CreateUserList().get(login))) {
				Client c1 = new Client(login);
				Account a1 = new Account(c1); // Add money on account
				System.out.println("Hello, " + login);
				System.out.println("What are you going to do?");
				System.out.println("1. Get money. 2. Add money. 3.Watch my balance.");
				int operation = sc.nextInt();
				switch (operation) {
				case(1):
					Terminal.GetMoney(login);
					break;
				case(2):
					
				case(3):
					System.out.println(Terminal.ShowMyBalance(login));
					break;
				}
			}
			else {
			System.out.println("Not correct");
			}
			
		case(2):
			int counterPassword = 0;
			while (counterPassword <= 2) {
			System.out.println("Please enter your manager's password");
			String enterManagerPass = sc.next();
			if (enterManagerPass.equals(managerPassword)) {
				counterPassword = 0;
				Terminal.Conn();
				Terminal.AddUser();
				break;
			}
			counterPassword++;	
			}
		
		case(3):
			int counterPassword1 = 0;
			while (counterPassword1 <= 2) {
				System.out.println("Please enter your manager's password");
				String enterManagerPass = sc.next();
				if (enterManagerPass.equals(managerPassword)) {
					counterPassword1 = 0;
					Terminal.Conn();
					Terminal.WatchUserList();
					break;
				}
				counterPassword1++;	
				}
		
		case(4):
			sc.close();
			System.exit(0);
		}
	}
}

