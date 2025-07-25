package fr.diginamic.recensement.services;

import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RechercheRegionsPlusPeuplees extends MenuService {

    /**
     * Affiche les regions les plus peuplées en France
     *
     * collect(groupingBy + summingInt) : regroupe les villes par région
     * et additionne les populations pour chaque région
     * entrySet().stream() = transformation du Map en stream (clé=region,
     * valeur=population)
     * sorted + reversed = trie par population décroissante
     * limit(10) = limite le nombre de régions à 10
     * forEach = affiche les régions avec leur nom et la population totale
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Les 10 régions les plus peuplées : ");

        recensement.getVilles().stream()
                .collect(Collectors.groupingBy(
                        Ville::getNomRegion,
                        Collectors.summingInt(Ville::getPopulationTotale)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.printf("%s, %d habitants %n",
                        entry.getKey(), entry.getValue()));
    }
}
