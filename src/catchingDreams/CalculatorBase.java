package catchingDreams;

import java.util.Scanner;

public class CalculatorBase {
	public static void main(String [] args) {
		System.out.println("Hello there!");
		System.out.println("It is a simple calcutalor made just for testing some capacities");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter number №1");
		double num1 = sc.nextDouble();
		System.out.println("Please, enter number №2");
		double num2 = sc.nextDouble();
		System.out.println("Thank you! Now let's choose the operation!");
		
		outer :
			while (true) {
			System.out.println("1 - Addition");
			System.out.println("2 - Substraction");
			System.out.println("3 - Multiplication");
			System.out.println("4 - Division");
			System.out.println("5- Quit the program");
		
			int operation = sc.nextInt();
			switch (operation) {
				case (1):
					System.out.println(num1 + num2);
					break;
				case (2):
					System.out.println(num1 - num2);
					break;
				case (3):
					System.out.println(num1 * num2);
					break;
				case (4): 
					System.out.println(num1 / num2);
					break;
				case (5):
					System.out.println("We are closing this app... Bye!");
					sc.close();
					break outer;
				default: 
					System.out.println("Enter correct number!");
			}
		}
	}
}
