package multiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Callable_FutureClasses {
	
	public static void main(String [] args) throws InterruptedException {
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(new Callable <Object>() {
			@Override
			public int call() throws Exception {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished");
				return  5;
				}
		}); 
		executorService.shutdown();
		
	
	public static int calculate() {
		return 5+ 4;
	}
}
