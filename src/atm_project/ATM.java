package atm_project;


//
import java.util.Scanner;
import java.sql.SQLException;


public class ATM {
	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		menu();
	}

	
	public static void menu() throws ClassNotFoundException, SQLException{
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
				UserMenu(login);
			}
			else {
			System.out.println("Not correct");
			}
			UserMenu(login);
			
		case(2):
			int counterPassword = 0;
			while (counterPassword <= 2) {
			System.out.println("Please enter your manager's password");
			String enterManagerPass = sc.next();
			if (enterManagerPass.equals(managerPassword)) {
				counterPassword = 0;
				System.out.println("Manager, you can add new User. Please add its logIn and password");
				Terminal.Conn();
				Terminal.AddUser();
				break;
			}
			counterPassword++;	
			}
			menu();
		
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
			menu();
			
		case(4):
			sc.close();
			System.exit(0);
		}
	}

	
	public static void UserMenu(String login) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello, " + login);
		System.out.println("What are you going to do?");
		System.out.println("1. Get money. 2. Add money. 3.Send money. 4.Watch my balance. 5.Log off. ");
		int operation = sc.nextInt();
		switch (operation) {
		case(1):
			Terminal.GetMoney(login);
			break;
		case(2):
			Terminal.AddMoney(login);
			break;
		case(3):
			Terminal.SendMoney(login);
			break;
		case(4):
			System.out.println(Terminal.ShowMyBalance(login));
			break;
		case(5):
			menu();
		}
	}
}


