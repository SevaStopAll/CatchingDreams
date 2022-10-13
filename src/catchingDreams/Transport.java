package catchingDreams;

public class Transport {
	String name; 
	String type;
	int speed;
	int capacity; 

	public Transport(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity; 
	}
	
	public class Boats extends Transport {
		public Boats (String name, String type) {
			super(name, type);
		}
	}
}

