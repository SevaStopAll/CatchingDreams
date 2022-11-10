package Algorythmes;
 

public class fibanaciNum {
	public static void main(String[] args) {
		System.out.println(fibNew(20));
	}
	
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
		mas[i] = (mas[i-1] + mas[i-2]) % 10;
		}
		return mas[n];
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

