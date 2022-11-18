package hardwareStore;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private int ID;
	private String name; 
	private int counter = 0;
	private List<SKU> bucket;
	
	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}
	
	public Client(String name) {
		this.name = name;
		counter++;
		ID = counter;
		List<SKU> bucket = new ArrayList<>();
	}
	
	public void choose(SKU sku) {
		bucket.add(sku);
	}
	
	
}
