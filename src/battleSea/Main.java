package battleSea;

import java.util.Scanner;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Generating enemy's field");
		int counter = 1;
		HashSet <String> turns = new HashSet<>();
		HashSet <String> turns1 = new HashSet<>();
		int [][] EnemySea = new int [5][5];
		for (int i = 0; i < 5; i++) {
			for (int q = 0; q < 5; q++) {
				EnemySea [i][q] = (int)Math.round(Math.random());
			}
		}
		
		System.out.println("Generating your field");
		int [][] YourSea = new int [5][5];
		for (int i = 0; i < 5; i++) {
			for (int q = 0; q < 5; q++) {
				YourSea [i][q] = (int)Math.round(Math.random());
			}
		}
				
		while(!(getShips(EnemySea) == 0)&& !(getShips(YourSea) == 0)) {
			System.out.println("Turn " + counter);
			counter++;
			System.out.println("Choose your target");
			int height = sc.nextInt();
			int weight = sc.nextInt();
			int [] turn = new int [2];
			turn[0] = height;
			turn[1] = weight;
			String aTurn = turn[0] + " " + turn[1];
			if (!turns.contains(aTurn)) {
				turns.add(aTurn);
				if(EnemySea[turn[0] - 1][turn[1] - 1] == 1) {
					EnemySea[turn[0] - 1][turn[1] - 1] = 0;
					System.out.println("Got it");
					System.out.println("Enemy's ships left " + getShips(EnemySea));
				}
			} else {
				System.out.println("You did this turn before");
			}
			System.out.println("Enemy's turn");
			int [] turn1 = new int[2];
			turn1[0] = (int)(1 + Math.random() * 5);
			turn1[1] = (int)(1 + Math.random() * 5);
			String aTurn1 = turn1[0] + " " + turn[1];
			if(!turns1.contains(aTurn1)) {
				turns1.add(aTurn1);
				if(YourSea[turn1[0] - 1][turn1[1] - 1] == 1) {
					YourSea[turn1[0] - 1][turn1[1] - 1] = 0;
					System.out.println("Enemy got it");
					System.out.println("Your ships left " + getShips(YourSea));
				}
			}
			else {
				System.out.println("Enemy's second chance");
				turn1[0] = (int)(1 + Math.random() * 5);
				turn1[1] = (int)(1 + Math.random() * 5);
				String aTurn2 = turn1[0] + " " + turn[1];
				if(!turns1.contains(aTurn2)) {
					turns1.add(aTurn2);
					if(YourSea[turn1[0] - 1][turn1[1] - 1] == 1) {
						YourSea[turn1[0] - 1][turn1[1] - 1] = 0;
						System.out.println("Enemy got it");
					}
				}
			}
			
			if (getShips(EnemySea) == 0) {
				System.out.println("You win!");
				sc.close();
			}
			if (getShips(YourSea) == 0) {
				System.out.println("You lose");
				sc.close();
			}
		}
	}
	
	public static int getShips(int [][] list) {
		int ships = 0;
		for (int i = 0; i < 5; i++) {
			for (int q = 0; q < 5; q++) {
				ships+= list[i][q];
			}
		}
		return ships;
	}

}
