package CatchingDreamsDuelGame;

public abstract class Human {
	private String name;
	private String position = "In the middle";
	private String shootDirection;
	private boolean isAlive = true;
	
	public Human(String name) {
		this.name = name;
		position = "In the middle";
	}
	
	public String getName() {
		return name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getShootDirection() {
		return shootDirection;
	}

	public void setShootDirection(String shootDirection) {
		this.shootDirection = shootDirection;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	public void getInfo() {
		System.out.println("ShootDirection: " + shootDirection + " Position: " + position);
	}
			
}
