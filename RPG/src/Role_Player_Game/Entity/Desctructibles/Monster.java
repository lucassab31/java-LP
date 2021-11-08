package Role_Player_Game.Entity.Desctructibles;

public class Monster extends Destructible {
	
	final double RATIO = 1.2;
	private double damage;

	public Monster(double d) {
		super(100, "m", 50);
		this.damage = d;
	}
	
	public double getDamage() {
		return this.damage;
	}
	
	public void loseLife(double d) {
		this.life -= d * this.RATIO;
	}

}
