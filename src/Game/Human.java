package Game;

import java.util.ArrayList;

public abstract class Human {
	private String name;
	private int HP = 100;
	private int Strenght;
	private static int defence = 0;
	private static int attack = 0;
	
	
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
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public void Hit(Human attacker, Human defender) {
		defender.HP -= (int)(1 + Math.random() * (attacker.getStrenght() + attacker.getAttack()) + 1);
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
	 ArrayList<Item> inventory = new ArrayList<Item>();

	public Hero(String name, int HP, int Strenght) {
		super(name, HP, Strenght);
		
	}
	
	public int GetInventorySize() {
		return inventory.size();
	}
	
	public void addDefence() {
		defence = 0;
		for (int i = 0; i < inventory.size(); i++)
		Human.defence += inventory.get(i).getDefence();
		System.out.println("Your Defence - " + Human.defence);
	}
	
	public void addDamage() {
		attack = 0;
		for (int i = 0; i < inventory.size(); i++)
		Human.attack +=  inventory.get(i).getDamage();
		System.out.println("Your Attack - " + Human.attack);
		
	}
	
	public void addItem(Item item) {
		inventory.add(item);
		System.out.println(item.getDescription());
		addDamage();
		addDefence();
	}
	
	public void WatchInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i+1) + " " + inventory.get(i).getDescription());
		}
	}
}

public static class NPC extends Human {

		public  NPC(String name, int HP, int Strenght) {
			super(name, HP, Strenght);
		}	
}

}

	
		
		

