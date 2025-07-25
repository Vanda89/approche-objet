package fr.diginamic.recensement.services;

import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RechercheDepartementsPlusPeuples extends MenuService {

    /**
     * Affiche les 10 départements les plus peuplés de France.
     * <p>
     * recensement.getVilles().stream() : parcourt la liste de toutes les villes
     * collect(groupingBy + summingInt) : regroupe les villes par département
     * et additionne les populations pour chaque département
     * entrySet().stream() : transformation du Map en stream (clé = code
     * département, valeur = population totale)
     * sorted + reversed = trie par population décroissante
     * limit(10) = limite le nombre de départements à 10
     * forEach : affiche chaque département avec son code et  sa population
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Les 10 départements les plus peuplés : ");

        recensement.getVilles().stream()
                .collect(Collectors.groupingBy(
                        Ville::getCodeDepartement,
                        Collectors.summingInt(Ville::getPopulationTotale))).entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.printf("%s, %d habitants %n ",
                        entry.getKey(), entry.getValue()));
    }
}
