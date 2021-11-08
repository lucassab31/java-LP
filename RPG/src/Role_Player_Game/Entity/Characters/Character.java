package Role_Player_Game.Entity.Characters;

import java.util.ArrayList;
import java.util.Scanner;

import Role_Player_Game.Entity.Entity;
import Role_Player_Game.Entity.Desctructibles.Monster;
import Role_Player_Game.Weapon.Weapon;

public class Character extends Entity {
	
	protected String name;
	protected double money;
	protected ArrayList<Weapon> inventory;

	public Character(String name, double l, double m, double xp, String t) {
		this.name = name;
		this.life = l;
		this.money = m;
		this.xp = xp;
		this.inventory = new ArrayList<Weapon>();
		this.type = t;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMoney() {
		return this.money;
	}

	public ArrayList<Weapon> getInventory() {
		return this.inventory;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void buy(Weapon w) {
		this.money -= w.getPrice();
		this.inventory.add(w);
	}

	@Override
	public String toString() {
		return "Personnage [" + this.name + ", " + this.money + "€, " + this.xp + "xp]";
	}

	@Override
	public void loseLife(double d) {
		this.life -= d;	
	}
	
	public boolean fight(Scanner sc, Entity e) {
		while (this.life > 0 && e.getLife() > 0) {
			this.inventory.get(this.inventory.indexOf(this.chooseWeapon(sc))).attack(e);
			if (e instanceof Monster) {
				Monster m = (Monster) e;
				this.loseLife(m.getDamage());
			}
		}
		if (e.getLife() <= 0) {
			this.xp += e.getXp();
			System.out.println("Vous avez gagné le combat et remporté " + e.getXp() + "xp");
			return true;
		} else {
			System.out.println("Vous êtes mort avec " + this.xp + "xp");
			return false;
		}
	}
	
	private Weapon chooseWeapon(Scanner sc) {
		int action;
		do {
			System.out.println("Quel arme vouelez-vous utiliser :");
			int i = 0;
			for (Weapon w : this.inventory) {
				System.out.println(i++ + " - " + w.getName());
			}
			action = sc.nextInt();
		} while (action < 0 || action > this.inventory.size());
		return this.inventory.get(action);
	}
}
