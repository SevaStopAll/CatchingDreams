package SchoolDairy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;

public class SchoolDairy {
	String [] [] schedule = new String [5][8];
	Map <Integer, String> dairy = new HashMap<>();
	String student;
	
	public SchoolDairy() {
		createSchedule();
		try {
			Scanner sc = new Scanner(System.in);
		student = sc.nextLine();
		}
		finally {}
	};
	
	public void createSchedule() {
		for (int i = 0; i < schedule.length; i++) {
			for (int j = 0; j < schedule[i].length; j++) {
				try {
					Scanner sc = new Scanner(System.in);
					schedule[i][j] = sc.nextLine();
				}
				finally {
					System.out.println("Done");
				}
			}
		}
	}
	
	public void createHomework() {
		try {
			Scanner sc = new Scanner(System.in);
			int dayLesson = sc.nextInt();
			sc.nextLine();
			String homework = sc.nextLine(); 
			dairy.put(dayLesson, homework);
		} finally {}
	}
	
	




} // class end



