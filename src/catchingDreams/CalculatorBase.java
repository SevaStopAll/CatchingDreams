package catchingDreams;

import java.io.*;
import java.util.Scanner;

public class CalculatorBase {
	public static void main(String [] args) throws Exception {
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
	
	public class Counter {
		  static int operationNumber = 0;

		  public static void invokeCounter() {
			  operationNumber++;
		     System.out.println("Operation №" + operationNumber + '\n');
		  }
		}
	
	public static void calc(double num1, double num2) throws Exception {
		int operationNumber = 0;
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
			FileWriter wr = new FileWriter("MyFile.txt", true);
			
			switch (operation) {
				case (0):
					System.out.println("This is a pre-pre-pet project, so you can enter 2 numbers by two enters. Hope I can improve it. Thank you");
				case (1):
					System.out.println(num1 + num2);
					operationNumber++;
					System.out.println(operationNumber);
					wr.write("Operation №" + operationNumber + '\n');
					wr.write(((double) num1 + " + " + (double) num2 + " = " + (double)(num1 + num2) + '\n'));
					wr.close();
					break;
				case (2):
					System.out.println(num1 - num2);
					operationNumber++;
					System.out.println(operationNumber);
					wr.write("Operation №" + operationNumber + '\n');
					wr.write(((double) num1 + " - " + (double) num2 + " = " + (double)(num1 - num2) + '\n'));
					wr.close();
					break;
				case (3):
					System.out.println(num1 * num2);
					operationNumber++;
					System.out.println(operationNumber);
					wr.write("Operation №" + operationNumber + '\n');
					wr.write(((double) num1 + " * " + (double) num2 + " = " + (double)(num1 * num2) + '\n'));
					wr.close();
					break;
				case (4): 	
					try {
						if(num2 == 0) throw new ArithmeticException();
					System.out.println(num1 / num2);
					operationNumber++;
					System.out.println(operationNumber);
					wr.write("Operation №" + operationNumber + '\n');
					wr.write(((double) num1 + " / " + (double) num2 + " = " + (double)(num1 / num2) + '\n'));
					wr.close();
					break; 
					} catch (ArithmeticException ex){
						System.out.println("Don't divide by zero.");
						wr.close();
					}		
				case (5): {
					System.out.println(num1 % num2);
					operationNumber++;
					System.out.println(operationNumber);
					wr.write("Operation №" + operationNumber + '\n');
					wr.write(((double) num1 + " % " + (double) num2 + " = " + (double)(num1 % num2) + '\n'));
					wr.close();
					break;
				}	
				case (6):
					System.out.println(Math.pow(num1, num2));
					operationNumber++;
					System.out.println(operationNumber);
					wr.write("Operation №" + operationNumber + '\n');
					wr.write(((double) num1 + " ^ " + (double) num2 + " = " + + (double)(Math.pow(num1, num2)) + '\n'));
					wr.close();
					break;
				case (7):
					System.out.println("Total operations number " + operationNumber);
					wr.write("You did " + operationNumber + "operations this cycle.");
					System.out.println("We are closing this app... Bye!");
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
