package multiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Callable_FutureClasses {
	
	public static void main(String [] args) throws InterruptedException {
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(new Callable <Integer>() {
			@Override
			public Integer call() throws Execption {
				return null;
			}
		}); 
		executorService.shutdown();
		
	
	public static int calculate() {
		return 5+ 4;
	}
}
