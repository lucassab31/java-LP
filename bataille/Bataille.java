package bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Bataille {

	public static void main(String[] args) {		
		//Création du paquet de cartes
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		//Pour toute les valeurs de carte
		for (int i : Carte.valeurs) {
			//Pour toute les couleurs
			for (Couleur c : Couleur.values()) {
				cartes.add(new Carte(c, i));
			}
		}
		//Mélange du paquet
		Collections.shuffle(cartes);
		
		//Split du paquet en 2 pour chaque joueur
		Joueur j1 = new Joueur(cartes.subList(0, cartes.size()/2));
		Joueur j2 = new Joueur(cartes.subList(cartes.size()/2, cartes.size()));
		
		int tour = 0;
		
		while (j1.hasCartes() && j2.hasCartes()) {
			tour++;
			
			//Chaque joueur pose une carte sur la table
			Carte c1 = j1.tirerCarte();
			Carte c2 = j2.tirerCarte();
			
			//Comparaison des cartes
			switch (c1.compareTo(c2)) {
				//Carte du joueur 1 est égale à celle du joueur 2, j1 et j2 prennent la carte de l'autre
				case -1:
					j1.ajouterCarte(c2);
					j2.ajouterCarte(c1);
					System.out.println("C1 = C2");
					break;
				//Carte du joueur 2 est supérieur à celle du joueur 1, j2 récupère les cartes
				case 0:
					j2.ajouterCarte(c1);
					j2.ajouterCarte(c2);
					System.out.println("C1 < C2");
					break;
				//Carte du joueur 1 est supérieur à celle du joueur 2, j2 récupère les cartes
				case 1:
					j1.ajouterCarte(c1);
					j1.ajouterCarte(c2);
					System.out.println("C2 < C1");
					break;
			}
		}
		
		if (!j1.hasCartes()) {
			System.out.println("Le joueur 2 gagne en " + tour + " de tours");
		} else if (!j2.hasCartes()) {
			System.out.println("Le joueur 1 gagne en " + tour + " de tours");
		} else {
			System.out.println("Problème");
		}
	}

}
