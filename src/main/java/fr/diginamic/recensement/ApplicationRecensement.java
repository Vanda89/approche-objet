package fr.diginamic.recensement;

import fr.diginamic.fichier.LectureFichier;
import fr.diginamic.fichier.Ville;
import fr.diginamic.recensement.services.*;

import java.util.List;
import java.util.Scanner;

public class ApplicationRecensement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            System.out.println();
            System.out.println("Bienvenue dans le service de recensement.");
            System.out.println("Veuillez indiquer avec quel service vous " +
                    "souhaitez communiquer :");
            System.out.println("1. Population d’une ville donnée");
            System.out.println("2. Population d’un département donné");
            System.out.println("3. Population d’une région donnée");
            System.out.println("4. Afficher les 10 régions les plus peuplées");
            System.out.println("5. Afficher les 10 départements les plus " +
                    "peuplés");
            System.out.println("6. Afficher les 10 villes les plus peuplées " +
                    "d’un département");
            System.out.println("7. Afficher les 10 villes les plus peuplées " +
                    "d’une région");
            System.out.println("8. Afficher les 10 villes les plus peuplées " +
                    "de France");
            System.out.println("9. Sortir");

            String choix;
            do {
                System.out.print("Entrez votre choix : ");
                choix = scanner.nextLine();
                if (!choix.matches("[1-9]")) {
                    System.out.println("Erreur de saisie, veuillez entrer un chiffre entre 1 et 9.");
                }
            } while (!choix.matches("[1-9]"));

            int utilisateurChoix = Integer.parseInt(choix);

            List<Ville> villes = LectureFichier.chargerVillesDepuisFichier("src/main/resources/recensement.csv");
            MenuService service;
            Recensement recensement = new Recensement(villes);

            switch (utilisateurChoix) {
                case 1:
                    service = new RecherchePopulationVille();
                    service.traiter(recensement, scanner);
                    break;
                case 2:
                    service = new RecherchePopulationDepartement();
                    service.traiter(recensement, scanner);
                    break;
                case 3:
                    service = new RecherchePopulationRegion();
                    service.traiter(recensement, scanner);
                    break;
                case 4:
                    service = new RechercheRegionsPlusPeuplees();
                    service.traiter(recensement, scanner);
                    break;
                case 5:
                    service = new RechercheDepartementsPlusPeuples();
                    service.traiter(recensement, scanner);
                    break;
                case 6:
                    service = new RechercheVillesPlusPeupleesParDepartement();
                    service.traiter(recensement, scanner);
                    break;
                case 7:
                    service = new RechercheVillesPlusPeupleesParRegion();
                    service.traiter(recensement, scanner);
                    break;
                case 8:
                    service = new RechercheVillesPlusPeupleesFrance();
                    service.traiter(recensement, scanner);
                    break;

                case 9:
                    System.out.println("Au revoir !");
                    quitter = true;
                    break;

            }
        }
    }
}
