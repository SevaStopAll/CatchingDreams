package Game;

import java.util.ArrayList;

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
	
	public int getStrenght() {
		return Strenght;
	}
	
	public void Hit(Human attacker, Human defender) {
		defender.HP -= (int)(1 + Math.random() * attacker.getStrenght()) + 1;
	}
	
	public void Fight(Human attacker, Human defender) {
		while (attacker.HP > 1 && defender.HP > 1) {
		attacker.Hit(attacker, defender);
		System.out.println(defender.GetName()+ " HP " + defender.getHP());
		defender.Hit(defender, attacker);
		System.out.println(attacker.GetName() + " HP " + attacker.getHP());
		}
		if (defender.HP <= 0) {
			System.out.println(defender.GetName() +" is dead.");
		}
		if (attacker.HP <= 0) { 
			System.out.println("You are dead.");
	}
	}
	

	
public static class Hero extends Human {
		
	public Hero(String name, int HP, int Strenght) {
		super(name, HP, Strenght);
		ArrayList<Item> inventory = new ArrayList<>();
	}
	 REPAIRE
	public void AddItem(Item item, ArrayList<Item> inventory) {
		inventory.add(item);
	}
	
}
	
public static class NPC extends Human {

		public  NPC(String name, int HP, int Strenght) {
			super(name, HP, Strenght);
		}
		
}

}
 /* NPC wolf1 = new NPC("Big wolf", 50, 5);
NPC Bandit = new NPC("Street bandit", 100, 3);
NPC Scorpion = new NPC("Giant scorpion", 80, 2);
ArrayList <NPC> enemies = new ArrayList <>();
enemies.add(wolf1);
enemies.add(Scorpion);
enemies.add(Bandit); */
	
		
		

