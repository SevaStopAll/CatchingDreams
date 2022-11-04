package Game;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Human {
	private String name;
	private int Strenght = (int)(1 + Math.random() * 10);
	private int Constitution = (int)(1 + Math.random() * 10);
	private int HP = (int)(50 + Math.random() * 50) + (Constitution * 5);
	private int baseHP = HP;
	private int Dexterity = (int)(1 + Math.random() * 10);
	private int Luck = (int)(1 + Math.random() * 10);
	int exp;
	private static int defence = 0;
	private static int attack = 0;
	private int gold = 0;

	
	public Human(String name) {
		this.name = name;
		
	}
	
	public Human(String name, int Strenght, int Constitution, int Dexterity, int exp) {
		this.name = name;
		this.Strenght = Strenght;
		this.Constitution = Constitution;
		this.Dexterity = Dexterity; 
		this.exp = exp;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void restoreHP() {
		if (HP + baseHP*0.5 < baseHP) {
		HP += baseHP*0.5;
		} else {
		HP = baseHP;	
		}
	}
	
	public int getbaseHP() {
		return baseHP;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(Human attacker, Human defender) {
		attacker.gold = attacker.getGold() + defender.getGold(); 
	}

	public void watchParams() {
		System.out.println("Your Strenght " + getStrenght());
		System.out.println("Your Constitution " + getConstitution());
		System.out.println("Your Dexterity " + getDexterity());
		System.out.println("Your Luck " + getLuck());
		System.out.println("Your have " + getGold() + " gold pieces");
	}
	
	public int getStrenght() {
		return Strenght;
	}
	
	public void setStrenght() {
		Strenght = getStrenght() + 1;
	}
	
	public int getConstitution() {
		return Constitution;
	}

	public void setConstitution() {
		Constitution = getConstitution() + 1;
	}
	
	public int getDexterity() {
		return Dexterity;
	}
	
	public void setDexterity() {
		Dexterity = getDexterity() + 1;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public void setLuck() {
		Luck = getLuck() + 1;
	}
	
	public int getLuck() {
		return Luck;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void earnExp(Human attacker, Human defender){
		attacker.exp = attacker.getExp() + defender.getExp();
	}
	
	public void hit(Human attacker, Human defender) {
		int MissingChance =(int)(1 + Math.random() * 100) - defender.getDexterity();
		if (MissingChance < 15) {
			System.out.println(attacker.getName() + " Missed");
		}
		else if (defender.getDefence() > (attacker.getAttack() + attacker.getStrenght())) {
			defender.HP -= (int)(1 + Math.random() * 1 + 1);
		} else {
		defender.HP -= (int)(1 + Math.random() * (attacker.getStrenght() + attacker.getAttack() - defender.getDefence()) + 1);
		}
	}
	
	public void criticalHit(Human attacker, Human defender) {
		int criticalHitChance = 3;
	    int thisChance = (int)(Math.random()*95 + criticalHitChance + attacker.getLuck());
		if (thisChance > 90) {
			defender.HP -=(int)(2*(1 + Math.random() * (attacker.getStrenght() + attacker.getAttack() - defender.getDefence()) + 1));
			System.out.println(attacker.getName() + " did critical hit");
		}
	}
	
	public void fight(Human attacker, Human defender) {
		Scanner sc = new Scanner(System.in);
		int turn = 1;
		while (attacker.getHP() > 0 && defender.getHP() > 0) {
			System.out.println("TURN " + turn);
			turn++;
			criticalHit(attacker, defender);
			criticalHit(defender, attacker);
			attacker.hit(attacker, defender);
			System.out.println(defender.getName() + " has " + defender.getHP() + "HP");
			defender.hit(defender, attacker);
			System.out.println(attacker.getName() + " has " + attacker.getHP() + "HP");
			// It will be useful when I create Fight System System.out.println("Press Enter to continue"); 
			// sc.nextLine();
		}
		if (defender.getHP() <= 0) {
			System.out.println(defender.getName() +" is dead.");
			attacker.restoreHP();
			earnExp(attacker, defender);
			if (attacker.getExp() >= Hero.nextLevelExp) {
				Hero.nextLevelExp += Hero.nextLevelExp*2;
				System.out.println("New level! Next level with EXP " + Hero.nextLevelExp);
				Hero.setPoints();
				System.out.println("You have " + Hero.getPoints() + " points.");	
			} 
		}
		if (attacker.getHP() <= 0) { 
			System.out.println("You are dead.");
			sc.close();
	}
	}


public static class Hero extends Human {
	 ArrayList<Item> inventory = new ArrayList<Item>();
	 public static int nextLevelExp = 100;
	 private static int levelPoints = 0;
	 
	public Hero(String name) {
		super(name);
		System.out.println("Your HP is " + getHP());
	}
	
	public static void setPoints() {
		levelPoints += 3;
	}
	
	public static int getPoints() {
		return levelPoints;
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
	
	public void LevelUp() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			if (levelPoints > 0) {
				System.out.println("What parameter would you like to change");
				System.out.println("1. Strenght 2. Constitution 3.Dexterity 4. Luck");
				int param = sc.nextInt();
				switch (param) {
					case(1):
						setStrenght();
						levelPoints--;
						break;
					case(2):
						setConstitution();
						levelPoints--;
						break;
					case(3):
						setDexterity();
						levelPoints--;
						break;
					case(4):	
						setLuck();
						levelPoints--;
						break;
				}
			} else {
		System.out.println("You don't have points");
		watchParams();
		sc.close();
		return;
		}
		} 
	}
}

public static class NPC extends Human {
			int level;
			
			
		public  NPC(String name, int exp, int level) {
			super(name);
			this.exp = exp;
			this.level = level;
		}
		
		public int getLevel() {
			return level;
		}
		
		public NPC(String name, int Strenght, int exp, int Constitution, int Dexterity) {
			super(name, Strenght, exp, Constitution, Dexterity);
			}

}
}





	
		
		

