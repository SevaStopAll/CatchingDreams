package cityGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class City {
	// Base parameters: 
	private String name;
	private int population = (int)(50 + Math.random() * 100); 
	private int freePopulation;
	private int popularity = 50; 
	private List <Building> yourBuildings = new LinkedList<>();
	private List <Building> buildList = new LinkedList<>();
	private List <Event> events = new ArrayList<>(); // When it is done, change to Event []. 
	private int populationPerTurn = (int) (population * 0.05);
	private List <Warrior> guard = new LinkedList<>();
	private int warriors = 0;
	private int age = 1;
	// Resources 
	private int gold = (int)(1 + Math.random() * 100);
	private int goldPerTurn = population; // Tax here
	private int wood = 10;
	private int stone = 10;
	private int iron = 5;
	public int food = (int)(1 + Math.random() * 100); // You need food for your population grows and lives
	
	
	public int getFood() {
		return food;
	}
	
	// every next turn this method sets how much food does player have
	public void setFood() {
		this.food -= population + collectAllFood();
	}

	public String getName() {
		return name;
	}
	
	// This method helps you to set number of your militia (it will be changed one day)
		public void setWarriors(int warriors) {
			this.warriors += warriors;
		}
		
	// This method helps to calculate your free people (- all workers and all militia troops)
	public int getWarriors() {
		return warriors;
	}
	
	// This method show you all information about your city and set some base parameters 
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
	
	
	// This method is the base, it change year and calculate your resources for the next turn
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
		setFood();
		setFreePopulation();
	}
	
	// This method return you all free workers
	public int getFreePopulation() {
		return freePopulation;
	}
	
	// Every turn this method calculate free workers (not busy and not militia)
	public void setFreePopulation() {
		this.freePopulation = getPopulation() - getAllWorkers() - getWarriors();
	}
	
	// When you build something, city pays it from its treasury
	public void buyBuilding(Building building) {
		this.gold -= building.getPrice();
	}
	
	//When you are set a building, first the app compare how many building you've already built. Then
	public void Build(City city, Building building) {
		if (building.getCurrentNumb() < building.getLimit() && city.getGold() > building.getPrice() && city.getFreePopulation() > building.getWorkers()) {
		yourBuildings.add(building);
		city.buyBuilding(building);
		int allWorkers;
		allWorkers =-building.getWorkers();
		} else {
			System.out.println("We can't build it. Main reasons: you don't have gold, you have the limit, you don't have free workers");
		}
	}
	
	// These methods below collect all resources for add it nextTurn(); 
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
	
	public int collectAllFood() {
		int allFood = 0;
		for (Building building: yourBuildings) {
			allFood += building.getAddFood(); 
		}
		return allFood;
	}
	
	// This method helps to calculate free workers (calculating all workers already busy)
	public int getAllWorkers() {
		int allWorkers = 0;
		for (Building building: yourBuildings) {
			allWorkers += building.getWorkers();
		}
		return allWorkers;
	}
	
	
	
	
// Here are all the buildings you can build. And here you can add new ones. 
// String name, int price, int buildTime, int addWood, int addGold, int addStone, int addIron, int addPopularity, int limit, int workers, int food
	public void setBuildList() {
		 Building villageHall = new Building("Village Hall", 0, 0, 0, 50, 0, 0, 1, 1, 1, 0);
		 Building villageTemple = new Building("VillageTemple", 100, 0, 0, 0, 0, 0, 3, 1, 1, 0);
		 Building inn = new Building("Inn", 50, 0, 0, 35, 0, 0, 3, 2, 1, 5);
		 Building mine = new Building("Mine", 50, 0, 0, 0, 0, 5, 0, 1, 5, 0);
		 Building sawmill = new Building("Sawmill", 50, 0, 5, 0, 0, 0, 0, 1, 5, 0);
		 Building quarry = new Building("Quarry", 100, 0, 0, 0, 5, 0, 0, 1, 5, 0);
		 Building field = new Building("Field", 50, 0, 0, 0, 0, 0, 0, 10, 10, 1000);
		buildList.add(villageHall);
		buildList.add(villageTemple);
		buildList.add(inn);
		buildList.add(mine);
		buildList.add(sawmill);
		buildList.add(quarry);
		buildList.add(field);
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
									
	// Here are all the events via anonymous class (interface event)
	Event testEvent = new Event() {
		@Override
		public void takePlace() {
			System.out.println("There are outlaws, Sir");
		}
	};
	
	Event testEvent2 = new Event() {
		@Override
		public void takePlace() {
		System.out.println("There are rats, Sir");	
		}
	};
	
	Event testEvent3 = new Event() {
		@Override
		public void takePlace() {
		System.out.println("All is well");
		}
	};
	
	// We add all the events via this method in the beginning of the game. We need at least 10 different events
	public void setEvents() {
		events.add(testEvent);
		events.add(testEvent2);
		events.add(testEvent3);
		}
	
	// Random event from events ArrayList comes and show its effect 
	public void getEvent() {
		int event = (int)(Math.random() * 3);
		events.get(event).takePlace();
	}
	
	
} // Class end	


	

