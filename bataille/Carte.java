package bataille;


public class Carte {
	
	static int valeurs[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	
	private Couleur couleur;
	private int valeur;

	public Carte(Couleur c, int v) {
		this.couleur = c;
		this.valeur = v;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public int getValeur() {
		return valeur;
	}
	
	public int compareTo(Carte c) {
		return (this.valeur > c.valeur ? 1 : (this.valeur < c.valeur ? 0 : -1));
	}

	@Override
	public String toString() {
		return "Carte [couleur=" + this.couleur + ", valeur=" + this.valeur + "]";
	}
	
}
