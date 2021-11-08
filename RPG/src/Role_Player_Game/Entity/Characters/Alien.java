package Role_Player_Game.Entity.Characters;

public class Alien extends Character {

	public Alien(String name) {
		super(name, 230, 150, 150, "A");
	}

	@Override
	public String toString() {
		return "Alien [" + this.name + ", " + this.money + "€, " + this.xp + "xp]";
	}
}
