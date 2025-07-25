package fr.diginamic.fichier;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Region;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectureFichier {
    public static List<Ville> chargerVillesDepuisFichier(String cheminFichier) {
        List<Ville> listeVilles = new ArrayList<>();
        cheminFichier = "src/main/resources/recensement.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            reader.readLine();
            String ligne;

            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.trim().split(";");
                int codeRegion = Integer.parseInt(parts[0]);
                String nomRegion = parts[1];
                String codeDepartement = parts[2];
                int codeVille = Integer.parseInt(parts[5]);
                String nameVille = parts[6].replace(" ", "");
                int populationTotale = Integer.parseInt(parts[9].replace(" ", ""));
                Ville ville = new Ville(codeRegion, nomRegion, codeDepartement,
                        codeVille,
                        nameVille, populationTotale);
                listeVilles.add(ville);
            }
            Recensement recensement = new Recensement(listeVilles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    return listeVilles;
    }
}
