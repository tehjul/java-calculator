import java.util.Random;
import java.util.Arrays;

public class Experience {
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

	public static void main(String[] args) {
		System.out.println("Génération d'un tableau de 20 marqueurs :");
		int[] marqueurs = genereMarqueurs(20);
		affiche(marqueurs);
		System.out.println();
		
		System.out.println("Sélection de 7 marqueurs positifs :");
		int[] marqueursPositifs = genereMarqueursPositifs(marqueurs, 7);
		affiche(marqueursPositifs);
		System.out.println();
		
		System.out.println("Exemple de génération d'un tableau trié :");
		int[] marqueursTries = tri(marqueurs);
		affiche(marqueursTries);
	}

}
