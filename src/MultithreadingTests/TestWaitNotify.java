package MultithreadingTests;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestWaitNotify {
	
	public static void main (String [] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}); 
		Thread thread2 = new Thread(new Runnable() { 
				@Override
				public void run() {
					try {
						pc.consume();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}	
		});
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
		
}

class ProducerConsumer {
	private Queue<Integer> queue = new LinkedList<>();
	private final int LIMIT = 10;
	private final Object lock = new Object();
	
	public void produce () throws InterruptedException {
		int value = 0;
		
		while(true) {
			synchronized(lock) { 
				while (queue.size() == LIMIT) {
					lock.wait();
				}
				queue.offer(value++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(lock) {
				while (queue.size() == 0) {
					lock.wait();
				}
					
				int value = queue.poll();
				System.out.println(value);
				System.out.println("Queue size is " + queue.size());
				lock.notify();
			}
			Thread.sleep(1000);
			
		}
	}
}