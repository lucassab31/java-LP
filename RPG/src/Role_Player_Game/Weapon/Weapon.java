package Role_Player_Game.Weapon;

import Role_Player_Game.Entity.Entity;

public abstract class Weapon {
	
	private String name;
	private float price;
	private int damage;

	public Weapon(String n, float p, int d) {
		this.name = n;
		this.price = p;
		this.damage = d;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public float getDamage() {
		return this.damage;
	}

	public void attack(Entity e) {	
		e.loseLife(this.damage);
 	}
	
	public abstract String ascii_art();
}
