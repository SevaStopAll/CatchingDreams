package Game;

public class Item {
	String name; 
	int price; 
	String description;
	int damage = 0;
	int defence = 0;
	
	public Item(String name, int price, String descpiption){
		this.name = name;
		this.price = price;
		this.description = descpiption;
	
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public int getDamage() {
		return damage;
	}
	
	
}
	
class Weapon extends Item {

	public Weapon(String name, int price, String description, int damage) {
		super(name, price, description);
		this.damage = damage;
	}
	
}	


class Armor extends Item {

	public Armor(String name, int price, String description, int defence) {
		super(name, price, description);
		this.defence = defence;
	}
	
}



