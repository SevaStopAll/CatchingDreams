package toDoList;

import java.util.Scanner;

public class ToDoList {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Conn_tDL.Conn(); 
		outer: while (true) {
			System.out.println("Hello! Bienvenue in my ToDoList project.");
			System.out.println("Choose an option");
			System.out.println("1: Write a thing to do");
			System.out.println("2: Delete a thing");
			System.out.println("3: Watch the list");
			System.out.println("4: Watch the readme");
			System.out.println("5: Exit the programm");
			System.out.println("6: Clean the table");
			int command = sc.nextInt();

			switch (command) {
			case (1):
				System.out.println("Write what do you want to add.");
				Conn_tDL.WriteDB();
				System.out.println("Press 'F' and Enter to quit to menu");
				sc.next();
				break;
			case (2):
				System.out.println("Enter the number of thing you want to make done.");
				Conn_tDL.MakeItDone();
				System.out.println("Press 'F' and Enter to quit to menu");
				sc.next();
				break;
			case (3):
				Conn_tDL.ReadDB();
				System.out.println("Press 'F' and Enter to quit to menu");
				sc.next();
				break;
			case (5):
				sc.close();
				break outer;
			case (6):
				Conn_tDL.Drop();
				System.out.println("Press 'F' and Enter to quit to menu");
				sc.next();
				break;
			default:
				System.out.println("Enter correct number");
			}
		}
	}
}
