package hardwareStore;

import java.util.ArrayList;
import java.util.List;

public class SKU {
	private String name;
	private double price;
	public static List <SKU> goodsList = new ArrayList<>();
	private String description;
	private int counter;
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private int SKU_ID;
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSKU_ID() {
		return SKU_ID;
	}

	public String getName() {
		return name;
	}

	public SKU(String name, double price, int number) {
		this.name = name;
		this.price = price;
		counter++;
		SKU_ID = counter;
		this.number = number;
	}
	
	public static void watchSKUs() {
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i).getSKU_ID());
			System.out.println(goodsList.get(i).getName());
			System.out.println(goodsList.get(i).getPrice());
			System.out.println(goodsList.get(i).getNumber());
		}
	}
	
}
