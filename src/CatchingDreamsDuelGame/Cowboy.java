package CatchingDreamsDuelGame;

public class Cowboy extends Human{
	String shootDirection;

	public Cowboy(int HP, String name) {
		super(HP, name);
		String position = "In the middle";
	}
	
	public String Shoot() {
		return shootDirection = "In the middle"; 
	}
	
	public void Duel(Cowboy cowboy, Cowboy cowboy2) {
		while(cowboy.getHP() > 0 && cowboy2.getHP() > 0) {
			if (cowboy.Shoot.equals(cowboy2.getPosition()) {
				cowboy2.getHP();
			}
		}
	}

}
