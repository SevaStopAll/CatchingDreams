package Supermarket_Cashier_printing;

import java.sql.SQLException;

public class Printing {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GoodsList_upload.uploadGoods();
		GoodsList_upload.AddToReceipt();
		GoodsList_upload.PrintReceipt();
	}
}
