package TestPackage;

public enum MusicGenre {
	RockMusic("���"), ClassicalMusic("��������"), RapMusic("���");
	
	private String translation;
	
	MusicGenre(String translation) {
		this.translation = translation;
	}
	
	public String getTranslation() {
		return translation;
	}
}
