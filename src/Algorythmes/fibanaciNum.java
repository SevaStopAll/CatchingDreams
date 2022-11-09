package Algorythmes;
 

public class fibanaciNum {
	public static void main(String[] args) {
		// int n = 841645;
		// System.out.println((n));
	}
	

}



/* Первый, медленный вариант алгоритма (дерево рекурсивных вызовов)
public static int fibRecurcive(int n) {
	if (n <= 1) 
		return n;
	 return fibRecurcive(n-1) + fibRecurcive(n-2);
	}
	*/


/* Второй, быстрый вариант алгоритма (через создание массива O (2n) строк кода)
public static int fibNew(int n) {
		int [] mas = new int [n+1];
		mas[0] = 0;
		mas[1] = 1;
		for (int i = 2; i <= n; i++) {
		mas[i] = (mas[i-1] % 10 + mas[i-2] % 10) % 10;
		}
		return mas[n];
	}
}
	*/



/*Третий варинт через  Map и BigInteger 

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


/* 3 доработанный вариант для уменьшения количества рекурсивных вызовов и без переполнения стека (
public class Fibonacci {
	
	Map<Integer, BigInteger> cashe = new HashMap<>();
	
	private BigInteger fibonacci(int n) {
		if (n < 2) {
			return BigInteger.valueOf(n);
		}
		if (cashe.containsKey(n)) {
			return cashe.get(n);
		} else {
			for (int  i= 2; i <= n; i++) {
			BigInteger res = fibonacci(i-1).add(fibonacci(i-2));
			cashe.put(i, res);
			}
			return cashe.get(n);
			
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


/* 4 доработанный вариант через ArrayList (
public class Fibonacci {

	private static final int MOD = (int)1e9 + 7;
	
	List <Integer> cashe = new ArrayList<>();
	
	{
	cashe.add(0);
	cashe.add(1);
	}
	
	private int fibonacci(int n) {
		
			for (int  i= case.size(); i <= n; i++) {
				int res = (cashe.get(i - 1) + cashe.get(i - 2)) % MOD;
				cashe.add(res);
		}
		return cashe.get(n)
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


/* 5 доработанный вариант без кэша (
public class Fibonacci {

	private static final int MOD = (int)1e9 + 7;
	int a = 0;
	int b = 1;
	
	for (int i = 0; i < n; i++) {
	int c = (a+b) % MOD;
	a = b;
	b = c;
	}	
 	return a;
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



/* Последняя цифра числа Фибонначи.
public static int fibNew(int n) {
		int [] mas = new int [n+1];
		mas[0] = 0;
		mas[1] = 1;
		for (int i = 2; i <= n; i++) {
		mas[i] = (mas[i-1] % 10 + mas[i-2] % 10) % 10;
		}
		return mas[n];
	}
*/

