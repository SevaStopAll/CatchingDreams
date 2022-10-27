package atm_project;

public class Account {
	int account_ID = 1;
	double summ;
	boolean isBlocked = false;
	
	public Account(double summ, Client client) {
		this.summ = summ;
		account_ID = Client.get_id();
	}
	
	public void addSumm(int add) {
		summ += add;
	}
	
	public void takeMoney(int take) {
		summ-= take;
	}
	
	public int getAccId() {
		return account_ID;
	}
	
	public double getSumm() {
		return summ;
	}
	
	
}
