package catchingDreams;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTraining {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		try {
		double goal = sc.nextDouble();
		}	
		catch (InputMismatchException ex) {
			System.out.println("Ошибка ввода");
		}
		finally {
			
		}
		}
	}

