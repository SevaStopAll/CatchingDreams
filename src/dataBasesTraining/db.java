package dataBasesTraining;
import java.sql.SQLException;
import java.util.Scanner;


public class db {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner (System.in);
		outer:
		while (true) {
			System.out.println("Here is the menu for DB management! Please choose option");
			System.out.println("1. Open DB or create new one. 2.Create new table if not exists. 3. Make an Insert query. 4. Show the data. 5. Close DB. 6. Close programm");
			int operation = sc.nextInt();
			switch (operation){
				case (1):
					conn.Conn();
					break;
				case (2):
					conn.CreateDB();
					break;
				case (3):
					conn.WriteDB();
					break;
				case (4):
					conn.ReadDB();
					break;
				case (5):
					conn.CloseDB();
					break;
				case (6): 
					sc.close();
					break outer;
					
			}
		}
		// conn.CreateDB();
		// conn.WriteDB();
		// conn.ReadDB();
		// conn.CloseDB();
	}
}
