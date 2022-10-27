package catchingDreams;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class ToDoList_txtFile {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> listToDo = new HashMap<Integer, String>();
		int count = 1;
		String toDo = "";
		outer: while (true) {
			System.out.println("Hello! Bienvenue in my ToDoList project.");
			System.out.println("Choose an option");
			System.out.println("1: Write a thing to do");
			System.out.println("2: Delete a thing");
			System.out.println("3: Watch the list");
			System.out.println("4: Watch the readme");
			System.out.println("5: Exit the programm");
			System.out.println("NB: Work in progress! 6: Read you last list from file");
			int command = sc.nextInt();

			switch (command) {
			case (1):
				System.out.println("Write what do you want to add.");
				toDo = sc.next();
				listToDo.put(count, toDo);
				FileWriter wr = new FileWriter("MyToDoList.txt", true);
				wr.write(toDo + '\n');
				wr.close();
				count++;
				System.out.println("Press 'F' and Enter to quit to menu");
				sc.next();
				break;

			case (2):
				System.out.println("Enter the number of thing you want to delete.");
				int toDelete = sc.nextInt();
				listToDo.remove(toDelete);
				System.out.println("Press 'F' and Enter to quit to menu");
				sc.next();
				break;
			case (3):
				for (HashMap.Entry<Integer, String> item : listToDo.entrySet()) {

					System.out.printf("Priority: %d  To Do: %s \n", item.getKey(), item.getValue());
				}
			System.out.println("Press 'F' and Enter to quit to menu");
			sc.next();
				break;
			case (5):
				sc.close();
				break outer;
			case (6):
				FileReader fr = new FileReader("MyToDoList.txt");
				Scanner scan = new Scanner(fr);
				while (scan.hasNext()) {
					String a = scan.next();
					listToDo.put(count, a);
					count++;
				}
				scan.close();
				fr.close();
				break;
			default:
				System.out.println("Enter correct number");
			}
		}
	}
}