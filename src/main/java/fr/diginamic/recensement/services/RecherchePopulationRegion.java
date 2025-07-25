package fr.diginamic.recensement.services;

import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Scanner;

public class RecherchePopulationRegion extends MenuService {

    /**
     * Affiche la population totale d’une région saisie par l’utilisateur.
     *
     * Demande à l'utilisateur le nom de la région
     * filter = filtre ensuite les villes correspondantes,
     * mapToInt = additionne leurs populations et affiche le résultat.
     * Si aucun département ne correspond, un message d’erreur est affiché.
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Veuillez entrer le nom de la région recherchée : ");
        String regionRecherchee = scanner.nextLine().trim();

        int populationTotaleRegion = recensement
                .getVilles()
                .stream()
                .filter(ville -> ville.getNomRegion().equalsIgnoreCase(regionRecherchee))
                .mapToInt(Ville::getPopulationTotale)
                .sum();

        if (populationTotaleRegion > 0) {
            System.out.printf("Population totale de la région %s : %d personnes.%n", regionRecherchee.toUpperCase(), populationTotaleRegion);
        } else {
            System.out.println("Région non trouvée.");
        }
    }
}
