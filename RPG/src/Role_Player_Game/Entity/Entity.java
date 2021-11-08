package Role_Player_Game.Entity;

public abstract class Entity {
	
	protected double life;
	protected double xp;
	protected String type;
	
	public double getLife() {
		return this.life;
	}
	
	public double getXp() {
		return this.xp;
	}
	
	public String getType() {
		return this.type;
	}
	
	public abstract void loseLife(double d);
}
