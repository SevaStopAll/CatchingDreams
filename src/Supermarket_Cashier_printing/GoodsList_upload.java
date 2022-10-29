package Supermarket_Cashier_printing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class GoodsList_upload {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	public static HashMap <String, Integer> goodsList = new HashMap<>();
	public static Stack<String> Bill1 = new Stack<>();
	public static Stack<Integer> BillPrice = new Stack<>();
	public static int totalSumm = 0;
		
	public static void uploadGoods() throws ClassNotFoundException, SQLException {
		Conn();
		CreateGoodsList();
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
		statmt.close();
		resSet.close();
		return goodsList;
	}
	
	public static void AddToReceipt() throws SQLException {
		Integer id = sc.nextInt();
		statmt = conn.createStatement();
		resSet = statmt.executeQuery("Select * from Goodlist WHERE SKU_id = " + id + ";");
		Bill1.add(resSet.getString("SKU_name"));
		BillPrice.add(resSet.getInt("price"));
		System.out.println("Position added. Positions in the receipt: " + Bill1.size());
		totalSumm += resSet.getInt("price");
		statmt.close();
		resSet.close();
	}
	
	public static void PrintReceipt() {
		int numOfGoods = 0;
		Date d = new Date();
		System.out.println(d);
		while(!BillPrice.isEmpty()) {
			System.out.print(Bill1.pop() + " " + BillPrice.pop() + " ₽");
			System.out.println();
			numOfGoods++;
		}
		System.out.println("Number of SKUs: " + numOfGoods);
		System.out.println("Total: " + totalSumm + " ₽");
	}
	
	public static void UpdateGoodsList() throws SQLException {
		statmt = conn.createStatement();
		String name = sc.nextLine();
		int price = sc.nextInt();
		statmt.execute("INSERT INTO 'Goodlist' (SKU_name, price) VALUES ('" + name + "', '" + price +"' );");
		System.out.println("New SKU was added.");
	}	
}
