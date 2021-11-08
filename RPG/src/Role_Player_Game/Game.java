package Role_Player_Game;

import java.util.ArrayList;
import java.util.Scanner;

import Role_Player_Game.Entity.Characters.Alien;
import Role_Player_Game.Entity.Characters.Character;
import Role_Player_Game.Entity.Characters.Humain;
import Role_Player_Game.Map.Map;
import Role_Player_Game.Weapon.Glock;
import Role_Player_Game.Weapon.Weapon;
import Role_Player_Game.Weapon.WeaponShop;

public class Game {
	
	private Scanner sc;
	private Map map;
	private WeaponShop shop;
	private Character player;

	public Game(Scanner sc, ArrayList<Weapon> w) {
		this.sc = sc;
		System.out.println("Bienvenu jeune joueur/se, il est temps de commencer ton aventure");
		
		this.player = this.characterCreation();
		this.player.buy(new Glock(20, 25));
		System.out.println(this.player);
		
		this.map = new Map(this.sc, this.player);
		this.map.displayMap();
		this.shop = new WeaponShop(w);
	}

	public Character characterCreation() {
		int character = 0;
		Character player = null;
		do {
			System.out.println("Tu vas devoir te battre pour survivre, pour cela choisi un personnage qui te correspond :");
			System.out.println(" 1 - Humain");
			System.out.println(" 2 - Alien");
			character = this.sc.nextInt();
		} while (character != 1 && character != 2);
		System.out.println("Choisi un nom de personnage : ");
		this.sc.nextLine();
		String name = this.sc.nextLine();
		switch (character) {
			case 1:
				player = new Humain(name);
				break;
	
			case 2:
				player = new Alien(name);
				break;
			default:
				System.out.println("Choisissez le nombre correspondant à une personnage");
				break;
		}
		return player;
	}
	
	public void play() {
		System.out.println("La partie commence, bon courage !");
		while (this.player.getLife() > 0) {		
			int action;
			do {
				System.out.println("Que souhaite-tu faire :");
				System.out.println(" 1 - Acheter des armes");
				System.out.println(" 2 - Te déplacer");
				action = this.sc.nextInt();
			} while (action != 1 && action != 2);
			this.sc.nextLine();
			
			//Achat armes
			if (action == 1) {
				this.shop();
			}
			
			//Déplacement
			if (action == 2) {
				this.move();
			}
		}
		System.out.println("Fin de la partie");
	}
	
	private void shop() {
		int action;
		do {
			this.shop.displayShop();
			System.out.println("Quelle arme voulez-vous acheter :");
			action = this.sc.nextInt();
		} while (action < 0 || action > this.shop.getNumberOfItems());
		this.sc.nextLine();
		this.player.buy(this.shop.getWeapon(action));
		System.out.println("Vous venez d'acheter une arme pour " + this.shop.getWeapon(action).getPrice() + "€");
		System.out.println("Il vous reste " + this.player.getMoney() + "€");
	}
	
	private void move() {
		String direction = "start";
		while (!this.map.movePlayer(direction)) {
			do {
				System.out.println("Choisi une direction :");
				System.out.println(" z - En haut");
				System.out.println(" q - A gauche");
				System.out.println(" s - A gauche");
				System.out.println(" d - En bas");
				direction = this.sc.nextLine();
			} while (direction == "z" || direction == "q" || direction == "s" || direction == "d");
		}
		this.map.displayMap();
		System.out.println(this.player);
	}
}
