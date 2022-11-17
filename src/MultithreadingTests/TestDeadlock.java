package MultithreadingTests;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadlock {

	public static void main(String[] args) throws InterruptedException {
		Runner runner = new Runner();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				runner.firstThread();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				runner.secondThread();
			}
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		runner.finished();
	}	

}

class Runner {
	private Account account1 = new Account();
	private Account account2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void takeLocks(Lock lock1, Lock lock2) {
		boolean firstLockTaken = false;
		boolean secondLockTaken = false;
		while (true) {
			try {
			firstLockTaken = lock1.tryLock();
			secondLockTaken = lock2.tryLock();
			} finally { // unlock always in finally block
				if(firstLockTaken && secondLockTaken) {
					return;
				} else {
					if(firstLockTaken) { 
						lock1.unlock(); // unlock always in finally block
					}
					if (secondLockTaken) {
						lock2.unlock(); // unlock always in finally block
					}
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void firstThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			takeLocks(lock1, lock2);
			try {
			Account.transfer(account1, account2, random.nextInt(100));
			} finally { // unlock always in finally block
			lock1.unlock(); // unlock always in finally block
			lock2.unlock(); // unlock always in finally block
			}
		}	
	}
	
	public void secondThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			takeLocks(lock2, lock1);
			 
			try {
			Account.transfer(account2, account1, random.nextInt(100));  
			} finally { // unlock always in finally block
			lock1.unlock(); // unlock always in finally block
			lock2.unlock(); // unlock always in finally block
			}
		}
	}
	
	public void finished() {
		System.out.println(account1.getBalance());
		System.out.println(account2.getBalance());
		System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
	}
}

class Account {
	private int balance = 10000;
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
	}
