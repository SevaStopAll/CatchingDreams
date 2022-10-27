package atm_project;



public class Client {
	static int clientId;
	String name;
	public static int counter = 1; 
	
	public Client(String name) {
		this.name = name;
		clientId = counter;
		counter++;
	}
	
	public static int get_id() {
		return clientId;
	}
	

	
	
}



