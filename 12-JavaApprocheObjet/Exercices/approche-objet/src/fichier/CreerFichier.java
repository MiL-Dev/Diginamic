package fichier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreerFichier {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\12. Java approche objet\\TP\\recensement.csv");

		boolean exists = Files.exists(path);
		boolean estFichier = Files.isRegularFile(path);
		boolean estLisible = Files.isReadable(path);
		
		if(exists && estFichier && estLisible) {
			List<String> lines = Files.readAllLines(path);
			List<String> newLines = new ArrayList<>();
			
			for(int i=0; i<100; i++) {
				newLines.add(lines.get(i));
			}
			System.out.println(newLines);
		}
		
	}

}
