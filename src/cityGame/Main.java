package cityGame;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello, player! How would you like to name your city?");
		City myCity = new City();
		Scanner sc = new Scanner(System.in);
		myCity.setName(sc.next());
		System.out.println("Your city name is " + myCity.getName());
		myCity.Build(villageHall);
		while(myCity.getGold() > 0 && myCity.getPopulation() > 0 && myCity.getPopularity() > 0) {
			myCity.nextTurn();
		}
	}
	
	// List of buildings (String name, int price, int buildTime, int addWood, int addGold, int addStone, int addIron, int addPopularity)
	static Building villageHall = new Building("Village Hall", 0, 0, 0, 50, 0, 0, 1);
	static Building villageTemple = new Building("VillageTemple", 100, 0, 0, 0, 0, 0, 3);
	static Building inn = new Building("Inn", 50, 0, 0, 35, 0, 0, 3);
	static Building mine = new Building("Mine", 50, 0, 0, 0, 0, 5, 0);
	static Building sawmill = new Building("Sawmill", 50, 0, 5, 0, 0, 0, 0);
	static Building quarry = new Building("Quarry", 100, 0, 0, 0, 5, 0, 0);
}
