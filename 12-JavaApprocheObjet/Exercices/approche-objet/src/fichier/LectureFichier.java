package fichier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LectureFichier {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Path path = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\12. Java approche objet\\TP\\recensement.csv");

		boolean exists = Files.exists(path);
		boolean estFichier = Files.isRegularFile(path);
		boolean estLisible = Files.isReadable(path);
		
		System.out.println(exists);
		System.out.println(estFichier);
		System.out.println(estLisible);
		List<String> lines = Files.readAllLines(path);
		
		
		//Demander pourquoi cela ne fonctionne pas ! String error

		ArrayList<Ville> cities = new ArrayList<>();
		Iterator<String> iter = lines.iterator();
		String line = iter.next();
		while (iter.hasNext()) {
			line = iter.next();
			String[] tokens = line.split(";");
			//a cause de la corse departement 2A je ne l'es pas mis en int
			Ville city = new Ville(tokens[6],tokens[2] , tokens[1], Integer.parseInt(tokens[9].replaceAll(" ", "")));
			cities.add(city);
		}
		
		
//		for(Ville city : cities) {
//			System.out.println(city.getDepartement());
//		}
		
		//Correction TP
		System.out.println("\nCORRECTION\n");
		
		Path pathOri = Paths.get("C:\\\\Users\\\\MiL\\\\Developpement\\\\Formation_Diginamic\\\\12. Java approche objet\\\\TP\\\\recensement.csv");
		List<String> lignes = Files.readAllLines(pathOri);
		String ligneColonne = lignes.remove(0);
		String[] colonnes = ligneColonne.split(";");
		
		List<Ville> villes25k = new ArrayList<>();
		for (String ligne : lignes) {
			
			String[] elements = ligne.split(";");
			int nbHabs = Integer.parseInt(elements[9].replaceAll(" ", ""));
			Ville ville = new Ville(elements[1], elements[2], elements[6], nbHabs);
			if (ville.getPopulationTotal()>=25000) {
				
				villes25k.add(ville);
			}
		}
		//Trie la liste de type Ville par nombre de population croissant
		//Collections.sort(villes25k);
		
		
		//Trier avec comparatorHabitant
		//Collections.sort(villes25k, new ComparatorHabitant());
		
		//Tri en ordre alphabetique
		Collections.sort(villes25k, new ComparatorNom());
		
		// Génération des lignes pour le fichier de sortie des villes de plus de 25000 habs
		ArrayList<String> selection = new ArrayList<>();
		
		// On commence par ajouter les entêtes de colonnes qui nous intéressent
		selection.add(colonnes[1]+";"+colonnes[2]+";"+colonnes[6]+";"+colonnes[9]);
		
		// Puis on ajoute à la liste des lignes, chaque ville de plus de 25k transformée en chaines de caractères
		for (Ville ville: villes25k) {
			String ligneSortie = ville.toCsv();
			selection.add(ligneSortie);
		}
		
		// Génération du fichier de sortie
		Path pathDest = Paths.get("C:\\\\Users\\\\MiL\\\\Developpement\\\\Formation_Diginamic\\\\12. Java approche objet\\\\TP\\\\recensement25k.csv");
		Files.write(pathDest, selection);
		
		System.out.println("Nombre de lignes sélectionnées = "+selection.size());

	}
}
