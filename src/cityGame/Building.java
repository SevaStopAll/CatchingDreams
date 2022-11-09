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
	private int limit;
	private int currentNumb = 0;
	private int workers;
	private int food;
	
	// Every building is in City class. But building methods and parameters are here
	public Building(String name, int price, int buildTime, int addWood, int addGold, int addStone, int addIron, int addPopularity, int limit, int workers, int food) {
		this.name = name;
		this.price = price;
		this.buildTime = buildTime;
		this.addWood = addWood;
		this.addGold = addGold;
		this.addStone = addStone;
		this.addIron = addIron;
		this.limit = limit;
		this.workers = workers;
		this.food = food;
	}
	
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	// Building time is not realised yet
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
	
	public int getAddFood() {
		return food;
	}
	
	// These three methods are about building limits in your city. 
	public void plusNumb() {
		currentNumb++;
	}
	
	public int getCurrentNumb() {
		return currentNumb;
	}
	
	public int getLimit() {
		return limit;
	}

	public int getWorkers() {
		return workers;
	}
	

}




