package Game;

public class Item {
	String name; 
	int price; 
	String description;
	
public static class Weapon extends Item {
	int Damage;
}	

public static class Armor extends Item {
	int Defence;
}
Weapon IronSword = new Weapon();
Weapon SilverSword = new Weapon();
Weapon Bow = new Weapon();
Armor LeatherArmor = new Armor();
Armor IronArmor = new Armor();


}
