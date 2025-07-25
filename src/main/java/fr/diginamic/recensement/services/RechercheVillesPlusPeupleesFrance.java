package fr.diginamic.recensement.services;

import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RechercheVillesPlusPeupleesFrance extends MenuService {

    /**
     * Affiche les 10 villes les plus peuplées de France.
     *
     * recensement.getVilles().stream() : parcourt la liste de toutes les villes
     * sorted + reversed : trie les villes par population décroissante
     * limit(10) : limite le résultat aux 10 premières villes
     * collect(Collectors.toList()) : collecte le résultat dans une liste
     * forEach : affiche chaque ville avec son nom, la région et la population
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.println("Les 10 villes les plus peuplées de France");

        recensement.getVilles().stream()
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList())
                .forEach(entry -> System.out.printf("%s, %s, %d habitants " +
                                "%n ",
                        entry.getNomVille(), entry.getNomRegion(),
                        entry.getPopulationTotale()));
    }
}
