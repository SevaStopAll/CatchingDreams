package Game;

import java.util.Scanner;

import Game.Human.Hero;
import Game.Human.NPC;


// \n - переход на другую строку 
public class GameItself {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello, Stranger! Let's name your Character!");
		Hero mainHero = new Hero(sc.nextLine());
		System.out.println("Hello, " + mainHero.GetName());
		System.out.println("So, you are in front of three doors. You don't remember anything. The place, You don't remember it. \nBut you know, somewhere inside, that you can't stop right now, you have to choose the door!");
		System.out.println("1.Choose 1st door. 2. Choose 2nd door. 3. Choose 3rd door.");
		int Door = sc.nextInt();
		switch (Door) {
		case(1):
			FirstLevel(mainHero);
			break;
			
		
		case(2):
			SecondLevel();
			break;
		
		case(3):
			ThirdLevel();
			break;
		}
		
		sc.close();	
	}

public static void FirstLevel(Hero mainHero) {
	System.out.println("You are in the forest. The door disappeared. And a big wolf is going to hurt you. Defend!");
}

public static void SecondLevel() {
	System.out.println("You are in the desert. The door disppeared. And a giant scorpion are going to hurt you. Defend!");
}

public static void ThirdLevel() {
	System.out.println("You are in the middle of the big city. The language is not your native but there is something common. You are walking down the street. \nThere are not a lot of people and one big guy with a knife is going to hurt you. Defend!");
}

}




