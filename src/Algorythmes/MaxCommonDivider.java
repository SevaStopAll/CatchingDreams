package Algorythmes;

import java.util.Scanner;

public class MaxCommonDivider {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(maxDivider(a, b));
	}
	
public static int maxDivider(int a, int b) {
		
		if (b == 0) {
			return a;
		}
		else {
			return maxDivider(b, (a%b));
		}	
	}

}


