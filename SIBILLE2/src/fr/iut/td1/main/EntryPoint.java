package fr.iut.td1.main;

import fr.iut.td1.interfaces.IObserver;
import fr.iut.td1.modele.Bilan;
import fr.iut.td1.vue.UIPhoneGraphe;
import fr.iut.td1.vue.UIWindowsGraphe;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		System.out.println("HELLO WORLD");
		System.out.println("----------------------------------------------");
		// Création du bilan
		Bilan bilan = new Bilan();
		bilan.setNum(1);
		System.out.println("----------------------------------------------");
		// Création du graphe
		IObserver graphe1 = new UIWindowsGraphe(1);
		IObserver graphe2 = new UIPhoneGraphe(2);
		IObserver graphe3 = new UIWindowsGraphe(3);
		// je rajoute mon graphe en tant qu'observateur
		// bilan est observé par UIGraphe
		bilan.addObserver(graphe1);
		bilan.addObserver(graphe2);
		bilan.addObserver(graphe3);
		// Bilan envoie l'ordre de changement aux observateurs
		bilan.setChange();
	}

}
