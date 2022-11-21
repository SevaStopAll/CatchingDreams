package TestPackage;

public enum MusicGenre {
	RockMusic("РОК"), ClassicalMusic("Классика"), RapMusic("РЕП");
	
	private String translation;
	
	MusicGenre(String translation) {
		this.translation = translation;
	}
	
	public String getTranslation() {
		return translation;
	}
}
