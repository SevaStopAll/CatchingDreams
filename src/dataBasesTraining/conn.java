package dataBasesTraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class conn {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	
	// --------Connection to the base--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   System.out.println("Please, enter the name of new or existing DB!");
		   String baseName = sc.nextLine();
		   conn = DriverManager.getConnection("jdbc:sqlite:" + baseName);
		   
		   System.out.println("The base was connected or created!");
	   }
	// --------Creating table--------  (Try to loop it)
	public static void CreateDB() throws ClassNotFoundException, SQLException {
		statmt = conn.createStatement();
		System.out.println("Please enter the table name");
		String tableName = sc.nextLine();
		System.out.println("Please enter how many columns do you want to add in your table (1 to 5)");
		int columnsNum = sc.nextInt();
		System.out.println("Set the columns' names");
		if (columnsNum == 1) {
			String column1 = sc.next();   
			sc.nextLine();														
			System.out.println("Set the columns' types");
			String column1Type = sc.nextLine();
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ");");
			System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 2) {
			String column1 = sc.next();
			sc.nextLine();
			String column2 = sc.next();
			sc.nextLine();
			System.out.println("Set the columns' types");
			String column1Type = sc.nextLine();
			String column2Type = sc.nextLine();
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ");");
			System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 3) {
			String column1 = sc.next();
			sc.nextLine();
			String column2 = sc.next();
			sc.nextLine();
			String column3 = sc.next();
			sc.nextLine();
			System.out.println("Set the columns' types");
			String column1Type = sc.nextLine();
			String column2Type = sc.nextLine();
			String column3Type = sc.nextLine();
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ", '" + column3 + "'" + column3Type + ");");
				
			System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 4) {
			String column1 = sc.next();
			sc.nextLine();
			String column2 = sc.next();
			sc.nextLine();
			String column3 = sc.next();
			sc.nextLine();
			String column4 = sc.next();
			sc.nextLine();
			System.out.println("Set the columns' types");
			String column1Type = sc.nextLine();
			String column2Type = sc.nextLine();
			String column3Type = sc.nextLine();
			String column4Type = sc.nextLine();
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ", '" + column3 + "'" + column3Type + ", '" + column4 + "'" + column4Type + ");");
				
			System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 5) {
			String column1 = sc.next();
			sc.nextLine();
			String column2 = sc.next();
			sc.nextLine();
			String column3 = sc.next();
			sc.nextLine();
			String column4 = sc.next();
			sc.nextLine();
			String column5 = sc.next();
			sc.nextLine();
			System.out.println("Set the columns' types");
			String column1Type = sc.nextLine();
			String column2Type = sc.nextLine();
			String column3Type = sc.nextLine();
			String column4Type = sc.nextLine();
			String column5Type = sc.nextLine();
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ", '" + column3 + "'" + column3Type + ", '" 
			+ column4 + "'" + column4Type + ", '" + column5 + "'" + column5Type +");");
				
			System.out.println("The table was created or already exists.");
		}
	   }
		
	// --------Making a query--------
	public static void WriteDB() throws SQLException
	{
		statmt = conn.createStatement();
		String query = sc.nextLine();
		statmt.execute(query);
		System.out.println("Done");
	}
	
	// -------- Printing data--------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		System.out.println("What would you like to see?");
		String query = sc.nextLine();
		// Here we have to choose the name of columns and its types for do not write it manually. 
		resSet = statmt.executeQuery(query);
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("name");
	        System.out.println( "ID = " + id );
	        System.out.println( "name = " + name );
	        System.out.println();
		}	
		
		System.out.println("Table is displayed");
	    }
	

		// --------Closing--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("Connections closed");
		   }

}