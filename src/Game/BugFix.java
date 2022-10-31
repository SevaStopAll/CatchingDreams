package Game;

import Game.Human.Hero;

public class BugFix {
	public static void main(String [] args) {
		Hero mainHero = new Hero("Granny", 150, 6);
		for (int i = 0; i < 20; i++) {
		System.out.println((int)(1 + Math.random() * mainHero.getStrenght()) + 1);
		}
	}
}
