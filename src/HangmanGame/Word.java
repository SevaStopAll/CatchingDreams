package HangmanGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Word {

	static ArrayList <char []> words = new ArrayList<>();
	static ArrayList<char []> emptyWords = new ArrayList<>();
	char [] letters;
	boolean isGuessed = false;
	char [] empty;
	private int errors = 5;
	
	
	public Word() {
		int rand = (int)(Math.random() * (words.size()));
		this.letters = words.get(rand);
		this.empty = emptyWords.get(rand);
		errors = 5;
	}
	
	@Override
	public String toString() {
		return "Word [letters=" + Arrays.toString(letters) + "]";
	}
	
	public void guess(String string) {
		for (int i = 0; i < letters.length; i++) {
			if (string.charAt(0) == letters[i]) {
				empty[i] = string.charAt(0);
			} else {
				errors--;
			}
		}
	}
	
	public void errorsCheck(Word word) {
		if (word.errors == 0) {
			System.out.println("You lose");
			System.exit(0);
		}
	}
	public void check() {
		int guessedLetters = 0;	
			for (int i = 0; i < letters.length; i++) {
			if (empty[i] == '-') {
				continue;
			} else {
				guessedLetters++;
			}
			if (guessedLetters == letters.length) {
				System.out.println("You win");
				isGuessed = true;
			}
		}
			
	} 
	
	public void realise(Word word) {
		Scanner sc = new Scanner(System.in);
		while(!word.isGuessed) {
			word.guess(sc.nextLine());
			System.out.println(empty); 
			word.errorsCheck(word);
			word.check();
		}
		sc.close();
	}
	
	public static void initWords() {
		char [] english = {'e','n','g','l','i','s','h'};
		char [] englishEmpty = {'-', '-', '-', '-', '-','-','-'};
		char [] cat = {'c','a','t'};
		char [] catEmpty = {'-','-','-'};
		char [] school = {'s', 'c', 'h', 'o', 'o', 'l'}; 
		char [] schoolEmpty = {'-', '-', '-', '-', '-', '-'};
		words.add(english);
		emptyWords.add(englishEmpty);
		words.add(cat);
		emptyWords.add(catEmpty);
		words.add(school);
		emptyWords.add(schoolEmpty);
	}
}
