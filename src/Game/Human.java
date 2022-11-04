package Game;

import java.util.ArrayList;

public abstract class Human {
	private String name;
	private int HP = (int)(50 + Math.random() * 100);
	private int Strenght;
	private static int defence = 0;
	private static int attack = 0;
	private int luck = 1;
	int exp;
	
	
	public Human(String name, int Strenght) {
		this.name = name;
		this.Strenght = Strenght;
	}
	
	
	public String GetName() {
		return name;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setHP() {
		HP = 150;
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
	
	public void setLuck(int luck) {
		this.luck = luck;
		System.out.println("Now your Luck is " + getLuck());
	}
	
	public int getLuck() {
		return luck;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void earnExp(Human attacker, Human defender){
		attacker.exp = attacker.getExp() + defender.getExp();
	}
	
	public void hit(Human attacker, Human defender) {
		if (defender.getDefence() > (attacker.getAttack() + attacker.getStrenght())) {
			defender.HP -= (int)(1 + Math.random() * 1 + 1);
		} else {
		defender.HP -= (int)(1 + Math.random() * (attacker.getStrenght() + attacker.getAttack() - defender.getDefence()) + 1);
		}
	}
	
	public void criticalHit(Human attacker, Human defender) {
		defender.HP -=(int)(2*(1 + Math.random() * (attacker.getStrenght() + attacker.getAttack() - defender.getDefence()) + 1));
	}
	
	public void fight(Human attacker, Human defender) {
		while (attacker.getHP() > 0 && defender.getHP() > 0) {
		    int criticalHitChance = 5;
		    int thisChance = (int)(Math.random()*95 + criticalHitChance + attacker.getLuck());
		    System.out.println("This chance now is " + thisChance);
			if (thisChance > 90) {
				attacker.criticalHit(attacker, defender);
				System.out.println("Critical");
			}
		attacker.hit(attacker, defender);
		System.out.println(defender.GetName()+ " HP " + defender.getHP());
		defender.hit(defender, attacker);
		System.out.println(attacker.GetName() + " HP " + attacker.getHP());
		
		}
		if (defender.getHP() <= 0) {
			System.out.println(defender.GetName() +" is dead.");
			earnExp(attacker, defender);
			if (attacker.getExp() >= Hero.nextLevelExp) {
				Hero.nextLevelExp += Hero.nextLevelExp*2;
				System.out.println("New level! Next level with EXP " + Hero.nextLevelExp);
			} 
		}
		if (attacker.getHP() <= 0) { 
			System.out.println("You are dead.");
	}
	}

public static class Hero extends Human {
	 ArrayList<Item> inventory = new ArrayList<Item>();
	 public static int nextLevelExp = 100;
	 
	public Hero(String name, int Strenght) {
		super(name, Strenght);
		setHP();
		System.out.println("Your HP is " + getHP());
	}
	
	public int getInventorySize() {
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
	
	public void watchInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i+1) + " " + inventory.get(i).getDescription());
		}
	}
}

public static class NPC extends Human {
		
		public  NPC(String name, int Strenght, int exp) {
			super(name, Strenght);
			this.exp = exp;
		}	
}

}

	
		
		

