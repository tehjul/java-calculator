import java.util.*;

public class Sibille {
	
	private static final Random random = new Random();
	
	static void affiche(int[] tab) {
		for (int i: tab)
			System.out.print(i + " ");
		System.out.println();
	}
	
	static int[] genereMarqueurs(int m) {
		int[] marqueurs = new int[m];
		
		for (int i = 0; i < m; ++i) {
			int marqueur = random.nextInt(m*100);
			
			boolean ok = true;
			for (int j = 0; (j < i) && ok; ++j)
				ok = marqueurs[j] != marqueur;
			
			if (ok)
				marqueurs[i] = marqueur;
		}
		
		return marqueurs;
	}
	
	static int[] genereMarqueursPositifs(int[] marqueurs, int p) {
		int[] marqueursPositifs = new int[p], aux = new int[marqueurs.length];
		
		for (int i = 0; i < aux.length; ++i)
			aux[i] = i;
		
		for (int i = 0; i < p; ++i) {
			int j = random.nextInt(aux.length-i);
			marqueursPositifs[i] = marqueurs[aux[j]];
			aux[j] = aux[aux.length-i-1];
		}
		
		return marqueursPositifs;
	}
	
	static int[] tri(int[] tab) {
		int[] tabTrie = new int[tab.length];
		
		for (int i = 0; i < tab.length; ++i) 
			tabTrie[i] = tab[i];
		
		Arrays.sort(tabTrie);
		
		return tabTrie;
	}
	
	//////////////////////////////////////////////////////////////////
	
	static int somme(int a, int b) {
		if (b == 0) return a;
		else return somme(a+1, b-1);	
	}
	
	static boolean est_dans_liste(int a, int[] b) {
		for (int i=0; i<b.length; i++) {
			if (b[i] == a) return true;
		}
		return false;
	}
	
	static int[] rechercheMarqueursNegatifsV1(int[] marqueurs, int[] marqueursPositifs) {
		int longueur = marqueurs.length - marqueursPositifs.length;
		int[] resultat = new int[longueur];
		int pos = 0;
		int choix;
		
		for (int i=0; i<marqueurs.length; i++) {
			choix = marqueurs[i];
			if (! est_dans_liste(choix, marqueursPositifs)) {
				resultat[pos] = choix;
				pos++;
			}
			
				
			}
		
		
		return resultat;
		
	}

	static boolean est_dans_listeV2(int[] liste, int choix, int ideb, int ifin) {
		boolean trouve = false;
		int m;
		while (! trouve && ideb < ifin) {
			m = (ideb + ifin -1) / 2;
			if (liste[m] == choix) trouve = true;
			else if (choix < liste[m]) ifin= m;
			else ideb = m+1;
		}
		return trouve;
	}
	
	static int[] rechercheMarqueursNegatifsV2(int[] marqueurs, int[] marqueursPositifsTries) {
		int longueur = marqueurs.length - marqueursPositifsTries.length;
		int[] resultat = new int[longueur];
		int pos = 0;
		int choix;
		
		for (int i=0; i<marqueurs.length; i++) {
			choix = marqueurs[i];
			if (! est_dans_listeV2(marqueursPositifsTries, choix, 0, marqueursPositifsTries.length)) {
				resultat[pos] = choix;
				pos++;
			}
			
				
			}
		
		
		return resultat;
		
	}
	
	static boolean est_dans_listeV3(int[] liste, int choix, int ideb, int ifin) {
		int m;
		if (ideb >= ifin) return false;
		else {
			m = (ideb + ifin -1) / 2;
			if (choix == liste[m]) return true;
			else if (choix < liste[m]) return est_dans_listeV3(liste, choix, ideb, m);
			else return est_dans_listeV3(liste, choix, m+1, ifin);
		}
	}
	
	static int[] rechercheMarqueursNegatifsV3(int[] marqueursTries, int[] marqueursPositifsTries) {
	int longueur = marqueursTries.length - marqueursPositifsTries.length;
	int[] resultat = new int[longueur];
	int pos = 0;
	int choix;
	
	for (int i=0; i<marqueursTries.length; i++) {
		choix = marqueursTries[i];
		if (! est_dans_listeV3(marqueursPositifsTries, choix, 0, marqueursPositifsTries.length)) {
			resultat[pos] = choix;
			pos++;
		}
		
			
		}
	
	
	return resultat;
	
}

	
	public static void main(String[] args) {
		int a = 5, b = 8;
		int c = somme(a,b);
		System.out.println("La somme de "+a+" et "+b+" est égal à : "+c);
		System.out.println();
		
		System.out.println("Génération d'un tableau de 20 marqueurs :");
		int[] marqueurs = genereMarqueurs(20);
		affiche(marqueurs);
		System.out.println();
		System.out.println("Sélection de 7 marqueurs positifs :");
		int[] marqueursPositifs = genereMarqueursPositifs(marqueurs, 7);
		affiche(marqueursPositifs);
		System.out.println();
		
		int[]RechercheV1 = rechercheMarqueursNegatifsV1(marqueurs, marqueursPositifs);
		System.out.println("Sélection de marqueurs négatifs V1 :");
		affiche(RechercheV1);
		
		int[]marqueursPositifsTries = tri(marqueursPositifs);
		System.out.println();
		int[]RechercheV2 = rechercheMarqueursNegatifsV2(marqueurs, marqueursPositifsTries);
		System.out.println("Sélection de marqueurs négatifs V2 :");
		affiche(RechercheV2);
		
		int[]marqueursTries = tri(marqueurs);
		System.out.println();
		int[]RechercheV3 = rechercheMarqueursNegatifsV3(marqueursTries, marqueursPositifsTries);
		System.out.println("Sélection de marqueurs négatifs V3 :");
		affiche(RechercheV3);
		
		
	}

}
