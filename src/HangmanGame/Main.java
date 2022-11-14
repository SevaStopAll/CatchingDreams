package HangmanGame;

public class Main {
	public static void main(String [] args) {

		char [] english = {'e','n','g','l','i','s','h'};
		char [] englishEmpty = {'-', '-', '-', '-', '-','-','-'};
		Word English = new Word(english, englishEmpty);
		English.initialise();
		English.realise(English);
	}
}
