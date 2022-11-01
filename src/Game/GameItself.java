package Game;

import java.util.Scanner;

import Game.Human.Hero;
import Game.Human.NPC;
import Game.Item.Weapon;


// \n - переход на другую строку 
public class GameItself {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello, Stranger! Welcome! Let's name your Character!");
		Hero mainHero = new Hero(sc.nextLine(), 150, 5);
		System.out.println("Hello, " + mainHero.GetName());
		System.out.println("So, you are in front of three doors. You don't remember anything. The place, You don't remember it. \nBut you know, somewhere inside, that you can't stop right now, you have to choose the door!");
		System.out.println("1.Choose 1st door. 2. Choose 2nd door. 3. Choose 3rd door.");
		int Door = sc.nextInt();
		switch (Door) {
		case(1):
			FirstLevel(mainHero);
			break;
			
		case(2):
			SecondLevel(mainHero);
			break;
		
		case(3):
			ThirdLevel(mainHero);
			break;
		}
		
		sc.close();	
	}

public static void FirstLevel(Hero mainHero) {
	System.out.println("You are in the forest. The door disappeared. And a big wolf is going to hurt you. Defend!");
	NPC wolf1 = new NPC("Big wolf", 50, 5);
	mainHero.Fight(mainHero, wolf1);
	if (mainHero.getHP() > 0) {
		System.out.println("The predator is dead and you can look around. Tall trees, green as emeralds, pines, oaks and a lot of other trees you don't names. \nThere is a bird songs, air is completely pure. You are not scared, it's really interesting to know, where are you.");	
	}
}

public static void SecondLevel(Hero mainHero) {
	System.out.println("You are in the desert. The door disppeared. And a giant scorpion are going to hurt you. Defend!");
	NPC Scorpion = new NPC("Giant scorpion", 80, 2);
	mainHero.Fight(mainHero, Scorpion);
	if (mainHero.getHP() > 0) {
		System.out.println("Now there is nothing to hurt you, and you can look around. Sand, mountains of sand around you until horizon. And the sun wants to fry you like a peace of meat. \nYou try to focus on lands to remark any signs of mankind.");
	}
}

public static void ThirdLevel(Hero mainHero) {
	System.out.println("You are in the middle of the big city. The language is not your native but there is something common. You are walking down the street. \nThere are not a lot of people and one big guy with a knife is going to hurt you. Defend!");
	NPC Bandit = new NPC("Street bandit", 100, 3);
	mainHero.Fight(mainHero, Bandit);
	Weapon IronSword = new Weapon();
	// REPAIRE
	addItem(IronSword);
	if (mainHero.getHP() > 0) {
		System.out.println("The bandit isn't breathing. Unfortunately, he is dead and you can't ask him anything. And you are in the poor city quarter. \nThere are no light and no guards here. And you decided to ask the way.");
	}
}

}




