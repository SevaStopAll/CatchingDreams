package CatchingDreamsDuelGame;

import java.util.Random;

public class NPC extends Human{
	String shootDirection;
	
	public NPC(String name) {
		super(name);
	}
	
	Random rand = new Random();
	
	
	public void move() {
		int chooseDirection = rand.nextInt(3);
		if (chooseDirection == 1) {
			setPosition("Left");
		} else if(chooseDirection == 2) {
			setPosition("In the middle"); 
		} else {
			setPosition("Right");
		}
	}
	
	public void shoot() {
		int chooseDirection = rand.nextInt(3);
		if (chooseDirection == 1) {
			setShootDirection("Left");
		} else if(chooseDirection == 2) {
			setShootDirection("In the middle"); 
		} else {
			setShootDirection("Right");
		}
	}
	

}
