package catchingDreams;

import java.util.Locale;
import java.util.Scanner;

import java.io.*;
import java.text.NumberFormat;

public class CurrencyConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double valueOf = sc.nextDouble();
		Money my = new Money(valueOf);
		System.out.println(my.conversation());
		sc.close();
	}

	public static class Money {
		double summ;

		public Money(double summ) {
			this.summ = summ;
		}

		public void setMoney(double summ) {
			this.summ = summ;
		}

		public String conversation() {
			System.out.println("Please, choose currency to convert in");
			System.out.println("1 - USD, 2 - EUR, 3 - CNY");
			Scanner sc = new Scanner(System.in);
			int currency = sc.nextInt();
			sc.close();
			String finSumm = "";
			switch (currency) {
			case (1):
				finSumm = NumberFormat.getCurrencyInstance(Locale.US).format(summ / 10);
			System.out.println("Press 'F' and Enter to quit to menu");
			sc.next();
				break;
			case (2):
				finSumm = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(summ / 20);
			System.out.println("Press 'F' and Enter to quit to menu");
			sc.next();
				break;
			case (3):
				finSumm = NumberFormat.getCurrencyInstance(Locale.CHINA).format(summ / 8);
			System.out.println("Press 'F' and Enter to quit to menu");
			sc.next();
				break;
			}
			return finSumm;
		}
	}

}