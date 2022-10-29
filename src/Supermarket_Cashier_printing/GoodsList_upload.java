package Supermarket_Cashier_printing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class GoodsList_upload {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	public static HashMap <String, Integer> goodsList = new HashMap<>();
	public static Stack <String> Bill1 = new Stack<>();
	public static Stack<Integer> BillPrice = new Stack<>();
	public int finPrice = 0;
	
	
	public static void uploadGoods() throws ClassNotFoundException, SQLException {
		Conn();
		CreateGoodsList();
		// Here we have to realise a menu. 
	}
	
	public static void Conn() throws ClassNotFoundException, SQLException {
		conn = null;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:GoodsList.db");
	}
	
	public static HashMap<String, Integer> CreateGoodsList() throws ClassNotFoundException, SQLException {
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("Select * from Goodlist");
		while (resSet.next()) {
			String SKU = resSet.getString("SKU_name");
			int price = resSet.getInt("price");
			goodsList.put(SKU, price);
		}
		return goodsList;
	}
	
	public static void AddToReceipt() throws SQLException {
		Integer id = sc.nextInt();
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("Select * from Goodlist WHERE SKU_id = " + id + ";");
		Bill1.add(resSet.getString("SKU_name"));
		BillPrice.add(resSet.getInt("price"));
	}
	
	public static void PrintReceipt() {
		for (int i = 0; i < BillPrice.size(); i++) {
			System.out.print(Bill1.pop() + " " + BillPrice.pop() + "Руб.");
			System.out.println();
		}
	}
	
}
