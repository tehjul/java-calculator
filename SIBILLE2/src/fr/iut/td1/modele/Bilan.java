package fr.iut.td1.modele;

import fr.iut.td1.miscs.Observable;

public class Bilan extends Observable{
	
	public Bilan() {
		super();
		System.out.println("dans constructeur de Bilan");
	}
	
	public void setChange() {
		System.out.println("dans méthode setChange .. le bilan est à jour ..");
		notify1();
	}

}
