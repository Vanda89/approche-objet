package fr.diginamic.recensement.services;

import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService {

    /**
     * Affiche la population totale d’un département saisi par l’utilisateur.
     *
     * Demande à l'utilisateur le code du département
     * filter = filtre ensuite les villes correspondantes,
     * mapToInt = additionne leurs populations et affiche le résultat.
     * Si aucun département ne correspond, un message d’erreur est affiché.
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Veuillez entrer le code du département recherché " +
                ": ");
        String departementRecherche = scanner.nextLine().trim();

        int populationTotaleDepartement = recensement
                .getVilles()
                .stream()
                .filter(ville -> ville.getCodeDepartement().equalsIgnoreCase(departementRecherche))
                .mapToInt(Ville::getPopulationTotale)
                .sum();

        if (populationTotaleDepartement > 0) {
            System.out.printf("Population totale du département %s : %d " +
                    "personnes.%n", departementRecherche.toUpperCase(), populationTotaleDepartement);
        } else {
            System.out.println("Département non trouvé.");
        }
    }
}
