package atm_project;

import java.util.Scanner;

public class ManagerTerminal {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the manager terminal. What do we have to do?");
		System.out.println("1.Add a new user. 2.Delete user. 3. Watch users list.");
		int operation = sc.nextInt();
		switch (operation) {
		case (1):
			Client a1 = new Client(sc.nextLine()); 
		case (2):
			
		case (3):
			
		}
	}
}
