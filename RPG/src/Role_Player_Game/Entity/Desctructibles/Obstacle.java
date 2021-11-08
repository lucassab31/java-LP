package Role_Player_Game.Entity.Desctructibles;

public class Obstacle extends Destructible {
	
	final double RATIO = 1.5;

	public Obstacle() {
		super(70, "o", 20);
	}
	
	public void loseLife(double d) {
		this.life -= d * this.RATIO;
	}
}
