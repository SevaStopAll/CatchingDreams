package MultithreadingTests;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Problem1 {
	private Lock lock = new ReentrantLock();
	static int [] mass = new int [1000]; 
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		Problem1 problem = new Problem1();
		problem.initialize();
		// problem.findMin();
		// problem.findMax();
		
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				problem.findMax();		
			}
		});
	
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				problem.findMin();
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
		
		long finish = System.currentTimeMillis();
		System.out.println(finish - start + " ms");
	}	
		
	
	public void initialize() {
		Random random = new Random();
		for (int i = 0; i < mass.length; i++) 
			mass[i] = random.nextInt(100) + 1;
	}
	
	public void findMax() {
		lock.lock();
		int max = 0;
		for (int i = 0; i < mass.length; i++) {
			if (mass[i] > max) {
				max = mass[i];
			}
		}
		System.out.println(max);
		lock.unlock();
	}
	
	public void findMin() {
		lock.lock();
		int min = 11;
		for (int i = 0; i < mass.length; i++) {
			if (mass[i] < min) {
				min = mass[i];
			}
		}
		System.out.println(min);
		lock.unlock();
	}
}
	
	

