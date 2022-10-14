package catchingDreams;

import java.util.HashMap;
import java.util.Scanner;

public class ExceptionTraining {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> listToDo = new HashMap <Integer, String>();
		int count = 1;
		String toDo = sc.nextLine();
		listToDo.put(count, toDo);
		count++;
}
}
