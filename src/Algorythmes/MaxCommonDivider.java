package Algorythmes;

import java.math.BigInteger;

public class MaxCommonDivider {
	
	private void run() {
		BigInteger a = new BigInteger("1474893273289574987509285029");
		BigInteger b = new BigInteger("1562553252514345363445");
		System.out.println(maxDivider(a,b));
		a.gcd(b);
	}
	
	private BigInteger maxDivider(BigInteger a, BigInteger b) {
		while (true) {
			System.out.println(a + " " + b);
			if (a.equals(BigInteger.ZERO)) return b;
			if (b.equals(BigInteger.ZERO)) return a;
			if (a.compareTo(b) >= 0) { 
				a = a.mod(b);
			} else {
				b = b.mod(a);
			}
		}
	}
		
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new MaxCommonDivider().run();
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");

	}
	}

/* Вариант с введения с преподавателем, где мы делим большее число на меньшее с остатком до тех пор, пока одно число не будет равно 0. 
 * public class MaxCommonDivider {
 * private void run(int a, int b) {
		System.out.println(maxDivider(a, b));
	}
	
	private int maxDivider(int a, int b) {
		
		if (b == 0) {
			return a;
		}
		else {
			return maxDivider(b, (a%b));
		}	
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new MaxCommonDivider().run(150, 15);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");

	}
	}
 */


/* Вариант решения через цикл, где мы идем от 1 до общего максимума из двух чисел. 
 * public class MaxCommonDivider {
	
	
	private void run(int a, int b) {
		System.out.println(maxDivider(a, b));
	}
	
	private int maxDivider(int a, int b) {
		int result = 0;
		for (int i = 1; i <= Math.max(a,b); i++) {
			if (a % i == 0 && b % i == 0) {
				result = i;
			}
		}
		return result;
	}
		

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new MaxCommonDivider().run(1241265745, 12345);
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");

	}

}
 */

/* Здесь мы применяем длинную арифметику. Избавились от хвостовой рекурсии.
 * public class MaxCommonDivider {
	
	private void run() {
		System.out.println(maxDivider(
				new BigInteger("1474893273289574987509285029"), 
				new BigInteger("1562553252514345363445"))
				);
	}
	
	private BigInteger maxDivider(BigInteger a, BigInteger b) {
		while (true) {
			System.out.println(a + " " + b);
			if (a.equals(BigInteger.ZERO)) return b;
			if (b.equals(BigInteger.ZERO)) return a;
			if (a.compareTo(b) >= 0) { 
				a = a.mod(b);
			} else {
				b = b.mod(a);
			}
		}
	}
		
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new MaxCommonDivider().run();
		long finishTime = System.currentTimeMillis();
		System.out.println(finishTime - startTime + "ms");

	}
	}
 */

