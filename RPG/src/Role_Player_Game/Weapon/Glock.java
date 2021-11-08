package Role_Player_Game.Weapon;

public class Glock extends Weapon {

	public Glock(float p, int d) {
		super("Glock", p, d);
	}

	public String ascii_art() {
		return 
				" +--^----------,--------,-----,--------^-,\n" +
				"| |||||||||   `--------'     |          O\n" +
				" `+---------------------------^----------|\n" +
				"   `\\_,---------,---------,--------------'\n" +
				"     / XXXXXX /'|       /'\n" +
				"    / XXXXXX /  `\\    /'\n" +
				"   / XXXXXX /`-------'\n" +
				"  / XXXXXX /\n" +
				" / XXXXXX /\n" +
				"(________(\n" +
				" `------'\n";
	}
}