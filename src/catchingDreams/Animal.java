package catchingDreams;

public class Animal {
    private String type;
    private String name;
    private int age;
    private double weight;
    private boolean isFly;
    private boolean isWalk;
    private boolean isSwimm;
    
    {
    	name = "Just animal";
    	type = "Just animal";
    }
    
    public Animal() {
    	
    }
    public Animal(String type, String name, int age, double weight, boolean isFly, boolean isWalk, boolean isSwimm) {
    	this.type = type;
    	this.name = name;
    	this.age = age;
    	this.weight = weight;
    	this.isFly = isFly;
    	this.isWalk = isWalk;
    	this.isSwimm = isSwimm;
    }
    
    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }
    
    public Animal(String type, int age) {
        this.type = type;
        this.age = age;
        name = "No name";
    }
    
    public Animal(String type, String name, int age, double weight) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    
    public void display() {

        System.out.println("Тип: " + type + " Имя: " + name + " Возраст: " + age + " Вес: " + weight);
        
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setFly (boolean isFly) {
        this.isFly = isFly;
    }
    public void setWalk (boolean isWalk) {
        this.isWalk = isWalk;
    }
    public void setSwimm (boolean isSwimm) {
        this.isSwimm = isSwimm;
    }
    public void rename(String a) {
        name = a;
    }
    public void holiday(int q) {
        weight += (q * 0.1);
    }
    
    public int getAge() {
        return age;
    }
    
    public String getType() {
        return type;
    }
    
    public String getName() {
        return name;  
    }
    public boolean isFly() {
        return isFly;
    }
    public boolean isWalk() {
        return isWalk;
    }
    public boolean isSwimm() {
        return isSwimm;
    }
    
    public double getWeight() {
        return weight;
    }  
    
    public static void iAnimal() {
    	System.out.println("I am animal");
    }
    
    public class Insect extends Animal{
    	int wingCount;
    	boolean likeJesus; 
    	
    	
    	public void ggggg() {
    		System.out.println("ggggg");
    	}
    	public Insect(String type, String name) {
    		super(type, name);
    	}
    	
    	public Insect() {
    		
    	}
    	public void setWingCount(int wingCount) {
    		this.wingCount = wingCount;
    	}
    	public int getWingCount() {
    		return wingCount;
    	}
    	
    	public void setLikeJesus(boolean likeJesus) {
    		this.likeJesus = likeJesus;
    	}
    	
    	public boolean isLikeJesus() {
    		return likeJesus;
    	}
    	
    	@Override 
    	public void display() {
    		System.out.println("I am " + getName());
    		System.out.println("Крыльев "+ wingCount + " " + "Хожу ли я по воде? " + likeJesus);
    	}
    }
    
    public class Fish extends Animal{
    	private String squama;
    	private boolean upStreamSwim;
    	boolean isSwim = true;

    	public void bul_bul() {
    		System.out.println("bul-bul");
    	}
    	
    	public Fish(String type, String name) {
    		super(type, name);
    	}
    	
    	public Fish() {
    		
    	}
    	
    	public void setSquama(String squama) {
    		this.squama = squama;
    	} 
    	
    	public String getSquama() {
    		return squama;
    	}
    	
    	public void setUpStreamSwim(boolean upStreamSwim) {
    		this.upStreamSwim = upStreamSwim;
    	}
    	
    	public boolean isUpStreamSwim() {
    		return upStreamSwim;
    	}
    	
    	@Override 
    	public void display() {
    		System.out.println("I am " + getName());
    		System.out.println("Чешуя у меня "+ squama + " " +  "Плаваю ли я против течения " + upStreamSwim);
    	} 
    	
    	
    }
    public class Bird extends Animal{
    	String area;
    	boolean winterFly;
    	boolean isFly = true;

    	
    	public void chirick_chirick() {
    		System.out.println("Chirik-chirik");
    	}
    	public  Bird (String type, String name, String area, boolean winterFly) {
    		super(type, name); 
    		this.area = area;
    		this.winterFly = winterFly;
    		
    	}
    	public Bird() {
    		
    	}
    	public void setArea(String area) {
    		this.area = area;
    	}
    	
    	public String getArea() {
    		return area;
    	}
    	
    	public void setWinterFly(boolean winterFly) {
    		this.winterFly = winterFly;
    		}
    	
    	public boolean isWinterFly() {
    		return winterFly;
    	}
    	
    	@Override 
    	public void display() {
    		System.out.println("I am " + getName());
    		System.out.println("Моя зона обитания: "+ area + " " +  "Улетаю ли я на ЮГ? " + isFly);
    	} 
    }
}