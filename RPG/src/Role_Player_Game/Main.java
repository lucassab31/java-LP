package Role_Player_Game;

import java.util.ArrayList;
import java.util.Scanner;

import Role_Player_Game.Weapon.AK47;
import Role_Player_Game.Weapon.Glock;
import Role_Player_Game.Weapon.M4A1S;
import Role_Player_Game.Weapon.Weapon;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Weapon> w = new ArrayList<Weapon>();
		w.add(new AK47(60, 80));
		w.add(new M4A1S(45, 65));
		w.add(new Glock(20, 25));
		Game g = new Game(sc, w);
		g.play();
	}
}
