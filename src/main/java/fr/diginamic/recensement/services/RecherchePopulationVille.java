package fr.diginamic.recensement.services;

import fr.diginamic.recensement.MenuService;
import fr.diginamic.recensement.Recensement;

import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {

    /**
     * Affiche les informations d'une ville recherchée par l'utilisateur.
     *
     * Demande à l'utilisateur le nom d'une ville.
     * filter + findFirst = filtre la ville dans la liste avec equalsIgnoreCase.
     * ifPresentOrElse = Permet d'afficher la ville si elle existe ou un
     * message d'erreur.
     *
     * @param recensement Objet contenant la liste de toutes les villes
     * @param scanner     Outil pour lire la saisie utilisateur
     */
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.print("Veuillez entrer le nom de la ville recherchée : ");
        String villeRecherchee = scanner.nextLine().trim();

        recensement
                .getVilles()
                .stream()
                .filter(ville -> ville.getNomVille().equalsIgnoreCase(villeRecherchee))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Ville non trouvée.")
                );
    }
}
