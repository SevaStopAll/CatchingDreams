package HangmanGame;

public class Main {
	public static void main(String [] args) {
		Word.initWords();
		Word word = new Word();
		word.realise(word);
	}
}
