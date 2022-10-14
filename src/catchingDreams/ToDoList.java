package catchingDreams;

import java.util.HashMap;
import java.util.Scanner;

public class ToDoList {
	public static void main(String [] args) {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, String> listToDo = new HashMap <Integer, String>();
	int count = 1;
	outer:
	 while (true) {
		System.out.println("Hello! Bienvenue in my ToDoList project.");
		System.out.println("Choose an option");
		System.out.println("1: Write a thing to do");
		System.out.println("2: Delete a thing");
		System.out.println("3: Watch the list");
		System.out.println("4: Watch the readme");
		System.out.println("5: Exit the programm");
		int command = sc.nextInt();
		
		switch (command) {
		case (1): 
			System.out.println("Write what do you want to add.");
			String toDo = sc.next();
			listToDo.put(count, toDo);
			count++;
			break;
			
		case (2):
			System.out.println("Enter the number of thing you want to delete.");
			int toDelete = sc.nextInt();
			listToDo.remove(toDelete);
		case (3):
			for(HashMap.Entry<Integer, String> item : listToDo.entrySet()){
		         
		           System.out.printf("Priority: %d  To Do: %s \n", item.getKey(), item.getValue());
		       }
			break;
		case(5): 
			sc.close();
			break outer;
		default: 
			System.out.println("Enter correct number");
		}
	}
}
}
