package fichier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LectureCreeFichier {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\12. Java approche objet\\TP\\open-food-facts.csv");

		boolean exists = Files.exists(path);
		boolean estFichier = Files.isRegularFile(path);
		boolean estLisible = Files.isReadable(path);
		
		System.out.println(exists);
		System.out.println(estFichier);
		System.out.println(estLisible);
		
		List<String> lines = Files.readAllLines(path);
		ArrayList<Produit> products = new ArrayList<>();
		Iterator<String> iter = lines.iterator();
		String line = iter.next();
		while (iter.hasNext()) {
			line = iter.next();
			String[] tokens = line.split("\\|"); // ici il faut mettre \\ parce que c'est une expression reguliere et du coup le double slash permet de forcer l'interpretation de |
			
			Produit product = new Produit(tokens[0], tokens[1], tokens[2], tokens[3]);
			products.add(product);
		}
		
		
		List<String> linesWrite = new ArrayList<>();
		linesWrite.add("Nom;Marque;Categorie;");

		for(Produit prod : products) {
//			System.out.println(prod.getCategorie());
//			System.out.println(prod.getMarque());
			if(numberByMC(prod, "Édulcorants", "La Maison Guiot")) {
				linesWrite.add(prod.getNom()+";"+prod.getMarque()+";"+prod.getCategorie()+";");

			}
			
		}
		
		Path pathCible = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\12. Java approche objet\\TP\\monFichier.txt");
		Files.write(pathCible, linesWrite);
		
		
	}
	public static boolean numberByMC(Produit product, String categorie, String marque) {
		if(product.getCategorie().equals(categorie) && product.getMarque().equals(marque)) {
			return true;
		}
			return false;
	}
	
}
