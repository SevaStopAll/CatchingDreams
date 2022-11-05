package cityGame;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello, player! How would you like to name your city?");
		City myCity = new City();
		Scanner sc = new Scanner(System.in);
		myCity.setName(sc.next());
		System.out.println("Your city name is " + myCity.getName());
	}
	
	
}
