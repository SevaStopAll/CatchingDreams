package cityGame;

import java.util.ArrayList;

public class City {
	// Base parameters: 
	private String name;
	private int population = (int)(1 + Math.random() * 100); 
	private int freePopulation = population;
	private int popularity = 50; 
	private ArrayList <Building> yourBuildings = new ArrayList<>();
	private int populationPerTurn = (int) (population * 0.05);
	private ArrayList <Warrior> guard = new ArrayList<>();
	private int age = 1;
	// Resources 
	private int gold = (int)(1 + Math.random() * 100);
	private int goldPerTurn = population; // Tax here
	private int wood = 10;
	private int stone = 10;
	private int iron = 5;
	
	
	public String getName() {
		return name;
	}
	public int getPopulationPerTurn() {
		return populationPerTurn;
	}
	public void setPopulationPerTurn(int populationPerTurn) {
		this.populationPerTurn = populationPerTurn;
	}
	public ArrayList<Warrior> getGuard() {
		return guard;
	}
	public void setGuard(ArrayList<Warrior> guard) {
		this.guard = guard;
	}
	public int getWood() {
		return wood;
	}
	public void setWood(int wood) {
		this.wood = wood;
	}
	
	public int getStone() {
		return stone;
	}
	public void setStone(int stone) {
		this.stone = stone;
	}
	
	public int getIron() {
		return iron;
	}
	public void setIron(int iron) {
		this.iron = iron;
	}
	
	public int getAge() {
		return age;
	}
	public void setName(String name) { 
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population += population;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold += gold;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity += popularity;
	}
	
	public void nextTurn() {
		System.out.println("This is " + age + " year(s) since our city has been created");
		/*
		System.out.println("Your population is " + getPopulation());
		System.out.println("Your gold is" + getGold());
		System.out.println("Your popularity is " + getPopularity());
		*/
		age++;
		this.population += populationPerTurn;
		this.gold += goldPerTurn;
		this.wood += getAllWood();
		this.iron += getAllIron();
		this.stone += getAllStone();
		this.popularity += getAllPopularity();	
	}
	
	public int getFreePopulation() {
		return freePopulation;
	}
	public void setFreePopulation(int freePopulation) {
		this.freePopulation = freePopulation;
	}
	
	public void Build(Building building) {
		yourBuildings.add(building);
		getAllGold();
		getAllWood();
		getAllIron();
		getAllStone();
		getAllPopularity();
	}
	
	
	// These methods collect all Add resources for add nextTurn(); 
	public int getAllGold() {
		int allGold = 0;
		for (Building building: yourBuildings) {
			allGold += building.getAddGold();
		}
		return allGold;
	}
	
	public int getAllWood() {
		int allWood = 0;
		for (Building building: yourBuildings) {
			allWood += building.getAddWood();
		}
		return allWood;
	}
	
	public int getAllIron() {
		int allIron = 0;
		for (Building building: yourBuildings) {
			allIron += building.getAddIron();
		}
		return allIron;
	}
	
	public int getAllPopularity() {
		int allPopularity = 0;
		for (Building building: yourBuildings) {
			allPopularity += building.getAddPopularity();
		}
		return allPopularity;
	}
	public int getAllStone() {
		int allStone = 0;
		for (Building building: yourBuildings) {
			allStone += building.getAddStone(); 
		}
		return allStone;
	}
	
	
}
