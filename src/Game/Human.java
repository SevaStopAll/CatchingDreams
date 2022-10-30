package Game;


public abstract class Human {
	private String name;
	static int HP = 10;
	static int Strenght = 1;
	
	public Human(String name) {
		this.name = name;
	}
	
	public Human(String name, int HP) {
		this.name = name;
		this.HP = HP;
	}
	
	public String GetName() {
		return name;
	}
	
public static class Hero extends Human {

	public Hero(String name) {
		super(name);
		HP = 100;
		Strenght = 5;
	}
		
	public Hero(String name, int HP) {
		super(name, HP);
	}	
	
	
}
	
public static class NPC extends Human {
		public  NPC(String name) {
			super(name);
		}
		
		public  NPC(String name, int HP) {
			super(name, HP);
		}
		
}
}
	
		
		

