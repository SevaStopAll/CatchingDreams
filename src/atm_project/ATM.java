package atm_project;

public class ATM {
	public static void main(String [] args) {
		Client Olga = new Client("Olga");
		System.out.println(Olga.get_id());
		Account a1 = new Account(300.00, Olga);
		System.out.println(a1.getAccId());
		Client Dima = new Client("Dima");
		System.out.println(Dima.get_id());		
		Account a2 = new Account(300.00, Dima);
		System.out.println(a2.getAccId());
		Client Sasha = new Client("Sasha");
		System.out.println(Sasha.get_id());
		Account a3 = new Account(300.00, Sasha);
		System.out.println(a3.getAccId());
		System.out.println(a1.getAccId());
		
	}
}
