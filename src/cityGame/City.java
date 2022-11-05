package cityGame;

import java.util.ArrayList;

public class City {
	private String name;
	private int population = (int)(1 + Math.random() * 100); 
	private int gold = (int)(1 + Math.random() * 100);
	private int popularity = 50; 
	private ArrayList <Building> yourBuilding = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	
}
