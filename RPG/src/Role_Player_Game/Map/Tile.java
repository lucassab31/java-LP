package Role_Player_Game.Map;

import Role_Player_Game.Entity.Entity;;

public class Tile {

	private int x;
	private int y;
	private String type;
	private Entity entity;

	public Tile(int x, int y, Entity e) {
		this.x = x;
		this.y = y;
		this.entity = e;
		this.type = this.entity.getType();
	}
	
	public Tile(int x, int y, String t) {
		this.x = x;
		this.y = y;
		this.entity = null;
		this.type = t;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Entity getEntity() {
		return this.entity;
	}

	public String getType() {
		return this.type;
	}
	
	public boolean canMove(String direction) {
		switch (direction) {
			case "z":
				return this.y - 1 >= 0;
			case "q":
				return this.x - 1 >= 0;
			case "d":
				return this.x + 1 <= 19;
			case "s":
				return this.y + 1 <= 19;
	
			default:
				return false;
		}
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
