package CatchingDreamsDuelGame;
import java.util.Scanner;

public class Cowboy extends Human{

	
	public Cowboy(String name) {
		super(name);
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void shoot() {
		int chooseDirection = sc.nextInt();
		if (chooseDirection == 1) {
			setShootDirection("Left");
		} else if(chooseDirection == 2) {
			setShootDirection("In the middle"); 
		} else {
			setShootDirection("Right");
		}
	}
	
	public void move() {
		int chooseDirection = sc.nextInt();
		if (chooseDirection == 1) {
			setPosition("Left");
		} else if(chooseDirection == 2) {
			setPosition("In the middle"); 
		} else {
			setPosition("Right");
		}
	}
	 
	public void Duel(Cowboy cowboy, NPC cowboy2) {
		while(cowboy.isAlive() && cowboy2.isAlive()) {
			cowboy.shoot();
			cowboy2.move();
			cowboy2.shoot();
			cowboy.move();
			if (cowboy.getShootDirection().equals(cowboy2.getPosition())) {
			    cowboy2.setAlive(false);
			    System.out.println("Your turn:");
				cowboy.getInfo();
				System.out.println("Your enemy's turn");
				cowboy2.getInfo();
			    System.out.println("Your enemy is dead.");
			} else if (cowboy2.getShootDirection().equals(cowboy.getPosition())) {
				cowboy.setAlive(false);
				System.out.println("Your turn:");
				cowboy.getInfo();
				System.out.println("Your enemy's turn");
				cowboy2.getInfo();
				System.out.println("You are dead.");
			} else {
				System.out.println("Your turn:");
				cowboy.getInfo();
				System.out.println("Your enemy's turn");
				cowboy2.getInfo();
				Duel(cowboy, cowboy2);
			}
		}
	}

}
