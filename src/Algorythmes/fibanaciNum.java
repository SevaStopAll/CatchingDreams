package Algorythmes;


// Последний вариант. Избавились от длинных чисел, находя число по модулю. А также избавились от кэша через выполнения одной и той же операции (подсчета С и сдвига А В) n раз. 
public class fibanaciNum {
	
	private static final int MOD = (int) (1e9 + 7);
	

	private int fibonacci(int n) {
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
		System.out.println(n + ": " +fibonacci(n));
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new fibanaciNum().run(100000);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");
		}
	
}





/* Первый, медленный вариант алгоритма (дерево рекурсивных вызовов), кол-во рекусивных вызовов
 * растет очень быстро, что влияет на скорость работы. 
public class fibanaciNum {
	
	int cnt;
	
	private int fibonacci(int n) {
		cnt++;
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
 	
	private void run(int n) {
		System.out.println(n + ": " +fibonacci(n));
		System.out.println(cnt + " calls");
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
		long startTime = System.currentTimeMillis();
		new fibanaciNum().run(i);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");
	}
	}
	
}
	*/


/* Второй, быстрый вариант алгоритма (через создание массива O (2n) строк кода)
public static int fibNew(int n) {
		int [] mas = new int [n+1];
		mas[0] = 0;
		mas[1] = 1;
		for (int i = 2; i <= n; i++) {
		mas[i] = (mas[i-1] + mas[i-2]);
		}
		return mas[n];
	}
}
	*/


/*Третий вариант через Кэш в виде HashMap (на основе Хэш таблицы)
 * // Время изменилось радикально, 1000 число Фибоначчи вычисляется за 4 мс.
И из-за переполнения типов int long мы взяли BigInteger(число хранится как массив 
символов). 
public class fibanaciNum {
	
	Map<Integer, BigInteger> cache = new HashMap<>();
	
	int cnt;
	
	private BigInteger fibonacci(int n) {
		cnt++;
		if (n < 2) {
			return BigInteger.valueOf(n);
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
		BigInteger res = fibonacci(n - 1).add(fibonacci(n - 2));
		cache.put(n, res);
		return res;
		}
	}
 	
	private void run(int n) {
		System.out.println(n + ": " +fibonacci(n));
		System.out.println(cnt + " calls");
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new fibanaciNum().run(10000);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");
		}
	
}

 */


/* Четвертый вариант 
 * // А теперь, после 1000 числа Фибоначчи у Java переполняется стек. Нам нужно уменьшить количество рекурсивных вызовов. Мы сначала будем вычислять меньшее, а потом большее.
// Теперь 100000 число Фибоначчи вычисляется за 1 секунду (320 мс) без переполнения стека рекурсивными вызовами (199999 вызовов)
public class fibanaciNum {
	
	Map<Integer, BigInteger> cache = new HashMap<>();
	
	int cnt;
	
	private BigInteger fibonacci(int n) {
		cnt++;
		if (n < 2) {
			return BigInteger.valueOf(n);
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			for (int i = 2; i <= n; i++) {
				BigInteger res = fibonacci(i - 1).add(fibonacci(i - 2));
				cache.put(i, res);
			}
			return cache.get(n);
		}
	}
 	
	private void run(int n) {
		System.out.println(n + ": " +fibonacci(n));
		System.out.println(cnt + " calls");
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new fibanaciNum().run(100000);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");
		}
	
}
 */


/*
 * 
 * // А теперь, после 1000 числа Фибоначчи у Java переполняется стек. Нам нужно уменьшить количество рекурсивных вызовов. Мы сначала будем вычислять меньшее, а потом большее.
// Теперь 100000 число Фибоначчи вычисляется за 1 секунду (320 мс) без переполнения стека рекурсивными вызовами (199999 вызовов).
// Чтобы избавиться от длинной арифметики мы взяли число по модулю, который мы посчитали константой MOD. 
public class fibanaciNum {
	
	private static final int MOD = (int) (1e9 + 7);
	
	List<Integer> cache = new ArrayList<>();
	
	{
		cache.add(0);
		cache.add(1);
	}
	
	private int fibonacci(int n) {
		for (int i = cache.size(); i <= n; i++) {
			int res = (cache.get(i - 1) + (cache.get(i - 2))) % MOD;
			cache.add(res);
		}
		return cache.get(n);
	}
 	
	private void run(int n) {
		System.out.println(n + ": " +fibonacci(n));
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new fibanaciNum().run(100000);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");
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

