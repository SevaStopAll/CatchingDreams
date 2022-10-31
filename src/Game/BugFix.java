package Game;


public class BugFix {
	public static void main(String [] args) throws InterruptedException {
		System.out.println("Hi! " + Thread.currentThread().getName());
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		myThread.join();
		
		Thread t2 = new Thread(new MyThreadRunnable());
		t2.start();

		
		System.out.println("Main thread is dead");
	}
}

class MyThread extends Thread {
	int x = 0;
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
		System.out.println(i + " " + Thread.currentThread().getName());

	}
}
}

class MyThreadRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
		System.out.println(i + " " + Thread.currentThread().getName());
		}
	}
}

// thread status new, ready, running, blocked, dead
// Thread.sleep(), Thread.yield.(), join();
