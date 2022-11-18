package hardwareStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBWork {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	

public static void Connect() throws ClassNotFoundException, SQLException {
	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:HardwareStoreDB.db");
}

public static void ShowMenu() throws SQLException {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select SKU_Category from SKUs;"); /// Here we have to print only CATEGORIES
	while(resSet.next()) {
		String category = resSet.getString("SKU_Category");
		System.out.println(category);
	}
}

public static void ShowSKUs() throws SQLException {
	statmt = conn.createStatement();
	String Category = "GPU";
	resSet = statmt.executeQuery("Select * from SKUs WHERE SKU_Category = '" + Category + "';"); /// Here we have to print SKU from a CATEGORY
	while(resSet.next()) {
		String SKU = resSet.getString("SKU_Name");
		double price = resSet.getDouble("SKU_price");
		int storage = resSet.getInt(7);
		System.out.println(SKU);
		System.out.println(price);
		System.out.println(storage);
	}
}

}


// end of the Class