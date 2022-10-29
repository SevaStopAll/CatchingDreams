package Supermarket_Cashier_printing;

import java.sql.SQLException;
import java.util.Scanner;

public class Printing {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GoodsList_upload.uploadGoods();
		MachineMenu();		
	}
	
	public static void MachineMenu() throws SQLException {
		System.out.println("Operations: 1.AddToReceipt 2.PrintReceipt 3.Turn off");
		Scanner sc = new Scanner(System.in);
		int operation = sc.nextInt();
		switch(operation) {
		case(1):
			GoodsList_upload.AddToReceipt();
			MachineMenu();
		case(2):
			GoodsList_upload.PrintReceipt();
			sc.close();
			System.exit(0);
		case(3):
			GoodsList_upload.UpdateGoodsList();
		case(4):
			sc.close();
			System.exit(0);
		}
	}
}
