package fr.diginamic.recensement.services;

import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RechercheVillesPlusPeupleesParRegion extends MenuService {
    /**
     * Affiche les 10 villes les plus peuplées d'une région spécifiée par l'utilisateur.
     *
     * recensement.getVilles().stream() : parcourt la liste de toutes les villes
     * filter : filtre les villes dont le nom de région correspond à la saisie
     * utilisateur
     * sorted + reversed : trie les villes par population décroissante
     * limit(10) : limite aux 10 premières villes les plus peuplées
     * collect(Collectors.toList()) : collecte le résultat dans une liste
     * forEach : affiche chaque ville avec son nom, la région et la population
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Veuillez entrer le nom de la région recherchée :");
        String regionRecherche = scanner.nextLine().trim();;

        System.out.printf("Les 10 villes les plus peuplées de la région %s%n", regionRecherche);

        recensement.getVilles().stream()
                .filter(ville -> ville.getNomRegion().equalsIgnoreCase(regionRecherche))
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList())
                .forEach(entry -> System.out.printf("%s, %s, %d habitants " +
                                "%n ",
                        entry.getNomVille(), entry.getNomRegion(),
                        entry.getPopulationTotale()));

    }
}
