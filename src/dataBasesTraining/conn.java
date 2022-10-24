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
	public static String column1;
	public static String column2;
	public static String column3;
	public static String column4;
	public static String column5;
	public static String column1Type;
	public static String column2Type;
	public static String column3Type;
	public static String column4Type;
	public static String column5Type;
	
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:humans.db");
		   
		   System.out.println("База Подключена!");
	   }
	// --------Создание таблицы--------
	public static void CreateDB() throws ClassNotFoundException, SQLException {
		statmt = conn.createStatement();
		System.out.println("Please enter the table name");
		String tableName = sc.nextLine();
		System.out.println("Please enter how many columns do you want to add in your table (1 to 5)");
		int columnsNum = sc.nextInt();
		System.out.println("Set the columns' names");
		if (columnsNum == 1) {
			column1 = sc.next();   
			sc.nextLine();														// Сделай в цикле!
			System.out.println("Set the columns' types");
			column1Type = sc.nextLine();
			System.out.println(column1Type);
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ");");
			System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 2) {
			 column1 = sc.next();
			 sc.nextLine();
			 column2 = sc.next();
			 sc.nextLine();
			 System.out.println("Set the columns' types");
			 column1Type = sc.nextLine();
			 column2Type = sc.nextLine();
			 statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ");");
				System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 3) {
			column1 = sc.next();
			 sc.nextLine();
			 column2 = sc.next();
			 sc.nextLine();
			 column3 = sc.next();
			 sc.nextLine();
			 System.out.println("Set the columns' types");
			 column1Type = sc.nextLine();
			 column2Type = sc.nextLine();
			 column3Type = sc.nextLine();
			 statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ", '" + column3 + "'" + column3Type + ");");
				
				System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 4) {
			column1 = sc.next();
			sc.nextLine();
			column2 = sc.next();
			sc.nextLine();
			column3 = sc.next();
			sc.nextLine();
			column4 = sc.next();
			sc.nextLine();
			System.out.println("Set the columns' types");
			column1Type = sc.nextLine();
			column2Type = sc.nextLine();
			column3Type = sc.nextLine();
			column4Type = sc.nextLine();
			statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ", '" + column3 + "'" + column3Type + ", '" + column4 + "'" + column4Type + ");");
				
			System.out.println("The table was created or already exists.");
		}
		else if (columnsNum == 5) {
			column1 = sc.next();
			sc.nextLine();
			column2 = sc.next();
			sc.nextLine();
			column3 = sc.next();
			sc.nextLine();
			column4 = sc.next();
			sc.nextLine();
			column5 = sc.next();
			sc.nextLine();
			 System.out.println("Set the columns' types");
			 column1Type = sc.nextLine();
			 column2Type = sc.nextLine();
			 column3Type = sc.nextLine();
			 column4Type = sc.nextLine();
			 column5Type = sc.nextLine();
			 statmt.execute("CREATE TABLE if not exists " + tableName + "('" + column1 + "'" + column1Type + ", '" + column2 + "'" + column2Type + ", '" + column3 + "'" + column3Type + ", '" 
			 + column4 + "'" + column4Type + ", '" + column5 + "'" + column5Type +");");
				
				System.out.println("The table was created or already exists.");
		}
	   }
		
		
		
	// --------Заполнение таблицы--------
	public static void WriteDB() throws SQLException
	{
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
		   				  
		   System.out.println("Таблица заполнена");
	}
	
	// -------- Вывод таблицы--------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM users");
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("name");
			String  phone = resSet.getString("phone");
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + name );
	         System.out.println( "phone = " + phone );
	         System.out.println();
		}	
		
		System.out.println("Таблица выведена");
	    }
	
	// ------------ 5 пункт Прямой запрос в БД -----------
		public static void WriteDBDirect () throws SQLException {
			statmt = conn.createStatement();
			String query = sc.nextLine();
			statmt.execute(query);
			System.out.println("OK");
		}

		// --------Закрытие--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("Соединения закрыты");
		   }

}