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
		calc(num1, num2);
		sc.close();
	}
	
	public static void calc(double num1, double num2) {
	outer :
			while (true) {
			System.out.println("0 - Watch the readme");	
			System.out.println("1 - Addition");
			System.out.println("2 - Substraction");
			System.out.println("3 - Multiplication");
			System.out.println("4 - Division");
			System.out.println("5 - Remainder of dividing");
			System.out.println("6 - Exponentiation");
			System.out.println("7 - Quit the program");
			System.out.println("9 - Choose another numbers");
			Scanner sc = new Scanner(System.in);
			int operation = sc.nextInt();
			switch (operation) {
				case (0):
					System.out.println("This is a pet project, so you can enter 2 numbers by two enters. Hope I can improve it. Thank you");
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
					try {
						if(num2 == 0) throw new ArithmeticException();
					System.out.println(num1 / num2);	
					break; 
					} catch (ArithmeticException ex){
						System.out.println("Don't divide by zero.");
					}		
				case (5): {
					System.out.println(num1 % num2);
					break;
				}	
				case (6):
					System.out.println(Math.pow(num1, num2));
					break;
				case (7):
					System.out.println("We are closing this app... Bye!");
					sc.close();
					break outer;
				case (9):
					System.out.println("Please, enter number №1");
					num1 = sc.nextDouble();
					System.out.println("Please, enter number №2");
					num2 = sc.nextDouble();
					calc(num1, num2);
				default: 
					System.out.println("Enter correct number!");
					
			}
		}
}
	
}
