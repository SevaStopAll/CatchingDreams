package Algorythmes;
 

public class fibanaciNum {
	public static void main(String[] args) {
		 int n = 841645;
		 System.out.println(fibNew(n));
	}
	

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

