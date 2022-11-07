package cityGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class City {
	// Base parameters: 
	private String name;
	private int population = (int)(1 + Math.random() * 100); 
	private int freePopulation;
	private int popularity = 50; 
	private List <Building> yourBuildings = new LinkedList<>();
	private List <Building> buildList = new LinkedList<>();
	private int populationPerTurn = (int) (population * 0.05);
	private List <Warrior> guard = new LinkedList<>();
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
	
	// This method show you all information about your city
	public void getInfo() {
		System.out.println("Age " + getAge() + " Gold " + getGold() + " Population " + getPopulation() + " Popularity " + getPopularity() + " Free workers " + getFreePopulation());
	}
	public int getPopulationPerTurn() {
		return populationPerTurn;
	}
	public void setPopulationPerTurn(int populationPerTurn) {
		this.populationPerTurn = populationPerTurn;
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
		this.gold += goldPerTurn + collectAllGold();
		this.wood += collectAllWood();
		this.iron += collectAllIron();
		this.stone += collectAllStone();
		this.popularity += getAllPopularity();	
		setFreePopulation();
	}
	
	public int getFreePopulation() {
		return freePopulation;
	}
	public void setFreePopulation() {
		this.freePopulation = getPopulation() - getAllWorkers();
	}
	
	public void buyBuilding(Building building) {
		this.gold -= building.getPrice();
	}
	
	//When you are set a building, first the app compare how many building you've already built. Then
	public void Build(City city, Building building) {
		if (building.getCurrentNumb() < building.getLimit() && city.getGold() > building.getPrice()) {
		yourBuildings.add(building);
		city.buyBuilding(building);
		int allWorkers = city.getPopulation();
		allWorkers =-building.getWorkers();
		} else {
			System.out.println("You have built maximum of this buildings or you don't have enought gold");
		}
	}
	
	
	// These methods collect all Add resources for add nextTurn(); 
	public int collectAllGold() {
		int allGold = 0;
		for (Building building: yourBuildings) {
			allGold += building.getAddGold();
		}
		return allGold;
	}
	
	public int collectAllWood() {
		int allWood = 0;
		for (Building building: yourBuildings) {
			allWood += building.getAddWood();
		}
		return allWood;
	}
	
	public int collectAllIron() {
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
	public int collectAllStone() {
		int allStone = 0;
		for (Building building: yourBuildings) {
			allStone += building.getAddStone(); 
		}
		return allStone;
	}
	
	public int getAllWorkers() {
		int allWorkers = 0;
		for (Building building: yourBuildings) {
			allWorkers += building.getWorkers();
		}
		return allWorkers;
	}
	
	
// Here are all the buildings you can build. And here you can add new ones. 
	public void setBuildList() {
		 Building villageHall = new Building("Village Hall", 0, 0, 0, 50, 0, 0, 1, 1, 1);
		 Building villageTemple = new Building("VillageTemple", 100, 0, 0, 0, 0, 0, 3, 1, 1);
		 Building inn = new Building("Inn", 50, 0, 0, 35, 0, 0, 3, 2, 1);
		 Building mine = new Building("Mine", 50, 0, 0, 0, 0, 5, 0, 1, 5);
		 Building sawmill = new Building("Sawmill", 50, 0, 5, 0, 0, 0, 0, 1, 5);
		 Building quarry = new Building("Quarry", 100, 0, 0, 0, 5, 0, 0, 1, 5);
		buildList.add(villageHall);
		buildList.add(villageTemple);
		buildList.add(inn);
		buildList.add(mine);
		buildList.add(sawmill);
		buildList.add(quarry);
	}
	
	// this method create the building when you are creating it
	public Building getBuilding(int number) {
		Building build = buildList.get(number);
		return build;
	}
	
	// this method show the name of building and its price.
	public void watchBuildlist() {
		int numb = 0;
		for(Building building: buildList) {
			System.out.println(numb + " " + building.getName() + " " + building.getPrice());
			numb ++;
		}
	}
}
