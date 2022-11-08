package cityGame;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello, player! How would you like to name your city?");
		City myCity = new City();
		myCity.setBuildList(); // these method should be united in one common method like "Building game"
		myCity.setEvents(); // these method should be united in one common method
		Scanner sc = new Scanner(System.in);
		myCity.setName(sc.next());
		myCity.setFreePopulation();
		System.out.println("Your city name is " + myCity.getName());
		myCity.Build(myCity, myCity.getBuilding(0));
		while(myCity.getGold() > 0 && myCity.getPopulation() > 0 && myCity.getPopularity() > 0) {
			myCity.nextTurn();
			myCity.getEvent();
			System.out.println("What would you like to do?");
			System.out.println("1.Build something. 2. Watch information about your city. 3.Set your militia.");
			int action = sc.nextInt();
			switch (action) {
				case(1):
					myCity.watchBuildlist();
					int building = sc.nextInt();
					myCity.Build(myCity, myCity.getBuilding(building));
					break;
				case(2):
					myCity.getInfo();
					break;
				case(3): 
					myCity.setWarriors(sc.nextInt());
					break;
			}
		}
	}
}
