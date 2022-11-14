package CatchingDreamsDuelGame;

public class GameItself {

	public static void main(String[] args) {
		Cowboy player = new Cowboy("Player");
		NPC enemy = new NPC("Enemy");
		player.Duel(player, enemy);

	}
}
