package Role_Player_Game.Map;

import java.util.Random;
import java.util.Scanner;

import Role_Player_Game.Entity.Entity;
import Role_Player_Game.Entity.Characters.Character;
import Role_Player_Game.Entity.Desctructibles.Monster;
import Role_Player_Game.Entity.Desctructibles.Obstacle;

public class Map {
	
	public final int MONSTERS = 22;
	public final int OBSTACLES = 38;
	private Scanner sc;
	
	private Tile [][] map = new Tile[20][20];
	private Tile player;

	public Map(Scanner sc, Character player) {
		this.sc = sc;
		for (int y=0; y < this.map[0].length; y++) {
			for (int x=0; x < this.map.length; x++) {
				this.map[x][y] = new Tile(x, y, ".");
			}
		}
		this.monstersGeneration();
		this.obstaclesGeneration();
		this.player = new Tile(0, this.map[0].length-1, player);
		this.map[0][this.map[0].length-1] = this.player;
		this.fight();
	}
	
	private void monstersGeneration() {
		int occupiedSpots = 0;
		Random random = new Random();

		while(occupiedSpots < this.MONSTERS){
		    int x = random.nextInt(this.map.length);
		    int y = random.nextInt(this.map[0].length);
		    if(this.map[x][y].getType() == "."){
		        this.map[x][y] = new Tile(x, y, new Monster(30));
		        occupiedSpots++;
		    }
		}
	}
	
	private void obstaclesGeneration() {
		int occupiedSpots = 0;
		Random random = new Random();

		while(occupiedSpots < this.OBSTACLES){
		    int x = random.nextInt(this.map.length);
		    int y = random.nextInt(this.map[0].length);
		    if(this.map[x][y].getType() == "."){
		        this.map[x][y] = new Tile(x, y, new Obstacle());
		        occupiedSpots++;
		    }
		}
	}
	
	public void displayMap() {
		for (int y=0; y < this.map[0].length; y++) {
			for (int x=0; x < this.map.length; x++) {
				System.out.print(this.map[x][y].getType());
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean movePlayer(String direction) {
		if (this.player.canMove(direction)) {
			int x = this.player.getX();
			int y = this.player.getY();
			int newX = x;
			int newY = y;
			switch (direction) {
				case "z":
					this.map[x][y-1] = this.player;
					newY--;
					break;
				case "s":
					this.map[x][y+1] = this.player;
					newY++;
					break;
				case "q":
					this.map[x-1][y] = this.player;
					newX--;
					break;
				case "d":
					this.map[x+1][y] = this.player;
					newX++;
					break;
				
				default:
					break;
			}
			this.map[x][y] = new Tile(x, y, ".");
			this.player.move(newX, newY);
			if (newX == 19 && newY == 0) {
				System.out.println("Vous avez terminé votre aventure");
				return true;
			}
			this.fight();
			return true;
		} else if (direction != "start"){
			System.out.println("Vous ne pouvez pas vous déplacer par ici");
			return false;
		} else {
			return false;
		}
	}
	
	public void fight() {
		Character p = (Character) this.player.getEntity();
		if (this.player.getX()+1 <= 19) {
			int x = this.player.getX()+1;
			int y = this.player.getY();
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Tu viens de rencontrer une obstacle/monstre, tu dois te battre");
				if (p.fight(this.sc, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
		if (this.player.getX()-1 >= 0) {
			int x = this.player.getX()-1;
			int y = this.player.getY();
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Tu viens de rencontrer une obstacle/monstre, tu dois te battre");
				if (p.fight(this.sc, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
		if (this.player.getY()+1 <= 19) {
			int x = this.player.getX();
			int y = this.player.getY()+1;
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Tu viens de rencontrer une obstacle/monstre, tu dois te battre");
				if (p.fight(this.sc, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
		if (this.player.getY()-1 >= 0) {
			int x = this.player.getX();
			int y = this.player.getY()-1;
			Entity e = this.getEntityXY(x, y);
			if (e != null) {
				System.out.println("Tu viens de rencontrer une obstacle/monstre, tu dois te battre");
				if (p.fight(this.sc, e)) {
					this.map[x][y] = new Tile(x, y, "X");
				}
			}
		}
	}
	
	private Entity getEntityXY(int x, int y) {
		return this.map[x][y].getEntity();
	}
}
