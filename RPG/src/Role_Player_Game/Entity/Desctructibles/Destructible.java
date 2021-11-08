package Role_Player_Game.Entity.Desctructibles;

import Role_Player_Game.Entity.Entity;;

public class Destructible extends Entity {
	
	final double RATIO = 1;

	public Destructible(double l, String t, double xp) {
		this.life = l;
		this.type = t;
		this.xp = xp;
	}
	
	public String getType() {
		return this.type;
	}

	@Override
	public void loseLife(double d) {
		this.life -= d;	
	}
}
