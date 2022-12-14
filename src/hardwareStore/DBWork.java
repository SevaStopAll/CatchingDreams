package hardwareStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBWork {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	static List<String> shopList = new ArrayList<>();
	static int TotalPrice = 0;
	static int orderNumber = 1;
	

public static void Connect() throws ClassNotFoundException, SQLException {

	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:HardwareStoreDB.db");
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select ORDER_NUMBER from ORDERS;");
	while (resSet.next()) {
		orderNumber = resSet.getInt("ORDER_NUMBER") + 1;
	}
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
	String Category = sc.next();
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



public static void addToShopList() throws SQLException {
	statmt = conn.createStatement();
	String Category = sc.nextLine();
	String SKU_Name = sc.nextLine();
	shopList.add(SKU_Name);
	resSet = statmt.executeQuery("Select * from SKUs WHERE SKU_Category = '" + Category + "' AND SKU_Name = '" + SKU_Name + "';");	
	while(resSet.next()) {
		double price = resSet.getDouble("SKU_price");
		TotalPrice += price;
		System.out.println(TotalPrice);
	}
	}

public static void createOrder() throws SQLException {
	for (String shop: shopList) {

			statmt = conn.createStatement();
			resSet = statmt.executeQuery("Select * from SKUs WHERE SKU_Name = '" + shop + "';");	
			while(resSet.next()) {
				int SKU_id = resSet.getInt("SKU_ID");
				statmt.execute("INSERT INTO ORDERS (ORDER_NUMBER, SKU_ID) VALUES ('" + orderNumber +"', '" + SKU_id + "');");
			} 
			orderNumber++;
	}
}


public static void addtoDB() throws SQLException {
		statmt = conn.createStatement();
		String Category = sc.nextLine();
		String SKU_producer = sc.nextLine();
		String SKU_Name = sc.nextLine();
		String SKU_Description = sc.nextLine();
		double SKU_Price = sc.nextDouble();
		int SKU_Storage = sc.nextInt();
		statmt.execute("INSERT INTO SKUs (SKU_Category, SKU_Producer, SKU_Name, SKU_Description, SKU_price, SKU_Storage) VALUES ('" + Category +
				"', '" + SKU_producer + "', '" + SKU_Name + "', '" + SKU_Description + "', '" + SKU_Price + "', '" + SKU_Storage + "');");
}

} //end of the Class

