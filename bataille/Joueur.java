package bataille;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
	private List<Carte> cartes;
	
	Joueur(List<Carte> c) {
		this.cartes = new ArrayList<Carte>();
		this.cartes.addAll(c);
		System.out.println(this.cartes);
	}
	
	public void ajouterCarte(Carte c) {
		this.cartes.add(c);
	}
	
	public Carte tirerCarte() {
		Carte c = this.cartes.get(0);
		this.cartes.remove(0);
		return c;
	}
	
	public boolean hasCartes() {
		return !this.cartes.isEmpty();
	}
}
