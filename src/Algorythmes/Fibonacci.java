package Algorythmes;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*Cashe with Map and BigInteger 

public class Fibonacci {
	
	Map<Integer, BigInteger> cashe = new HashMap<>();
	
	private BigInteger fibonacci(int n) {
		if (n < 2) {
			return BigInteger.valueOf(n);
		}
		if (cashe.containsKey(n)) {
			return cashe.get(n);
		} else {
			BigInteger res = fibonacci(n-1).add(fibonacci(n-2));
			cashe.put(n, res);
			return res;
		}
	}
	private void run(int n) {
		System.out.println(fibonacci(n));
		
	}
	public static void main(String [] args) {
		long startTime = System.currentTimeMillis();
		new Fibonacci().run(10);
		long finishTime = System.currentTimeMillis();
		System.out.println(startTime - finishTime);
	}
}
*/
