package Game;


public abstract class Human {
	private String name;
	private int HP = 100;
	private int Strenght;
	
	public Human(String name) {
		this.name = name;
	}
	
	public Human(String name, int HP, int Strenght) {
		this.name = name;
		this.HP = HP;
		this.Strenght = Strenght;
	}
	
	public String GetName() {
		return name;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getStrenght(Human human) {
		return human.Strenght;
	}
	
	public void Hit(Human attacker, Human defender) {
		defender.HP -= attacker.getStrenght(attacker);
	}
	
	public void Fight(Human attacker, Human defender) {
		while (attacker.HP != 0 && defender.HP != 0) {
		attacker.Hit(attacker, defender);
		System.out.println(defender.GetName()+ " HP " + defender.getHP());
		defender.Hit(defender, attacker);
		System.out.println(attacker.GetName() + " HP " + attacker.getHP());
		}
		if (defender.HP == 0) {
			System.out.println(defender.GetName() +" is dead.");
		}
		else { 
			System.out.println("You are dead.");
	}
	}
	
public static class Hero extends Human {
		
	public Hero(String name, int HP, int Strenght) {
		super(name, HP, Strenght);
	}	
	
	
}
	
public static class NPC extends Human {

		public  NPC(String name, int HP, int Strenght) {
			super(name, HP, Strenght);
			 
		}
		
}
}
	
		
		

