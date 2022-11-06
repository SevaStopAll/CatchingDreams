package cityGame;


public class Building {
	private final String name; 
	private int price; 
	private int buildTime;
	private int addWood;
	private int addGold;
	private int addStone;
	private int addIron;
	private int addPopularity;


	
	
	public Building(String name, int price, int buildTime, int addWood, int addGold, int addStone, int addIron, int addPopularity) {
		this.name = name;
		this.price = price;
		this.buildTime = buildTime;
		this.addWood = addWood;
		this.addGold = addGold;
		this.addStone = addStone;
		this.addIron = addIron;
	}
	
	public void getInfo() {
		
	}
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getBuildTime() {
		return buildTime;
	}


	public int getAddWood() {
		return addWood;
	}

	public int getAddGold() {
		return addGold;
	}


	public int getAddStone() {
		return addStone;
	}

	public int getAddIron() {
		return addIron;
	}
	
	public int getAddPopularity() {
		return addPopularity;
	}
}




