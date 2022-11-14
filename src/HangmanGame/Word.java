package HangmanGame;

import java.util.Scanner;

public class Word {
	char [] letters;
	boolean isGuessed = false;
	char [] empty;
	
	public Word(char [] letters, char [] empty) {
		this.letters = letters;
		this.empty = empty;
	}
	
	public void initialise() {
		System.out.println(empty);
	}
	
	public void guess(String string) {
		for (int i = 0; i < letters.length; i++) {
			if (string.charAt(0) == letters[i]) {
				empty[i] = string.charAt(0);
			} else {
				break;
			}
		}
	}
	
	public void check() {
		for (int i = 0; i < letters.length; i++) {
			if (empty[i] == '-') {
				break;
			} else {
				System.out.println("Next one");
			}
		}
	}
	
	public void realise(Word word) {
		Scanner sc = new Scanner(System.in);
		while(!word.isGuessed) {
			word.guess(sc.nextLine());
			System.out.println(empty); 
			System.out.println(letters);
			word.check();
		}
		sc.close();
	}
}
