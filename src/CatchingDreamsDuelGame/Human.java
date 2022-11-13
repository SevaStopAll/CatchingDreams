package CatchingDreamsDuelGame;

public abstract class Human {
	int HP;
	String name;
	String position;
	
	public Human(int HP, String name) {
		this.HP = HP;
		this.name = name;
		position = "In the middle";
	}
	
	public String getName() {
		return name;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
			
}
