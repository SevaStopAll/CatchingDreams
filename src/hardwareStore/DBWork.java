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
	

public static void Connect() throws ClassNotFoundException, SQLException {
	try {
	conn = null;
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:HardwareStoreDB.db");
}
finally {}
} 

public static void ShowMenu() throws SQLException {
	try {
	statmt = conn.createStatement();
	resSet = statmt.executeQuery("Select SKU_Category from SKUs;"); /// Here we have to print only CATEGORIES
	while(resSet.next()) {
		String category = resSet.getString("SKU_Category");
		System.out.println(category);
	}
	}
	finally {
		
	}
}

public static void ShowSKUs() throws SQLException {
	try {
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
	finally {}
}



public static void addToShopList() throws SQLException {
	try {
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
	} finally {}
	}


public static void addtoDB() throws SQLException {
	try {
		statmt = conn.createStatement();
		String Category = sc.nextLine();
		String SKU_producer = sc.nextLine();
		String SKU_Name = sc.nextLine();
		String SKU_Description = sc.nextLine();
		double SKU_Price = sc.nextDouble();
		int SKU_Storage = sc.nextInt();
		statmt.execute("INSERT INTO SKUs (SKU_Category, SKU_Producer, SKU_Name, SKU_Description, SKU_price, SKU_Storage) VALUES ('" + Category +
				"', '" + SKU_producer + "', '" + SKU_Name + "', '" + SKU_Description + "', '" + SKU_Price + "', '" + SKU_Storage + "');");
	} finally {} 
}

} //end of the Class

