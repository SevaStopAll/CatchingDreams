package MultithreadingTests;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureAndCallable {
	
	public static void main(String [] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		// Lambda with Callable
		Future<Integer> future = executorService.submit(() -> {
				System.out.println("Starting");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished");
				Random random = new Random();
				int randomValue = random.nextInt();
				if(randomValue < 5) 
					throw new Exception("Something bad happened");
				
				return random.nextInt(10);		
		});
		
	/* Lambda with Runnable
	 * 	executorService.submit(() -> {	
				System.out.println("Hello from Thread");
			}
		);
	*/  
		executorService.shutdown();
		
		try {
			int result = future.get(); // get waits for thread ending;
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			Throwable ex = e.getCause();
			System.out.println(ex.getMessage());
		}
	}
	
}
