package atm_project;

import java.util.Scanner;


public class ATM {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to ATM. Please select option.");
		System.out.println("1.Log in. 2. Register new member (only for employers). 3. Exit.");
		int operationNumber = sc.nextInt();
		String managerPassword = "Qwerty";
		switch(operationNumber) {
		
		case(1):
			System.out.println("Please add your name and password!");
			
		case(2):
			int counterPassword = 0;
			while (counterPassword <= 2) {
			System.out.println("Please enter your manager's password");
			String enterManagerPass = sc.next();
			if (enterManagerPass.equals(managerPassword)) {
				counterPassword = 0;
				System.out.println("Ok. There will be manager's terminal");
			}
			counterPassword++;	
			}
			
		case(3):
			sc.close();
			System.exit(0);
		}
	}
}
