package hardwareStore;

import java.sql.SQLException;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBWork.Connect();
		System.out.println("Welcome to our store. Here are categories of goods");
		DBWork.addToShopList();
		DBWork.createOrder();
	}

}
