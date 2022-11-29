
public class Character {
	private String race;
	private String characterClass;
	private boolean busted;
	private int HP = 100; 
	private boolean Alive = true;
	
	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public boolean isBusted() {
		return busted;
	}

	public void setBusted(boolean busted) {
		this.busted = busted;
		setHP(150); 
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public boolean isAlive() {
		return Alive;
	}

	public void setAlive(boolean alive) {
		Alive = alive;
	}

	public static void act() {}
	
	
}
